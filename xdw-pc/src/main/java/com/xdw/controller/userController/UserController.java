package com.xdw.controller.userController;

import com.xdw.entity.UserRegist;
import com.xdw.service.UserRegistService;
import com.xdw.util.JsonView;
import com.xdw.util.MD5Util;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserRegistService userRegistService;

    /**
     * 用户注册
     * @param userRegist
     * @return
     */
    @RequestMapping("/insertUserRegist")
    public JsonView insertUserRegist(UserRegist userRegist){
        JsonView jsonView = new JsonView();
        try{
            userRegist.setPassword(MD5Util.MD5(userRegist.getPassword()));
            UserRegist u = userRegistService.selectUserByUserName(userRegist);
            if(u!=null){
                jsonView.setMessage("此账号已被注册");
                jsonView.setCode(JsonView.ERROR);
            }else{
                userRegist.setCreateTime(new Date());
                Integer i = userRegistService.insertUserRegist(userRegist);
                if(i>0){
                    jsonView.setCode(JsonView.SUCCESS);
                    jsonView.setMessage("注册成功");
                }else{
                    jsonView.setMessage("注册失败");
                    jsonView.setCode(JsonView.ERROR);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("注册异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     * 用户登录
     * @param userRegist
     * @return
     */
    @RequestMapping("/login")
    public JsonView login(UserRegist userRegist, HttpServletRequest request){
        JsonView jsonView = new JsonView();
        try{
            if(userRegist.getPassword()!=null && !("").equals(userRegist.getPassword())){
                userRegist.setPassword(MD5Util.MD5(userRegist.getPassword()));
            }
            UserRegist login = userRegistService.login(userRegist);
            if(login.getISLogin()!=null &&login.getISLogin()==1){
                jsonView.setMessage("您已经登陆");
            }else{
                userRegist.setISLogin(1);
                userRegist.setUpdateTime(new Date());
                Integer i = userRegistService.updateUserInfo(userRegist);
                if(i>0){
                    //把用户信息存放到session中
                    request.getSession().setAttribute(userRegist.getUserName(), userRegist);
                    jsonView.setMessage("登陆成功");
                    jsonView.setCode(JsonView.SUCCESS);
                    jsonView.setData(userRegist);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("登陆异常");
        }
        return jsonView;
    }

    /**
     * 用户退出
     * @param userRegist
     * @param request
     * @return
     */
    @RequestMapping("/toQuit")
    public JsonView toQuit(UserRegist userRegist,HttpServletRequest request){
        JsonView jsonView = new JsonView();
        try{
            userRegist.setUpdateTime(new Date());
            userRegist.setISLogin(0);
            Integer i = userRegistService.updateUserInfo(userRegist);
            if(i>0){
                //把用户信息congsession中移除
                request.getSession().removeAttribute(userRegist.getUserName());
                jsonView.setMessage("退出成功");
                jsonView.setCode(JsonView.SUCCESS);
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("退出失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("退出异常");
        }
        return jsonView;
    }

    /**
     * 修改密码（用户知道自己的旧密码）
     * @param userRegist
     * @return
     */
    @RequestMapping("/updatePassword")
    public JsonView updatePassword(UserRegist userRegist,String newPassword){
        JsonView jsonView = new JsonView();
        try{
            userRegist.setPassword(MD5Util.MD5(userRegist.getPassword()));
            UserRegist u = userRegistService.login(userRegist);
            //原密码输入正确
            if(u!=null){
                userRegist.setPassword(MD5Util.MD5(newPassword));
                userRegist.setUpdateTime(new Date());
                Integer i = userRegistService.updateUserInfo(userRegist);
                if(i>0){
                    jsonView.setCode(JsonView.SUCCESS);
                    jsonView.setMessage("重置密码成功");
                }else{
                    jsonView.setCode(JsonView.ERROR);
                    jsonView.setMessage("重置密码失败");
                }
            }else{//原密码输入有误
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("旧密码输入有误");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("修改异常");
            jsonView.setCode(JsonView.ERROR);
        }
        return jsonView;
    }

    /**
     *  忘记密码，重置密码（用户不知道自己旧密码）
     * @param userRegist
     * @return
     */
    @RequestMapping("/rememberPassword")
    public JsonView rememberPassword(UserRegist userRegist){
        JsonView jsonView = new JsonView();
        try{
            userRegist.setPassword(MD5Util.MD5(userRegist.getPassword()));
            userRegist.setUpdateTime(new Date());
            Integer i = userRegistService.updateUserInfo(userRegist);
            if(i>0){
                jsonView.setMessage("修改密码成功");
                jsonView.setCode(JsonView.SUCCESS);
            }else{
                jsonView.setCode(JsonView.ERROR);
                jsonView.setMessage("修改密码失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setMessage("异常");
        }
        return jsonView;
    }
}

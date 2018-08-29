package com.xdw.controller.userController;

import com.xdw.UserRegist;
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
            userRegist.setCreateTime(new Date());
            Integer i = userRegistService.insertUserRegist(userRegist);
            if(i>0){
                jsonView.setCode(JsonView.SUCCESS);
                jsonView.setMessage("注册成功");
            }else{
                jsonView.setMessage("注册失败");
                jsonView.setCode(JsonView.ERROR);
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
            if(login.getISLogin()==1){
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
   /* public JsonView toQuit(UserRegist userRegist,HttpServletRequest request){
        JsonView jsonView = new JsonView();
        try{
            userRegist.setUpdateTime(new Date());
            userRegist.setISLogin(0);
            Integer i = userRegistService.updateUserInfo(userRegist);

            if(i>0){

            }
        }catch(Exception e){
            e.printStackTrace();
            jsonView.setCode(JsonView.ERROR);
            jsonView.setMessage("退出异常");
        }
        return jsonView;
    }*/
}

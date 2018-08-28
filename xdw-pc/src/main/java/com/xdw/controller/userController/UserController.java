package com.xdw.controller.userController;

import com.xdw.UserRegist;
import com.xdw.service.UserRegistService;
import com.xdw.util.JsonView;
import com.xdw.util.MD5Util;
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
}

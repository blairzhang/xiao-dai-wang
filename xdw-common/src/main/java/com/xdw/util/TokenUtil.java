package com.xdw.util;

import com.xdw.UserRegist;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    //存放用户app Token
    public static Map<String, String> userTokenMap = new HashMap<String, String>();

    //存放用户Token对应的用户登陆信息
    public static Map<String, UserRegist> loginUserMap = new HashMap<String, UserRegist>();


    /**
     * 生成ToKen
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public static String UserToken(String username, String password, UserRegist userAppRegist) {

        String token = userTokenMap.get(username);

        /**
         * 判断是否是新用户登陆
         * 是 生成token返回
         * 不是 删除旧的token 生成新的token返回
         */
        if (token == null) {
            //先删除旧的存有用户信息的Token
            if(loginUserMap.get(userTokenMap.get(username))!=null)
                loginUserMap.remove(userTokenMap.get(username));
            //声成一个以用户名+密码+时间的 MD5 值作为 ToKen 存入 userTokenMap
            token = CustomMD5.passwordAndSalt(password, username + new Date().getTime(), 1);
            //将 token 存入 userTokenMap
            userTokenMap.put(username, token);

            //再将用户登陆的信息存入生成的 Token
            loginUserMap.put(token, userAppRegist);
            //返回生成的token
            return token;
        } else {
            //删除旧的token信息
            userTokenMap.remove(username);
            loginUserMap.remove(token);
            //声成一个以用户名+密码+时间的 MD5 值作为 ToKen 存入 userTokenMap
            token = CustomMD5.passwordAndSalt(password, username + new Date().getTime(), 1);
            //将 token 存入 userTokenMap
            userTokenMap.put(username, token);
            //将用户登陆的信息存入生成的 Token
            loginUserMap.put(token, userAppRegist);
            //返回生成的token
            return token;
        }
    }

    /**
     * 校验token是否有效 有效返回用户信息
     *
     * @param strtoken
     * @return
     */
    public static UserRegist userToken(String strtoken) {
        String token = userTokenMap.get(strtoken);
        if (token == null)
            return null;
        UserRegist userRegist = loginUserMap.get(token);
        return userRegist;
    }




}

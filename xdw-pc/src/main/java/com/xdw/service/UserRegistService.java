package com.xdw.service;

import com.github.pagehelper.PageInfo;
import com.xdw.entity.UserRegist;
import com.xdw.util.PageRequest;
import com.xdw.vo.UserVo;

import java.util.Map;

public interface UserRegistService {

    //根据用户名查看此账号是否已经被注册
    public UserRegist selectUserByUserName(UserRegist userRegist);

    public Integer insertUserRegist(UserRegist userRegist);

    public UserRegist login(UserRegist userRegist);

    public Integer updateUserInfo(UserRegist userRegist);


}

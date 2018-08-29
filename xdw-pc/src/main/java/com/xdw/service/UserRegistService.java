package com.xdw.service;

import com.xdw.UserRegist;

public interface UserRegistService {

    public Integer insertUserRegist(UserRegist userRegist);

    public UserRegist login(UserRegist userRegist);

    public Integer updateUserInfo(UserRegist userRegist);
}

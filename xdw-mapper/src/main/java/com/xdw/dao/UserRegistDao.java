package com.xdw.dao;

import com.xdw.entity.UserRegist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRegistDao {

    public Integer insertUserRegist(UserRegist userRegist);

    public UserRegist login(UserRegist userRegist);

    public Integer updateUserInfo(UserRegist userRegist);
}

package com.xdw.dao;

import com.xdw.entity.UserRegist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRegistDao {

    //根据用户名查看此账号是否已经被注册
    public UserRegist selectUserByUserName(UserRegist userRegist);

    public Integer insertUserRegist(UserRegist userRegist);

    public UserRegist login(UserRegist userRegist);

    public Integer updateUserInfo(UserRegist userRegist);

    public UserRegist selectUserById(Long id);
}

package com.xdw.dao;

import com.xdw.UserRegist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRegistDao {

    public Integer insertUserRegist(UserRegist userRegist);
}

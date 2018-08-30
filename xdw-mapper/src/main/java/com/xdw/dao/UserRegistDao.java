package com.xdw.dao;

import com.xdw.entity.UserRegist;
import com.xdw.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserRegistDao {

    //根据用户名查看此账号是否已经被注册
    public UserRegist selectUserByUserName(UserRegist userRegist);

    public Integer insertUserRegist(UserRegist userRegist);

    public UserRegist login(UserRegist userRegist);

    public Integer updateUserInfo(UserRegist userRegist);

    public UserRegist selectUserById(Long id);

    //分页查询所有的用户信息
    public List<UserVo> selectUserByPage(Map map);
}

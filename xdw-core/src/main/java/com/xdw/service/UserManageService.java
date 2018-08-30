package com.xdw.service;

import com.github.pagehelper.PageInfo;
import com.xdw.entity.UserRegist;
import com.xdw.util.PageRequest;
import com.xdw.vo.UserVo;

import java.util.Map;

public interface UserManageService {

    //分页查询所有的用户信息
    public PageInfo<UserVo> selectUserByPage(Map map, PageRequest pageRequest);

    //修改（注销，重置密码）
    public Integer updateUserInfo(UserRegist userRegist);
}

package com.xdw.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xdw.dao.UserRegistDao;
import com.xdw.entity.UserRegist;
import com.xdw.service.UserManageService;
import com.xdw.util.PageRequest;
import com.xdw.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    private UserRegistDao userRegistDao;


    //==============================================后台管理，用户管理
    /**
     * 后台查询所有用户信息
     * @param map
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<UserVo> selectUserByPage(Map map, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<UserVo> userVos = userRegistDao.selectUserByPage(map);
        PageInfo<UserVo> pageInfo = new PageInfo<>(userVos);
        pageInfo.setSize(userVos.size());
        return pageInfo;
    }

    /**
     * 修改（注销，重置密码）
     * @param userRegist
     * @return
     */
    @Override
    public Integer updateUserInfo(UserRegist userRegist) {
        return userRegistDao.updateUserInfo(userRegist);
    }
}

package com.xdw.service.impl;

import com.xdw.entity.UserRegist;
import com.xdw.dao.UserRegistDao;
import com.xdw.service.UserRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRegistServiceImpl implements UserRegistService {

    @Autowired
    private UserRegistDao userRegistDao;

    /**
     * 用户注册
     * @param userRegist
     * @return
     */
    @Transactional(value = "transactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 36000)
    @Override
    public Integer insertUserRegist(UserRegist userRegist) {
        return userRegistDao.insertUserRegist(userRegist);
    }

    /**
     * 用户登陆
     * @param userRegist
     * @return
     */
    @Override
    public UserRegist login(UserRegist userRegist) {
        return userRegistDao.login(userRegist);
    }

    /**
     * 修改
     * @param userRegist
     * @return
     */
    @Override
    public Integer updateUserInfo(UserRegist userRegist) {
        Integer i = userRegistDao.updateUserInfo(userRegist);
        return i;
    }
}

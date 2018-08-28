package com.xdw.service.impl;

import com.xdw.UserRegist;
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
}

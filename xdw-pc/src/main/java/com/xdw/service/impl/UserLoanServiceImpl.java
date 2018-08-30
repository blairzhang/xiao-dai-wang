package com.xdw.service.impl;

import com.xdw.entity.UserLoan;
import com.xdw.dao.UserLoanDao;
import com.xdw.service.UserLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName xiao-dai-wang
 * @ClassName UserLoanServiceImpl
 * @Description TODO TODO 用户贷款表Service
 * @Author sanmu
 * @Date 2018/8/29 10:59
 * @Version 1.0
 **/
@Service
public class UserLoanServiceImpl implements UserLoanService {

    @Autowired
    private UserLoanDao userLoanDao;

    //贷款申请
    @Override
    public int insertUserLoanInfo(UserLoan userLoan) {
        userLoan.setCreateTime(new Date());
        userLoan.setStatus(0);
        return userLoanDao.insertUserLoanInfo(userLoan);
    }
    //按用户ID查询所有贷款申请
    @Override
    public List<UserLoan> selectUserLoanByUserId(Long userId) {
        return userLoanDao.selectUserLoanByUserId(userId);
    }
    //按ID查询贷款申请
    @Override
    public UserLoan selectUserLoanById(Long id) {
        return userLoanDao.selectUserLoanById(id);
    }
    //按条件查询所有贷款信息
    @Override
    public List<UserLoan> selectUserLoanAll(UserLoan userLoan) {
        return userLoanDao.selectUserLoanAll(userLoan);
    }
    //审核贷款信息
    @Override
    public int updateUserLoanInfoById(UserLoan userLoan) {
        return userLoanDao.updateUserLoanInfoById(userLoan);
    }
}

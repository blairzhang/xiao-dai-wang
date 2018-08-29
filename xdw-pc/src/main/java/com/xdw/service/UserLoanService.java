package com.xdw.service;

import com.xdw.entity.UserLoan;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserLoanService
 * @Description TODO 用户贷款表Service
 * @Author sanmu
 * @Date 2018/8/29 10:58
 * @Version 1.0
 **/

public interface UserLoanService {
    //贷款申请
    int insertUserLoanInfo(UserLoan userLoan);
    //按用户ID查询所有贷款申请
    List<UserLoan> selectUserLoanByUserId(Long userId);
    //按ID查询贷款申请
    UserLoan selectUserLoanById(Long id);
    //按条件查询多有贷款信息
    List<UserLoan> selectUserLoanAll(UserLoan userLoan);
    //审核贷款信息
    int updateUserLoanInfoById(UserLoan userLoan);
}

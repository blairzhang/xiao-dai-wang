package com.xdw.dao;

import com.xdw.entity.UserLoan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName UserLoanDao
 * @Description TODO 用户贷款表Dao
 * @Author sanmu
 * @Date 2018/8/29 10:29
 * @Version 1.0
 **/
@Mapper
public interface UserLoanDao {
    //贷款申请
    int insertUserLoanInfo(UserLoan userLoan);
    //按用户ID查询所有贷款申请
    List<UserLoan> selectUserLoanByUserId(Long userId);
    //按ID所有贷款申请
    UserLoan selectUserLoanById(Long id);
    //按条件查询所有贷款信息
    List<UserLoan> selectUserLoanAll(UserLoan userLoan);
    //审核贷款信息
    int updateUserLoanInfoById(UserLoan userLoan);
}

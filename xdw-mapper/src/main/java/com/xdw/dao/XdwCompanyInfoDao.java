package com.xdw.dao;

import com.xdw.entity.XdwCompanyInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface XdwCompanyInfoDao {

    public int insertXdwCompanyInfo(Map map);

    public XdwCompanyInfo selectXdwCompanyInfo(Integer status);

}

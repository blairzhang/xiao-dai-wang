package com.xdw.service.impl;

import com.xdw.dao.BusinessprofileDao;
import com.xdw.entity.Businessprofile;
import com.xdw.service.PcBusinessprofileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PcBusinessprofileServiceimpl implements PcBusinessprofileService {

    @Autowired
    private BusinessprofileDao businessprofileDao;

    /**
     * pc端查询企业简介数据
     * @param status
     * @return(返回单个结果集，如果返回多个结果会抱错。)
     */
    @Override
    public Businessprofile selectBusinessprofile(int status) {
        return businessprofileDao.selectBusinessprofile(status);
    }
}

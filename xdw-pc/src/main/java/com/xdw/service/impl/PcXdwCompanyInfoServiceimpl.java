package com.xdw.service.impl;

import com.xdw.dao.XdwCompanyInfoDao;
import com.xdw.entity.XdwCompanyInfo;
import com.xdw.service.PcXdwCompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PcXdwCompanyInfoServiceimpl implements PcXdwCompanyInfoService {

    @Autowired
    private XdwCompanyInfoDao xdwCompanyInfoDao;

    @Override
    public XdwCompanyInfo selectXdwCompanyInfo(Integer status) {
        return xdwCompanyInfoDao.selectXdwCompanyInfo(status);
    }
}

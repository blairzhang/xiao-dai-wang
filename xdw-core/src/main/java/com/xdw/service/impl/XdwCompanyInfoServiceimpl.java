package com.xdw.service.impl;

import com.xdw.dao.XdwCompanyInfoDao;
import com.xdw.service.XdwCompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class XdwCompanyInfoServiceimpl implements XdwCompanyInfoService {

    @Autowired
    private XdwCompanyInfoDao xdwCompanyInfoDao;

    /**
     * 后台联系我们添加数据
     * @param map
     * @return
     */
    @Override
    public int insertXdwCompanyInfo(Map map) {
        return xdwCompanyInfoDao.insertXdwCompanyInfo(map);
    }
}

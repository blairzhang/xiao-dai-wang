package com.xdw.service.impl;

import com.xdw.dao.BusinessprofileDao;
import com.xdw.service.BusinessprofileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class BusinssprofileServiceimpl implements BusinessprofileService {

    @Autowired
    private BusinessprofileDao businessprofileDao;

    /**
     * 后台添加企业简介数据
     * @param map
     * @return
     */
    @Override
    public int insertBusinessprofile(Map map) {
        return businessprofileDao.insertBusinessprofile(map);
    }
}

package com.xdw.service.impl;

import com.xdw.dao.LoandiscribeDao;
import com.xdw.service.LoandiscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class LoandiscribeServiceimpl implements LoandiscribeService {

    @Autowired
    private LoandiscribeDao loandiscribeDao;

    @Override
    public int insertLoandiscribe(Map map) {
        return loandiscribeDao.insertLoandiscribe(map);
    }
}

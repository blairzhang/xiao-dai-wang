package com.xdw.service.impl;

import com.xdw.dao.AdvertisingDao;
import com.xdw.entity.Advertising;
import com.xdw.service.AdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName xiao-dai-wang
 * @ClassName AdvertisingServiceImpl
 * @Description TODO 处理banner图业务逻辑接口实现
 * @Author sanmu
 * @Date 2018/8/29 17:28
 * @Version 1.0
 **/
@Service
public class AdvertisingServiceImpl implements AdvertisingService {

    @Autowired
    private AdvertisingDao advertisingDao;

    //添加banner图
    @Override
    public int insertAdvertising(Advertising advertising) {
        return advertisingDao.insertAdvertising(advertising);
    }

    //根据id查看banner图
    @Override
    public Advertising selectAdvertisingById(Long id) {
        return advertisingDao.selectAdvertisingById(id);
    }

    //查看所有banner图
    @Override
    public List<Advertising> selectAdvertisingAll() {
        return advertisingDao.selectAdvertisingAll();
    }

    //修改banner图
    @Override
    public int updateAdvertising(Advertising advertising) {
        return advertisingDao.updateAdvertising(advertising);
    }

    //删除banner图
    @Override
    public int deleteAdvertising(Long id) {
        return advertisingDao.deleteAdvertising(id);
    }
}

package com.xdw.service;

import com.xdw.entity.Advertising;

import java.util.List;

/**
 * @ProjectName xiao-dai-wang
 * @ClassName AdvertisingService
 * @Description TODO 处理banner图业务逻辑接口
 * @Author sanmu
 * @Date 2018/8/29 17:22
 * @Version 1.0
 **/
public interface AdvertisingService {
    //添加banner图
    int insertAdvertising(Advertising advertising);
    //根据id查看banner图
    Advertising selectAdvertisingById(Long id);
    //查看所有banner图
    List<Advertising> selectAdvertisingAll();
    //修改banner图
    int updateAdvertising(Advertising advertising);
    //删除banner图
    int deleteAdvertising(Long id);
}

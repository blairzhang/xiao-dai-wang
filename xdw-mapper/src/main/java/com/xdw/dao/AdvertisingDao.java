package com.xdw.dao;

import com.xdw.entity.Advertising;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ProjectName xiao-dai-wang
 * @ClassName AdvertisingDao
 * @Description TODO 广告，banner图数据库操作
 * @Author sanmu
 * @Date 2018/8/29 17:01
 * @Version 1.0
 **/
@Mapper
public interface AdvertisingDao {
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

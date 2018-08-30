package com.xdw.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LoandiscribeDao {

    public int insertLoandiscribe(Map map);

}

package com.xdw.dao;

import com.xdw.entity.Businessprofile;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface BusinessprofileDao {

    public int insertBusinessprofile(Map map);

    public Businessprofile selectBusinessprofile(int status);
}

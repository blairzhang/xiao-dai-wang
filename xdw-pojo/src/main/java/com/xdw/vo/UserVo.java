package com.xdw.vo;

import com.xdw.entity.UserRegist;

import java.io.Serializable;

public class UserVo  extends UserRegist implements Serializable{

    private String city;//所在城市

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

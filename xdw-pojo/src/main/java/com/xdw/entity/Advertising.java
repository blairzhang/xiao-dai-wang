package com.xdw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ProjectName xiao-dai-wang
 * @ClassName Advertising
 * @Description TODO 广告，banner图
 * @Author sanmu
 * @Date 2018/8/29 16:59
 * @Version 1.0
 **/
public class Advertising {
    private Long id;//主键id
    private String advertisingName;//广告名称
    private String advertisingURL;//广告链接
    private String advertisingPic;//广告图片路径
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;//修改时间
    private Integer status;//状态（0取消 1存在）

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdvertisingName() {
        return advertisingName;
    }

    public void setAdvertisingName(String advertisingName) {
        this.advertisingName = advertisingName;
    }

    public String getAdvertisingURL() {
        return advertisingURL;
    }

    public void setAdvertisingURL(String advertisingURL) {
        this.advertisingURL = advertisingURL;
    }

    public String getAdvertisingPic() {
        return advertisingPic;
    }

    public void setAdvertisingPic(String advertisingPic) {
        this.advertisingPic = advertisingPic;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

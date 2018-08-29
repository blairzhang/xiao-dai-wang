package com.xdw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ProjectName xiao-dai-wang
 * @ClassName UserLoan
 * @Description TODO 用户贷款表
 * @Author sanmu
 * @Date 2018/8/29 10:22
 * @Version 1.0
 **/
public class UserLoan {
    private Long id;//主键id
    private Long userId;//贷款用户id（user_regist的主键id）
    private String actualName;//真实姓名
    private String idCard;//身份证号
    private String idCardPicZ;//身份证正面图片
    private String idCardPicF;//身份证反面照片
    private Double loanMoney;//贷款金额
    private String loanLX;//贷款利息（小数，字符串）
    private String city;//所在城市
    private String phone;//手机号
    private String propertyInfo;//资产信息
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;//修改时间
    private String causeBy;//贷款失败原因
    private Integer status;//状态（0申请贷款 1贷款成功 2贷款失败）
    private Date startTime;//起始时间
    private Date endTime;//结束时间

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getActualName() {
        return actualName;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCardPicZ() {
        return idCardPicZ;
    }

    public void setIdCardPicZ(String idCardPicZ) {
        this.idCardPicZ = idCardPicZ;
    }

    public String getIdCardPicF() {
        return idCardPicF;
    }

    public void setIdCardPicF(String idCardPicF) {
        this.idCardPicF = idCardPicF;
    }

    public Double getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(Double loanMoney) {
        this.loanMoney = loanMoney;
    }

    public String getLoanLX() {
        return loanLX;
    }

    public void setLoanLX(String loanLX) {
        this.loanLX = loanLX;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPropertyInfo() {
        return propertyInfo;
    }

    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
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

    public String getCauseBy() {
        return causeBy;
    }

    public void setCauseBy(String causeBy) {
        this.causeBy = causeBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

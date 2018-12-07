package com.cc.sftp.model;

/**
 * @Author: cc
 * @Date: 2018-12-06 17:53
 * @Description: TODO
 */
public class BossOrderInfo {

    /**
     * BOSS订单流水号
     */
    private String externalOrderId;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 平台产品编码
     */
    private String Code;

    /**
     * 产品面值
     */
    private String money;

    /**
     * 产品订购时间
     */
    private String effectiveDate;

    /**
     * 产品失效时间
     */
    private String expireDate;

    public BossOrderInfo(String externalOrderId, String userPhone, String code, String money, String effectiveDate, String expireDate) {
        this.externalOrderId = externalOrderId;
        this.userPhone = userPhone;
        this.Code = code;
        this.money = money;
        this.effectiveDate = effectiveDate;
        this.expireDate = expireDate;
    }

    public String getExternalOrderId() {
        return externalOrderId;
    }

    public void setExternalOrderId(String externalOrderId) {
        this.externalOrderId = externalOrderId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
}

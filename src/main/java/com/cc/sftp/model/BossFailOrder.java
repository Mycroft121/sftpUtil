package com.cc.sftp.model;

/**
 * @Author: cc
 * @Date: 2018-12-06 17:53
 * @Description: TODO
 */
public class BossFailOrder {

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
}

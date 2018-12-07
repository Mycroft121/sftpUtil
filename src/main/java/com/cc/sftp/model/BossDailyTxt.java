package com.cc.sftp.model;

import jdk.internal.dynalink.linker.LinkerServices;

import java.util.List;

/**
 * @Author: cc
 * @Date: 2018-12-06 17:53
 * @Description: TODO
 */
public class BossDailyTxt {

    private int count;

    private List<BossAccountInfo> accountList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<BossAccountInfo> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<BossAccountInfo> accountList) {
        this.accountList = accountList;
    }
}

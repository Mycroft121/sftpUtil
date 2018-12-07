package com.cc.sftp.job;

import com.cc.sftp.service.TxtService;
import com.cc.sftp.util.DateUtil;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * @Author: cc
 * @Date: 2018-12-06 16:25
 * @Description: TODO
 */
@Component
@EnableScheduling
public class SftpJob {

    @Autowired
    TxtService txtService;

    @Scheduled(cron = "*/5 * * * * ? ")
    public void sftpJob() throws FileNotFoundException, SftpException {
        System.out.println("开始执行sftp定时任务");
        txtService.doReconciliationTask(DateUtil.getPartStringDate(new Date()));
    }
}

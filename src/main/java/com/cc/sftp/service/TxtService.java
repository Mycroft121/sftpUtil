package com.cc.sftp.service;

import com.jcraft.jsch.SftpException;

import java.io.FileNotFoundException;

public interface TxtService {

    public void readFile(String readFile);

    public void writeFile(String writeFile);


    public void doReconciliationTask(String partStringDate) throws FileNotFoundException, SftpException;
}

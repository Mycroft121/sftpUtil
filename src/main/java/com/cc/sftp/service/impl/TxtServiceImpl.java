package com.cc.sftp.service.impl;

import com.cc.sftp.model.BossFailOrder;
import com.cc.sftp.model.BossOrderInfo;
import com.cc.sftp.service.TxtService;
import com.cc.sftp.util.SFTPUtil;
import com.jcraft.jsch.SftpException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: cc
 * @Date: 2018-12-06 17:10
 * @Description: TODO
 */
@Service
public class TxtServiceImpl implements TxtService {

    private static String readFilePath = "/home/backup/";
    private static String writeFilePath = "/home/backup/";

    private static String readLocalPath = "/Users/chencheng/develop/";
    private static String writeLocalPath = "/Users/chencheng/develop/";

    private static String readFileNamePrefix = "MIGU-video-member-";
    private static String writeFileNamePrefix = "MIGU-video-member-back-";

    private static String fileSuffix = ".txt";


    /**
     * 读入TXT文件
     *
     * @param readFile txt文件路径
     */
    @Override
    public void readFile(String readFile) {
        try {
            FileReader reader = new FileReader(readFile);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入TXT文件
     */
    @Override
    public void writeFile(String writeFile) {
        try {
            File writeName = new File(writeFile);
            writeName.createNewFile();
            FileWriter writer = new FileWriter(writeName);
            BufferedWriter out = new BufferedWriter(writer);

            out.write("我会写入文件啦1\r\n");
            out.write("我会写入文件啦2\r\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doReconciliationTask(String partStringDate) throws FileNotFoundException, SftpException {
//        String readFileName = readFileNamePrefix+partStringDate+fileSuffix;
//        String writeFileName = readFileNamePrefix+partStringDate+fileSuffix;

        String readFileName = "3.txt";
        String writeFileName = "2.txt";

        //下载文件
        SFTPUtil sftp = new SFTPUtil("root", "", "", 22);
        sftp.login();
        sftp.download(readFilePath, readFileName, readLocalPath+readFileName);

        List<BossOrderInfo> orderInfos = new ArrayList<>();
        List<BossFailOrder> failOrderInfos = new ArrayList<>();

        //读取文件进行处理
        try {
            FileReader reader = new FileReader(readLocalPath + readFileName);
            BufferedReader br = new BufferedReader(reader);
            String line;
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                if (lineNum == 0) {
                    lineNum++;
                } else {
                    BossOrderInfo bossOrderInfo = lineToBossOrderInfo(line);
                    orderInfos.add(bossOrderInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //TODO 具体业务处理逻辑
        for(int i = 0 ;i < orderInfos.size();i++){
            if (i%2 != 0){
                BossFailOrder bossFailOrder = new BossFailOrder();
                bossFailOrder.setExternalOrderId(orderInfos.get(i).getExternalOrderId());
                bossFailOrder.setUserPhone(orderInfos.get(i).getUserPhone());
                bossFailOrder.setCode(orderInfos.get(i).getCode());
                failOrderInfos.add(bossFailOrder);
            }
        }

        try {
            File writeName = new File(writeLocalPath + writeFileName);
            writeName.createNewFile();
            FileWriter writer = new FileWriter(writeName);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(failOrderInfos.size()+"\r\n");
            for (BossFailOrder failOrder : failOrderInfos) {
                out.write(failOrder.getExternalOrderId()+"|"+failOrder.getUserPhone()+"|"+failOrder.getCode());
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //上传文件到目标服务器
        File file = new File(writeLocalPath + writeFileName);
        InputStream is = new FileInputStream(file);
        sftp.upload("/", writeFilePath, writeFileName, is);

        sftp.logout();
    }


    private BossOrderInfo lineToBossOrderInfo(String line) {
        List<String> list = Arrays.asList(line.split("\\|"));
        return new BossOrderInfo(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
    }

}

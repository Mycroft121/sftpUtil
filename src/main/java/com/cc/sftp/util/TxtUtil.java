package com.cc.sftp.util;

import java.io.*;

/**
 * @Author: cc
 * @Date: 2018-12-06 16:50
 * @Description: 操作txt文件工具类
 */
public class TxtUtil {
    public static void main(String args[]) {
        //readFile("/Users/chencheng/develop/1.txt");
        writeFile("/Users/chencheng/develop/1.txt");
    }

    /**
     * 读入TXT文件
     * @param readFile txt文件路径
     */
    public static void readFile(String readFile) {
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
    public static void writeFile(String writeFile) {
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

}

package com.cc.sftp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SftpApplicationTests {

    @Test
    public void contextLoads() {
        String val = "1000000001|13812148457|MIGU|10000|2018-11-02 14:55:04|2018-11-02 14:55:04";
        List<String> list = Arrays.asList(val.split("\\|"));
        List<String> newList = new ArrayList<>();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(newList);
        System.out.println(newList.size());
    }
}

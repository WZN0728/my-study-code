package com.study.demo.mode.adapter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author wuting
 * @date 2019/02/14
 */
@Service
public class AliSDK {

    public String putBuket(String fileName) {
        System.out.printf("ali sdk buket:%s%n", fileName);
        return "put buket success";
    }

    public String uploadFile(String fileName) {
        System.out.printf("ali sdk upload:%s%n", fileName);
        return "uploadFile success";
    }

}

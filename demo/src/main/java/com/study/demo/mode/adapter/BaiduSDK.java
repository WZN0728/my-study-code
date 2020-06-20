package com.study.demo.mode.adapter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author wuting
 * @date 2019/02/14
 */
@Service
public class BaiduSDK {

    public String putObject(String fileName) {
        System.out.printf("上传文件:%s%n成功", fileName);
        return "baidu sdk success";
    }

}

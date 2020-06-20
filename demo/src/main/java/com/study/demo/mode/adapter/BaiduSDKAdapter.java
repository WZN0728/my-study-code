package com.study.demo.mode.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class BaiduSDKAdapter implements CloudSDK {

    private static final BaiduSDK baiduSDK = new BaiduSDK();

    @Override
    public void putObject(String fileName) {
        String baiduSDKResult = baiduSDK.putObject(fileName);
        System.out.printf("baiduSDKResult:%s%n", baiduSDKResult);
    }

}

package com.study.demo.mode.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class AliSDKAdapter implements CloudSDK {

    private static final AliSDK aliSDK = new AliSDK();

    @Override
    public void putObject(String fileName) {
        String buketResult = aliSDK.putBuket(fileName);
        String uploadResult = aliSDK.uploadFile(fileName);
        System.out.printf("buketResult:%s,uploadResult:%s%n", buketResult, uploadResult);
    }

}

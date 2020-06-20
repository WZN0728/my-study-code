package com.study.demo.mode.adapterThink;

/**
 * @author wuting
 * @date 2019/06/02
 */
public class AliSDKAdapter implements CloudSDK {

    AliSDK aliSDK;

    public AliSDKAdapter(AliSDK aliSDK) {
        this.aliSDK = aliSDK;
    }

    @Override
    public void putObject(String fileName) {
        aliSDK.putBucket();
        aliSDK.uploadFile(fileName);
    }

}

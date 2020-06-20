package com.study.demo.mode.adapterThink;

/**
 * @author wuting
 * @date 2019/06/02
 */
public class BaiduSDKAdapter implements CloudSDK {

    BaiduSDK baiduSDK;

    public BaiduSDKAdapter(BaiduSDK baiduSDK) {
        this.baiduSDK = baiduSDK;
    }

    @Override
    public void putObject(String fileName) {
        baiduSDK.pubObject(fileName);
    }

}

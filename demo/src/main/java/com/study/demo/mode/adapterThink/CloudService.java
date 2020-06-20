package com.study.demo.mode.adapterThink;

/**
 * @author wuting
 * @date 2019/06/02
 */
public class CloudService {

    CloudSDK cloudSDK;

    public CloudService(String sdkType) {
        this.cloudSDK = CloudSDKFactory.createSDK(sdkType);
    }

    public void putObject(String fileName) {
        cloudSDK.putObject(fileName);
    }

}

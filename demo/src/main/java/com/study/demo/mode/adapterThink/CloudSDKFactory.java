package com.study.demo.mode.adapterThink;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuting
 * @date 2019/06/02
 */
public class CloudSDKFactory {

    private static Map<String, CloudSDK> cloudSDKMap = new ConcurrentHashMap<>();

    static {
        cloudSDKMap.put("ALISDK", new AliSDKAdapter(new AliSDK()));
        cloudSDKMap.put("BDSDK", new BaiduSDKAdapter(new BaiduSDK()));
    }

    public static CloudSDK createSDK(String sdk) {
        return cloudSDKMap.get(sdk);
    }

}

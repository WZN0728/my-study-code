package com.study.demo.mode.adapter;

import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class CloudSDKFactory {

    private static final SDKBean sdkBean = new SDKBean();

    static final Map<String, CloudSDK> cloudSDKMap = new ConcurrentHashMap<String, CloudSDK>();

    static {
        cloudSDKMap.put("ALISDK", new AliSDKAdapter());
        cloudSDKMap.put("BAIDUSDK", new BaiduSDKAdapter());
    }

    public static CloudSDK create(String strategyCloudSDK) {
        if (StringUtils.isEmpty(strategyCloudSDK)) {
            sdkBean.putSDKValue("ALISDK");
        } else {
            sdkBean.putSDKValue(strategyCloudSDK);
        }
        return cloudSDKMap.get(sdkBean.getSDKValue());
    }

}

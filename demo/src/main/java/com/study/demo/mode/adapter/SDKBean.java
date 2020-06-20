package com.study.demo.mode.adapter;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuting
 * @date 2019/02/14
 */
@Repository
public class SDKBean {

    private List<String> strategyCloudSDKList = new ArrayList<String>();

    public void putSDKValue(String strategyCloudSDK) {
        strategyCloudSDKList.clear();
        strategyCloudSDKList.add(strategyCloudSDK);
    }

    public String getSDKValue() {
        return strategyCloudSDKList.get(0);
    }

    public List<String> getStrategyCloudSDKList() {
        return strategyCloudSDKList;
    }

}

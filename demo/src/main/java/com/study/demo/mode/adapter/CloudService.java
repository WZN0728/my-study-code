package com.study.demo.mode.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * All rights Reserved, Designed By MyCompany
 *
 * @version V1.0
 * @Package com.study.demo.mode.adapter
 * @Description: 适配器模式下的实现(用一句话描述该文件做什么)
 * @author: 吴停
 * @Copyright: 2019/2/14 14:39 All rights reserved.
 */
@Service
public class CloudService {

    CloudSDK cloudSDK;

    private void init(String strategyCloudSDK) {
        this.cloudSDK = CloudSDKFactory.create(strategyCloudSDK);
    }

    public void putObject(String fileName, String strategyCloudSDK) {
        init(strategyCloudSDK);
        cloudSDK.putObject(fileName);
    }

}

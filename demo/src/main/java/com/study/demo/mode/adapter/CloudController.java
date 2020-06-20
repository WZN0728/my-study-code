package com.study.demo.mode.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wuting
 * @date 2019/02/14
 */
@Controller
public class CloudController {

    @Autowired
    CloudService cloudService;

    @Autowired
    SDKBean sdkBean;

    @RequestMapping(value = "/cloud")
    public String uploadFile(@RequestParam String fileName, String strategyCloudSDK) {
        sdkBean.putSDKValue(strategyCloudSDK);
        cloudService.putObject(fileName, strategyCloudSDK);
        return "success";
    }

}

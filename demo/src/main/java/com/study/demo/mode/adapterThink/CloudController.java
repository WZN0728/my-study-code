package com.study.demo.mode.adapterThink;

/**
 * @author wuting
 * @date 2019/06/02
 */
public class CloudController {

    CloudService cloudService;

    public CloudController(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    public void storeUpload() {
        cloudService.putObject("jd.zip");
    }

    public static void main(String[] args) {
        CloudController cloudController = new CloudController(new CloudService("BDSDK"));
        cloudController.storeUpload();
    }

}

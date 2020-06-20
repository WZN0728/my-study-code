package com.demo.rmi.rpc.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author wuting
 * @date 2019/03/21
 */
public class RegisterCenterImpl implements IRegisterCenter {

    private CuratorFramework curatorFramework;

    {
        curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(ZkConfig.ZK_CONNCTION_ADDRESS).sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 10))
                .build();
        curatorFramework.start();
    }

    /**
     * 所谓的注册服务其实就是根据当前的接口全路径在zk上创建一个节点
     *
     * @param serviceName
     * @param serviceAddress
     */
    @Override
    public void register(String serviceName, String serviceAddress) {
        String serverPath = ZkConfig.ZK_CONNCTION_REGISTRY + "/" + serviceName;
        try {
            //判断当前的路径是否存在
            if (curatorFramework.checkExists().forPath(serverPath) == null) {
                //不存在就创建永久节点
                curatorFramework.create().creatingParentsIfNeeded()
                        .withMode(CreateMode.PERSISTENT)
                        .forPath(serverPath, "0".getBytes());
            }
            String addressPath = serverPath + "/" + serviceAddress;
            //创建临时子节点
            String rNode = curatorFramework.create().withMode(CreateMode.EPHEMERAL)
                    .forPath(addressPath, "0".getBytes());
            System.out.printf("服务注册成功:%s%n", rNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

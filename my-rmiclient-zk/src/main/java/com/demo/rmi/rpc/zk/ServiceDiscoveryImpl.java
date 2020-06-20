package com.demo.rmi.rpc.zk;

import com.alibaba.fastjson.JSON;
import com.demo.rmi.rpc.balance.LoadBalance;
import com.demo.rmi.rpc.balance.RandomLoadBalance;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.List;

/**
 * @author wuting
 * @date 2019/03/21
 */
public class ServiceDiscoveryImpl implements IServiceDiscovery {

    private String serviceAddress;

    private List<String> response;

    CuratorFramework curatorFramework;

    public ServiceDiscoveryImpl(String serviceAddress) {
        this.serviceAddress = serviceAddress;
        curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(ZkConfig.ZK_CONNCTION_ADDRESS)
                .connectionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 10))
                .build();
        curatorFramework.start();
    }

    @Override
    public String discovery(String serviceName) {
        String path = ZkConfig.ZK_CONNCTION_REGISTRY + "/" + serviceName;
        try {
            response = curatorFramework.getChildren().forPath(path);
            System.out.printf("获取到的子节点值:%s%n", JSON.toJSONString(response));
        } catch (Exception e) {
            throw new RuntimeException("获取子节点异常!!!");
        }
        //动态服务发现节点的变化
        registerWacher(path);
        //负载均衡机制
        LoadBalance loadBalance = new RandomLoadBalance();
        return loadBalance.selectHost(response);
    }

    private void registerWacher(final String path) {
        PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework, path, true);
        PathChildrenCacheListener pathChildrenCacheListener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                response = curatorFramework.getChildren().forPath(path);
            }
        };
        pathChildrenCache.getListenable().addListener(pathChildrenCacheListener);
        try {
            pathChildrenCache.start();
        } catch (Exception e) {
            throw new RuntimeException("注册 pathChildren 异常:" + e);
        }
    }

}

/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  ZkclientApiOperationTest.java
 * @Package com.test.zkclient
 * @Copyright: 2018 All rights reserved.
 */
package com.test.zkclient;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher.Event.KeeperState;

/**
 * @ClassName: ZkclientApiOperationTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月13日 上午11:00:55
 */
public class ZkclientApiOperationTest {

	private static final String CONNECTIONSTRING = "192.168.10.128:2181,192.168.10.129:2181,192.168.10.130:2181,192.168.10.131:2181";

	public static void main(String[] args) {
		ZkClient zkClient = new ZkClient(CONNECTIONSTRING, 5000);
		// 递归创建父节点功能
		// zkClient.createPersistent("/wyl/lxr/wt", true);
		// 递归删除父节点功能
		// zkClient.deleteRecursive("/wyl");
		// 创建节点并且在节点上添加数据
		// String createResult = zkClient.create("/wyl", "family".getBytes(),
		// CreateMode.PERSISTENT);
		// System.out.println(createResult);
		// 获取子节点
		List<String> list = zkClient.getChildren("/node");
		System.out.println(list);
		zkClient.writeData("/wyl", "my son");
		zkClient.subscribeDataChanges("/wyl", new IZkDataListener() {

			@Override
			public void handleDataDeleted(String dataPath) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(dataPath);
			}

			@Override
			public void handleDataChange(String dataPath, Object data) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(dataPath + " -> " + data.toString());
			}
		});
		zkClient.delete("/node/node1", -1);
		zkClient.subscribeChildChanges("/node", new IZkChildListener() {

			@Override
			public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(parentPath + "->" + currentChilds.toString());
			}
		});
		zkClient.subscribeStateChanges(new IZkStateListener() {

			@Override
			public void handleStateChanged(KeeperState state) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(state);
			}

			@Override
			public void handleSessionEstablishmentError(Throwable error) throws Exception {
				// TODO Auto-generated method stub

			}

			@Override
			public void handleNewSession() throws Exception {
				// TODO Auto-generated method stub

			}
		});
	}

}

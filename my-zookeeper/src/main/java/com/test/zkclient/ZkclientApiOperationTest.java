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
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��13�� ����11:00:55
 */
public class ZkclientApiOperationTest {

	private static final String CONNECTIONSTRING = "192.168.10.128:2181,192.168.10.129:2181,192.168.10.130:2181,192.168.10.131:2181";

	public static void main(String[] args) {
		ZkClient zkClient = new ZkClient(CONNECTIONSTRING, 5000);
		// �ݹ鴴�����ڵ㹦��
		// zkClient.createPersistent("/wyl/lxr/wt", true);
		// �ݹ�ɾ�����ڵ㹦��
		// zkClient.deleteRecursive("/wyl");
		// �����ڵ㲢���ڽڵ����������
		// String createResult = zkClient.create("/wyl", "family".getBytes(),
		// CreateMode.PERSISTENT);
		// System.out.println(createResult);
		// ��ȡ�ӽڵ�
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

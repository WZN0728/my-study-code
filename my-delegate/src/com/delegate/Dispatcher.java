/**
 * 
 */
package com.delegate;

/**
 * <p>
 * 标题：my-delegate
 * </p>
 * <p>
 * 描述：Dispatcher
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.delegate.Dispatcher.java
 * </p>
 * <p>
 * 版权：Copyright (c) 2002-2016 Digitalchina CO.,LTD. All rights reserved.
 * </p>
 * <p>
 * 公司：神州数码系统集成服务有限公司
 * </p>
 * <p>
 * 作者：wuting
 * </p>
 * <p>
 * 创建时间：2017年12月20日下午3:05:46
 * </p>
 * <p>
 * 负责人：wuting
 * </p>
 * <p>
 * 部门：工程院安全可靠研发中心产品研发部
 * </p>
 * <p>
 * 修改者：wuting
 * </p>
 * <p>
 * 修改时间：2017年12月20日下午3:05:46
 * </p>
 * <p>
 * 修改内容：
 * </p>
 */
public class Dispatcher {

	IExecutor ieExecutor;

	public Dispatcher(IExecutor ieExecutor) {
		this.ieExecutor = ieExecutor;
	}

	// 委派模式与代理模式的区别：只关心结果，不关心过程（项目经理分活，程序员干活，功劳是我的，干活是你的）
	// 委派模式与工厂模式的区别：知道自己把活委派给了谁，但是工厂模式不需要用户关心具体哪个工厂干的活，默认工厂会根据用户的需求自动调用相对应的工厂方法
	public void doWork() {
		ieExecutor.doWork();
	}

}
/**
 * 
 */
package com.delegate;

/** 
 * <p>标题：my-delegate</p>
 * <p>描述：ExecutorPgB</p>
 * <p>编译者：wuting</p>
 * <p>版本：1.0</p>
 * <p>文件名：com.delegate.ExecutorPgB.java</p>
 * <p>版权：Copyright (c) 2002-2016 Digitalchina CO.,LTD.  All rights reserved.</p>
 * <p>公司：神州数码系统集成服务有限公司</p>
 * <p>作者：wuting</p>
 * <p>创建时间：2017年12月20日下午3:04:17</p>
 * <p>负责人：wuting</p>
 * <p>部门：工程院安全可靠研发中心产品研发部</p>
 * <p>修改者：wuting</p>
 * <p>修改时间：2017年12月20日下午3:04:17</p>
 * <p>修改内容：</p>
 */
public class ExecutorPgB implements IExecutor {

	@Override
	public void doWork() {
		System.out.println("b程序员干活");
	}

}
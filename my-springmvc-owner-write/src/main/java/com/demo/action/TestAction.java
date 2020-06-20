/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  TestAction.java
 * @Package com.framework.test
 * @Copyright: 2018 All rights reserved.
 */
package com.demo.action;

import com.demo.service.INamedService;
import com.demo.service.ITestService;
import com.framework.annotation.MyAutowired;
import com.framework.annotation.MyController;

/**
 * @ClassName: TestAction
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月29日 下午10:44:37
 */
@MyController
public class TestAction {

	@MyAutowired
	private ITestService iTestService;

	@MyAutowired("named")
	private INamedService namedService;

}

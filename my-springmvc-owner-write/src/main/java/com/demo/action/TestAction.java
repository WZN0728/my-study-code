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
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��29�� ����10:44:37
 */
@MyController
public class TestAction {

	@MyAutowired
	private ITestService iTestService;

	@MyAutowired("named")
	private INamedService namedService;

}

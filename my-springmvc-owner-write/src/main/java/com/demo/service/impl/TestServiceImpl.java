/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  ServiceImpl.java
 * @Package com.framework.service.impl
 * @Copyright: 2018 All rights reserved.
 */
package com.demo.service.impl;

import com.demo.service.ITestService;
import com.framework.annotation.MyAutowired;
import com.framework.annotation.MyService;

/**
 * @ClassName: ServiceImpl
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��29�� ����10:45:50
 */
@MyService
public class TestServiceImpl implements ITestService {

	@MyAutowired
	private ITestService testService;

}

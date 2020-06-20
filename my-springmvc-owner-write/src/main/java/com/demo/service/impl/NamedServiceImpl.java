/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  NamedServiceImpl.java
 * @Package com.framework.service.impl
 * @Copyright: 2018 All rights reserved.
 */
package com.demo.service.impl;

import com.demo.service.INamedService;
import com.framework.annotation.MyAutowired;
import com.framework.annotation.MyService;

/**
 * @ClassName: NamedServiceImpl
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��29�� ����10:49:14
 */
@MyService("named")
public class NamedServiceImpl implements INamedService {

	@MyAutowired
	private INamedService namedService;

}

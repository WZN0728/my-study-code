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
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月29日 下午10:45:50
 */
@MyService
public class TestServiceImpl implements ITestService {

	@MyAutowired
	private ITestService testService;

}

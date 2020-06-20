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
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月29日 下午10:49:14
 */
@MyService("named")
public class NamedServiceImpl implements INamedService {

	@MyAutowired
	private INamedService namedService;

}

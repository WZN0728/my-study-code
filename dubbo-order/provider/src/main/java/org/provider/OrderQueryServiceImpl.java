/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  OrderQueryServiceImpl.java
 * @Package org.provider
 * @Copyright: 2018 All rights reserved.
 */
package org.provider;

import org.api.IOrderQueryService;
import org.springframework.stereotype.Service;

/**
 * @ClassName:  OrderQueryServiceImpl
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date:   2018年4月17日 下午6:10:32
 */
@Service("orderQuerySerice")
public class OrderQueryServiceImpl implements IOrderQueryService{

	public String queryOrder(String value) {
		System.out.println("接收到的消息   ->   "+value);
		return value;
	}

	
	
}

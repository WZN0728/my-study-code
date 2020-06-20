/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  IOrderService.java
 * @Package org.api
 * @Copyright: 2018 All rights reserved.
 */
package org.api;

/**
 * @ClassName:  IOrderService
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date:   2018年4月17日 上午11:39:34
 */
public interface IOrderService {

	DoOrderResponse doOrder(DoOrderRequest doOrderRequest);
	
}

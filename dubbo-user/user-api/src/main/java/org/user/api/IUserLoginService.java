/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  UserLogin.java
 * @Package org.user.api
 * @Copyright: 2018 All rights reserved.
 */
package org.user.api;

import org.user.api.dto.UserLoginRequest;
import org.user.api.dto.UserLoginResponse;

/**
 * @ClassName: UserLogin
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月18日 下午3:22:16
 */
public interface IUserLoginService {

	UserLoginResponse login(UserLoginRequest userLoginRequest);

}

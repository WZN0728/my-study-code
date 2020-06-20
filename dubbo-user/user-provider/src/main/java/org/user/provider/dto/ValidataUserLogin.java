/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  ValidataUserLogin.java
 * @Package org.user.provider.dto
 * @Copyright: 2018 All rights reserved.
 */
package org.user.provider.dto;

import org.springframework.util.StringUtils;
import org.user.api.dto.UserLoginRequest;

/**
 * @ClassName: ValidataUserLogin
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月18日 下午4:40:31
 */
public class ValidataUserLogin {

	public static boolean checkUserLogin(UserLoginRequest userLoginRequest) {
		if (StringUtils.isEmpty(userLoginRequest.getUsername())
				|| StringUtils.isEmpty(userLoginRequest.getPassword())) {
			return false;
		}
		return true;
	}

}

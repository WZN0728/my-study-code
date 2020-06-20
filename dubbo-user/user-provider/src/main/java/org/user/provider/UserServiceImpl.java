/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  UserServiceImpl.java
 * @Package org.user.provider
 * @Copyright: 2018 All rights reserved.
 */
package org.user.provider;

import org.springframework.stereotype.Service;
import org.user.api.IUserLoginService;
import org.user.api.dto.UserLoginRequest;
import org.user.api.dto.UserLoginResponse;
import org.user.provider.dto.ValidataUserLogin;

/**
 * @ClassName: UserServiceImpl
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月18日 下午4:35:42
 */
@Service("userService")
public class UserServiceImpl implements IUserLoginService {

	public UserLoginResponse login(UserLoginRequest userLoginRequest) {
		UserLoginResponse userLoginResponse = new UserLoginResponse();
		if (ValidataUserLogin.checkUserLogin(userLoginRequest)) {
			userLoginResponse.setCode("000000");
			userLoginResponse.setMessage("用户或密码不能为空!");
		}
		if ("admin".equals(userLoginRequest.getUsername()) && "admin".equals(userLoginRequest.getPassword())) {
			userLoginResponse.setCode("111111");
			userLoginResponse.setMessage("登录成功!");
		} else {
			userLoginResponse.setCode("222222");
			userLoginResponse.setMessage("用户不存在!");
		}
		return userLoginResponse;
	}

}

/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  UserLoginRequest.java
 * @Package org.user.api.dto
 * @Copyright: 2018 All rights reserved.
 */
package org.user.api.dto;

import java.io.Serializable;

/**
 * @ClassName: UserLoginRequest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月18日 下午3:41:04
 */
public class UserLoginRequest implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -1577124348770912600L;

	private String username;

	private String password;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("UserLoginRequest [username=%s, password=%s]", username, password);
	}

}

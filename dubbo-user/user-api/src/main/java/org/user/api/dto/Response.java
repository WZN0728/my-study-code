/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  Response.java
 * @Package org.user.api.dto
 * @Copyright: 2018 All rights reserved.
 */
package org.user.api.dto;

import java.io.Serializable;

/**
 * @ClassName:  Response
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date:   2018年4月18日 下午3:26:33
 */
public class Response implements Serializable{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -8339748964814585877L;
	
	private String code;
	
	private String message;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Response [code=%s, message=%s]", code, message);
	}

}

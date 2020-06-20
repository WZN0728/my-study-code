/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  DoOrderResponse.java
 * @Package org.api
 * @Copyright: 2018 All rights reserved.
 */
package org.api;

import java.io.Serializable;

/**
 * @ClassName:  DoOrderResponse
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date:   2018年4月17日 上午11:39:19
 */
public class DoOrderResponse implements Serializable{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 7123433212154082519L;
	
	private String name;
	
	private String code;
	
	private String data;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

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
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("DoOrderResponse [name=%s, code=%s, data=%s]", name, code, data);
	}

}

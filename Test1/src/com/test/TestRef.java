/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  TestRef.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

/**
 * @ClassName:  TestRef
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date:   2018年4月24日 下午10:38:45
 */
public class TestRef {
	
	private String name = "abc";
	
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

	class test1 extends TestRef{
		test1 t1 = (test1) new TestRef();
	}

}

/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  TestRef.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

/**
 * @ClassName:  TestRef
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date:   2018��4��24�� ����10:38:45
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

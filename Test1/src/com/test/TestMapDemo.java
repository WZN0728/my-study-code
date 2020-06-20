/**
 * <p>Title: Test.java</p>
 * <p>Description: 项目：my-spring-boot 包名：com.test.myspringboot</p>   
 * <p>Copyright: Copyright (c) 2017</p>   
 * <p>Company: cyberplus</p>   
 * @author wuting   
 * @date 2018年2月5日 下午4:30:39  
 * @version 1.0   
*/
package com.test;

import java.util.HashMap;
import java.util.Map;

public class TestMapDemo {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 2; i++) {
			map.put(1, i);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("key = " + entry.getKey() + " : " + "value = " + entry.getValue());
		}
	}

}

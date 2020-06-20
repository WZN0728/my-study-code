/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  TestJson.java
 * @Package com.gupao
 * @Copyright: 2018 All rights reserved.
 */
package com.gupao.json;

import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;

/**
 * @ClassName: TestJson
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月4日 下午1:20:22
 */
public class TestJson {

	private static String json1 = "[{\"layoutTreeName\":\"是否换行\",\"layoutTreeId\":\"ds.obj.fields.endLine\",\"fdId\":135},\n"
			+ "{\"layoutTreeName\":\"数据源\",\"layoutTreeId\":\"ds.obj.fields.lDataSourse\",\"fdId\":136}]";

	private static String json2 = "[{layoutTreeName=是否换行, layoutTreeId=ds.obj.fields.endLine, dataType=08}, {layoutTreeName=数据源, layoutTreeId=ds.obj.fields.lDataSourse, dataType=01}, {layoutTreeName=页面唯一标识, layoutTreeId=ds.obj.fields.docId, dataType=01}]";

	public static void main(String[] args) throws Exception {
		// test1();
		test2();
	}

	public static void test1() {
		net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(json1);
		for (int i = 0; i < json.size(); i++) {
			JSONObject job = json.getJSONObject(i);
			String s = job.getString("fdId");
			String s1 = job.getString("layoutTreeId");
			System.out.println(s + " : " + s1);
		}
	}

	public static void test2() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		List list = mapper.readValue(json1, List.class);
		for (int i = 0; i < list.size(); i++) {
			LinkedHashMap map = (LinkedHashMap) list.get(i);
			System.out.println(map.get("fdId"));
		}
	}

}

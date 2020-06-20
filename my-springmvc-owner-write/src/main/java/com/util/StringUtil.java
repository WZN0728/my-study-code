/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  StringUtil.java
 * @Package com.framework.util
 * @Copyright: 2018 All rights reserved.
 */
package com.util;

/**
 * @ClassName: StringUtil
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��28�� ����9:29:33
 */
public class StringUtil {

	// ����ĸתСд
	public static String toLowerCaseFirstOne(String value) {
		if (Character.isLowerCase(value.charAt(0))) {
			return value;
		} else {
			return (new StringBuilder()).append(Character.toLowerCase(value.charAt(0))).append(value.substring(1))
					.toString();
		}
	}

	// ����ĸת��д
	public static String toUpperCaseFirstOne(String value) {
		if (Character.isUpperCase(value.charAt(0))) {
			return value;
		} else {
			return (new StringBuilder()).append(Character.toUpperCase(value.charAt(0))).append(value.substring(1))
					.toString();
		}
	}

}

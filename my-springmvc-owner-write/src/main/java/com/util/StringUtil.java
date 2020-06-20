/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  StringUtil.java
 * @Package com.framework.util
 * @Copyright: 2018 All rights reserved.
 */
package com.util;

/**
 * @ClassName: StringUtil
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月28日 下午9:29:33
 */
public class StringUtil {

	// 首字母转小写
	public static String toLowerCaseFirstOne(String value) {
		if (Character.isLowerCase(value.charAt(0))) {
			return value;
		} else {
			return (new StringBuilder()).append(Character.toLowerCase(value.charAt(0))).append(value.substring(1))
					.toString();
		}
	}

	// 首字母转大写
	public static String toUpperCaseFirstOne(String value) {
		if (Character.isUpperCase(value.charAt(0))) {
			return value;
		} else {
			return (new StringBuilder()).append(Character.toUpperCase(value.charAt(0))).append(value.substring(1))
					.toString();
		}
	}

}

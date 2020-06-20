/**
 * 
 */
package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 标题：sort
 * </p>
 * <p>
 * 描述：OperationString
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.OperationString.java
 * </p>
 * <p>
 * 版权：Copyright (c) 2002-2016 Digitalchina CO.,LTD. All rights reserved.
 * </p>
 * <p>
 * 公司：神州数码系统集成服务有限公司
 * </p>
 * <p>
 * 作者：wuting
 * </p>
 * <p>
 * 创建时间：2016年12月16日下午2:48:56
 * </p>
 * <p>
 * 负责人：wuting
 * </p>
 * <p>
 * 部门：工程院安全可靠研发中心产品研发部
 * </p>
 * <p>
 * 修改者：wuting
 * </p>
 * <p>
 * 修改时间：2016年12月16日下午2:48:56
 * </p>
 * <p>
 * 修改内容：
 * </p>
 */
public class OperationString {

	public static void main(String[] args) {
		String s = "love23next234csdn3423javaeye";
		System.out.println(getStringNum(s));
		System.out.println(getStringLetter(s));
	}

	public static String getStringNum(String value) {
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(value);
		return m.replaceAll("");
	}

	public static String getStringLetter(String value) {
		Pattern p = Pattern.compile("[^a-zA-Z]");
		Matcher m = p.matcher(value);
		return m.replaceAll("");
	}

}
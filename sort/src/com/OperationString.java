/**
 * 
 */
package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * ���⣺sort
 * </p>
 * <p>
 * ������OperationString
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.OperationString.java
 * </p>
 * <p>
 * ��Ȩ��Copyright (c) 2002-2016 Digitalchina CO.,LTD. All rights reserved.
 * </p>
 * <p>
 * ��˾����������ϵͳ���ɷ������޹�˾
 * </p>
 * <p>
 * ���ߣ�wuting
 * </p>
 * <p>
 * ����ʱ�䣺2016��12��16������2:48:56
 * </p>
 * <p>
 * �����ˣ�wuting
 * </p>
 * <p>
 * ���ţ�����Ժ��ȫ�ɿ��з����Ĳ�Ʒ�з���
 * </p>
 * <p>
 * �޸��ߣ�wuting
 * </p>
 * <p>
 * �޸�ʱ�䣺2016��12��16������2:48:56
 * </p>
 * <p>
 * �޸����ݣ�
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
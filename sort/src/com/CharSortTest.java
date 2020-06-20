/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  CharSortTest.java
 * @Package com
 * @Copyright: 2018 All rights reserved.
 */
package com;

/**
 * @ClassName: CharSortTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��25�� ����12:24:00
 */
public class CharSortTest {

	public static void main(String[] args) {
		System.out.println(compareToTest("abc", "def"));
	}

	public static int compareToTest(String value, String anotherString) {
		int len1 = value.length();
		int len2 = anotherString.length();
		int lim = Math.min(len1, len2);
		char v1[] = value.toCharArray();
		char v2[] = anotherString.toCharArray();

		int k = 0;
		while (k < lim) {
			char c1 = v1[k];
			char c2 = v2[k];
			if (c1 != c2) {
				return c1 - c2;
			}
			k++;
		}
		return len1 - len2;
	}

}

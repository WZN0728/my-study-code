/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  TryCatchFinally.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

/**
 * @ClassName: TryCatchFinally
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��8�� ����10:57:02
 */
public class TryCatchFinally {

	/**
	 * �ܽ᣺
	 * 1
	 * try��catch��finally����У������try�����return��䣬�򷵻ص�֮��ǰtry�б�����ʱ��Ӧ��ֵ���˺�Ա������κε��޸ģ�����Ӱ��try��return�ķ���ֵ
	 * 
	 * 2 ���finally������return ��䣬�򷵻�try��catch�еķ��������ԡ�
	 * 
	 * 3 ���finally�����׳��쳣��������try��catch��finally�����׳��쳣 @Title: test @Description:
	 * TODO(������һ�仰�����������������) @param: @return @return: String @throws
	 */
	/**
	 * ע�⣺
	 * 1 ������try����catch��ʹ��return��䡣ͨ��finally���дﵽ��try����catch����ֵ�޸��ǲ����еġ�
	 * 
	 * 2 finally���б���ʹ��return��䣬��Ϊfinally�������ʹ��return��䣬����ʾ��������try��catch���е��쳣��Ϣ�������˴���ķ���
	 * 
	 * 3 finally���б����ٴ��׳��쳣��������������try����ķ������׳��쳣�����һ�������try��catch���е��쳣 @Title:
	 * test @Description: TODO(������һ�仰�����������������) @param: @return @return:
	 * String @throws
	 */
	public static final String test() {
		String t = "";
		try {
			t = "try";
//			return t;
		} catch (Exception e) {
			t = "catch";
			return t;
		} finally {
			t = "finally";
		}
		return t;
	}

	public static void main(String[] args) {
		System.out.print(TryCatchFinally.test());
	}

}

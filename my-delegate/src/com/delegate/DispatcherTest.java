/**
 * 
 */
package com.delegate;

/** 
 * <p>���⣺my-delegate</p>
 * <p>������DispatcherTest</p>
 * <p>�����ߣ�wuting</p>
 * <p>�汾��1.0</p>
 * <p>�ļ�����com.delegate.DispatcherTest.java</p>
 * <p>��Ȩ��Copyright (c) 2002-2016 Digitalchina CO.,LTD.  All rights reserved.</p>
 * <p>��˾����������ϵͳ���ɷ������޹�˾</p>
 * <p>���ߣ�wuting</p>
 * <p>����ʱ�䣺2017��12��20������3:07:00</p>
 * <p>�����ˣ�wuting</p>
 * <p>���ţ�����Ժ��ȫ�ɿ��з����Ĳ�Ʒ�з���</p>
 * <p>�޸��ߣ�wuting</p>
 * <p>�޸�ʱ�䣺2017��12��20������3:07:00</p>
 * <p>�޸����ݣ�</p>
 */
public class DispatcherTest {

	public static void main(String[] args) {
		Dispatcher dispatcher = new Dispatcher(new ExecutorPgA());
		dispatcher.doWork();
	}
	
}
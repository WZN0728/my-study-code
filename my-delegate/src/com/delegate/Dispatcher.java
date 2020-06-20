/**
 * 
 */
package com.delegate;

/**
 * <p>
 * ���⣺my-delegate
 * </p>
 * <p>
 * ������Dispatcher
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.delegate.Dispatcher.java
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
 * ����ʱ�䣺2017��12��20������3:05:46
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
 * �޸�ʱ�䣺2017��12��20������3:05:46
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
public class Dispatcher {

	IExecutor ieExecutor;

	public Dispatcher(IExecutor ieExecutor) {
		this.ieExecutor = ieExecutor;
	}

	// ί��ģʽ�����ģʽ������ֻ���Ľ���������Ĺ��̣���Ŀ����ֻ����Ա�ɻ�������ҵģ��ɻ�����ģ�
	// ί��ģʽ�빤��ģʽ������֪���Լ��ѻ�ί�ɸ���˭�����ǹ���ģʽ����Ҫ�û����ľ����ĸ������ɵĻĬ�Ϲ���������û��������Զ��������Ӧ�Ĺ�������
	public void doWork() {
		ieExecutor.doWork();
	}

}
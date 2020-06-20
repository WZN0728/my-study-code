/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  AutomicIntegerTest.java
 * @Package com.automic
 * @Copyright: 2018 All rights reserved.
 */
package com.atomic;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * @ClassName: AutomicIntegerTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��12�� ����11:12:15
 */
public class AutomicIntegerTest {

	static AtomicInteger ai = new AtomicInteger(1);

	/**
	 * ������getAndIncrement��getAndAdd��getAndSet���صĶ���ԭ�ȵ�ֵ��ֻ������Щ����ִ�й�����ͨ��get()��������ȡʱ���ܻ�ȡ�����º��ֵ @Title:
	 * main @Description: TODO(������һ�仰�����������������) @param: @param args @return:
	 * void @throws
	 */
	public static void main(String[] args) {
		// ��ԭ�ӷ�ʽ����ǰֵ��1��ע�⣬���ﷵ�ص�������ǰ��ֵ��
		/**
		 * public final int getAndIncrement() { for (;;) { int current = get(); int next
		 * = current + 1; if (compareAndSet(current, next)) return current; } } public
		 * final boolean compareAndSet(int expect, int update) { return
		 * unsafe.compareAndSwapInt(this, valueOffset, expect, update); }
		 */
		int a = ai.getAndIncrement();
		System.out.println("a  " + a);
		int b = ai.get();
		System.out.println("b  " + b);
		int c = ai.getAndAdd(2);
		System.out.println("c  " + c);
		System.out.println("����֮���ֵ" + ai.get());
		// ��boolean compareAndSet��int expect��int update��������������ֵ����Ԥ��ֵ������ԭ�ӷ�
		// ʽ����ֵ����Ϊ�����ֵ��
		boolean d = ai.compareAndSet(2, 2);
		System.out.println("d  " + d);
		System.out.println(ai.get());
		// ��ԭ�ӷ�ʽ����ΪnewValue��ֵ�������ؾ�ֵ��
		int e = ai.getAndSet(3);
		System.out.println("e  " + e);
		System.out.println(ai.get());
		/**
		 * ���ջ����ó�newValue��ʹ��lazySet����ֵ�󣬿��ܵ������� �߳���֮���һС��ʱ���ڻ��ǿ��Զ����ɵ�ֵ�����ڸ÷����ĸ�����Ϣ���Բο��������
		 * �������һƪ���¡�AtomicLong.lazySet����ι����ģ��������µ�ַ�ǡ�http://ifeve.com/howdoes-
		 * atomiclong-lazyset-work/���� �������������ʱû�з��ֲ�ѯ����ֵ���ӳ�����
		 */
		ai.lazySet(6);
		System.out.println(ai.get());
		for (;;) {
			if (ai.get() == 6) {
				System.out.println("lazyset" + ai.get());
				break;
			}
		}
	}
	
}

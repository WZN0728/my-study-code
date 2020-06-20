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
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月12日 上午11:12:15
 */
public class AutomicIntegerTest {

	static AtomicInteger ai = new AtomicInteger(1);

	/**
	 * 不论是getAndIncrement、getAndAdd、getAndSet返回的都是原先的值，只有在这些方法执行过后在通过get()方法来获取时才能获取到更新后的值 @Title:
	 * main @Description: TODO(这里用一句话描述这个方法的作用) @param: @param args @return:
	 * void @throws
	 */
	public static void main(String[] args) {
		// 以原子方式将当前值加1，注意，这里返回的是自增前的值。
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
		System.out.println("设置之后的值" + ai.get());
		// ·boolean compareAndSet（int expect，int update）：如果输入的数值等于预期值，则以原子方
		// 式将该值设置为输入的值。
		boolean d = ai.compareAndSet(2, 2);
		System.out.println("d  " + d);
		System.out.println(ai.get());
		// 以原子方式设置为newValue的值，并返回旧值。
		int e = ai.getAndSet(3);
		System.out.println("e  " + e);
		System.out.println(ai.get());
		/**
		 * 最终会设置成newValue，使用lazySet设置值后，可能导致其他 线程在之后的一小段时间内还是可以读到旧的值。关于该方法的更多信息可以参考并发编程
		 * 网翻译的一篇文章《AtomicLong.lazySet是如何工作的？》，文章地址是“http://ifeve.com/howdoes-
		 * atomiclong-lazyset-work/”。 但是在这里测试时没有发现查询到的值有延迟现象
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

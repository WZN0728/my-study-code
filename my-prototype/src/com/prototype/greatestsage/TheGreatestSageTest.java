package com.prototype.greatestsage;

public class TheGreatestSageTest {

	public static void main(String[] args) throws Exception {
		// 无论是深拷贝还是浅拷贝，对象的引用都不是同一个
		// 浅拷贝的对象是同一个对象，深拷贝的对象都不是同一个
		// 1.浅拷贝：浅拷贝简单归纳就是只复制一个对象（这里指的对象其实就是对象的引用），对象内部存在指向其他对象，数组或引用则不复制。
		// 2.深拷贝：将对象中的所有字段复制到新的对象中。不过，无论是对象的值类型字段，还是引用类型字段，都会被重新创建并赋值，对于副本的修改，不会影响到源对象本身。
		TheGreatestSage theGreatestSage = new TheGreatestSage();
		System.out.println("浅拷贝克隆-----------------------");
		theGreatestSage.change1();
		System.out.println("深拷贝克隆-----------------------");
		theGreatestSage.change();
	}

}
package com.prototype.simple;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ConcretePrototypeTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		new ConcurrentHashMap();
		ArrayList<String> list = new ArrayList<String>();
		list.add("张三的其它信息");
		ConcretePrototype cp = new ConcretePrototype();
		cp.setAge(18);
		cp.setName("zhangsan");
		cp.setList(list);
		ConcretePrototype cpClone = (ConcretePrototype) cp.clone();
		//当前是使用了object的clone，属于浅拷贝
		//浅拷贝只对当前的八大基本数据类型以及string九种数据类型做拷贝（复杂类型拷贝不了）
		//浅拷贝之后对象的引用不同但是对象相同
		//拷贝不走构造方法
		System.out.println(cpClone.getAge() == cp.getAge());
		System.out.println(cpClone.getName() == cp.getName());
		System.out.println(cpClone.getAge());
		System.out.println(cpClone.getName());
		System.out.println(cpClone.getList().get(0));
		System.out.println(cpClone == cp);
		System.out.println(cpClone.equals(cp));
		System.out.println(cpClone.getList() == cp.getList());
	}
	
}
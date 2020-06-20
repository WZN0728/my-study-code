package com.prototype.simple;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ConcretePrototypeTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		new ConcurrentHashMap();
		ArrayList<String> list = new ArrayList<String>();
		list.add("������������Ϣ");
		ConcretePrototype cp = new ConcretePrototype();
		cp.setAge(18);
		cp.setName("zhangsan");
		cp.setList(list);
		ConcretePrototype cpClone = (ConcretePrototype) cp.clone();
		//��ǰ��ʹ����object��clone������ǳ����
		//ǳ����ֻ�Ե�ǰ�İ˴�������������Լ�string���������������������������Ϳ������ˣ�
		//ǳ����֮���������ò�ͬ���Ƕ�����ͬ
		//�������߹��췽��
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
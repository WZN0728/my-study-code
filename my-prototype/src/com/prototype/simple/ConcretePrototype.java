package com.prototype.simple;

import java.util.ArrayList;
import java.util.List;

public class ConcretePrototype implements Cloneable {

	private int age;
	
	private String name;
	
	private ArrayList<String> list = new ArrayList<String>();
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	protected Object clone() throws CloneNotSupportedException {
		ConcretePrototype prototype = null;
		try{
			prototype = (ConcretePrototype)super.clone();
			prototype.list = (ArrayList)list.clone();
			//克隆基于字节码的
			//用反射，或者循环
		}catch(Exception e){
			e.printStackTrace();
		}
		return prototype;
	}
	
}
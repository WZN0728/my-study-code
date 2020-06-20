package com.strategy;

import java.util.Collections;

public class MyListTest {

	//策略模式的思想
	//就是不管执行逻辑如何,最终的执行结果都是一样的
	//例如：我来公司，不管我是坐地铁还是坐公交，或者是自己开车骑自行车，最终都会到公司
	//过程不同，但是结果一样
	public static void main(String[] args) {
		new MyList().sort(new NumberComparator());
	}
	
}
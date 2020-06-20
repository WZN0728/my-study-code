package com.hahsmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {

	public static void main(String[] args) {
		//jdkHashMap();
		myHashMapTest();
	}
	
	public static void jdkHashMap(){
		Map<String,String> map = new HashMap<String,String>();
		for(int i=0;i<1000;i++){
			map.put(i+"", i+"");
		}
		for(int i=0;i<1000;i++){
			System.out.println(map.get(i+""));
		}
	}
	
	public static void myHashMapTest(){
		MyMap<String,String> map = new MyHashMap<String,String>();
		for(int i=0;i<1000;i++){
			map.put(i+"", i+"");
		}
		for(int i=0;i<1000;i++){
			System.out.println(map.get(i+""));
		}
	}

	/*JDK1.8下的ConcurrentHashMap在使用computeIfAbsent时的死循环(same hashcode)
	public static void main(String[] args) {
		Map<String, String> map = new ConcurrentHashMap<>();
		map.computeIfAbsent("AaAa",
				key -> map.
						computeIfAbsent("BBBB", key2 -> "value"));
	}*/
	
}
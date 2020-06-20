package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExceptionTest {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		try {
			Iterator<String> iterator = list.iterator();
			while (iterator.hasNext()) {
				String item = iterator.next();
				if (item.equals("3")) {
					iterator.remove();
				}
			}
			System.out.println(list.toString());
			for (Object s : list) {
				if(s.equals("3")){
					list.remove(s);
				}
			}
			System.out.println(list.toString());
		} catch (Exception e) {
			System.out.println("-------------");
			e.printStackTrace();
		}
	}

}
/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  ArrayListTest.java
 * @Package com
 * @Copyright: 2018 All rights reserved.
 */
package com;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: ArrayListTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月24日 下午10:41:07
 */
public class ArrayListTest {

	static List<Integer> intList = Arrays.asList(2, 3, 1);

	public static void main(String[] args) {
		sortBaseTypeByDefaultMode();
		sortBaseTypeByIDefineMode();
		sortEmpByDefaultMode();
		sortEmpByIDefineMode();
	}

	private static void sortBaseTypeByDefaultMode() {
		System.out.println("正序排序");
		System.out.println("before sort:");
		ArrayListTest.showList(intList);
		System.out.println("=========================");
		Collections.sort(intList);
		System.out.println("after sort:");
		ArrayListTest.showList(intList);
	}

	private static void sortBaseTypeByIDefineMode() {
		System.out.println("倒序排序");
		System.out.println("before sort:");
		ArrayListTest.showList(intList);
		System.out.println("=========================");
		Collections.sort(intList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// 返回值为int类型，大于0表示正序，小于0表示逆序
				return o2 - o1;
			}
		});
		//Collections.sort(intList, (v1,v2) -> {return v1-v2;});lambda表达
		System.out.println("after sort:");
		ArrayListTest.showList(intList);
	}

	private static void sortEmpByDefaultMode() {
		System.out.println("关于emp对象的排序");
		System.out.println("");
		System.out.println("before sort:");
		ArrayListTest.showList(empList);
		System.out.println("=========================");
		Collections.sort(empList);
		System.out.println("after sort:");
		ArrayListTest.showList(empList);
	}

	private static void sortEmpByIDefineMode() {
		System.out.println("通过reverse方法实现相反的排序");
		System.out.println("before sort:");
		ArrayListTest.showList(empList);
		System.out.println("=========================");
		Comparator<Emp> comparator = new Comparator<Emp>() {
			@Override
			public int compare(Emp o1, Emp o2) {
				/* 按员工编号正序排序 */
				// return o1.getEmpno() - o2.getEmpno();
				/* 按员工编号逆序排序 */
				// return o2.getEmpno()-o1.getEmpno();
				/* 按员工姓名正序排序 */
				// return o1.getEname().compareTo(o2.getEname());
				/* 按员工姓名逆序排序 */
				return o2.getEname().compareTo(o1.getEname());
			}
		};
		/* 新的逆序实现方式 */
		Collections.sort(empList, comparator.reversed());
		System.out.println("after sort:");
		ArrayListTest.showList(empList);
	}

	static List<Emp> empList;

	static {
		Emp emp1 = new Emp(2, "Gu Yu");
		Emp emp2 = new Emp(3, "Zhang Fei");
		Emp emp3 = new Emp(1, "Liu Bei");
		empList = Arrays.asList(emp1, emp2, emp3);
	}

	static class Emp implements Comparable<Emp> {
		private int empno;
		private String ename;

		public int getEmpno() {
			return empno;
		}

		public void setEmpno(int empno) {
			this.empno = empno;
		}

		public String getEname() {
			return ename;
		}

		public void setEname(String ename) {
			this.ename = ename;
		}

		public Emp(int empno, String ename) {
			super();
			this.empno = empno;
			this.ename = ename;
		}

		@Override
		public String toString() {
			return "empno:\t" + empno + "\tename:\t" + ename;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Emp emp) {
			/* 按员工编号正序排序 */
			// return this.getEmpno() - emp.getEmpno();
			/* 按员工编号逆序排序 */
			// return emp.getEmpno()-this.getEmpno();
			/* 按员工姓名正序排序 */
			// return this.getEname().compareTo(emp.getEname());
			/* 按员工姓名逆序排序 */
			return emp.getEname().compareTo(this.getEname());
		}
	}

	public static void showList(List list) {
		for (Object obj : list) {
			System.out.println(obj);
		}
	}

}

/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  Merge.java
 * @Package com
 * @Copyright: 2018 All rights reserved.
 */
package com;

/**
 * @ClassName: Merge
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月19日 下午5:28:36
 */
public class Merge {

	static int[] c;

	public static void main(String[] args) {
		int[] i1 = { 3, 2, 1 };
		int[] i2 = { 5, 4, 6 };
		merge(i1, i2);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + "   ");
		}
	}

	public static int[] merge(int[] a, int[] b) {
		int pa, pb, pc;
		pa = pb = pc = 0;
		int m = a.length;
		int n = b.length;
		c = new int[m + n];
		while (pa < m && pb < n) {
			if (a[pa] < b[pb]) {
				c[pc++] = a[pa++];
			} else {
				c[pc++] = b[pb++];
			}
		}
		if (pa < m) {
			while (pa < m)
				c[pc++] = a[pa++];
		} else {
			while (pb < n)
				c[pc++] = b[pb++];
		}
		return c;
	}

}

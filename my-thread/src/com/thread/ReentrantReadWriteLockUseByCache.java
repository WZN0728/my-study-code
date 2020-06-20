/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  test.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: test
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��19�� ����4:01:45
 */
public class ReentrantReadWriteLockUseByCache {
	/**
	 * ʾ���У�Cache���һ�����̰߳�ȫ��HashMap��Ϊ�����ʵ�֣�ͬʱʹ�ö�д���� ������д������֤Cache���̰߳�ȫ�ġ��ڶ�����get(String
	 * key)�����У���Ҫ��ȡ��������ʹ �ò������ʸ÷���ʱ���ᱻ������д����put(String key,Object
	 * value)������clear()�������ڸ��� HashMapʱ������ǰ��ȡд��������ȡд���������̶߳��ڶ�����д���Ļ�ȡ������������
	 * ֻ��д�����ͷ�֮��������д�������ܼ�����Cacheʹ�ö�д�������������Ĳ����ԣ�Ҳ�� ֤ÿ��д���������еĶ�д�����Ŀɼ��ԣ�ͬʱ���˱�̷�ʽ��
	 */
	static Map<String, Object> map = new HashMap<String, Object>();
	static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	static Lock r = rwl.readLock();
	static Lock w = rwl.writeLock();

	// ��ȡһ��key��Ӧ��value
	public static final Object get(String key) {
		r.lock();
		try {
			return map.get(key);
		} finally {
			r.unlock();
		}
	}

	// ����key��Ӧ��value�������ؾɵ�value
	public static final Object put(String key, Object value) {
		w.lock();
		try {
			return map.put(key, value);
		} finally {
			w.unlock();
		}
	}

	// ������е�����
	public static final void clear() {
		w.lock();
		try {
			map.clear();
		} finally {
			w.unlock();
		}
	}
}

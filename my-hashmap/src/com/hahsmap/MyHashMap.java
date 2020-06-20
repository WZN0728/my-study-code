package com.hahsmap;

public class MyHashMap<K, V> implements MyMap<K, V> {

	private int USE_SIZE;

	private static Double DEFAULT_LOAD_FACTOR = 0.75;

	private static Integer DEFAULT_INITIAL_CAPACITY = 1 << 4;

	private static final Integer MAXIMUM_CAPACITY = 1 << 30;

	private Entry<K, V>[] entryTable = null;

	// 门面模式
	public MyHashMap() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public MyHashMap(Integer defaultInitialCapacity, Double defaultLoadFactor) {
		if (defaultInitialCapacity < 0) {
			throw new IllegalArgumentException("hashmap的初始值不能为负数");
		}
		if (defaultLoadFactor < 0 || Double.isNaN(defaultLoadFactor)) {
			throw new IllegalArgumentException("hashmap的负载因子必须为大于零的数字：" + defaultLoadFactor);
		}
		this.DEFAULT_LOAD_FACTOR = defaultLoadFactor;
		this.DEFAULT_INITIAL_CAPACITY = defaultInitialCapacity;
		entryTable = new Entry[defaultInitialCapacity];
	}

	@Override
	public V get(K k) {
		int index = getIndex(k, entryTable.length);
		if (entryTable[index] == null) {
			throw new NullPointerException("当前key不存在");
		}
		return findValueByEqualsKey(k, entryTable[index]);
	}

	// 这里是根据递归获取当前key的值,通过递归获取值就是为了当前entry数组的结构为entry[]----->entry(key,value,next)------->entry(next)
	// 因为每一个entry对象中都维护了一个next对象（其实就是下一个entry对象，因为key计算出来的index有可能重复，这种碰撞就用next对象来解决）
	// 所以为了解决碰撞出现的这种共享同一位置的两个或者多个entry对象的获取就通过判断entry.next!=null的方法进行递归获取
	private V findValueByEqualsKey(K k, Entry<K, V> entry) {
		if (k == entry.getKey() || k.equals(entry.getKey())) {
			return entry.getValue();
		} else if (null != entry.entryNext) {
			return findValueByEqualsKey(k, entry.entryNext);
		}
		return null;
	}

	// 这里获取当前数组的下标，通过k的hashCode值进行hash运算，在与上当前的数组长度-1
	// 这里的数组长度-1的意义在于两点：1.JDK底层定义的数组初始化长度都是2的n次方，
	// 这么做的意义在于可以迎合计算机处理器的底层的位运算，因为2的n次方可以表示为1<<N的位运算
	// 2.数组长度-1还有一点是为了防止数组下标越界，例如：初始值16-1=15，二进制表示为1111（高位补零），
	// 这样的话（1111&上任何值）都不会得到比它自己还大的值，保证数组下标不越界，在就是保证没有意义的值出现
	// 假设当前的值为（1100&上其它值）那么将会出现什么情况？（浪费很多空间）
	private int getIndex(K k, int length) {
		return hash(k.hashCode()) & (length - 1);
	}

	// 这里进行大量的与或运算，目的就是尽量均匀的散列
	// 这里的与或运算是SUN公司自己通过大量的测试得出的最优运算结论
	private int hash(int hashCode) {
		hashCode = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
		hashCode = hashCode ^ ((hashCode >>> 7) ^ (hashCode >>> 4));
		return hashCode;
	}

	@Override
	public V put(K k, V v) {
		if (USE_SIZE > entryTable.length * DEFAULT_LOAD_FACTOR) {
			resize();
		}
		int index = getIndex(k, entryTable.length);
		Entry<K, V> entry = entryTable[index];
		if (null == entry) {
			USE_SIZE++;
			entryTable[index] = new Entry<K, V>(k, v, null);
		} else {
			entryTable[index] = new Entry<K, V>(k, v, entry);
		}
		return entryTable[index].getValue();
	}

	@SuppressWarnings({ "unchecked" })
	private void resize() {
		int tableLength = 0;
		if (tableLength > MAXIMUM_CAPACITY) {
			// 如果当前数组的长度已经超过定义的最大长度，则使其直接扩展为int类型的最大值，其实这个就是JDK底层实现的基本思想（JDK认为如果entry数组的长度已经超过定义的这个值，那么就没有必要再一次进行扩容）
			tableLength = Integer.MAX_VALUE;
		} else {
			tableLength = entryTable.length * 2;
		}
		Entry<K, V>[] newEntry = new Entry[tableLength];
		transfer(newEntry);
		// 这一步很重要，是将已经拥有旧数组所有值得新数组赋值给原来的数组（为了改变原来数组的长度）
		entryTable = newEntry;
	}

	// 将旧的entry数组中的数据迁移到新的entry数组中
	private void transfer(Entry<K, V>[] newEntry) {
		for (int i = 0; i < entryTable.length; i++) {
			if (null == entryTable[i]) {
				continue;
			}
			// 获取当前旧的数组中的信息
			Entry<K, V> entry = entryTable[i];
			do {
				// 1.首先将旧数组中entry对象的next对象保存起来
				Entry<K, V> next = entry.entryNext;
				// 根据新数组的长度和原来旧数组中的key的值获取新的索引值
				int index = getIndex(entry.getKey(), newEntry.length);
				// 2.如果旧数组中entry.next不为空,则将旧数组中的entry与next两者互换位置
				// 如果旧数组中的entry.next为空,则不做处理
				// 这里其实就是将旧数组中的next对象置空（不管当前的对象是空还是有值，都置为空，然后通过do/while操作将next对象与原有的对象进行位置互换）
				entry.entryNext = newEntry[index];
				// 3.将旧数组中的entry对象储存到新数组中
				newEntry[index] = entry;
				// 4.当前的这个next的就是在第一步中获取的next对象,其实就是将next对象提前保存起来,将旧数组中的next对象置空
				entry = next;
			} while (null != entry);
		}
	}

	static final class Entry<K, V> implements MyMap.Entry<K, V> {

		K k;

		V v;

		Entry<K, V> entryNext;

		public Entry(K k, V v, Entry<K, V> entryNext) {
			this.k = k;
			this.v = v;
			this.entryNext = entryNext;
		}

		/**
		 * 这里的get方法就是获取当前数组中的每一个entry对象的具体的值，
		 * 其实就是对应的每一个Entry[i]，MyMap中的get方法对应的外层调用时的方法，
		 * 而这个内部类中的get方法对应的是在本方法中获取每一个entry对象的方法
		 */

		@Override
		public K getKey() {
			return k;
		}

		@Override
		public V getValue() {
			return v;
		}

	}

}
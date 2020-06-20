package com.hahsmap;

public class MyHashMap<K, V> implements MyMap<K, V> {

	private int USE_SIZE;

	private static Double DEFAULT_LOAD_FACTOR = 0.75;

	private static Integer DEFAULT_INITIAL_CAPACITY = 1 << 4;

	private static final Integer MAXIMUM_CAPACITY = 1 << 30;

	private Entry<K, V>[] entryTable = null;

	// ����ģʽ
	public MyHashMap() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public MyHashMap(Integer defaultInitialCapacity, Double defaultLoadFactor) {
		if (defaultInitialCapacity < 0) {
			throw new IllegalArgumentException("hashmap�ĳ�ʼֵ����Ϊ����");
		}
		if (defaultLoadFactor < 0 || Double.isNaN(defaultLoadFactor)) {
			throw new IllegalArgumentException("hashmap�ĸ������ӱ���Ϊ����������֣�" + defaultLoadFactor);
		}
		this.DEFAULT_LOAD_FACTOR = defaultLoadFactor;
		this.DEFAULT_INITIAL_CAPACITY = defaultInitialCapacity;
		entryTable = new Entry[defaultInitialCapacity];
	}

	@Override
	public V get(K k) {
		int index = getIndex(k, entryTable.length);
		if (entryTable[index] == null) {
			throw new NullPointerException("��ǰkey������");
		}
		return findValueByEqualsKey(k, entryTable[index]);
	}

	// �����Ǹ��ݵݹ��ȡ��ǰkey��ֵ,ͨ���ݹ��ȡֵ����Ϊ�˵�ǰentry����ĽṹΪentry[]----->entry(key,value,next)------->entry(next)
	// ��Ϊÿһ��entry�����ж�ά����һ��next������ʵ������һ��entry������Ϊkey���������index�п����ظ���������ײ����next�����������
	// ����Ϊ�˽����ײ���ֵ����ֹ���ͬһλ�õ��������߶��entry����Ļ�ȡ��ͨ���ж�entry.next!=null�ķ������еݹ��ȡ
	private V findValueByEqualsKey(K k, Entry<K, V> entry) {
		if (k == entry.getKey() || k.equals(entry.getKey())) {
			return entry.getValue();
		} else if (null != entry.entryNext) {
			return findValueByEqualsKey(k, entry.entryNext);
		}
		return null;
	}

	// �����ȡ��ǰ������±꣬ͨ��k��hashCodeֵ����hash���㣬�����ϵ�ǰ�����鳤��-1
	// ��������鳤��-1�������������㣺1.JDK�ײ㶨��������ʼ�����ȶ���2��n�η���
	// ��ô�����������ڿ���ӭ�ϼ�����������ĵײ��λ���㣬��Ϊ2��n�η����Ա�ʾΪ1<<N��λ����
	// 2.���鳤��-1����һ����Ϊ�˷�ֹ�����±�Խ�磬���磺��ʼֵ16-1=15�������Ʊ�ʾΪ1111����λ���㣩��
	// �����Ļ���1111&���κ�ֵ��������õ������Լ������ֵ����֤�����±겻Խ�磬�ھ��Ǳ�֤û�������ֵ����
	// ���赱ǰ��ֵΪ��1100&������ֵ����ô�������ʲô��������˷Ѻܶ�ռ䣩
	private int getIndex(K k, int length) {
		return hash(k.hashCode()) & (length - 1);
	}

	// ������д�����������㣬Ŀ�ľ��Ǿ������ȵ�ɢ��
	// ��������������SUN��˾�Լ�ͨ�������Ĳ��Եó��������������
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
			// �����ǰ����ĳ����Ѿ������������󳤶ȣ���ʹ��ֱ����չΪint���͵����ֵ����ʵ�������JDK�ײ�ʵ�ֵĻ���˼�루JDK��Ϊ���entry����ĳ����Ѿ�������������ֵ����ô��û�б�Ҫ��һ�ν������ݣ�
			tableLength = Integer.MAX_VALUE;
		} else {
			tableLength = entryTable.length * 2;
		}
		Entry<K, V>[] newEntry = new Entry[tableLength];
		transfer(newEntry);
		// ��һ������Ҫ���ǽ��Ѿ�ӵ�о���������ֵ�������鸳ֵ��ԭ�������飨Ϊ�˸ı�ԭ������ĳ��ȣ�
		entryTable = newEntry;
	}

	// ���ɵ�entry�����е�����Ǩ�Ƶ��µ�entry������
	private void transfer(Entry<K, V>[] newEntry) {
		for (int i = 0; i < entryTable.length; i++) {
			if (null == entryTable[i]) {
				continue;
			}
			// ��ȡ��ǰ�ɵ������е���Ϣ
			Entry<K, V> entry = entryTable[i];
			do {
				// 1.���Ƚ���������entry�����next���󱣴�����
				Entry<K, V> next = entry.entryNext;
				// ����������ĳ��Ⱥ�ԭ���������е�key��ֵ��ȡ�µ�����ֵ
				int index = getIndex(entry.getKey(), newEntry.length);
				// 2.�����������entry.next��Ϊ��,�򽫾������е�entry��next���߻���λ��
				// ����������е�entry.nextΪ��,��������
				// ������ʵ���ǽ��������е�next�����ÿգ����ܵ�ǰ�Ķ����ǿջ�����ֵ������Ϊ�գ�Ȼ��ͨ��do/while������next������ԭ�еĶ������λ�û�����
				entry.entryNext = newEntry[index];
				// 3.���������е�entry���󴢴浽��������
				newEntry[index] = entry;
				// 4.��ǰ�����next�ľ����ڵ�һ���л�ȡ��next����,��ʵ���ǽ�next������ǰ��������,���������е�next�����ÿ�
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
		 * �����get�������ǻ�ȡ��ǰ�����е�ÿһ��entry����ľ����ֵ��
		 * ��ʵ���Ƕ�Ӧ��ÿһ��Entry[i]��MyMap�е�get������Ӧ��������ʱ�ķ�����
		 * ������ڲ����е�get������Ӧ�����ڱ������л�ȡÿһ��entry����ķ���
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
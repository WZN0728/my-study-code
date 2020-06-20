package com.hahsmap;

import java.util.HashMap;

//Java�е�hashCode�������Ǹ���һ���Ĺ����������ص���Ϣ
//���������Ĵ洢��ַ������� �ֶεȣ�ӳ���һ����ֵ�������ֵ����Ϊɢ��ֵ
public class MyTest {
	private static class Person {
		// ���֤
		int idCard;
		// ����
		String name;

		public Person(int idCard, String name) {
			this.idCard = idCard;
			this.name = name;
		}
		// ��дhashCode ������ Object��������ͳhashCode
		/*
		 * @Override public int hashCode() { return idCard%10; }
		 * 
		 * @Override public boolean equals(Object o) { if (this == o && this.hashCode()
		 * == o.hashCode()) { return true; } if (o == null || getClass() !=
		 * o.getClass()){ return false; } Person person = (Person) o;
		 * //���������Ƿ��ֵ��ͨ��idCard��ȷ�� return (this.hashCode() == person.hashCode())
		 * &&(this.idCard == person.idCard); }
		 */

	}

	// ��ͳ��JDK����Ĵ洢��ַ�ж��������� ����ͳһ���ж���������ķ�ʽ���ʺ����ǵ�ҵ������ �����ж����������Ƿ���
	// ͬһ������Ӧ��Ҫ���Լ���hashCode
	public static void main(String[] args) {
		// String a = "HelloWorld";
		// String b = "HelloWorld";
		String a = new String("HelloWorld");
		String b = new String("HelloWorld");
		System.out.println("hashCode:" + a.hashCode());
		System.out.println("HelloWorld1   " + (a == b));
		System.out.println("HelloWorld2   " + a.equals(b));
		System.out.println("---------------------------------");
		HashMap<Person, String> map = new HashMap<Person, String>();
		Person person = new Person(1234, "Sam");
		System.out.println(person.hashCode() + "    " + new Person(1234, "Sam").hashCode());
		System.out.println("equals�����" + new Person(1234, "Sammy").equals(person));
		// put��hashmap��ȥ key:Person value:
		// �棺hashcode��person��--��hash--��indexFor-->��������λ��
		// map.put(person,"а������");
		// ��hashcode �õ���HashCode��һ��
		// HashCode���صľ���һ����������ֵ
		// ȡ��hashcode��new Person(1234,"Sammy")��-->hash-->indexFor-->��������λ��
		// getȡ�������߼��Ͻ�Ӧ���������а��������
		// System.out.println("���:"+map.get(new Person(1234,"Sammy")));
	}

}
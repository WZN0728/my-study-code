package com.strategy;

import java.util.Collections;

public class MyListTest {

	//����ģʽ��˼��
	//���ǲ���ִ���߼����,���յ�ִ�н������һ����
	//���磺������˾�����������������������������������Լ����������г������ն��ᵽ��˾
	//���̲�ͬ�����ǽ��һ��
	public static void main(String[] args) {
		new MyList().sort(new NumberComparator());
	}
	
}
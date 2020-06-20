package com.prototype.greatestsage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class TheGreatestSage extends Monkey implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1801182728585129605L;

	private GoldRingedStaff goldRingedStaff;

	public GoldRingedStaff getGoldRingedStaff() {
		return goldRingedStaff;
	}

	public void setGoldRingedStaff(GoldRingedStaff goldRingedStaff) {
		this.goldRingedStaff = goldRingedStaff;
	}

	public TheGreatestSage() {
		this.goldRingedStaff = new GoldRingedStaff();
		this.birthDay = new Date();
		this.name = "�����";
		this.height = 150;
		this.weight = 40;
		System.out.println("���췽��......");
	}

	// ��ʥ�ķ�����
	public Object clone() {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ByteArrayOutputStream bos = null;
		TheGreatestSage theGreatestSageCopy = null;
		try {
			// �����л����Ѷ�����������ʽ�����ļ���
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			// �ڷ����л������ļ��е������������У��Զ������ʽʹ��
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			theGreatestSageCopy = (TheGreatestSage) ois.readObject();
			theGreatestSageCopy.birthDay = new Date();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				oos.close();
				bis.close();
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return theGreatestSageCopy;
	}

	// ���÷����ܣ���ʼ�仯
	public void change() throws Exception {
		TheGreatestSage theGreatestSageCopy = (TheGreatestSage) clone();
		System.out.println("��ʥ�����������:" + this.birthDay.getTime());
		System.out.println("��ʥ�����������:" + theGreatestSageCopy.birthDay.getTime());
		System.out.println(
				"��ʥ����Ľ𹿰�������ʥ�Ľ𹿰��Ƿ���ͬһ��:" + (this.getGoldRingedStaff() == theGreatestSageCopy.getGoldRingedStaff()));
		System.out.println("��ʥ����ͷ����ʥ�Ƿ���ͬһ����ʥ:" + (theGreatestSageCopy == this));
	}

	// �������ʹ�õ���object��clone��������ʵ����ǳ����
	public Object cloneShallow() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// ���÷����ܣ���ʼ�仯
	public void change1() throws Exception {
		TheGreatestSage theGreatestSageCopy = (TheGreatestSage) cloneShallow();
		System.out.println("��ʥ�����������:" + this.birthDay.getTime());
		System.out.println("��ʥ�����������:" + theGreatestSageCopy.birthDay.getTime());
		System.out.println(
				"��ʥ����Ľ𹿰�������ʥ�Ľ𹿰��Ƿ���ͬһ��:" + (this.getGoldRingedStaff() == theGreatestSageCopy.getGoldRingedStaff()));
		System.out.println("��ʥ����ͷ����ʥ�Ƿ���ͬһ����ʥ:" + (theGreatestSageCopy == this));
	}

}
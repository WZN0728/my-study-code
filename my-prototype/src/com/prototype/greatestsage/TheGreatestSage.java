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
		this.name = "孙悟空";
		this.height = 150;
		this.weight = 40;
		System.out.println("构造方法......");
	}

	// 大圣的分身技能
	public Object clone() {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ByteArrayOutputStream bos = null;
		TheGreatestSage theGreatestSageCopy = null;
		try {
			// 先序列换，把对象以流的形式读到文件中
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			// 在反序列化，把文件中的流读到程序中，以对象的形式使用
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

	// 调用分身技能，开始变化
	public void change() throws Exception {
		TheGreatestSage theGreatestSageCopy = (TheGreatestSage) clone();
		System.out.println("大圣本尊的生日是:" + this.birthDay.getTime());
		System.out.println("大圣分身的生日是:" + theGreatestSageCopy.birthDay.getTime());
		System.out.println(
				"大圣本尊的金箍棒与分身大圣的金箍棒是否是同一根:" + (this.getGoldRingedStaff() == theGreatestSageCopy.getGoldRingedStaff()));
		System.out.println("大圣本尊和分身大圣是否是同一个大圣:" + (theGreatestSageCopy == this));
	}

	// 这个方法使用的是object的clone方法，其实就是浅拷贝
	public Object cloneShallow() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 调用分身技能，开始变化
	public void change1() throws Exception {
		TheGreatestSage theGreatestSageCopy = (TheGreatestSage) cloneShallow();
		System.out.println("大圣本尊的生日是:" + this.birthDay.getTime());
		System.out.println("大圣分身的生日是:" + theGreatestSageCopy.birthDay.getTime());
		System.out.println(
				"大圣本尊的金箍棒与分身大圣的金箍棒是否是同一根:" + (this.getGoldRingedStaff() == theGreatestSageCopy.getGoldRingedStaff()));
		System.out.println("大圣本尊和分身大圣是否是同一个大圣:" + (theGreatestSageCopy == this));
	}

}
package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

/**
 * <p>
 * ���⣺edes
 * </p>
 * <p>
 * ������DBUtil
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.dcits.sip.ec.common.DBUtil.java
 * </p>
 * <p>
 * ��Ȩ��Copyright (c) 2002-2016 Digitalchina CO.,LTD. All rights reserved.
 * </p>
 * <p>
 * ��˾������������Ϣϵͳ���޹�˾
 * </p>
 * <p>
 * ���ߣ�wuting
 * </p>
 * <p>
 * ����ʱ�䣺2016��7��1������10:50:00
 * </p>
 * <p>
 * �����ˣ�wuting
 * </p>
 * <p>
 * ���ţ�����Ժ��ȫ�ɿ��з����Ĳ�Ʒ�з���
 * </p>
 * <p>
 * �޸��ߣ�wuting
 * </p>
 * <p>
 * �޸�ʱ�䣺2016��7��1������10:50:00
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
public class DBUtil {

	private static String url;

	private static String user;

	private static String password;

	public static DataSource ds = null;

	private static Properties props = null;

	static {
		InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		props = new Properties();
		try {
			props.load(in);
			url = props.getProperty("jdbc.url");
			user = props.getProperty("jdbc.username");
			password = props.getProperty("jdbc.password");
			Class.forName(props.getProperty("jdbc.driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection(Connection conn) throws Exception {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public static DataSource getDs() {
		return ds;
	}

	public static void setDs(DataSource ds) {
		DBUtil.ds = ds;
	}

}
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
 * 标题：edes
 * </p>
 * <p>
 * 描述：DBUtil
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.dcits.sip.ec.common.DBUtil.java
 * </p>
 * <p>
 * 版权：Copyright (c) 2002-2016 Digitalchina CO.,LTD. All rights reserved.
 * </p>
 * <p>
 * 公司：神州数码信息系统有限公司
 * </p>
 * <p>
 * 作者：wuting
 * </p>
 * <p>
 * 创建时间：2016年7月1日上午10:50:00
 * </p>
 * <p>
 * 负责人：wuting
 * </p>
 * <p>
 * 部门：工程院安全可靠研发中心产品研发部
 * </p>
 * <p>
 * 修改者：wuting
 * </p>
 * <p>
 * 修改时间：2016年7月1日上午10:50:00
 * </p>
 * <p>
 * 修改内容：
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
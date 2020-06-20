package com.test;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashSet;
import java.util.Set;

public class JdbcTest1 {

	private static Set<String> METADATA_INFO = new HashSet<String>();

	public static void main(String[] args) throws Exception {
		String s1 = "b";
		String s2 = "abc";
		System.out.println(s2.indexOf(s1));
		String table = "CL_PZGL_FWDZ";
		initRemark(table.split(","));
//		getColumnsRemark(DBUtil.getConnection().getMetaData(), table.split(","));
//		for (String string : METADATA_INFO) {
//			System.out.println(string);
//		}
	}
	
	public static void initRemark(String[] tableArray) throws Exception {
		ResultSet rs = null;
		ResultSetMetaData meta = null;
		PreparedStatement pstmt = null;
		try {
			for (String tableNameValue : tableArray) {
				String sql = "select * from " + tableNameValue;
				pstmt = DBUtil.getConnection().prepareStatement(sql);
				rs = pstmt.executeQuery();
				meta = rs.getMetaData();
				int columnCount = meta.getColumnCount();
				for (int i = 1; i < columnCount + 1; i++) {
					System.out.println(meta.getColumnName(i) + " µÚ " + i + " ¸ö ");
				}
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			rs.close();
			pstmt.close();
		}
	}

	// ×Ö¶Î×¢ÊÍ
	public static void getColumnsRemark(DatabaseMetaData metaData, String[] list) throws Exception {
		ResultSet columnRemark = null;
		try {
			for (String tableName : list) {
				columnRemark = metaData.getColumns(null, null, tableName.toUpperCase(), null);
				while (columnRemark.next()) {
					if (!"".equals(columnRemark.getString("REMARKS")) && columnRemark.getString("REMARKS") != null) {
						METADATA_INFO.add(
								"COMMENT ON COLUMN " + tableName + "." + "\"" + columnRemark.getString("COLUMN_NAME")
										+ "\"" + " IS " + "'" + columnRemark.getString("REMARKS") + "'" + ";\n");
					}
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			columnRemark.close();
		}
	}

}
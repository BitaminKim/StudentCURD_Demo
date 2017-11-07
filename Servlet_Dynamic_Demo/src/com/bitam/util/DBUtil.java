package com.bitam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private final static String CLASS_DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://192.168.123.64/test?characterEncoding=utr-8";
	private final static String USERNAME = "bitaminkim";
	private final static String PASSWORD = "kim940907";
	
	public DBUtil() {
		try {
			Class.forName(CLASS_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("加载驱动失败");
		}
	}

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接数据库失败");
		}
		return null;
	}
}

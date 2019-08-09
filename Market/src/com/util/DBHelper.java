package com.util;
/**
 * 	����������ӵĹ�����
 * @author ���¶�
 * @Date 2019��8��5��
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbutils.DbUtils;

public class DBHelper {

	private static String name;
	private static String pass;
	private static String url;
	private static String driver;
	
	//ThreadLocal
	private static final ThreadLocal<Connection> LOCAL_CONN = new ThreadLocal<>();
	
	static {
		
		try {
			//���������ļ�����
			Properties properties = new Properties();
			//�����·�����м���
			properties.load(DBHelper.class.getResourceAsStream("/jdbc.properties"));
			
			name = properties.getProperty("name");
			pass = properties.getProperty("pass");
			url = properties.getProperty("url");
			driver = properties.getProperty("driver");
			
			//1.ע������
			Class.forName(driver);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn(boolean flag) {
		
		Connection conn = LOCAL_CONN.get();
		if(conn == null) {
			try {
				//2.����DriverManage
				conn = DriverManager.getConnection(url, name, pass);
				conn.setAutoCommit(flag);
				LOCAL_CONN.set(conn);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public static void closeResources(Connection conn) {
		if (conn != null) {
			DbUtils.closeQuietly(conn);
			LOCAL_CONN.remove();
		}
	}
}

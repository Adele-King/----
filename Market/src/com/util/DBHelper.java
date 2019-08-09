package com.util;
/**
 * 	获得数据连接的工具类
 * @author 宋月娥
 * @Date 2019年8月5日
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
			//加载配置文件内容
			Properties properties = new Properties();
			//编译的路径进行加载
			properties.load(DBHelper.class.getResourceAsStream("/jdbc.properties"));
			
			name = properties.getProperty("name");
			pass = properties.getProperty("pass");
			url = properties.getProperty("url");
			driver = properties.getProperty("driver");
			
			//1.注册驱动
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
				//2.调用DriverManage
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

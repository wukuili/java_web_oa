package com.sanqing.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	private static final String DBDRIVER="com.mysql.jdbc.Driver" ;
	private static final String DBURL="jdbc:mysql://localhost:3306/oa";
	private static final String DBUSER="root";
	private static final String DBPASSWORD="";
	public static Connection getConnection() {
		Connection connection=null;//声明一个连接对象
		try {
			Class.forName(DBDRIVER);//注册驱动
			connection=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();//捕获驱动类无法找到的异常
		} catch (SQLException e) {
			
			e.printStackTrace();//捕获sql异常
		}
		return connection;
	}
	/**
	 * 关闭连接对象
	 * @param connection 连接对象
	 */
	public static void close(Connection connection) {
		if (connection!=null) {//如果connection连接对象不为空
			try {
				connection.close();//关闭connection连接对象
			} catch (SQLException e) {
				
				e.printStackTrace();//捕获sql异常
			}
		}
	}
	/**
	 * 关闭预处理对象
	 * @param psmt 预处理对象
	 */
	public static void close(PreparedStatement psmt) {
		if (psmt!=null) {//如果psmt不为空
			try {
				psmt.close();//关闭psmt对象
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//捕获sql异常
			}
		}
	}
	/**
	 * 关闭结果集对象
	 * @param rt 结果集对象
	 */
	public static void close(ResultSet rt) {
		if (rt!=null) {//如果结果集对象不为空
			try {
				rt.close();//关闭结果集对象
			} catch (SQLException e) {
				
				e.printStackTrace();//打印sql异常
			}
		}
	}
}

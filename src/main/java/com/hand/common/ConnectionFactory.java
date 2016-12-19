package com.hand.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *  数据库连接工厂类，要使用单例模式
 *  	实现单例模式：首先把构造器变成私有的，然后设置一个静态的成员变量调用构造器
 *  				用getInstance方法获得该成员变量，这样，这个类在使用的时候就只能有一个实例存在了
 *
 */
public class ConnectionFactory {
	
	static private String driver;
	static private String url;
	static private String user;
	static private String password;
	
	private static final ConnectionFactory factory = new ConnectionFactory();
	
	private Connection conn;
	
	/**
	 *  在类加载的时候就读取properties文件
	 */
	static{
		Properties properties = new Properties();
		try {
			//先获得类加载器，然后用getResourceAsStream方法读取属性文件
			InputStream is = ConnectionFactory.class.getResourceAsStream("/jdbc/db.properties");
			// 读取属性
			properties.load(is);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  把当前类单例化
	 */
	private ConnectionFactory(){}
	public static ConnectionFactory getInstance(){
		return factory;
	}
	
	
	/**
	 * @return 一个Connection
	 */
	public Connection getConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

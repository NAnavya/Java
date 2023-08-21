package org.virtusa.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class DbUtil {
	private static Connection createConnection(String driver,String url,String username,String password) {
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static Connection getConnection() {
		Properties properties=getProperties("C:\\Intel\\security space\\HRMApp\\resources\\database.properties");
		String driver=properties.getProperty("jdbc.driver");
		String url=properties.getProperty("jdbc.url");
		String username=properties.getProperty("jdbc.username");
		String password=properties.getProperty("jdbc.password");
		return createConnection(driver, url, username, password);
	}
	private static Properties getProperties(String filePath) {
		Properties properties=null;
		try {
			FileInputStream fis=new FileInputStream(filePath);
			properties=new Properties();
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

}

package org.virtusa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.ResultSet;

public class JdbcSelectDemo {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/vdb";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	static
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			Statement st=con.createStatement()) {
				ResultSet rs=st.executeQuery("select * from emp");
				while(rs.next())
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

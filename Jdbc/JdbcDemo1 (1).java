package org.virtusa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDemo1 {
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws SQLException {
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","navya")){
			if(con!=null)
			{
				System.out.println("connection established");
			}
			else
				System.out.println("Connection not established");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

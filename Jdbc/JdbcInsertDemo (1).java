package org.virtusa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcInsertDemo {
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
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int eno;
		String name,address;
		
		try(Connection con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
				Statement st=con.createStatement()) {
					System.out.println("enter the employee details");
					eno=Integer.parseInt(br.readLine());
					name=br.readLine();
					address=br.readLine();
					int i=st.executeUpdate("insert into emp values("+eno+",'"+name+"','"+address+"')");
					if(i>0)
						System.out.println("Successfully inserted");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}

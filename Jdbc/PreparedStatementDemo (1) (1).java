package org.virtusa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PreparedStatementDemo {
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
				PreparedStatement pst=con.prepareStatement("insert into emp values(?,?,?)") ){
				System.out.println("Enter the employee details");
				eno=Integer.parseInt(br.readLine());
				name=br.readLine();
				address=br.readLine();
				pst.setInt(1, eno);
				pst.setString(2, name);
				pst.setString(3, address);
				int i=pst.executeUpdate();
				if(i>0)
					System.out.println("Inserted successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}

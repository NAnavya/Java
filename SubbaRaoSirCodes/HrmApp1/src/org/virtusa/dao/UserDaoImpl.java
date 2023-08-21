package org.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.virtusa.entities.User;
import org.virtusa.util.DbUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean validateUser(User user) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean isValidUser=false;
		try {
			con=DbUtil.getConnection();
			pst=con.prepareStatement("select * from user where username=? and password=?");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				isValidUser=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValidUser;
	}

}

package com.shimdu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shimdu.model.User;

public class UserDao {
	/**
	 * µÇÂ¼ÑéÖ¤
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */

	public User login(Connection con, User user)throws Exception{
		User resultUser=null;
		String sql="SELECT * FROM t_user WHERE userName = ? AND password = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
}

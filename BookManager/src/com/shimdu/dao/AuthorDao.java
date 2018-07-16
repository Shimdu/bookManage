package com.shimdu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shimdu.model.Author;
import com.shimdu.util.StringUtil;

/**
 * 图书作者Dao
 * @author Administrator
 *
 */
public class AuthorDao {

	/**
	 * 图书作者添加
	 * @param con
	 * @param author
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, Author author) throws Exception {
		String sql = "INSERT INTO t_author VALUES (null, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, author.getName());
		pstmt.setString(2, author.getDob());
		pstmt.setString(3, author.getGender());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书作者
	 * @param con
	 * @param author
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, Author author)throws Exception{
		StringBuffer sb = new StringBuffer("SELECT * FROM t_author");
		if(StringUtil.isNotEmpty(author.getName())) {
			sb.append(" AND name LIKE '%"+ author.getName() +"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("AND", "WHERE"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 图书作者删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id)throws Exception{
		String sql = "DELETE FROM t_author WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书作者更新
	 * @param con
	 * @param author
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, Author author)throws Exception{
		String sql = "UPDATE t_author SET name = ?, dob = ?, gender = ? WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, author.getName());
		pstmt.setString(2, author.getDob());
		pstmt.setString(3, author.getGender());
		return pstmt.executeUpdate();
	}
}

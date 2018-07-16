package com.shimdu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shimdu.model.BookType;
import com.shimdu.util.StringUtil;

/**
 * 图书类别Dao
 * @author Administrator
 *
 */
public class BookTypeDao {

	public int add(Connection con, BookType bookType)throws Exception{
		String sql = "INSERT INTO t_booktype VALUES (null, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		return pstmt.executeUpdate();
	}
	
	public ResultSet list(Connection con,BookType bookType)throws Exception{
		StringBuffer sb = new StringBuffer("SELECT * FROM t_booktype");
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			sb.append(" AND bookTypeName LIKE '%"+ bookType.getBookTypeName() +"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("AND", "WHERE"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 删除图书类别
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id)throws Exception {
		String sql = "DELETE FROM t_bookType WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 更新图书类别
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, BookType bookType)throws Exception {
		String sql = "UPDATE t_bookType SET bookTypeName = ?, bookTypeDesc = ? WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
		return pstmt.executeUpdate();
	}
	
}

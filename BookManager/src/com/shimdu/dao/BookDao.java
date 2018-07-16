package com.shimdu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shimdu.model.Book;
import com.shimdu.util.StringUtil;

/**
 * 图书Dao
 * @author Administrator
 *
 */
public class BookDao {
	/**
	 * 图书添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, Book book)throws Exception {
		String sql = "INSERT INTO t_book VALUES (null, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getBookDesc());
		pstmt.setFloat(3, book.getPrice());
		pstmt.setInt(4, book.getBookTypeId());
		pstmt.setInt(5, book.getAuthorId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书列表
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Book book)throws Exception{
		StringBuffer sb = new StringBuffer("SELECT * FROM t_book b, t_bookType bt, t_author a WHERE b.bookTypeId = bt.id AND b.authorId = a.id");
		if(StringUtil.isNotEmpty(book.getBookName())) {
			sb.append(" AND bookName LIKE '%"+ book.getBookName() +"%'");
		}
		if(book.getAuthorId()!=null && book.getAuthorId()!=-1) {
			sb.append(" AND name LIKE '%"+ book.getAuthor() +"%')");
		}
		if(book.getBookTypeId()!=null && book.getBookTypeId()!=-1) {
			sb.append(" AND bookTypeId = "+ book.getBookName());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	/**
	 * 图书删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id)throws Exception {
		String sql = "DELETE FROM t_book WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书更新
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, Book book)throws Exception {
		String sql = "UPDATE t_book SET bookName = ?, bookDesc = ?, price = ?, bookTypeId = (SELECT id FROM t_auhtor WHERE name = ?), authorId = ? WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getBookDesc());
		pstmt.setFloat(3, book.getPrice());
		pstmt.setInt(4, book.getBookTypeId());
		pstmt.setString(5, book.getAuthor());
		pstmt.setInt(6, book.getId());
		return pstmt.executeUpdate();
	}
	
	public boolean existBookByBookTypeId(Connection con,String bookTypeId)throws Exception{
		String sql = "SELECT id FROM t_book WHERE bookTypeId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookTypeId);
		ResultSet rs = pstmt.executeQuery();
		return rs.next();
	}
}

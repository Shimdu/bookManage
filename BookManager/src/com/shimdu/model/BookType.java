package com.shimdu.model;
/**
 * 图书类类别实体
 * @author Administrator
 *
 */
public class BookType {

	private int id;
	private String bookTypeName;
	private String bookTypeDesc;
	
	public BookType() {
		super();
	}
	
	public BookType(String bookTypeName, String bookTypeDesc) {
		super();
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}

	public BookType(int id, String bookTypeName, String bookTypeDesc) {
		super();
		this.id = id;
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}

	public BookType(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookTypeDesc() {
		return bookTypeDesc;
	}
	public void setBookTypeDesc(String bookTyoeDesc) {
		this.bookTypeDesc = bookTyoeDesc;
	}

	@Override
	public String toString() {
		return bookTypeName;
	}
}

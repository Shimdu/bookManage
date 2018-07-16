package com.shimdu.model;

/**
 * Õº È µÃÂ
 * @author Administrator
 *
 */
public class Book {
	private int id;
	private String bookName;
	private Integer authorId;
	private String author;
	private float price;
	private String bookDesc;
	private Integer bookTypeId;
	
	public Book() {
		super();
	}
	
	public Book(String bookName, String author, Integer bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookTypeId = bookTypeId;
	}

	public Book(String bookName, int authorId, float price, String bookDesc, int bookTypeId) {
		super();
		this.bookName = bookName;
		this.authorId = authorId;
		this.price = price;
		this.bookDesc = bookDesc;
		this.bookTypeId = bookTypeId;
	}
	
	public Book(int id, String bookName, String author, float price, String bookDesc, Integer bookTypeId) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.bookDesc = bookDesc;
		this.bookTypeId = bookTypeId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public Integer getAuthorId() {
		return authorId;
	}


	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getBookDesc() {
		return bookDesc;
	}


	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}


	public Integer getBookTypeId() {
		return bookTypeId;
	}


	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}


	@Override
	public String toString() {
		return bookName;
	}
}

package com.shopping.biz.book;

public class BookVO {
	int bookNum;
	String bookName;
	int bookPrice;
	String bookComment;
	String bookPicture;
	int bookCount;
	String id;
	int bookGrade;
	int gradeCount;
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookComment() {
		return bookComment;
	}
	public void setBookComment(String bookComment) {
		this.bookComment = bookComment;
	}
	public String getBookPicture() {
		return bookPicture;
	}
	public void setBookPicture(String bookPicture) {
		this.bookPicture = bookPicture;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBookGrade() {
		return bookGrade;
	}
	public void setBookGrade(int bookGrade) {
		this.bookGrade = bookGrade;
	}
	public int getGradeCount() {
		return gradeCount;
	}
	public void setGradeCount(int gradeCount) {
		this.gradeCount = gradeCount;
	}
	@Override
	public String toString() {
		return "BookVO [bookNum=" + bookNum + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", bookComment="
				+ bookComment + ", bookPicture=" + bookPicture + ", bookCount=" + bookCount + ", id=" + id
				+ ", bookGrade=" + bookGrade + ", gradeCount=" + gradeCount + "]";
	}
	
	
	
}

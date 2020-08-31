package com.shopping.biz.basket;

public class BasketVO {
	int basketNum;
	String id;
	int count;
	int bookNum;
	String bookName;
	int bookPrice;
	String bookComment;
	String bookPicture;
	int bookCount;
	public int getBasketNum() {
		return basketNum;
	}
	public void setBasketNum(int basketNum) {
		this.basketNum = basketNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
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
	@Override
	public String toString() {
		return "BasketVO [basketNum=" + basketNum + ", id=" + id + ", count=" + count + ", bookNum=" + bookNum
				+ ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", bookComment=" + bookComment
				+ ", bookPicture=" + bookPicture + ", bookCount=" + bookCount + "]";
	}
	
	
	
	
}

package com.shopping.biz.order;

public class OrderVO {
	
	int orderNum;
	String id;
	String orderDate;
	String deliverAddress;
	int creditcardNum;
	
	int detailNum;	
	int bookNum;
	String deliverState;
	int orderPrice;
	int returnState;
	String bookPicture;
	String bookName;
	int count;
	int grade2;
	
	String grade;
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliverAddress() {
		return deliverAddress;
	}
	public void setDeliverAddress(String deliverAddress) {
		this.deliverAddress = deliverAddress;
	}
	public int getCreditcardNum() {
		return creditcardNum;
	}
	public void setCreditcardNum(int creditcardNum) {
		this.creditcardNum = creditcardNum;
	}
	public int getDetailNum() {
		return detailNum;
	}
	public void setDetailNum(int detailNum) {
		this.detailNum = detailNum;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getDeliverState() {
		return deliverState;
	}
	public void setDeliverState(String deliverState) {
		this.deliverState = deliverState;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getReturnState() {
		return returnState;
	}
	public void setReturnState(int returnState) {
		this.returnState = returnState;
	}
	public String getBookPicture() {
		return bookPicture;
	}
	public void setBookPicture(String bookPicture) {
		this.bookPicture = bookPicture;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public int getGrade2() {
		return grade2;
	}
	public void setGrade2(int grade2) {
		this.grade2 = grade2;
	}
	@Override
	public String toString() {
		return "OrderVO [orderNum=" + orderNum + ", id=" + id + ", orderDate=" + orderDate + ", deliverAddress="
				+ deliverAddress + ", creditcardNum=" + creditcardNum + ", detailNum=" + detailNum + ", bookNum="
				+ bookNum + ", deliverState=" + deliverState + ", orderPrice=" + orderPrice + ", returnState="
				+ returnState + ", bookPicture=" + bookPicture + ", bookName=" + bookName + ", count=" + count
				+ ", grade2=" + grade2 + ", grade=" + grade + "]";
	}
	
	
	
	
}

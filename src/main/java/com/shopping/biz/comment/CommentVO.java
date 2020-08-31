package com.shopping.biz.comment;

public class CommentVO {
	int commentNum;
	int bookNum;
	String comment;
	String id;
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	@Override
	public String toString() {
		return "CommentVO [commentNum=" + commentNum + ", bookNum=" + bookNum + ", comment=" + comment + ", id=" + id
				+ "]";
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}

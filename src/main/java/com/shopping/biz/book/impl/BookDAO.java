package com.shopping.biz.book.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.biz.book.BookVO;
import com.shopping.biz.order.OrderVO;

@Repository("bookDAO")
public class BookDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int insertBook(BookVO vo) {
		return sqlSession.insert("bookDAO.insert",vo);
	}
	
	public int updateCount(OrderVO vo) {
		return sqlSession.update("bookDAO.updateCount",vo);
	}
	
	public int deleteBook(BookVO vo) {
		return sqlSession.delete("bookDAO.delete",vo);
	}
	
	public List<BookVO> listBook(BookVO vo){
		return sqlSession.selectList("bookDAO.listBook",vo);
	}
	public List<BookVO> allBook(){
		return sqlSession.selectList("bookDAO.allBook");
	}
	
	public List<BookVO> listSelect(BookVO vo){
		return sqlSession.selectList("bookDAO.listSelect",vo);
	}
	
	public BookVO oneBook(BookVO vo){
		return sqlSession.selectOne("bookDAO.oneBook",vo);
	}
	
	public int updateBook(BookVO vo) {
		return sqlSession.update("bookDAO.update",vo);
	}

}

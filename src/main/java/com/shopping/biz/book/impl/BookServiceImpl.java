package com.shopping.biz.book.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.biz.book.BookService;
import com.shopping.biz.book.BookVO;
import com.shopping.biz.order.OrderVO;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookDAO bookDAO;
	
	@Override
	public int insertBook(BookVO vo) {
		// TODO Auto-generated method stub
		return bookDAO.insertBook(vo);
	}

	@Override
	public int updateCount(OrderVO vo) {
		// TODO Auto-generated method stub
		return bookDAO.updateCount(vo);
	}

	@Override
	public int deleteBook(BookVO vo) {
		// TODO Auto-generated method stub
		return bookDAO.deleteBook(vo);
	}

	@Override
	public List<BookVO> listBook(BookVO vo) {
		// TODO Auto-generated method stub
		return bookDAO.listBook(vo);
	}

	@Override
	public BookVO oneBook(BookVO vo) {
		// TODO Auto-generated method stub
		return bookDAO.oneBook(vo);
	}

	@Override
	public List<BookVO> listSelect(BookVO vo) {
		// TODO Auto-generated method stub
		return bookDAO.listSelect(vo);
	}
	
	@Override
	public List<BookVO> allBook() {
		// TODO Auto-generated method stub
		return bookDAO.allBook();
	}

	@Override
	public int updateBook(BookVO vo) {
		// TODO Auto-generated method stub
		return bookDAO.updateBook(vo);
	}

	
}

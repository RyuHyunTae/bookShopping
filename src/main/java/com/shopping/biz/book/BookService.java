package com.shopping.biz.book;

import java.util.List;

import com.shopping.biz.order.OrderVO;

public interface BookService {
	int insertBook(BookVO vo);
	
	int updateCount(OrderVO vo);
	
	int updateBook(BookVO vo);
	
	int deleteBook(BookVO vo);
	
	List<BookVO> listBook(BookVO vo);
	List<BookVO> allBook();
	
	List<BookVO> listSelect(BookVO vo);
	
	BookVO oneBook(BookVO vo);
}

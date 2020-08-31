package com.shopping.biz.comment;

import java.util.List;

import com.shopping.biz.book.BookVO;

public interface CommentService {
	int insertComment(CommentVO vo);
	
	List<CommentVO> commentList(CommentVO vo);
}

package com.shopping.biz.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDAO commentDAO;	
	@Override
	public int insertComment(CommentVO vo) {
		// TODO Auto-generated method stub
		return commentDAO.insertComment(vo);
	}
	@Override
	public List<CommentVO> commentList(CommentVO vo) {
		// TODO Auto-generated method stub
		return commentDAO.commentList(vo);
	}

}

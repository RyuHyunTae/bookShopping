package com.shopping.biz.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.biz.book.BookVO;


@Repository("commentDAO")
public class CommentDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int insertComment(CommentVO vo) {
		return sqlSession.insert("commentDAO.insert",vo);
	}
	
	public List<CommentVO> commentList(CommentVO vo){
		System.out.println(vo.toString());
		return sqlSession.selectList("commentDAO.commentList",vo);
	}
}

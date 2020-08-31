package com.shopping.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.biz.book.BookVO;
import com.shopping.biz.comment.CommentService;
import com.shopping.biz.comment.CommentVO;

@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/insertComment.do")
	public String insertComment(CommentVO vo) {
		System.out.println("¥Ò±€ µÓ∑œ √≥∏Æ");
		commentService.insertComment(vo);
		return "listBook.do";
	}
	
	@RequestMapping(value = "/comment.do")
	public ModelAndView search(CommentVO vo, ModelAndView mav) {
		System.out.println("∏Æ∫‰ ¿Ãµø");
		mav.addObject("comment", commentService.commentList(vo));
		mav.setViewName("comment.jsp");
		return mav;
	}
}

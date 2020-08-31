package com.shopping.view.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.biz.basket.BasketService;
import com.shopping.biz.basket.BasketVO;
import com.shopping.biz.book.BookService;
import com.shopping.biz.book.BookVO;
import com.shopping.biz.order.OrderService;
import com.shopping.biz.order.OrderVO;
import com.shopping.biz.user.UserVO;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	BasketService basketService;

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/insertBook.do")
	public String insertBook(BookVO vo) {
		System.out.println("책 등록 처리");
		bookService.insertBook(vo);
		return "listBook.do";
	}

	@RequestMapping(value = "/deleteBook.do")
	public String deleteCloth(BookVO vo) {
		System.out.println("책 삭제 처리");
		BasketVO basket = new BasketVO();
		basket.setBookNum(vo.getBookNum());
		bookService.deleteBook(vo);
		if (!basketService.CheckNun(basket).isEmpty()) {
			basketService.deleteAllCloth(basket);
		}
		return "listBook.do";
	}

	@RequestMapping(value = "/listBook.do")
	public ModelAndView listBook(BookVO vo, ModelAndView mav) {
		System.out.println("책 목록 불러오기");
		mav.addObject("listBook", bookService.listBook(vo));
		mav.setViewName("main.jsp");
		return mav;
	}

	@RequestMapping(value = "/oneBook.do")
	public ModelAndView oneCloth(BookVO vo, ModelAndView mav) {
		System.out.println("책 상세 불러오기");

		double grade2 = 0.0;
		int grade3 = 0;
		int count = 0;
		List<OrderVO> list2 = new ArrayList<OrderVO>();
		OrderVO vo2 = new OrderVO();
		vo2.setBookNum(vo.getBookNum());
		list2 = orderService.grade2(vo2);
		for (OrderVO grade : list2) {
			if (grade.getGrade2() != 0) {
				grade3 += grade.getGrade2();
				count++;
			}
		}
		grade2 = (double) grade3 / count;
		mav.addObject("oneBook", bookService.oneBook(vo));
		mav.addObject("grade2", grade2);
		mav.setViewName("bookDetail.jsp");
		return mav;
	}

	@RequestMapping(value = "/updatePage.do")
	public ModelAndView updatePage(BookVO vo, ModelAndView mav) {
		System.out.println("책 수정 페이지 불러오기");
		mav.addObject("oneBook", bookService.oneBook(vo));
		mav.setViewName("updateBookDetail.jsp");
		return mav;
	}

	@RequestMapping(value = "/updateCloth.do")
	public String updateCloth(BookVO vo) {
		System.out.println("책 수정 처리");
		bookService.updateBook(vo);
		return "oneBook.do";
	}

	@RequestMapping(value = "/search.do")
	public ModelAndView search(BookVO vo, ModelAndView mav) {
		System.out.println("검색 이동");
		mav.addObject("selectList", bookService.listSelect(vo));
		mav.setViewName("search.jsp");
		return mav;
	}

	@RequestMapping(value = "/grade.do")
	public String grade(OrderVO vo) {
		System.out.println("평점 등록 처리");
		List<OrderVO> vo2 = new ArrayList<OrderVO>();
		vo2 = orderService.price(vo);
		System.out.println(vo2.toString());
		if (vo2.isEmpty()) {
			return "oneBook.do";
		} else {
			orderService.insertGrade(vo);
			return "oneBook.do";
		}
	}

}

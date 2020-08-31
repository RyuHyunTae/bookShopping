package com.shopping.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.biz.basket.BasketService;
import com.shopping.biz.basket.BasketVO;
import com.shopping.biz.book.BookService;
import com.shopping.biz.book.BookVO;

@Controller
public class BasketController {
	
	@Autowired
	BasketService basketService;
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/insertBasket.do")
	public String insertBasket(BasketVO vo) {
		System.out.println("장바구니 등록 처리");
		if(basketService.CheckNun(vo).isEmpty()) {
		basketService.insertBasket(vo);
		} else {
			basketService.updateCount(vo);
		}
		return "oneBook.do";
	}
	@RequestMapping(value = "/deleteBasket.do")
	public String deleteBasket(BasketVO vo) {
		System.out.println("장바구니 삭제 처리");
		basketService.deleteBasket(vo);
		return "listBasket.do";
	}
	
	@RequestMapping(value = "/listBasket.do")
	public ModelAndView oneCloth(BasketVO vo, ModelAndView mav) {
		System.out.println("장바구니 불러오기");
		mav.addObject("listBasket", basketService.listBasket(vo));
		mav.addObject("allBook", bookService.allBook());
		mav.setViewName("basketList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/updateCountUp.do")
	public String updateCountUp(BasketVO vo) {
		System.out.println("장바구니 수량 증가 처리");
		basketService.updateCountUp(vo);
		return "listBasket.do";
	}
	
	@RequestMapping(value = "/updateCountDown.do")
	public String updateCountDown(BasketVO vo) {
		System.out.println("장바구니 수량 감소 처리");
		basketService.updateCountDown(vo);
		return "listBasket.do";
	}
}

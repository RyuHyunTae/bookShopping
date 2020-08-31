package com.shopping.view.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.shopping.biz.user.AddressVO;
import com.shopping.biz.user.CreditcardVO;
import com.shopping.biz.user.UserService;
import com.shopping.biz.user.UserVO;

@Controller
public class OrderController {
	@Autowired
	BookService bookService;
	@Autowired
	BasketService basketService;
	@Autowired
	OrderService orderService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/oneOrder.do")
	public ModelAndView oneOrder(BookVO vo, ModelAndView mav) {
		System.out.println("����ȭ�� (1)");
		AddressVO address=new AddressVO();
		address.setId(vo.getId());
		CreditcardVO creditcard = new CreditcardVO();
		creditcard.setId(vo.getId());
		mav.addObject("oneList", bookService.oneBook(vo));
		mav.addObject("addressList",userService.listAddress(address));
		mav.addObject("creditcardList",userService.listCreditcard(creditcard));
		mav.setViewName("orderPage.jsp");
		return mav;
	}

	@RequestMapping(value = "/listOrder.do")
	public ModelAndView listOrder(BasketVO vo, ModelAndView mav) {
		System.out.println("����ȭ�� (2)");
		AddressVO address=new AddressVO();
		address.setId(vo.getId());
		CreditcardVO creditcard = new CreditcardVO();
		creditcard.setId(vo.getId());
		mav.addObject("basketList", basketService.listBasket(vo));
		mav.addObject("addressList",userService.listAddress(address));
		mav.addObject("creditcardList",userService.listCreditcard(creditcard));
		mav.setViewName("orderListPage.jsp");
		return mav;
	}

	@RequestMapping(value = "/insertOneOrder.do")
	public String insertOneOrder(OrderVO vo,HttpSession session) {
		System.out.println("����(1) ó��");
		int sum=0;
		OrderVO list = new OrderVO();
		orderService.insertOrder(vo);
		list = orderService.loadOrderNum(vo);
		vo.setOrderNum(list.getOrderNum());
		orderService.insertOrderDetail(vo);
		
		
		List<OrderVO> vo2 = new ArrayList<OrderVO>();
		vo2=orderService.price(vo);
		UserVO vo3 = new UserVO();
		for(OrderVO price : vo2) {
			sum+=price.getOrderPrice();
			
		}
		if(sum>=30000) {
			vo3.setGrade("a");
		} else if(sum>=10000&&sum<30000) {
			vo3.setGrade("b");
		} else {
			vo3.setGrade("c");
		}
		vo3.setId(vo.getId());
		userService.grade(vo3);
		
		session.setAttribute("grade",vo3.getGrade());
		vo3.setPoint(vo.getOrderPrice()/10);
		userService.updatePoint(vo3);
		bookService.updateCount(vo);
		return "main.do";
	}

	@RequestMapping(value = "/insertListOrder.do")
	public String insertListOrder(OrderVO vo,HttpSession session) {
		System.out.println("����(2) ó��");
		int sum=0;
		OrderVO list = new OrderVO();
		BasketVO basket = new BasketVO();
		basket.setId(vo.getId());
		List<BasketVO> list2 = new ArrayList<BasketVO>();
		orderService.insertOrder(vo);
		list = orderService.loadOrderNum(vo);
		vo.setOrderNum(list.getOrderNum());
		list2 = basketService.listBasket(basket);
		for (BasketVO a : list2) {
			vo.setBookNum(a.getBookNum());
			if(vo.getGrade().equals("a")) {
				double ex= a.getBookPrice()*0.8;
				int ex2 = (int) ex;
				vo.setOrderPrice(ex2);
			} else if(vo.getGrade().equals("b")) {
				double ex= a.getBookPrice()*0.9;
				int ex2 = (int) ex;
				vo.setOrderPrice(ex2);
			} else if(vo.getGrade().equals("c")) {
				double ex= a.getBookPrice();
				int ex2 = (int) ex;
				vo.setOrderPrice(ex2);
			}
			vo.setBookName(a.getBookName());
			vo.setBookPicture(a.getBookPicture());
			vo.setCount(a.getCount());
			orderService.insertOrderDetail(vo);
			
			List<OrderVO> vo2 = new ArrayList<OrderVO>();
			vo2=orderService.price(vo);
			UserVO vo3 = new UserVO();
			for(OrderVO price : vo2) {
				sum+=price.getOrderPrice();
				
			}
			if(sum>=30000) {
				vo3.setGrade("a");
			} else if(sum>=10000&&sum<30000) {
				vo3.setGrade("b");
			} else {
				vo3.setGrade("c");
			}
			vo3.setId(vo.getId());
			userService.grade(vo3);
			vo3.setPoint(vo.getOrderPrice()/10);
			userService.updatePoint(vo3);
			session.setAttribute("grade",vo3.getGrade());
			
			for(int i=0;i<vo.getCount();i++) {
			bookService.updateCount(vo);
			}
			
			
		}
		
		
		basketService.deleteAllBasket(basket);
		return "main.do";
	}

	@RequestMapping(value = "/orderConfirmation.do")
	public ModelAndView orderConfirmation(OrderVO vo, ModelAndView mav) {
		System.out.println("�ֹ� Ȯ�� ȭ��");
		List<OrderVO> list = new ArrayList<OrderVO>();
		List<OrderVO> list2 = new ArrayList<OrderVO>();
		list = orderService.orderConfirmation(vo);
		for(OrderVO a : list) {
			vo.setOrderNum(a.getOrderNum());
			list2.addAll(orderService.orderConfirmationDetail(vo));
		}
		mav.addObject("orderList", list);
		mav.addObject("orderDetailList", list2);
		mav.addObject("allCloth",bookService.allBook());
		mav.setViewName("orderConfirmation.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/allOrder.do")
	public ModelAndView allOrder(OrderVO vo, ModelAndView mav) {
		System.out.println("�� �ֹ� ȭ��");
		mav.addObject("allOrder", orderService.allOrder());
		mav.setViewName("allOrder.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/delivery.do")
	public String delivery(OrderVO vo) {
		System.out.println("��� ó��");
		orderService.delivery(vo);
		return "allOrder.do";
	}
	
	@RequestMapping(value = "/deleteOrder.do")
	public String deleteOrder(OrderVO vo) {
		System.out.println("�ֹ� ���� ó��");
		orderService.deleteOrderDetail(vo);
		if(orderService.CheckNun(vo).isEmpty()) {
			orderService.deleteOrder(vo);
		}
		return "allOrder.do";
	}
	
	@RequestMapping(value = "/returnState.do")
	public String returnState(OrderVO vo) {
		System.out.println("��ǰ ó��");
		orderService.returnState(vo);
		return "orderConfirmation.do";
	}
	
	@RequestMapping(value = "/returnPage.do")
	public ModelAndView returnPage(OrderVO vo, ModelAndView mav) {
		System.out.println("ȯ�� ��û ȭ��");
		mav.addObject("returnAll", orderService.returnAll());
		mav.setViewName("returnPage.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/returnCheck.do")
	public String returnCheck(OrderVO vo) {
		System.out.println("��ǰ �Ϸ� ó��");
		orderService.returnState(vo);
		return "returnPage.do";
	}
	
	@RequestMapping(value = "/returnCancel.do")
	public String returnCancel(OrderVO vo) {
		System.out.println("��ǰ ��� ó��");
		orderService.returnState(vo);
		return "returnPage.do";
	}
	
	@RequestMapping(value = "/userOrder.do")
	public ModelAndView userOrder(OrderVO vo, ModelAndView mav) {
		System.out.println("���� �ֹ� ��û ȭ��");
		mav.addObject("userOrder", orderService.userOrder(vo));
		mav.setViewName("userOrder.jsp");
		return mav;
	}
	
}

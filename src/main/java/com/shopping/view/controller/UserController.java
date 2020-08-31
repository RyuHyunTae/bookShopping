package com.shopping.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.biz.user.AddressVO;
import com.shopping.biz.user.CreditcardVO;
import com.shopping.biz.user.UserService;
import com.shopping.biz.user.UserVO;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login.do")
	public String login(UserVO vo, HttpSession session) {
		System.out.println("로그인 처리");
		UserVO user = userService.login(vo);
		if (user != null) {
			session.setAttribute("id", user.getId());;
			session.setAttribute("admin", user.getAdmin());
			session.setAttribute("grade",user.getGrade());
			return "main.do";
		} else {
			return "login.jsp";
		}
	}

	@RequestMapping(value = "/join.do")
	public String join(UserVO vo) {
		System.out.println("회원가입 처리");
		userService.join(vo);
		AddressVO address = new AddressVO();
		address.setId(vo.getId());
		address.setPostCode(vo.getPostCode());
		address.setAddress(vo.getAddress());
		address.setAddressdetail(vo.getAddressdetail());
		userService.insertAddress(address);
		return "login.jsp";
	}
	
	@RequestMapping(value="logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		session.invalidate();
		return "login.jsp";
	}
	
	@RequestMapping(value = "/listUser.do")
	public ModelAndView listUser(UserVO vo, ModelAndView mav) {
		System.out.println("유저 정보 불러오기");
		mav.addObject("listUser", userService.listUser(vo));
		mav.setViewName("userList.jsp");
		return mav;
	}
	
	@RequestMapping(value="userInfo.do")
	public ModelAndView userInfo(UserVO vo, ModelAndView mav) {
		System.out.println("유저 개인정보 불러오기");
		mav.addObject("userInfo",userService.userInfo(vo));
		mav.setViewName("userInfo.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/userUpdate.do")
	public String update(UserVO vo) {
		System.out.println("유저 정보 수정 처리");
		userService.update(vo);
		return "main.do";
	}
	
	@RequestMapping(value = "/creditcardList.do")
	public ModelAndView creditcardList(CreditcardVO vo, ModelAndView mav) {
		System.out.println("신용카드 리스트");
		mav.addObject("creditcardList",userService.listCreditcard(vo));
		mav.setViewName("creditcardList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/insertCreditcard.do")
	public String insertCreditcard(CreditcardVO vo) {
		System.out.println("신용카드 등록 처리");
		userService.insertCreditcard(vo);
		return "creditcardList.do";
	}
	
	@RequestMapping(value = "/deleteCreditcard.do")
	public String deleteCreditcard(CreditcardVO vo) {
		System.out.println("신용카드 삭제 처리");
		userService.deleteCreditcard(vo);
		return "creditcardList.do";
	}
	
	@RequestMapping(value = "/addressList.do")
	public ModelAndView addressList(AddressVO vo, ModelAndView mav) {
		System.out.println("신용카드 리스트");
		mav.addObject("addressList",userService.listAddress(vo));
		mav.setViewName("addressList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/insertAddress.do")
	public String insertAddress(AddressVO vo) {
		System.out.println("주소 등록 처리");
		userService.insertAddress(vo);
		return "addressList.do";
	}
	
	@RequestMapping(value = "/deleteAddress.do")
	public String deleteAddress(AddressVO vo) {
		System.out.println("주소 삭제 처리");
		userService.deleteAddress(vo);
		return "addressList.do";
	}
}

package com.shopping.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ViewController {
	@RequestMapping(value = "/main.do")
	public String main() {
		System.out.println("메인 페이지 이동");
		return "listBook.do";
	}
}

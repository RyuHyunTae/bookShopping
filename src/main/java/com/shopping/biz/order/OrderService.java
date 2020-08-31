package com.shopping.biz.order;

import java.util.List;

public interface OrderService {
	int insertOrder(OrderVO vo);
	int insertOrderDetail(OrderVO vo);
	
	int deleteOrder(OrderVO vo);
	int deleteOrderDetail(OrderVO vo);
	
	List<OrderVO> CheckNun(OrderVO vo);
	
	
	OrderVO loadOrderNum(OrderVO vo);
	
	int delivery(OrderVO vo);
	int returnState(OrderVO vo);
	
	List<OrderVO> returnAll();
	
	List<OrderVO> orderConfirmation(OrderVO vo);
	List<OrderVO> orderConfirmationDetail(OrderVO vo);
	
	List<OrderVO> allOrder();
	List<OrderVO> userOrder(OrderVO vo);
	
	List<OrderVO> price(OrderVO vo);
	
	int insertGrade(OrderVO vo);
	
	List<OrderVO> bookEmpty(OrderVO vo);
	
	List<OrderVO> grade2(OrderVO vo);
}

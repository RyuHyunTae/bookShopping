package com.shopping.biz.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.biz.order.OrderService;
import com.shopping.biz.order.OrderVO;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public int insertOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.insertOrder(vo);
	}

	@Override
	public int insertOrderDetail(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.insertDetailOrder(vo);
	}

	@Override
	public int deleteOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.deleteOrder(vo);
	}

	@Override
	public int deleteOrderDetail(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.deleteDetailOrder(vo);
	}

	@Override
	public List<OrderVO> CheckNun(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.checkNun(vo);
	}

	@Override
	public OrderVO loadOrderNum(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.loadOrderNum(vo);
	}

	@Override
	public int delivery(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.delivery(vo);
	}

	@Override
	public int returnState(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.returnState(vo);
	}

	@Override
	public List<OrderVO> returnAll() {
		// TODO Auto-generated method stub
		return orderDAO.returnAll();
	}

	@Override
	public List<OrderVO> orderConfirmation(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.orderConfirmation(vo);
	}

	@Override
	public List<OrderVO> orderConfirmationDetail(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.orderConfirmationDetail(vo);
	}

	@Override
	public List<OrderVO> allOrder() {
		// TODO Auto-generated method stub
		return orderDAO.allOrder();
	}

	@Override
	public List<OrderVO> userOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.userOrder(vo);
	}

	@Override
	public List<OrderVO> price(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.price(vo);
	}

	@Override
	public List<OrderVO> grade2(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.grade2(vo);
	}

	@Override
	public int insertGrade(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.insertGrade(vo);
	}

	@Override
	public List<OrderVO> bookEmpty(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.bookEmpty(vo);
	}

}

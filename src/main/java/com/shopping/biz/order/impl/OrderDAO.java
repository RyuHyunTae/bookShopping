package com.shopping.biz.order.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.biz.order.OrderVO;

@Repository("orderDAO")
public class OrderDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int insertOrder(OrderVO vo) {
		return sqlSession.insert("orderDAO.insert",vo);
	}
	
	public int insertDetailOrder(OrderVO vo) {
		return sqlSession.insert("orderDAO.insertDetail",vo);
	}
	
	public OrderVO loadOrderNum(OrderVO vo) {
		return sqlSession.selectOne("orderDAO.loadOrderNum",vo);
	}
	
	public List<OrderVO> orderConfirmation(OrderVO vo){
		return sqlSession.selectList("orderDAO.orderConfirmation",vo);
	}
	
	public List<OrderVO> orderConfirmationDetail(OrderVO vo){
		return sqlSession.selectList("orderDAO.orderConfirmationDetail",vo);
	}
	
	public List<OrderVO> allOrder(){
		return sqlSession.selectList("orderDAO.allOrder");
	}
	
	public int delivery(OrderVO vo) {
		return sqlSession.update("orderDAO.delivery",vo);
	}
	
	public int deleteOrder(OrderVO vo) {
		return sqlSession.insert("orderDAO.delete",vo);
	}
	
	public int deleteDetailOrder(OrderVO vo) {
		return sqlSession.insert("orderDAO.deleteDetail",vo);
	}
	
	public List<OrderVO> checkNun(OrderVO vo){
		return sqlSession.selectList("orderDAO.checkNun",vo);
	}
	
	public int returnState(OrderVO vo) {
		return sqlSession.update("orderDAO.returnState",vo);
	}
	
	public List<OrderVO> returnAll(){
		return sqlSession.selectList("orderDAO.returnAll");
	}
	
	public List<OrderVO> userOrder(OrderVO vo){
		return sqlSession.selectList("orderDAO.userOrder",vo);
	}
	
	public List<OrderVO> price(OrderVO vo){
		return sqlSession.selectList("orderDAO.price",vo);
	}
	
	public List<OrderVO> grade2(OrderVO vo) {
		return sqlSession.selectList("orderDAO.grade2",vo);
	}
	
	public int insertGrade(OrderVO vo) {
		return sqlSession.insert("orderDAO.insertGrade",vo);
	}
	
	public List<OrderVO> bookEmpty(OrderVO vo){
		return sqlSession.selectList("orderDAO.bookEmpty",vo);
	}
}

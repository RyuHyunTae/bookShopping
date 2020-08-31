package com.shopping.biz.basket.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.biz.basket.BasketVO;
import com.shopping.biz.order.OrderVO;

@Repository("basketDAO")
public class BasketDAO {

	@Autowired
	SqlSession sqlSession;
	
	public int insertBasket(BasketVO vo) {
		return sqlSession.insert("basketDAO.insert",vo);
	}
	public int deleteBasket(BasketVO vo) {
		return sqlSession.delete("basketDAO.delete",vo);
	}
	public int deleteAllBasket(BasketVO vo) {
		return sqlSession.delete("basketDAO.deleteAll",vo);
	}
	
	public List<BasketVO> listBasket(BasketVO vo){
		return sqlSession.selectList("basketDAO.listBasket",vo);
	}
	
	public List<BasketVO> checkNun(BasketVO vo){
		return sqlSession.selectList("basketDAO.checkNun",vo);
	}
	
	public int deleteAllCloth(BasketVO vo) {
		return sqlSession.delete("basketDAO.deleteAllCloth",vo);
	}
	
	public int updateCount(BasketVO vo) {
		return sqlSession.update("basketDAO.updateCount",vo);
	}
	
	public int updateCountUp(BasketVO vo) {
		return sqlSession.update("basketDAO.updateCountUp",vo);
	}
	
	public int updateCountDown(BasketVO vo) {
		return sqlSession.update("basketDAO.updateCountDown",vo);
	}
}

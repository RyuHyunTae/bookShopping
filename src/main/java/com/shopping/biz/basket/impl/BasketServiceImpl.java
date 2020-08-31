package com.shopping.biz.basket.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.biz.basket.BasketService;
import com.shopping.biz.basket.BasketVO;

@Service
public class BasketServiceImpl implements BasketService {
	@Autowired
	BasketDAO basketDAO;
	
	@Override
	public int insertBasket(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.insertBasket(vo);
	}

	@Override
	public int deleteBasket(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.deleteBasket(vo);
	}
	
	@Override
	public int deleteAllBasket(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.deleteAllBasket(vo);
	}

	@Override
	public List<BasketVO> listBasket(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.listBasket(vo);
	}

	@Override
	public List<BasketVO> CheckNun(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.checkNun(vo);
	}

	@Override
	public int deleteAllCloth(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.deleteAllCloth(vo);
	}
	
	@Override
	public int updateCount(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.updateCount(vo);
	}

	@Override
	public int updateCountUp(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.updateCountUp(vo);
	}

	@Override
	public int updateCountDown(BasketVO vo) {
		// TODO Auto-generated method stub
		return basketDAO.updateCountDown(vo);
	}
}

package com.shopping.biz.basket;

import java.util.List;

public interface BasketService {
	int insertBasket(BasketVO vo);
	
	int deleteBasket(BasketVO vo);
	
	int deleteAllBasket(BasketVO vo);
	
	int deleteAllCloth(BasketVO vo);
	
	List<BasketVO> listBasket(BasketVO vo);
	
	List<BasketVO> CheckNun(BasketVO vo);
	
	int updateCount(BasketVO vo);
	
	int updateCountUp(BasketVO vo);
	int updateCountDown(BasketVO vo);
}

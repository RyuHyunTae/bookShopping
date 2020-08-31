package com.shopping.biz.user;

import java.util.List;

public interface UserService {
	
	UserVO login(UserVO vo);
	
	int join(UserVO vo);
	
	int update(UserVO vo);
	
	List<UserVO> listUser(UserVO vo);
	
	UserVO userInfo(UserVO vo);
	
	List<CreditcardVO> listCreditcard(CreditcardVO vo);
	
	int insertCreditcard(CreditcardVO vo);
	
	int deleteCreditcard(CreditcardVO vo);
	
	List<AddressVO> listAddress(AddressVO vo);
	
	int insertAddress(AddressVO vo);
	
	int deleteAddress(AddressVO vo);
	
	List<UserVO> grade(UserVO vo);
	
	int updatePoint(UserVO vo);
}

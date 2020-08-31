package com.shopping.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.biz.user.AddressVO;
import com.shopping.biz.user.CreditcardVO;
import com.shopping.biz.user.UserService;
import com.shopping.biz.user.UserVO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDAO;
	
	@Override
	public UserVO login(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.login(vo);
	}

	@Override
	public int join(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.join(vo);
	}
	
	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.update(vo);
	}

	@Override
	public List<UserVO> listUser(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.listUser(vo);
	}

	@Override
	public UserVO userInfo(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.userInfo(vo);
	}

	@Override
	public List<CreditcardVO> listCreditcard(CreditcardVO vo) {
		// TODO Auto-generated method stub
		return userDAO.listCreditcard(vo);
	}

	@Override
	public int insertCreditcard(CreditcardVO vo) {
		// TODO Auto-generated method stub
		return userDAO.insertCreditcard(vo);
	}

	@Override
	public int deleteCreditcard(CreditcardVO vo) {
		// TODO Auto-generated method stub
		return userDAO.deleteCreditcard(vo);
	}

	@Override
	public int insertAddress(AddressVO vo) {
		// TODO Auto-generated method stub
		return userDAO.insertAddress(vo);
	}

	@Override
	public int deleteAddress(AddressVO vo) {
		// TODO Auto-generated method stub
		return userDAO.deleteAddress(vo);
	}

	@Override
	public List<AddressVO> listAddress(AddressVO vo) {
		// TODO Auto-generated method stub
		return userDAO.listAddress(vo);
	}

	@Override
	public List<UserVO> grade(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.grade(vo);
	}

	@Override
	public int updatePoint(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.updatePoint(vo);
	}
	
}

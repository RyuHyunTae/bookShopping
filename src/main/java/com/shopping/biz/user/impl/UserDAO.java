package com.shopping.biz.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.biz.user.AddressVO;
import com.shopping.biz.user.CreditcardVO;
import com.shopping.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	@Autowired
	SqlSession sqlSession;
	//CRUD 기능의 메소드 구현
	//회원 등록
	public UserVO login(UserVO vo)
	{
		return sqlSession.selectOne("userDAO.login",vo);
	}
	
	public int join(UserVO vo)
	{
		return sqlSession.insert("userDAO.join",vo);
	}
	
	public int update(UserVO vo)
	{
		return sqlSession.update("userDAO.update",vo);
	}
	
	public List<UserVO> listUser(UserVO vo){
		return sqlSession.selectList("userDAO.listUser",vo);
	}
	
	public UserVO userInfo(UserVO vo) {
		return sqlSession.selectOne("userDAO.userInfo",vo);
	}
	
	public List<CreditcardVO> listCreditcard(CreditcardVO vo){
		return sqlSession.selectList("userDAO.listCreditcard",vo);
	}
	
	public int insertCreditcard(CreditcardVO vo)
	{
		return sqlSession.insert("userDAO.insertCreditcard",vo);
	}
	
	public int deleteCreditcard(CreditcardVO vo)
	{
		return sqlSession.delete("userDAO.deleteCreditcard",vo);
	}
	
	public List<AddressVO> listAddress(AddressVO vo){
		return sqlSession.selectList("userDAO.listAddress",vo);
	}
	
	public int insertAddress(AddressVO vo)
	{
		return sqlSession.insert("userDAO.insertAddress",vo);
	}
	
	public int deleteAddress(AddressVO vo)
	{
		return sqlSession.delete("userDAO.deleteAddress",vo);
	}
	
	public List<UserVO> grade(UserVO vo){
		return sqlSession.selectList("userDAO.grade",vo);
	}
	
	public int updatePoint(UserVO vo)
	{
		return sqlSession.update("userDAO.updatePoint",vo);
	}
}

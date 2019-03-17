package com.woo502.recommend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woo502.recommend.bo.User;
import com.woo502.recommend.dao.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<User> findAll() throws Exception{
		return mapper.findAll();
	}
}

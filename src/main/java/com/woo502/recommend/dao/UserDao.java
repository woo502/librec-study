package com.woo502.recommend.dao;

import java.util.List;

import com.woo502.recommend.bo.User;

public interface UserDao {

	List<User> findAll() throws Exception;

}

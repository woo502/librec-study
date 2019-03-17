package com.woo502.recommend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woo502.recommend.bo.Book;
import com.woo502.recommend.dao.mapper.BookMapper;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private BookMapper mapper;
	
	@Override
	public List<Book> findAll() throws Exception {
		return mapper.findAll();
	}
	
}

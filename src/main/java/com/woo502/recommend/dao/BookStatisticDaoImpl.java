package com.woo502.recommend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woo502.recommend.bo.BookStatistic;
import com.woo502.recommend.dao.mapper.BookStatisticMapper;

@Repository
public class BookStatisticDaoImpl implements BookStatisticDao {

	@Autowired
	private BookStatisticMapper mapper;
	
	@Override
	public List<BookStatistic> findAll() throws Exception {
		return mapper.findAll();
	}
	
}

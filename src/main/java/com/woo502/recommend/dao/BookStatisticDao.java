package com.woo502.recommend.dao;

import java.util.List;

import com.woo502.recommend.bo.BookStatistic;

public interface BookStatisticDao {

	List<BookStatistic> findAll() throws Exception;

}

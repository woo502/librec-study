package com.woo502.recommend.dao;

import java.util.List;

import com.woo502.recommend.bo.Book;

public interface BookDao {

	List<Book> findAll() throws Exception;

}

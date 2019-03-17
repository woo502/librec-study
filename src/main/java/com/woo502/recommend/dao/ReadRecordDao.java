package com.woo502.recommend.dao;

import java.util.List;

import com.woo502.recommend.bo.ReadRecord;

public interface ReadRecordDao {

	List<ReadRecord> findAll() throws Exception;

}

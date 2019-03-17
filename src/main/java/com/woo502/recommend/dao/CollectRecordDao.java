package com.woo502.recommend.dao;

import java.util.List;

import com.woo502.recommend.bo.CollectRecord;

public interface CollectRecordDao {

	List<CollectRecord> findAll() throws Exception;

}

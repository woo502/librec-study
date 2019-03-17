package com.woo502.recommend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woo502.recommend.bo.CollectRecord;
import com.woo502.recommend.dao.mapper.CollectRecordMapper;

@Repository
public class CollectRecordDaoImpl implements CollectRecordDao {

	@Autowired
	private CollectRecordMapper mapper;
	
	@Override
	public List<CollectRecord> findAll() throws Exception {
		return mapper.findAll();
	} 
}

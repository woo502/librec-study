package com.woo502.recommend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woo502.recommend.bo.ReadRecord;
import com.woo502.recommend.dao.mapper.ReadRecordMapper;

@Repository
public class ReadRecordDaoImpl implements ReadRecordDao {

	@Autowired
	private ReadRecordMapper mapper;
	
	@Override
	public List<ReadRecord> findAll() throws Exception {
		return mapper.findAll();
	} 
}

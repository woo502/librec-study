package com.woo502.recommend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woo502.recommend.bo.ShareRecord;
import com.woo502.recommend.dao.mapper.ShareRecordMapper;

@Repository
public class ShareRecordDaoImpl implements ShareRecordDao {

	@Autowired
	private ShareRecordMapper mapper;
	
	@Override
	public List<ShareRecord> findAll() throws Exception {
		return mapper.findAll();
	} 
}

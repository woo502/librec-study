package com.woo502.recommend.dao;

import java.util.List;

import com.woo502.recommend.bo.ShareRecord;

public interface ShareRecordDao {

	List<ShareRecord> findAll() throws Exception;

}

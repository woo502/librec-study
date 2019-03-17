package com.woo502.recommend.svc;

import java.util.List;

import net.librec.recommender.item.RecommendedItem;

public interface RecommendSvc {

	/**
	 * 	生成推荐数据
	 * @throws Exception
	 */
	public void recommend() throws Exception;
	
	/**
	 *	获取某个用户的推荐列表
	 * @param userId 用户id
	 * @return 
	 * @throws Exception
	 */
	public List<RecommendedItem> getUserRecommedList(Long userId) throws Exception;
}

package com.woo502.recommend.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.woo502.recommend.svc.RecommendSvc;

public class RefreshUserRecommendJob implements Job{
	
	Logger logger = LoggerFactory.getLogger(RefreshUserRecommendJob.class);

	@Autowired
	private RecommendSvc svc;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			svc.recommend();
		} catch (Exception e) {
			logger.error("更新用户推荐失败", e);
		}
	}

}

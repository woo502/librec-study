package com.woo502.recommend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woo502.recommend.svc.RecommendSvc;
import com.woo502.recommend.vo.ResJson;

import net.librec.recommender.item.RecommendedItem;

@Controller
@RequestMapping("/recommend")
public class RecommendController extends BaseController {
	
	Logger logger = LoggerFactory.getLogger(RecommendController.class);

	@Autowired
	private RecommendSvc svc;

	@ResponseBody
	@RequestMapping(value = "/{userId}/book")
	public ResJson book(@PathVariable Long userId) {

		if (userId == 0) {
			return new ResJson(-2, null);
		}
		List<RecommendedItem> userRecommedList = null;
		try {
			userRecommedList = svc.getUserRecommedList(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResJson(0, userRecommedList);
	}

}

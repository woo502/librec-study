package com.woo502.recommend.svc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woo502.recommend.bo.Book;
import com.woo502.recommend.bo.BookStatistic;
import com.woo502.recommend.bo.CollectRecord;
import com.woo502.recommend.bo.ReadRecord;
import com.woo502.recommend.bo.ShareRecord;
import com.woo502.recommend.bo.User;
import com.woo502.recommend.dao.BookDao;
import com.woo502.recommend.dao.BookStatisticDao;
import com.woo502.recommend.dao.CollectRecordDao;
import com.woo502.recommend.dao.ReadRecordDao;
import com.woo502.recommend.dao.ShareRecordDao;
import com.woo502.recommend.dao.UserDao;
import com.woo502.recommend.datamodel.MyDataModel;

import net.librec.conf.Configuration;
import net.librec.conf.Configuration.Resource;
import net.librec.filter.GenericRecommendedFilter;
import net.librec.recommender.Recommender;
import net.librec.recommender.RecommenderContext;
import net.librec.recommender.cf.ItemKNNRecommender;
import net.librec.recommender.item.RecommendedItem;
import net.librec.similarity.PCCSimilarity;
import net.librec.similarity.RecommenderSimilarity;

@Service
public class RecommendSvcImpl implements RecommendSvc {
	
	Logger logger = LoggerFactory.getLogger(RecommendSvcImpl.class);
	
	private static List<RecommendedItem> recommendedItemList= null;
	
	ReentrantLock lock = new ReentrantLock(true);

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private ReadRecordDao readRecordDao;
	
	@Autowired
	private ShareRecordDao shareRecordDao;
	
	@Autowired
	private CollectRecordDao collectRecordDao;
	
	@Autowired
	private BookStatisticDao bookStatisticDao;
	
	@Override
	public void recommend() throws Exception {
		
		logger.info("recommend Algorithm runing ......");
		Long startTime = System.currentTimeMillis();
		
		List<User> userList = userDao.findAll();
		List<Book> bookList = bookDao.findAll();
		List<ReadRecord> readList = readRecordDao.findAll();
		List<ShareRecord> shareList = shareRecordDao.findAll();
		List<CollectRecord> collectList = collectRecordDao.findAll();
		List<BookStatistic> bookStatistics = bookStatisticDao.findAll();
		
		User zeroUser = new User();
		zeroUser.setUserid(0);
		zeroUser.setSex((byte)0);
		userList.set(0, zeroUser);
		
		Configuration conf = new Configuration();
		Resource resource = new Resource("itemknn-testranking.properties");
		conf.addResource(resource);
		MyDataModel dataModel = new MyDataModel(conf, userList, bookList, readList, shareList, collectList, bookStatistics);
		dataModel.buildDataModel();

		// build recommender context
		RecommenderContext context = new RecommenderContext(conf, dataModel);

		// build similarity
		conf.set("rec.recommender.similarity.key", "item");
		RecommenderSimilarity similarity = new PCCSimilarity();
		similarity.buildSimilarityMatrix(dataModel);
		context.setSimilarity(similarity);

		// build recommender
//		conf.set("rec.neighbors.knn.number", "5");
		Recommender recommender = new ItemKNNRecommender();
		recommender.setContext(context);

		// run recommender algorithm
		recommender.recommend(context);

		lock.lock();
		recommendedItemList = recommender.getRecommendedList();
		lock.unlock();
		
		Long endTime = System.currentTimeMillis();
		
		logger.info("recommend Algorithm run finish ! time userd : " + (endTime - startTime));
	}

	@Override
	public List<RecommendedItem> getUserRecommedList(Long userId) throws Exception {
		List<String> userIdList = new ArrayList<>();
//        List<String> itemIdList = new ArrayList<>();
        
        List<RecommendedItem> orignList = recommendedItemList;
        
        userIdList.add(userId.toString());
		GenericRecommendedFilter filter = new GenericRecommendedFilter();
		filter.setUserIdList(userIdList);
//		filter.setUserIdList(itemIdList);
		List<RecommendedItem> result = filter.filter(orignList);
		if (result == null || result.size() == 0) {
			userIdList.set(0, "0");
			filter.setUserIdList(userIdList);
			lock.lock();
			result = filter.filter(orignList);
			lock.unlock();
		}
		
		return result;
	}

}

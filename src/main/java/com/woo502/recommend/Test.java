package com.woo502.recommend;

import java.util.ArrayList;
import java.util.List;

import net.librec.conf.Configuration;
import net.librec.conf.Configuration.Resource;
import net.librec.data.model.TextDataModel;
import net.librec.eval.RecommenderEvaluator;
import net.librec.eval.rating.RMSEEvaluator;
import net.librec.filter.GenericRecommendedFilter;
import net.librec.recommender.Recommender;
import net.librec.recommender.RecommenderContext;
import net.librec.recommender.cf.ItemKNNRecommender;
import net.librec.recommender.cf.UserKNNRecommender;
import net.librec.recommender.item.RecommendedItem;
import net.librec.similarity.PCCSimilarity;
import net.librec.similarity.RecommenderSimilarity;

public class Test {

	public static void main(String[] args) throws Exception{
		// build data model
        Configuration conf = new Configuration();
        Resource resource = new Resource("itemknn-testranking.properties");
		conf.addResource(resource);
        conf.set("dfs.data.dir", "D:\\wordspace\\git\\jweb_book_recommend\\data");
        conf.set("data.input.path", "book");
        TextDataModel dataModel = new TextDataModel(conf);
        dataModel.buildDataModel();

        // build recommender context
        RecommenderContext context = new RecommenderContext(conf, dataModel);

        // build similarity
        conf.set("rec.recommender.similarity.key" ,"item");
        RecommenderSimilarity similarity = new PCCSimilarity();
        similarity.buildSimilarityMatrix(dataModel);
        context.setSimilarity(similarity);

        // build recommender
        conf.set("rec.neighbors.knn.number", "5");
        Recommender recommender = new ItemKNNRecommender();
        recommender.setContext(context);

        // run recommender algorithm
        recommender.recommend(context);

        // evaluate the recommended result
//        RecommenderEvaluator evaluator = new RMSEEvaluator();
//        System.out.println("RMSE:" + recommender.evaluate(evaluator));

        // set id list of filter
        List<String> userIdList = new ArrayList<>();
        List<String> itemIdList = new ArrayList<>();
//        userIdList.add("5");
//        itemIdList.add("70");

        // filter the recommended result
        List<RecommendedItem> recommendedItemList = recommender.getRecommendedList();

        System.out.println("recommendedItemList size:" + recommendedItemList.size());
        
        GenericRecommendedFilter filter = new GenericRecommendedFilter();
//        filter.setUserIdList(userIdList);
//        filter.setItemIdList(itemIdList);
//        recommendedItemList = filter.filter(recommendedItemList);
        
        // print filter result
        for (RecommendedItem recommendedItem : recommendedItemList) {
            System.out.println(
                    "user:" + recommendedItem.getUserId() + " " +
                    "item:" + recommendedItem.getItemId() + " " +
                    "value:" + recommendedItem.getValue()
            );
        }

        System.out.println("recommendedItemList size:" + recommendedItemList.size());

        System.out.println("recommendedItemList size:" + recommender.getRecommendedList().size());
	}

}

package test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.woo502.recommend.svc.RecommendSvc;

import net.librec.recommender.item.RecommendedItem;

public class RecommendTest{
	
	private static ApplicationContext context;
    private static RecommendSvc svc;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("cfg.env", "local");
        String[] classPath = new String[]{"classpath:conf-spring/spring-service.xml",
                "classpath:conf-spring/spring-mybatis.xml"};
        context = new ClassPathXmlApplicationContext(classPath);
        svc = (RecommendSvc)context.getBean(RecommendSvc.class);
    }

    @Test
    public void recommendTest() {
    	try {
			svc.recommend();
			List<RecommendedItem> userRecommedList = svc.getUserRecommedList(49l);

			System.out.println(JSON.toJSONString(userRecommedList));
//	        List<String> itemIdList = new ArrayList<>();
//	        itemIdList.add("2759");
//			GenericRecommendedFilter filter = new GenericRecommendedFilter();
//			filter.setUserIdList(itemIdList);
//			List<RecommendedItem> filter2 = filter.filter(userRecommedList);
//			System.out.println(JSON.toJSONString(filter2));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}

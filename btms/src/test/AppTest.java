package test;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunjee.btms.service.DataSummaryService;
import com.sunjee.btms.service.PreSellSummaryService;




public class AppTest {

	private DataSummaryService dataSummaryService;
	private PreSellSummaryService preSellSummaryService;
	
	public static void main(String args[]){
		new AppTest().testDataSummary();
	}

	public void testDataSummary(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.dataSummaryService = (DataSummaryService) applicationContext.getBean("dataSummaryService");
		this.preSellSummaryService = (PreSellSummaryService) applicationContext.getBean("preSellSummaryService");
		Date yesterday = DateUtils.addDays(new Date(), -1);
		yesterday = new Date();
		try{
			this.dataSummaryService.addSumOfDay(yesterday, true);
			this.preSellSummaryService.addSummaryOfDay(yesterday, true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

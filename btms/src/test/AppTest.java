package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import com.sunjee.component.bean.User;
import com.sunjee.util.DateUtil;

public class AppTest {

	public static void main(String[] args) {
		/*String num = String.valueOf(new Date().getTime());
		List<String> nums = new ArrayList<String>();
		for(int i = 0; i < 100; i ++){
			String str = String.valueOf((Math.random()+1)*10000).substring(0,5);
			//System.out.println(num + str);
			nums.add(num +str);
		}
		for(int i = 0; i < nums.size(); i ++){
			for(int j = 0; j < nums.size(); j ++){
				if(i == j){
					continue;
				}
				if(nums.get(i) == nums.get(j)){
					System.out.println(i + "与" + j + "值为：" + nums.get(j));
				}
			}
			System.out.println(nums.get(i));
			User user = new User();
			user.setEmail("dsafsdaf");
		}*/
		
		new AppTest().startSummaryTask();
		while(true){}
	}

	@Test
	public void orderNumTest() {
		long num = new Date().getTime();
		System.out.println(num);
	}
	
	private void startSummaryTask() {
		Date start = DateUtils.addMinutes(new Date(), 1);
		final Date taskDate = DateUtils.addMinutes(start, 1);
		long period = taskDate.getTime() - start.getTime();
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("定时任务开始...：" + DateUtil.getCurrentDateTime());
				System.out.println(DateUtil.getCurrentDateTime());
				System.out.println("定时任务结束：" + DateUtil.getCurrentDateTime() + "\n\n================================================================\n\n");
			}
		}, start, period);
	}
}

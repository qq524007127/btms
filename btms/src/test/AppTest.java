package test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import com.sunjee.util.DateUtil;

public class AppTest {
	
	public static void main(String[] args) {
		new AppTest().executeTimerSummaryTask(DateUtils.addMinutes(new Date(), 1));
	}

	private void executeTimerSummaryTask(final Date taskDateTime){
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("定时任务开始...：" + taskDateTime);
				executeTimerSummaryTask(DateUtils.addMinutes(new Date(), 1));
			}
		}, taskDateTime);
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

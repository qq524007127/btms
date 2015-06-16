package com.sunjee.btms.components;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Component;

import com.sunjee.btms.service.DataSummaryService;
import com.sunjee.btms.service.PreSellSummaryService;
import com.sunjee.component.bean.BaseBean;
import com.sunjee.util.DateUtil;

@Component("dataSummaryComponent")
public class DataSummaryComponent extends BaseBean {

	private static final long serialVersionUID = -3598636128023063275L;
	
	public static final String EXECUTE_SUMMARY_TIME = " 23:59:50";	//每天数据汇总任务的执行时间

	private DataSummaryService dataSummaryService;
	private PreSellSummaryService preSellSummaryService;

	public DataSummaryService getDataSummaryService() {
		return dataSummaryService;
	}

	@Resource(name = "dataSummaryService")
	public void setDataSummaryService(DataSummaryService dataSummaryService) {
		this.dataSummaryService = dataSummaryService;
	}

	public PreSellSummaryService getPreSellSummaryService() {
		return preSellSummaryService;
	}

	@Resource(name = "preSellSummaryService")
	public void setPreSellSummaryService(
			PreSellSummaryService preSellSummaryService) {
		this.preSellSummaryService = preSellSummaryService;
	}

	@PostConstruct
	public void initComponent() {
		/*new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("正在汇总数据...");
				try {
					dataSummaryService.addSummaryOnBefore();
					preSellSummaryService.initSumOfBefore();
					System.out.println("数据汇总完成...");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();*/
		try {
			System.out.println("正在汇总数据...");
			dataSummaryService.addSummaryOnBefore();
			preSellSummaryService.initSumOfBefore();
			System.out.println("数据汇总完成...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date summaryTaskDateTime = DateUtil.parseDateTime(DateUtil.getCurrentDate() + EXECUTE_SUMMARY_TIME);
		executeTimerSummaryTask(summaryTaskDateTime);
	}

	/**
	 * 定时任务
	 */
	@Deprecated
	private void startSummaryTask() {
		Date start = DateUtil.parseDateTime(DateUtil.getCurrentDate() + EXECUTE_SUMMARY_TIME);
		final Date taskDate = DateUtils.addDays(start, 1); // 以后每天同一时间执行
		long period = taskDate.getTime() - start.getTime();
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("定时任务开始...：" + DateUtil.getCurrentDateTime());
				Date now = new Date();
				try {
					dataSummaryService.addSumOfDay(now, true);
					preSellSummaryService.addSummaryOfDay(now, true);
				} catch (Exception e) {
					System.out.println("定时汇总任务出现异常..." + DateUtil.getCurrentDateTime());
					e.printStackTrace();
				}
				System.out.println("定时任务结束：" + DateUtil.getCurrentDateTime());
			}
		}, start, period);
	}
	
	/**
	 * 定时统计任务
	 */
	private void executeTimerSummaryTask(final Date taskDateTime){
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("定时任务开始...：" + DateUtil.getCurrentDateTime());
				Date now = new Date();
				try {
					dataSummaryService.addSumOfDay(now, true);
					preSellSummaryService.addSummaryOfDay(now, true);
				} catch (Exception e) {
					System.out.println("定时汇总任务出现异常:" + e.getMessage());
					e.printStackTrace();
					
				}
				System.out.println("定时任务结束：" + DateUtil.getCurrentDateTime());
				executeTimerSummaryTask(getNextTaskDateTime());
			}
		}, taskDateTime);
	}
	
	/**
	 * 获取下次汇总任务的执行时间
	 * @return
	 */
	private Date getNextTaskDateTime(){
		Date nextTaskDateTime = DateUtil.parseDateTime(DateUtil.getCurrentDate() + EXECUTE_SUMMARY_TIME);
		nextTaskDateTime = DateUtils.addDays(nextTaskDateTime, 1);
		return nextTaskDateTime;
	}
}

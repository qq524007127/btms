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
		new Thread(new Runnable() {
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
		}).start();

		startSummaryTask();
	}

	/**
	 * 定时任务，每天23:59:30执行统计任务
	 */
	private void startSummaryTask() {
		Date start = DateUtil.parseDateTime(DateUtil.getCurrentDate() + " 23:59:30"); // 当天23:59:00执行
		final Date taskDate = DateUtils.addDays(start, 1); // 以后每天同一时间执行
		long period = taskDate.getTime() - start.getTime();
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("定时任务：" + DateUtil.getCurrentDateTime());
				Date now = new Date();
				try {
					dataSummaryService.addSumOfDay(now, true);
					preSellSummaryService.addSummaryOfDay(new Date(), true);
				} catch (Exception e) {
				}
			}
		}, start, period);
	}
}

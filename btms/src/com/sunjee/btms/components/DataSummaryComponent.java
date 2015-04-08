package com.sunjee.btms.components;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sunjee.btms.service.DataSummaryService;
import com.sunjee.component.bean.BaseBean;
import com.sunjee.util.DateUtil;

@Component("dataSummaryComponent")
public class DataSummaryComponent extends BaseBean {

	private static final long serialVersionUID = -3598636128023063275L;

	private DataSummaryService dataSummaryService;
	private Timer sumaryTask;

	public DataSummaryService getDataSummaryService() {
		return dataSummaryService;
	}

	@Resource(name="dataSummaryService")
	public void setDataSummaryService(DataSummaryService dataSummaryService) {
		this.dataSummaryService = dataSummaryService;
	}

	@PostConstruct
	public void initComponent() {
		this.sumaryTask = new Timer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("正在汇总数据...");
				try {
					dataSummaryService.addSummaryOnBefore();
					System.out.println("数据汇总完成...");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		startSummaryTask();
	}

	private void startSummaryTask() {
		Date now = new Date();
		Date taskTime = DateUtil.getEndOfDay(new Date());
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("定时任务：" + new Date());
			}
		}, new Date(), 1000 * 30);
	}
}

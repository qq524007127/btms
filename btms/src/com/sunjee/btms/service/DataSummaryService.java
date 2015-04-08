package com.sunjee.btms.service;

import java.util.Date;

import com.sunjee.btms.bean.DataSummary;

public interface DataSummaryService extends SupportService<DataSummary> {
	
	/**
	 * 汇总之前没有汇总的数据（一般只在启动系统时调用）
	 */
	void addSummaryOnBefore();
	
	/**
	 * 汇总某天的数据
	 * @param date
	 * @param cover	如果已经有统计记录是否覆盖
	 */
	void addSummaryByDate(Date date, boolean cover);
	
}

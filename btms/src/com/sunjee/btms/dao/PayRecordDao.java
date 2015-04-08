package com.sunjee.btms.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sunjee.btms.bean.PayRecord;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;

public interface PayRecordDao extends SupportDao<PayRecord> {

	void saveOrUpdate(PayRecord payRecord);
	/**
	 * 获取收费时间最早的时间
	 * @return
	 */
	Date getMinDate();
	/**
	 * 获取在开始与结束时间内的缴费记录
	 * @param pager
	 * @param start
	 * @param end
	 * @param sorts
	 * @return
	 */
	List<PayRecord> getAllByDate(Pager pager, Date start, Date end,
			Map<String, SortType> sorts);

}

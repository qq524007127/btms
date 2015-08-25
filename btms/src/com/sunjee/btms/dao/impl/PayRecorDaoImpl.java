package com.sunjee.btms.dao.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sunjee.btms.bean.PayRecord;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.PayRecordDao;

@Repository("payRecordDao")
public class PayRecorDaoImpl extends SupportDaoImpl<PayRecord> implements
		PayRecordDao {

	private static final long serialVersionUID = -7802060362212508447L;

	@Override
	public void saveOrUpdate(PayRecord payRecord) {
		getSession().saveOrUpdate(payRecord);
	}

	@Override
	public Date getMinDate() {
		String hql = "Select min(payDate) from PayRecord";
		Object result = createQuery(null, hql, null).uniqueResult();
		if(result == null){
			return null;
		}
		return (Date) result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PayRecord> getAllByDate(Pager pager, Date start, Date end,
			Map<String, SortType> sorts) {
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("from ").append(getTableName()).append(" where 1=1");
		if(start != null){
			param.put("start", start);
			hql.append(" and payDate >= :start");
		}
		if(end != null){
			param.put("end", end);
			hql.append(" and payDate <= :end");
		}
		hql.append(" ").append(createSortHql(sorts));
		return createQuery(pager, hql.toString(), param).list();
	}

}

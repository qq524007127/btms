package com.sunjee.btms.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.DonationType;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.BlessSeatDao;

@Repository("blessSeatDao")
public class BlessSeatDaoImpl extends SupportDaoImpl<BlessSeat> implements
		BlessSeatDao {

	private static final long serialVersionUID = 1211403946136687061L;

	@SuppressWarnings("unchecked")
	@Override
	public DataGrid<BlessSeat> getEnableDataGrid(Pager pager,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		DataGrid<BlessSeat> dg = new DataGrid<>();
		StringBuffer whereValue = new StringBuffer("");
		if(whereParams.containsKey("withOutIds") && whereParams.get("withOutIds") != null){
			whereValue.append("(");
			for(String bsId : (String[]) whereParams.get("withOutIds")){
				whereValue.append("'" + bsId +"',");
			}
			whereValue = new StringBuffer("bs.bsId not in " + whereValue.substring(0, whereValue.length()-1) + ") and ");
		}
		if(whereParams.containsKey("searchKey") && whereParams.get("searchKey") != null){
			
			whereValue.append("bs.bsCode like '%").append(whereParams.get("searchKey")).append("%' and ");
		}
		
		StringBuffer hql = new StringBuffer("from BlessSeat bs where ");
		hql.append(whereValue).append("bs.bsId not in (select distinct bsr.blessSeat.bsId from BSRecord bsr where permit = false and donatType = ");
		hql.append(":buy").append(") and bs.bsId not in (select distinct bsr.blessSeat.bsId from BSRecord bsr where donatOverdue > ");
		hql.append(":currentDate").append(" and ").append("donatType = ").append(":lease)"); 
		hql.append(" and bs.lev is not null");
		System.out.println(hql);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("buy", DonationType.buy);
		params.put("lease", DonationType.lease);
		params.put("currentDate", new Date());
		
		dg.setTotal(getRecordTotal(hql.toString(), params));

		hql.append(" ").append(createSortHql(sortParams));
		dg.setRows(createQuery(pager, hql.toString(), params).list());
		return dg;
	}

}

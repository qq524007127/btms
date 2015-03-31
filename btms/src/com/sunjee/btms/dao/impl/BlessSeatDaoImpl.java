package com.sunjee.btms.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.bean.Enterprise;
import com.sunjee.btms.bean.Member;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.DonationType;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.BlessSeatDao;
import com.sunjee.util.DateUtil;

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
		if(whereParams.containsKey("withoutIds") && whereParams.get("withoutIds") != null){
			whereValue.append("(");
			for(String bsId : (String[]) whereParams.get("withoutIds")){
				whereValue.append("'" + bsId +"',");
			}
			whereValue = new StringBuffer("bs.bsId not in " + whereValue.substring(0, whereValue.length()-1) + ") and ");
		}
		if(whereParams.containsKey("searchKey") && whereParams.get("searchKey") != null){
			
			whereValue.append("bs.bsCode like '%").append(whereParams.get("searchKey")).append("%' and ");
		}
		
		StringBuffer hql = new StringBuffer("from BlessSeat bs where ");
		hql.append(whereValue).append("bs.bsId not in (select distinct bsr.blessSeat.bsId from BSRecord bsr where permit = true and donatType = ");
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

	@SuppressWarnings("unchecked")
	@Override
	public DataGrid<BlessSeat> getSaledGrid(Member member, Pager pager,
			String searchKey, Map<String, SortType> sortParams) {
		StringBuffer hql = new StringBuffer("from BSRecord bsr join bsr.mem m join bsr.blessSeat bs where m.memberId = :memberId");
		hql.append(" and ((bsr.donatType = :buy and bsr.permit = true) or (bsr.donatType = :lease and bsr.donatOverdue > :currentDate))");
		hql.append(" and bs.bsCode like :search");
		DataGrid<BlessSeat> dg = new DataGrid<>();
		Map<String, Object> param = new HashMap<>();
		param.put("memberId", member.getMemberId());
		param.put("buy",DonationType.buy);
		param.put("lease",DonationType.lease);
		param.put("currentDate",new Date());
		if(StringUtils.isEmpty(searchKey)){
			searchKey = "";
		}
		param.put("search","%"+searchKey+"%");
		Query query = createQuery(null, "select count(bs) " + hql.toString(), param);
		dg.setTotal(Float.valueOf((query.uniqueResult().toString())));
		hql.append(" ").append(createSortHql(sortParams));
		query = createQuery(pager, "select distinct bs " + hql.toString(), param);
		dg.setRows(query.list());
		return dg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DataGrid<BlessSeat> getSaledGrid(Enterprise enterprise, Pager pager,
			String searchKey, Map<String, SortType> sortParams) {
		StringBuffer hql = new StringBuffer("from BSRecord bsr join bsr.enterprise e join bsr.blessSeat bs where e.enterId = :enterId");
		hql.append(" and ((bsr.donatType = :buy and bsr.permit = true) or (bsr.donatType = :lease and bsr.donatOverdue > :currentDate))");
		hql.append(" and bs.bsCode like :search");
		DataGrid<BlessSeat> dg = new DataGrid<>();
		Map<String, Object> param = new HashMap<>();
		param.put("enterId", enterprise.getEnterId());
		param.put("buy",DonationType.buy);
		param.put("lease",DonationType.lease);
		param.put("currentDate",new Date());
		if(StringUtils.isEmpty(searchKey)){
			searchKey = "";
		}
		param.put("search","%"+searchKey+"%");
		Query query = createQuery(null, "select count(bs) " + hql.toString(), param);
		dg.setTotal(Float.valueOf((query.uniqueResult().toString())));
		hql.append(" ").append(createSortHql(sortParams));
		query = createQuery(pager, "select distinct bs " + hql.toString(), param);
		dg.setRows(query.list());
		return dg;
	}

}

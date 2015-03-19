package com.sunjee.btms.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sunjee.btms.bean.Shelf;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.ShelfDao;

@Repository("shelfDao")
public class ShelfDaoImpl extends SupportDaoImpl<Shelf> implements ShelfDao {

	private static final long serialVersionUID = -2474570399674141680L;

	@Override
	public DataGrid<Shelf> getShelfGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		DataGrid<Shelf> dg = new DataGrid<>();
		String hql = "from Shelf where permit = true";
		hql += " " + createWhereHql(whereParams,false);
		dg.setTotal(getRecordTotal(hql,whereParams));
		hql += " " + createSortHql(sortParams);
		System.out.println(hql);
		dg.setRows(getEntitysByHql(page, hql, whereParams));
		return dg;
	}

}

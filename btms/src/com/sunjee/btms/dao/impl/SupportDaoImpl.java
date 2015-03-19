package com.sunjee.btms.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.SupportDao;
import com.sunjee.component.bean.BaseBean;
import com.sunjee.util.GenericTypeUtil;

public class SupportDaoImpl<T extends BaseBean> implements SupportDao<T>{

	private static final long serialVersionUID = -1856809819767706244L;

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	/**
	 * 获取满足查询条件的数据总条数
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public float getRecordTotal(String hql, Map<String, Object> params) {
		Query query = getSession().createQuery("select count(*) " + hql);
		initQueryParams(query, params);
		return Float.valueOf(query.uniqueResult().toString());
	}
	
	/**
	 * 查询满足条件的数据总条数
	 * @param whereParams
	 * @return
	 */
	public float getRecordTotal(Map<String,Object> whereParams){
		StringBuffer hql = new StringBuffer("select count(*) ").append(createQueryHql(whereParams));
		Query query = createQuery(null,hql.toString(), whereParams);
		return Float.valueOf(query.uniqueResult().toString());
	}


	@SuppressWarnings("unchecked")
	@Override
	public DataGird<T> getDataGrid(Pager page,Map<String,Object> whereParams,Map<String, SortType> sortParams) {
		DataGird<T> dg = new DataGird<>();
		
		dg.setTotal(getRecordTotal(whereParams));

		String hql = createQueryHql(whereParams, sortParams);
		Query query = createQuery(page,hql, null);
		dg.setRows(query.list());
		return dg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DataGird<T> getDataGridByHql(Pager page, String hql, Map<String, Object> whereParams) {
		DataGird<T> dg = new DataGird<>();
		dg.setTotal(getRecordTotal(hql,whereParams));
		
		Query query = createQuery(page, hql, whereParams);
		dg.setRows(query.list());
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getEntitys(Pager page,Map<String, Object> whereParams,Map<String,SortType> sortParams) {
		return createQuery(page,whereParams,sortParams).list();
	}
	
	/**
	 * 组装hql语句
	 * @param whereParams	{"id":"1001","name":"testName"}
	 * @return	from Entiry where 1=1 and id=:id and name=:name
	 */
	public String createQueryHql(Map<String, Object> whereParams){
		return createQueryHql(whereParams,null);
	}
	
	/**
	 * 组装hql语句
	 * @param whereParams	{"id":"1001","name":"testName"}
	 * @param sortParams	排序的字段（{"id":"asc","name":"desc"}）
	 * @return	from Entiry where 1=1 and id=:id and name=:name order by id asc,name desc
	 */
	public String createQueryHql(Map<String, Object> whereParams,Map<String, SortType> sortParams) {
		StringBuffer hql = new StringBuffer("from ");
		hql.append(getTableName());
		hql.append(" where 1=1");
		if (whereParams != null && whereParams.size() > 0) {
			for (String key : whereParams.keySet()) {
				if(StringUtils.isEmpty(key)){
					continue;
				}
				if(whereParams.get(key) == null){
					hql.append(" and " + key.trim() + " is null");
				}
				else{
					hql.append(" and " + key.trim() + "=:" + key.trim());
				}
			}
		}
		
		if (sortParams != null && sortParams.size() > 0) {
			hql.append(" order by ");
			for (String key : sortParams.keySet()) {
				if(StringUtils.isEmpty(key)){
					continue;
				}
				SortType sortType = sortParams.get(key);
				if(sortType == null){
					sortType = SortType.asc;
				}
				hql.append(key.trim()).append(" ").append(sortType).append(",");
			}
		}
		if(hql.toString().endsWith(",")){
			return hql.subSequence(0, hql.length()-1).toString();
		}
		System.out.println(hql);
		return hql.toString();
	}
	
	/**
	 * 创建一个查询对象
	 * @param hql
	 * @param whereParams
	 * @return
	 */
	public Query createQuery(Pager page,Map<String, Object> whereParams,Map<String,SortType> sortParams) {
		String hql = createQueryHql(whereParams,sortParams);
		return createQuery(page,hql,whereParams);
	}
	
	/**
	 * 创建一个查询对象
	 * @param hql
	 * @param params
	 * @return
	 */
	public Query createQuery(Pager page,String hql, Map<String, Object> whereParams) {
		Query query = getSession().createQuery(hql);
		initQueryParams(query, whereParams);
		if(page != null){
			query.setFirstResult(page.getFirstIndex());
			query.setMaxResults(page.getRows());
		}
		return query;
	}
	
	/**
	 * 初始化查询参数
	 * 
	 * @param query
	 * @param whereParams
	 */
	public void initQueryParams(Query query, Map<String, Object> whereParams) {
		if (whereParams == null)
			return;
		for (String key : whereParams.keySet()) {
			if(StringUtils.isEmpty(key)){
				continue;
			}
			if(whereParams.get(key) == null){
				continue;
			}
			query.setParameter(key, whereParams.get(key));
		}
	}
	
	
	@Override
	public final String getTableName() {
		return GenericTypeUtil.getGenerParamType(this.getClass()).getSimpleName();
	}

	@Override
	public int executeUpate(Map<String, Object> valueParams,
			Map<String, Object> whereParams) {
		return 0;
	}

	@Override
	public int executeUpate(String hql, Map<String, Object> whereParams) {
		return createQuery(null,hql, whereParams).executeUpdate();
	}

	@Override
	public void updateEntiry(T t) {
		getSession().update(t);
	}

	@Override
	public void saveEntity(T t) {
		getSession().save(t);
	}

	@Override
	public List<T> getEntitys(Pager page, String hql,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		
		return null;
	}
	
	/**
	 * 根据所传参数自动拼接where子句，当isWhere为false时，返回：”and xxx = :xxx“,为true时返回：”where xxx = :xxx“
	 * @param curHql
	 * @param isWhere是否生成where关键字
	 * @return
	 */
	public String createWhereHql(Map<String, Object> whereParams,boolean isWhere){
		StringBuffer hql = null;
		if(isWhere){
			hql = new StringBuffer("where 1=1 ");
		}
		
		else{
			hql = new StringBuffer("");
		}
		
		if (whereParams != null && whereParams.size() > 0) {
			for (String key : whereParams.keySet()) {
				if(StringUtils.isEmpty(key) || whereParams.get(key) == null){
					continue;
				}
				hql.append(" and " + key.trim() + "=:" + key.trim());
			}
		}
		return hql.toString();
	}
	
	/**
	 * 根据所传参数自动拼接order by子句，返回格式为：”order by xxx asc,xx desc“
	 * @param sortParams
	 * @return
	 */
	public String createSortHql(Map<String, SortType> sortParams){
		StringBuffer hql = new StringBuffer("");
		if (sortParams != null && sortParams.size() > 0) {
			hql.append("order by ");
			for (String key : sortParams.keySet()) {
				if(StringUtils.isEmpty(key)){
					continue;
				}
				SortType sortType = sortParams.get(key);
				if(sortType == null){
					sortType = SortType.asc;
				}
				hql.append(key.trim()).append(" ").append(sortType).append(",");
			}
		}
		if(hql.toString().trim().length() > 0 && hql.toString().endsWith(",")){
			return hql.subSequence(0, hql.length()-1).toString();
		}
		return hql.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getEntitysByHql(Pager page, String hql,
			Map<String, Object> whereParams) {
		return createQuery(page,hql,whereParams).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getEntityById(Serializable id) {
		return (T) getSession().get(GenericTypeUtil.getGenerParamType(this.getClass()), id);
	}
}

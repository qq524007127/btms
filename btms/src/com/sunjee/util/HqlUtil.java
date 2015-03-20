package com.sunjee.util;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.sunjee.btms.common.SortType;

public class HqlUtil implements Serializable {

	private static final long serialVersionUID = -6137926381134303863L;
	
	/**
	 * 初始化查询参数
	 * 
	 * @param query
	 * @param whereParams
	 */
	public static void initQueryParams(Query query, Map<String, Object> whereParams) {
		if (whereParams == null || whereParams.size() < 1)
			return;
		for (String key : whereParams.keySet()) {
			if(StringUtils.isEmpty(key)){
				continue;
			}
			if(whereParams.get(key) == null){
				continue;
			}
			if(whereParams.get(key) instanceof HqlNullType){
				continue;
			}
			if(whereParams.get(key) instanceof HqlLikeType){
				HqlLikeType like = (HqlLikeType) whereParams.get(key);
				query.setParameter(key, like.getValue());
				continue;
			}
			query.setParameter(key, whereParams.get(key));
		}
	}
	
	/**
	 * 根据所传参数自动拼接where子句，当isWhere为false时，返回：”and xxx = :xxx“,为true时返回：”where xxx = :xxx“
	 * @param curHql
	 * @param isWhere是否生成where关键字
	 * @return
	 */
	public static String createWhereHql(Map<String, Object> whereParams,boolean isWhere){
		StringBuffer hql = null;
		if(isWhere){
			hql = new StringBuffer("where 1=1 ");
		}
		
		else{
			hql = new StringBuffer("");
		}
		
		if (whereParams != null && whereParams.size() > 0) {
			for (String key : whereParams.keySet()) {
				if(StringUtils.isEmpty(key) || whereParams.get(key) == null ||  StringUtils.isEmpty(whereParams.get(key).toString())){
					continue;
				}
				if(whereParams.get(key) instanceof HqlNullType){
					HqlNullType param = (HqlNullType) whereParams.get(key);
					if(param.equals(HqlNullType.isNull)){
						hql.append(" and ").append(key.trim()).append(" is null");
					}
					else if(param.equals(HqlNullType.isNotNull)){
						hql.append(" and ").append(key.trim()).append(" is not null");
					}
				}
				else if(whereParams.get(key) instanceof HqlLikeType){
					HqlLikeType param = (HqlLikeType) whereParams.get(key);
					
					if(param.equals(LikeType.leftLike)){
						hql.append(" and ").append(key.trim()).append(" like '%:").append(key.trim()).append("'");
					}
					else if(param.equals(LikeType.rightLike)){
						hql.append(" and ").append(key.trim()).append(" like ':").append(key.trim()).append("%'");
					}
					else if(param.equals(LikeType.allLike)){
						hql.append(" and ").append(key.trim()).append(" like '%:").append(key.trim()).append("%'");
					}
					else if(param.equals(LikeType.noneLike)){
						hql.append(" and ").append(key.trim()).append(" like ':").append(key.trim()).append("'");
					}
				}
				else{
					hql.append(" and " + key.trim() + "=:" + key.trim());
				}
			}
		}
		return hql.toString();
	}
	
	/**
	 * 根据所传参数自动拼接order by子句，返回格式为：”order by xxx asc,xx desc“
	 * @param sortParams
	 * @return
	 */
	public static String createSortHql(Map<String, SortType> sortParams){
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
}

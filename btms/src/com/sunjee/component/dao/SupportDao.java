package com.sunjee.component.dao;

import java.util.List;
import java.util.Map;

public interface SupportDao<T> extends java.io.Serializable{
	String getTableName();
	/**
	 * 查询所有实体
	 * @return
	 */
	List<T> getAllEntity();
	/**
	 * 查询所有符合条件的实体
	 * @param params	查询条件
	 * @return
	 */
	List<T> getEntiresByParams(Map<String, Object> params);
}

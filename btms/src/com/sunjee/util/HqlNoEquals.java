package com.sunjee.util;

import java.io.Serializable;

/**
 * Hql语句不等于
 * 
 * @author ShenYunjie
 * 
 */
public class HqlNoEquals implements Serializable {

	private static final long serialVersionUID = 5644908871443972516L;

	private Object value;

	public HqlNoEquals(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}
}

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

	public final static int NO_EQ = 0;	//不等于 !=
	public final static int MORE = 1;	//大于 >
	public final static int LESS = 2;	//小于 <
	public final static int MORE_EQ = 3;	//大于登陆  >=
	public final static int LESS_EQ = 4;	//大于等于 <=
	
	
	private Object value;
	private int expression;	//表达式

	/**
	 * 默认表示不等于返回  ' != '
	 * @param value
	 */
	public HqlNoEquals(Object value) {
		this.value = value;
		this.expression = NO_EQ;
	}
	
	/**
	 * 
	 * @param value
	 * @param expression 0:' != '; 
	 * 	1:' > ';
	 * 	2:' < ';
	 * 	3:' >= ';
	 * 	4' <= '
	 */
	public HqlNoEquals(Object value,int expression) {
		this.value = value;
		this.expression = expression;
	}

	public Object getValue() {
		return value;
	}
	
	public String getSymbol(){
		String str = " != ";
		switch (expression) {
		case MORE:
			str = " > ";
			break;
		case LESS:
			str = " < ";
			break;
		case MORE_EQ:
			str = " >= ";
			break;
		case LESS_EQ:
			str = " <= ";
			break;

		default:
			break;
		}
		return str;
	}
}

package com.sunjee.btms.common;

import com.sunjee.component.bean.BaseBean;

public class Constant extends BaseBean {
	
	private static final long serialVersionUID = -8038749523743108851L;
	
	/**
	 * 用户初始密码
	 */
	public final static String INIT_PASSWORD = "123456";
	
	public final static int COST_GROUP = 0;
	public final static int COMMON_COST_TYPE = 0;	//普通收费项目
	public final static int MEMBER_COST_TYPE = 2;	//会员费
	public final static int MANAGE_COST_TYPE = 2;	//福位管理费类型
}

package com.sunjee.btms.common;

import com.sunjee.component.bean.BaseBean;

public class Constant extends BaseBean {
	
	private static final long serialVersionUID = -8038749523743108851L;
	
	public final static String DEFUALT_DATE_FORMAT = "yyyy-MM-dd";	//默认日期格式
	public final static String DEFUALT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";	//默认日期时间格式
	public final static int DEFUALT_DOWNLOAD_BUFFER_SIZE = 1024*5;	//下载默认缓存大小5K
	public final static String EXCEL_SUFFIX = ".xls";
	
	/**
	 * 用户初始密码
	 */
	public final static String INIT_PASSWORD = "123456";
	
	/** 收费类型相关 **/
	
	public final static int COST_GROUP = 0;
	/**
	 * 普通收费项目
	 */
	public final static int COMMON_COST_TYPE = 0;	//普通收费项目
	/**
	 * 会员费
	 */
	public final static int MEMBER_COST_TYPE = 1;	//会员费
	/**
	 * 福位管理费类型
	 */
	public final static int MANAGE_COST_TYPE = 2;	//
	/**
	 * 福位租赁费
	 */
	public final static int BS_LEASE_COST_TYPE = 3;	//
	
	/**End**/
	
	
	/** 系统资源文件相关 **/
	/**
	 * 资源文件根路径
	 */
	public final static String RESOURCE_PATH = "/resource/";	
	/**
	 * 临时文件夹路径
	 */
	public final static String TEMP_PATH = RESOURCE_PATH + "temp/";
	/**
	 * 资源文件根路径
	 */
	public final static String TEMPLATE_PATH = RESOURCE_PATH + "template/";	//
	/**
	 * 数据汇总表模板路径
	 */
	public final static String SUMMARY_TEMPLATE_NAME = TEMPLATE_PATH + "summarytemplate.xls";	//
	
	/**End**/

}

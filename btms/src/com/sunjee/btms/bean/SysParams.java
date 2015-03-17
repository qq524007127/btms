package com.sunjee.btms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 系统参数对应的实体类
 * 
 * @author ShenYunjie
 * 
 */
@Entity
@Table(name = "t_sys_params")
public class SysParams extends BaseBean {

	private static final long serialVersionUID = 7130000762886620376L;

	private String paramId;
	private String paramName;
	private String paramKey; // 参数key
	private String paramValue; // 参数值
	private int paramType; // 参数对应的组
	private int paramRemrk;

	public SysParams() {
		super();
	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(length=36)
	public String getParamId() {
		return paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	@Column(nullable = false, length = 150)
	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	@Column(length = 32, nullable = false, unique = true)
	public String getParamKey() {
		return paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	@Column(length = 200, nullable = false)
	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	@Column(nullable = false)
	public int getParamType() {
		return paramType;
	}

	public void setParamType(int paramType) {
		this.paramType = paramType;
	}

	@Column(length = 200)
	public int getParamRemrk() {
		return paramRemrk;
	}

	public void setParamRemrk(int paramRemrk) {
		this.paramRemrk = paramRemrk;
	}

}

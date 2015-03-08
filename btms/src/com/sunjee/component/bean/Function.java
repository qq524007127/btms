package com.sunjee.component.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 功能（权限）类，每个模块对应多个工功能（如：增、删、改、查等）
 * 
 * @author ShenYunjie
 * 
 */
@Entity
@Table(name = "t_function")
public class Function extends BaseBean {

	private static final long serialVersionUID = -6803702694950888509L;

	private String funId;
	private String funName;
	private String callback; // 功能对应调用的方法
	private boolean permit = true; // 是否启用
	private String icon; // 对应图标
	private Module module; // 对应的模块
	private String remark; // 对应描述

	public Function() {
		super();
	}

	public Function(String funName, String callback) {
		super();
		this.funName = funName;
		this.callback = callback;
	}

	@Id
	@Column(name = "fun_id", length = 32)
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	public String getFunId() {
		return funId;
	}

	public void setFunId(String funId) {
		this.funId = funId;
	}

	@Column(length = 50, nullable = false)
	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	@Column(length = 50, nullable = false)
	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public boolean isPermit() {
		return permit;
	}

	public void setPermit(boolean permit) {
		this.permit = permit;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="module_id")
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@Column(length = 100)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

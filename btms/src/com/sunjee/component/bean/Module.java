package com.sunjee.component.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_module")
public class Module extends BaseBean {

	private static final long serialVersionUID = 8203722193282827649L;

	private String moduleId;
	private String moduleName;
	private String pageUrl; // 对应的页面
	private Set<Function> funs;
	private boolean permit = true;
	private String remark; // 描述

	public Module() {
		super();
	}

	public Module(String moduleName, String pageUrl, Set<Function> funs) {
		super();
		this.moduleName = moduleName;
		this.pageUrl = pageUrl;
		this.funs = funs;
	}

	@Id
	@Column(name = "module_id", length = 32)
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	@Column(length=50,nullable=false,unique=true)
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Column(length=100,nullable=false)
	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="module_id")
	public Set<Function> getFuns() {
		return funs;
	}

	public void setFuns(Set<Function> funs) {
		this.funs = funs;
	}

	@Column(nullable=false)
	public boolean isPermit() {
		return permit;
	}

	public void setPermit(boolean permit) {
		this.permit = permit;
	}

	@Column(length=500)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

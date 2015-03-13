package com.sunjee.btms.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 企业用户实体类
 * 
 * @author ShenYunjie
 * 
 */
@Entity
@Table(name = "t_enterprise")
public class Enterprise extends BaseBean {

	private static final long serialVersionUID = 6252626944571657041L;

	private String enterId;
	private String enterName;
	private String enterAddress;
	private String busLisCode; // 营业执照代码
	private String legalPersonName; // 法定代表人姓名
	private String enterTell;
	private String spareName; // 备用联系人姓名
	private String spareTell; // 备用联系人姓名
	private Set<BlessSeat> bsSet; // 企业对应捐赠的福位
	private Set<Tablet> tabletSet; // 企业对应捐赠的牌位
	private boolean enterPermit = true; // 企业是否有效
	private String enterRemark; // 备注

	public Enterprise() {
		super();
	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(length = 32)
	public String getEnterId() {
		return enterId;
	}

	public void setEnterId(String enterId) {
		this.enterId = enterId;
	}

	@Column(length = 50, nullable = false)
	public String getEnterName() {
		return enterName;
	}

	public void setEnterName(String enterName) {
		this.enterName = enterName;
	}

	@Column(length = 150)
	public String getEnterAddress() {
		return enterAddress;
	}

	public void setEnterAddress(String enterAddress) {
		this.enterAddress = enterAddress;
	}

	@Column(length = 20, nullable = false)
	public String getBusLisCode() {
		return busLisCode;
	}

	public void setBusLisCode(String busLisCode) {
		this.busLisCode = busLisCode;
	}

	@Column(length = 50, nullable = false)
	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	@Column(length = 11, nullable = false)
	public String getEnterTell() {
		return enterTell;
	}

	public void setEnterTell(String enterTell) {
		this.enterTell = enterTell;
	}

	@Column(length = 50)
	public String getSpareName() {
		return spareName;
	}

	public void setSpareName(String spareName) {
		this.spareName = spareName;
	}

	@Column(length = 11)
	public String getSpareTell() {
		return spareTell;
	}

	public void setSpareTell(String spareTell) {
		this.spareTell = spareTell;
	}

	@OneToMany(mappedBy = "enterprise")
	public Set<BlessSeat> getBsSet() {
		return bsSet;
	}

	public void setBsSet(Set<BlessSeat> bsSet) {
		this.bsSet = bsSet;
	}

	@OneToMany(mappedBy = "enterprise")
	public Set<Tablet> getTabletSet() {
		return tabletSet;
	}

	public void setTabletSet(Set<Tablet> tabletSet) {
		this.tabletSet = tabletSet;
	}

	@Column(nullable = false)
	public boolean isEnterPermit() {
		return enterPermit;
	}

	public void setEnterPermit(boolean enterPermit) {
		this.enterPermit = enterPermit;
	}

	@Column(length = 200)
	public String getEnterRemark() {
		return enterRemark;
	}

	public void setEnterRemark(String enterRemark) {
		this.enterRemark = enterRemark;
	}
}

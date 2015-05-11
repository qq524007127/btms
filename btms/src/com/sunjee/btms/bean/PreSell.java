package com.sunjee.btms.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sunjee.component.bean.BaseBean;

/**
 * 福位预售
 * 
 * @author ShenYunjie
 * 
 */
@Entity
@Table(name = "t_presell")
public class PreSell extends BaseBean {

	private static final long serialVersionUID = -4047906956293077685L;

	private String psId;
	private float psPrice;
	private int psCount;
	private float totalPrice;
	private PayRecord pRecord;
	private String orderCode; // 订单号
	private boolean cash; // 是否已兑现
	private boolean permit = true;
	private String remark;

	public PreSell() {
		super();
	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(length = 36)
	public String getPsId() {
		return psId;
	}

	public void setPsId(String psId) {
		this.psId = psId;
	}

	@Column(name = "price")
	public float getPsPrice() {
		return psPrice;
	}

	public void setPsPrice(float psPrice) {
		this.psPrice = psPrice;
	}

	@Column(name = "count")
	public int getPsCount() {
		return psCount;
	}

	public void setPsCount(int psCount) {
		this.psCount = psCount;
	}

	@Column(name = "total_price")
	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "record_id", nullable = false)
	public PayRecord getpRecord() {
		return pRecord;
	}

	public void setpRecord(PayRecord pRecord) {
		this.pRecord = pRecord;
	}

	@Column(name = "order_code", length = 50, unique = true, nullable = false, updatable = false)
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Column(name = "iscash")
	public boolean isCash() {
		return cash;
	}

	public void setCash(boolean cash) {
		this.cash = cash;
	}

	@Column(name = "permit")
	public boolean isPermit() {
		return permit;
	}

	public void setPermit(boolean permit) {
		this.permit = permit;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

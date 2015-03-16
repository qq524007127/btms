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

/**
 * 缴费明细实体类
 * 
 * @author ShenYunjie
 * 
 */
@Entity
@Table(name = "t_pay_detail")
public class PayDetail extends BaseBean {

	private static final long serialVersionUID = 3599882529798523778L;

	private String detailId;
	private String detailItemName;
	private float itemPrice; // 明细单价
	private int detailLength = 1; // 缴费年限
	private float detTotalPrice; // 缴费总价
	private PayRecord payRecord; // 对应缴费记录

	public PayDetail() {
		super();
	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@GeneratedValue(generator = "uuid")
	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	@Column(nullable = false, length = 200, name = "name")
	public String getDetailItemName() {
		return detailItemName;
	}

	public void setDetailItemName(String detailItemName) {
		this.detailItemName = detailItemName;
	}

	@Column(nullable = false, name = "price")
	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Column(name = "time_length")
	public int getDetailLength() {
		return detailLength;
	}

	public void setDetailLength(int detailLength) {
		this.detailLength = detailLength;
	}

	@Column(nullable = false)
	public float getDetTotalPrice() {
		return detTotalPrice;
	}

	public void setDetTotalPrice(float detTotalPrice) {
		this.detTotalPrice = detTotalPrice;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "record_id", nullable = false)
	public PayRecord getPayRecord() {
		return payRecord;
	}

	public void setPayRecord(PayRecord payRecord) {
		this.payRecord = payRecord;
	}

}

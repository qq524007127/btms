package com.sunjee.btms.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.GenericGenerator;

import com.sunjee.btms.common.DonationType;
import com.sunjee.component.bean.User;

/**
 * 福位捐赠记录表
 * 
 * @author ShenYunjie
 * 
 */
@Entity
@Table(name = "t_bs_record")
public class BSRecord extends BaseBean {

	private static final long serialVersionUID = 4305123593283110547L;

	private String bsRecId;
	private Date bsRecCreateDate; // 捐赠日期
	private Member member;
	private Enterprise enterprise; // 会员和企业只能有一个且必须有一个
	private BlessSeat blessSeat;
	private float bsRecToltalPrice; // 捐赠金额
	private User bsRecUser; // 销售员
	private DonationType donatType; // 捐赠类型，普通捐赠或租赁
	private int donatLength; // 租赁时长
	private Date donatOverdue; // 租赁到期时间

	public BSRecord() {
		super();
	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(length = 32, name = "record_id")
	public String getBsRecId() {
		return bsRecId;
	}

	public void setBsRecId(String bsRecId) {
		this.bsRecId = bsRecId;
	}

	@JSON(format = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name = "create_date")
	public Date getBsRecCreateDate() {
		return bsRecCreateDate;
	}

	public void setBsRecCreateDate(Date bsRecCreateDate) {
		this.bsRecCreateDate = bsRecCreateDate;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "enter_id")
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bs_id", nullable = false)
	public BlessSeat getBlessSeat() {
		return blessSeat;
	}

	public void setBlessSeat(BlessSeat blessSeat) {
		this.blessSeat = blessSeat;
	}

	@Column(nullable = false, name = "total_price")
	public float getBsRecToltalPrice() {
		return bsRecToltalPrice;
	}

	public void setBsRecToltalPrice(float bsRecToltalPrice) {
		this.bsRecToltalPrice = bsRecToltalPrice;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	public User getBsRecUser() {
		return bsRecUser;
	}

	public void setBsRecUser(User bsRecUser) {
		this.bsRecUser = bsRecUser;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public DonationType getDonatType() {
		return donatType;
	}

	public void setDonatType(DonationType donatType) {
		this.donatType = donatType;
	}

	@Column(name = "length")
	public int getDonatLength() {
		return donatLength;
	}

	public void setDonatLength(int donatLength) {
		this.donatLength = donatLength;
	}

	@JSON(format = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "overdue")
	public Date getDonatOverdue() {
		return donatOverdue;
	}

	public void setDonatOverdue(Date donatOverdue) {
		this.donatOverdue = donatOverdue;
	}

}

package com.sunjee.btms.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.GenericGenerator;

import com.sunjee.component.bean.User;

/**
 * 缴费记录
 * 
 * @author ShenYunjie
 * 
 */
@Entity
@Table(name = "t_pay_record")
public class PayRecord extends BaseBean {

	private static final long serialVersionUID = -5101428351637694142L;
	private String payRecId;
	private Date payDate;
	private Member member;
	private Enterprise enterprise;
	private User payUser;
	private Set<PayDetail> payDatailSet; // 支付明细

	public PayRecord() {
		super();
	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@GeneratedValue(generator = "uuid")
	public String getPayRecId() {
		return payRecId;
	}

	public void setPayRecId(String payRecId) {
		this.payRecId = payRecId;
	}

	@JSON(format = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
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
	@JoinColumn(name = "user_id")
	public User getPayUser() {
		return payUser;
	}

	public void setPayUser(User payUser) {
		this.payUser = payUser;
	}

	@OneToMany(mappedBy = "payRecord")
	public Set<PayDetail> getPayDatailSet() {
		return payDatailSet;
	}

	public void setPayDatailSet(Set<PayDetail> payDatailSet) {
		this.payDatailSet = payDatailSet;
	}

}

package com.sunjee.btms.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.GenericGenerator;

import com.sunjee.component.bean.User;

/**
 * 牌位捐赠记录表
 * 
 * @author ShenYunjie
 * 
 */
@Entity
@Table(name = "t_tablet_record")
public class TabletRecord extends BaseBean {

	private static final long serialVersionUID = 3814005178353532669L;
	private String tlRecId;
	private Date tlRecCreateDate;
	private Member member;
	private Enterprise enterprise;
	private Tablet tablet; // 对应的牌位
	private int tlRecLength;
	private Date tlRecOverdue;
	private float tlTotalPrice;
	private User tlRecUser; // 销售员

	public TabletRecord() {
		super();
	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(length=36)
	public String getTlRecId() {
		return tlRecId;
	}

	public void setTlRecId(String tlRecId) {
		this.tlRecId = tlRecId;
	}

	@Temporal(TemporalType.DATE)
	@JSON(format = "yyyy-MM-dd")
	@Column(nullable = false, name = "create_date")
	public Date getTlRecCreateDate() {
		return tlRecCreateDate;
	}

	public void setTlRecCreateDate(Date tlRecCreateDate) {
		this.tlRecCreateDate = tlRecCreateDate;
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
	@JoinColumn(name = "tablet_id", nullable = false)
	public Tablet getTablet() {
		return tablet;
	}

	public void setTablet(Tablet tablet) {
		this.tablet = tablet;
	}

	@Column(nullable = false, name = "length")
	public int getTlRecLength() {
		return tlRecLength;
	}

	public void setTlRecLength(int tlRecLength) {
		this.tlRecLength = tlRecLength;
	}

	@Temporal(TemporalType.DATE)
	@JSON(format = "yyyy-MM-dd")
	@Column(nullable = false, name = "overdue")
	public Date getTlRecOverdue() {
		return tlRecOverdue;
	}

	public void setTlRecOverdue(Date tlRecOverdue) {
		this.tlRecOverdue = tlRecOverdue;
	}

	@Column(nullable = false, name = "total_price")
	public float getTlTotalPrice() {
		return tlTotalPrice;
	}

	public void setTlTotalPrice(float tlTotalPrice) {
		this.tlTotalPrice = tlTotalPrice;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getTlRecUser() {
		return tlRecUser;
	}

	public void setTlRecUser(User tlRecUser) {
		this.tlRecUser = tlRecUser;
	}

}

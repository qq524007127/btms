package com.sunjee.btms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 福位实体类
 * 
 * @author ShenYunjie
 * 
 */
@Entity
@Table(name = "t_bless_seat")
public class BlessSeat extends BaseBean {

	private static final long serialVersionUID = -3536124556799345305L;

	private String bsId;
	private String bsCode; // 福位编号(E01030203)
	private Shelf shelf; // 所在福位架
	private int shelfRow; // 在福位架的所属行
	private int shelfColumn; // 在福位架的所属列
	private Member member; // 捐赠此福位的会员
	private Enterprise enterprise; // 捐赠此福位的企业（一个福位同时只能被一个会员或企业捐赠）
	private Level lev; // 福位级别（即：福位对应的价格）
	private Deader deader; // 福位使用者，即：死者
	private float managExpense; // 管理费
	private boolean permit = true; // 是否有效
	private String remark;

	public BlessSeat() {
		super();
	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	public String getBsId() {
		return bsId;
	}

	public void setBsId(String bsId) {
		this.bsId = bsId;
	}

	@Column(length = 9, nullable = false, unique = true)
	public String getBsCode() {
		return bsCode;
	}

	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shelf_id", nullable = false)
	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	@Column(nullable = false)
	public int getShelfRow() {
		return shelfRow;
	}

	public void setShelfRow(int shelfRow) {
		this.shelfRow = shelfRow;
	}

	@Column(nullable = false)
	public int getShelfColumn() {
		return shelfColumn;
	}

	public void setShelfColumn(int shelfColumn) {
		this.shelfColumn = shelfColumn;
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
	@JoinColumn(name = "enterprise_id")
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "level_id")
	public Level getLev() {
		return lev;
	}

	public void setLev(Level lev) {
		this.lev = lev;
	}

	@OneToOne(mappedBy = "blessSeat")
	public Deader getDeader() {
		return deader;
	}

	public void setDeader(Deader deader) {
		this.deader = deader;
	}

	@Column(nullable = false)
	public float getManagExpense() {
		return managExpense;
	}

	public void setManagExpense(float managExpense) {
		this.managExpense = managExpense;
	}

	@Column(nullable = false)
	public boolean isPermit() {
		return permit;
	}

	public void setPermit(boolean permit) {
		this.permit = permit;
	}

	@Column(length = 200)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

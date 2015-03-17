package com.sunjee.btms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 会员证对应实体类
 * 
 * @author ShenYunjie
 * 
 */
@Entity
@Table(name = "t_member_card")
public class MemberCard extends BaseBean {

	private static final long serialVersionUID = 2854417978130880183L;

	private String memCardId;
	private String memCode;
	private boolean permit = true; // 是否有效(默认有效）
	private Member member;

	public MemberCard() {
		super();
	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	@Column(length=36)
	public String getMemCardId() {
		return memCardId;
	}

	public void setMemCardId(String memCardId) {
		this.memCardId = memCardId;
	}

	@Column(length = 12, nullable = false, unique = true)
	public String getMemCode() {
		return memCode;
	}

	public void setMemCode(String memCode) {
		this.memCode = memCode;
	}

	@Column(nullable = false)
	public boolean isPermit() {
		return permit;
	}

	public void setPermit(boolean permit) {
		this.permit = permit;
	}

	@OneToOne(fetch = FetchType.EAGER)
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}

package com.sunjee.component.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_user")
public class User extends BaseBean {

	private static final long serialVersionUID = -1576404671908915966L;

	private String usreId;
	private String userCode;
	private String userName;
	private String password;
	private Set<Role> roleSet;
	private boolean permit;

	public User() {
		super();
	}

	public User(String userCode, String userName) {
		super();
		this.userCode = userCode;
		this.userName = userName;
	}

	public User(String usreId, String userCode, String userName,
			String password, boolean permit) {
		super();
		this.usreId = usreId;
		this.userCode = userCode;
		this.userName = userName;
		this.password = password;
		this.permit = permit;
	}

	@Id
	@Column(length = 32)
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@GeneratedValue(generator = "uuid")
	public String getUsreId() {
		return usreId;
	}

	public void setUsreId(String usreId) {
		this.usreId = usreId;
	}

	@Column(length = 16, nullable = false, unique = false)
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(length = 10, nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(length = 32, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	public boolean isPermit() {
		return permit;
	}

	public void setPermit(boolean permit) {
		this.permit = permit;
	}

}

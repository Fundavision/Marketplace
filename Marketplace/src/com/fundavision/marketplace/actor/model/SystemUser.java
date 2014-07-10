package com.fundavision.marketplace.actor.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

@View(name = "SimpleUser", members = "firstName; lastName")
@Entity
@Table(name = "User")
public class SystemUser {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@DefaultValueCalculator(value = EnumCalculator.class, properties = {
			@PropertyValue(name = "enumType", value = "com.fundavision.marketplace.actor.model.SystemUser$UserType"),
			@PropertyValue(name = "value", value = "GUEST") })
	private UserType userType = UserType.GUEST;

	public enum UserType {
		FRIEND, GUEST
	}

	@Column(nullable = false)
	@Required
	private String firstName;

	@Column(nullable = false)
	private String middleName;

	@Column(nullable = false)
	@Required
	private String lastName;

	@Hidden
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationDate;

	@Hidden
	@Column(columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP", updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Hidden
	@Column(columnDefinition = "TIMESTAMP default '2030-01-01 00:00:00'", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	@PrePersist
	protected void onCreate() {
		createDate = modifyDate = new Date();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, 1);
		expirationDate = calendar.getTime();
	}

	@PreUpdate
	protected void onUpdate() {
		modifyDate = new Date();
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
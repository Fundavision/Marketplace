package com.fundavision.marketplace.actor.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

@View(name = "SimpleActor", members = "user.firstName, user.lastName")
@Entity
public class Actor {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int actorID;

	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "companyID")
	@ReferenceView("SimpleCompany")
	@Required
	private Company company;

	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "userID")
	@ReferenceView("SimpleUser")
	@Required
	private SystemUser user;

	@Required
	@Enumerated(EnumType.STRING)
	@DefaultValueCalculator(value = EnumCalculator.class, properties = {
			@PropertyValue(name = "enumType", value = "com.fundavision.marketplace.actor.model.ApprovalManager$ApprovalRequestStatus"),
			@PropertyValue(name = "value", value = "UNREQUESTED") })
	private ApprovalManager.ApprovalRequestStatus status;

	@Required
	@Enumerated(EnumType.STRING)
	@DefaultValueCalculator(value = EnumCalculator.class, properties = {
			@PropertyValue(name = "enumType", value = "com.fundavision.marketplace.actor.model.Actor$PrimaryUserType"),
			@PropertyValue(name = "value", value = "DEFAULT") })
	private PrimaryUserType primaryUserType;

	public enum PrimaryUserType {
		DEFAULT, PRIMARY, NORMAL
	}

	@DefaultValueCalculator(CurrentDateCalculator.class)
	@Column(columnDefinition = "date")
	private Date expirationDate;

	public int getActorID() {
		return actorID;
	}

	public void setActorID(int actorID) {
		this.actorID = actorID;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public SystemUser getUser() {
		return user;
	}

	public void setUser(SystemUser user) {
		this.user = user;
	}

	public ApprovalManager.ApprovalRequestStatus getStatus() {
		return status;
	}

	public void setStatus(ApprovalManager.ApprovalRequestStatus status) {
		this.status = status;
	}

	public PrimaryUserType getPrimaryUserType() {
		return primaryUserType == null ? PrimaryUserType.DEFAULT
				: primaryUserType;
	}

	public void setPrimaryUserType(PrimaryUserType primaryUserType) {
		this.primaryUserType = primaryUserType;
	}

}

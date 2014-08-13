/*
 * Associates Role information with the Actor requesting it
 */
package com.fundavision.marketplace.actor.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.fundavision.marketplace.actor.model.Task.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Role {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int roleID;
	
	/**
	 * Role must be same company  as Actor.  This is probably redundant
	 */
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "companyID")
	@ReferenceView("SimpleCompany")
	private Company company;
	
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "actorID")
    @ReferenceView("SimpleActor")
	private Actor actor;
	
	@Hidden
	@Enumerated(EnumType.STRING) 
	private RoleType roleType ;
	
	public enum RoleType {OWNER,PRODUCER,SELLER,SHIPPER,WAREHOUSER,BUYER,INVESTOR,LENDER,BORROWER,SPONSOR,APPROVER}
	
	@Column(columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	@Hidden
	private Date createDate;
	
	@Hidden
	@Column(columnDefinition="TIMESTAMP default '2030-01-01 00:00:00'")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	public Role(RoleType roleType) {
		this.roleType = roleType ;
	}
	
	@PrePersist
	protected void onCreate() {
		createDate = modifyDate = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		modifyDate = new Date();
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public RoleType getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
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

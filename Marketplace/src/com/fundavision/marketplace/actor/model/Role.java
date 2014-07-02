/*
 * Associates Role information with the Actor requesting it
 */
package com.fundavision.marketplace.actor.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Role {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleID;
	
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "actorID")
	@ReferenceView("SimpleActor")
	private Actor actor;
	
	@Required
	@Enumerated(EnumType.STRING) 
	private RoleType role ;
	public enum RoleType {OWNER,PRODUCER,SELLER,SHIPPER,WAREHOUSER,BUYER,INVESTOR,LENDER,BORROWER,SPONSOR,APPROVER}
	
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
	public RoleType getRole() {
		return role;
	}
	public void setRole(RoleType role) {
		this.role = role;
	}
	
	
}

/*
 * Associates Role information with the Actor requesting it
 */
package com.fundavision.marketplace.actor.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.fundavision.marketplace.actor.model.Task.*;

@Entity
public abstract class Role {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleID;
	
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "actorID")
    //ReferenceView("SimpleActor")
	private Actor actor;
	
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "approverID")
	private Approver approver;
	
	@Required
	@Enumerated(EnumType.STRING) 
	private RoleType roleType ;
	public enum RoleType {OWNER,PRODUCER,SELLER,SHIPPER,WAREHOUSER,BUYER,INVESTOR,LENDER,BORROWER,SPONSOR,APPROVER}
	
	public Role(RoleType roleType) {
		this.roleType = roleType ;
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
	public Approver getApprover() {
		return approver;
	}
	public void setApprover(Approver approver) {
		this.approver = approver;
	}
	private RoleType getRoleType() {
		return roleType;
	}
	private void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}	
}

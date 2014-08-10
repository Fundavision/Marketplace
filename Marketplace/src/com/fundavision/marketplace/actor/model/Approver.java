package com.fundavision.marketplace.actor.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Approver extends Role {
	public Approver() {
		super(RoleType.APPROVER);
	}

}


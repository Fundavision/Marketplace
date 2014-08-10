package com.fundavision.marketplace.actor.model;

import javax.persistence.*;

import org.openxava.annotations.*;

public class Shipper extends Role {
	public Shipper() {
		super(RoleType.SHIPPER);
	}

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shipperID;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "companyID")
	private Company company;

	
}

package com.fundavision.marketplace.actor.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Producer extends Role {
	public Producer() {
		super(RoleType.PRODUCER);
	}

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "companyID")
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}

package com.fundavision.marketplace.actor.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.fundavision.marketplace.actor.model.Actor.*;

@Entity
public class Location {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int locationID; 

	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "companyID")
	@ReferenceView("SimpleCompany")
	@Required
	private Company company;
	
	@Column
	@Required
	private String name ;
	
	@Required
	@Enumerated(EnumType.STRING)
	@DefaultValueCalculator(value = EnumCalculator.class, properties = {
			@PropertyValue(name = "enumType", value = "com.fundavision.marketplace.actor.model.Location$LocationType"),
			@PropertyValue(name = "value", value = "POSTAL") })
	private LocationType locationType;
	
	public enum LocationType {
		POSTAL, COMPANY, BILLING, SEAPORT, AIRPORT, DROPSHIP, WAREHOUSE
	}
	
	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public LocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}
	
}

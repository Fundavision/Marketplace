package com.fundavision.marketplace.actor.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.fundavision.marketplace.actor.model.Role.*;

@Entity
public class Shipper extends Role {
	
	@Required
	@Enumerated(EnumType.STRING) 
	public ShipType shipType ;
	
	//-- need to put real values here
	public enum ShipType {AIR,LAND,SEA}
	
	public Shipper() {
		super(RoleType.SHIPPER);
	}

	public ShipType getShipType() {
		return shipType;
	}

	public void setShipType(ShipType shipType) {
		this.shipType = shipType;
	}
	
}

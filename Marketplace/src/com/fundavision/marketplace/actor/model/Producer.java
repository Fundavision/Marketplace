package com.fundavision.marketplace.actor.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@View (name="SimpleProducer", members="actor")
@Entity
public class Producer extends Role {
	public Producer() {
		super(RoleType.PRODUCER);
	}
}

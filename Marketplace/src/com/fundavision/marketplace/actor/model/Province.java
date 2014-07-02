package com.fundavision.marketplace.actor.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Province {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int provinceID;
}

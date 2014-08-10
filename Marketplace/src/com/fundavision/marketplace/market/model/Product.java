
package com.fundavision.marketplace.market.model;

import java.util.*;
import javax.persistence.*;
import org.openxava.annotations.*;
import com.fundavision.marketplace.actor.model.*;

@Entity
public class Product {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productID;
	
	@Column
	@Required
	private String title;
	
	@Stereotype("TEXT_AREA")
	private String shortDescription;
	
	@Stereotype("TEXT_AREA")
	private String longDescription;
	
	@ManyToOne
	@JoinColumn(name = "roleID")
	@Required
	private Producer producer;
	
	@Column(columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	@Hidden
	private Date createDate;
	
	@Hidden
	@Column(columnDefinition="TIMESTAMP default '2030-01-01 00:00:00'")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
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

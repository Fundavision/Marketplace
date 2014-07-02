package com.fundavision.marketplace.actor.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

@View (name="SimpleCompany", members="businessEntityName")
@Entity
public class Company {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int companyID;
	
	@Column(unique=true)
	@Required
	private String businessEntityName;
	
	@Stereotype("TEXT_AREA")
	private String description;
	
	@OneToMany(mappedBy="company", cascade=CascadeType.REMOVE)
	private Collection<Actor> actors;
	
	@OneToMany(mappedBy="company", cascade=CascadeType.REMOVE)
	private Collection<Account> accounts;
	
	@OneToMany(mappedBy="company", cascade=CascadeType.REMOVE)
	private Collection<Location> locations;
	
	@Required
	@Enumerated(EnumType.STRING)
	@DefaultValueCalculator(value = EnumCalculator.class, properties = {
			@PropertyValue(name = "enumType", value = "com.fundavision.marketplace.actor.model.ApprovalManager$ApprovalRequestStatus"),
			@PropertyValue(name = "value", value = "UNREQUESTED") })
	private ApprovalManager.ApprovalRequestStatus status = ApprovalManager.ApprovalRequestStatus.UNREQUESTED ;

	@Column(columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
	@Hidden
	private Date createDate;
	
	@Hidden
	@Column(columnDefinition="TIMESTAMP default '2030-01-01 00:00:00'")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
	
	@Column(columnDefinition="TIMESTAMP default '2030-01-01 00:00:00'")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationDate;

	@Column
	@Stereotype("EMAIL") @DisplaySize(40)
	private String email;
	
	@Column
	@Stereotype("TELEPHONE") @DisplaySize(40)
	private String phone1;
	
	@Column
	@Stereotype("TELEPHONE") @DisplaySize(40)
	private String phone2;
	
	@Column
	@Stereotype("TELEPHONE") @DisplaySize(40)
	private String fax;
	
	@Column(columnDefinition = "longblob")
	@Stereotype("PHOTO")
	private byte[] image;
	
	@Column
	private int roleSet;
	
	@Column
	private String imageURL;

	public int getCompanyID() {
		return companyID;
	}

	public String getBusinessEntityName() {
		return businessEntityName;
	}

	public void setBusinessEntityName(String businessEntityName) {
		this.businessEntityName = businessEntityName;
	}

	
	public Collection<Actor> getActors() {
		return actors;
	}

	public void setActors(Collection<Actor> actors) {
		this.actors = actors;
	}

	public Collection<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}

	public Collection<Location> getLocations() {
		return locations;
	}

	public void setLocations(Collection<Location> locations) {
		this.locations = locations;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ApprovalManager.ApprovalRequestStatus getStatus() {
		return status;
	}

	public void setStatus(ApprovalManager.ApprovalRequestStatus status) {
		this.status = status;
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

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(int roleSet) {
		this.roleSet = roleSet;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	
}

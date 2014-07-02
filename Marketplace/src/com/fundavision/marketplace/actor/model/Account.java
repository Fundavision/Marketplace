/*
 * Account information for each of a Company's financial accounts
 */
package com.fundavision.marketplace.actor.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.fundavision.marketplace.actor.model.Actor.*;


@Entity
public class Account {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountID;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "companyID")
	@ReferenceView("SimpleCompany")
	private Company company;
	
	@Column
	@Required
	private String name;
	
	 @Required
	 @Enumerated(EnumType.STRING)
		@DefaultValueCalculator(value = EnumCalculator.class, properties = {
				@PropertyValue(name = "enumType", value = "com.fundavision.marketplace.actor.model.Account$AccountType"),
				@PropertyValue(name = "value", value = "DEFAULT") }) 
	 private AccountType accountType; 
	 public enum AccountType { DEFAULT, CHECKING, CREDITCARD, DEBITCARD, ONLINE_PAYMENT, ONLINE_BANKING, LINE_OF_CREDIT }	
	
	@Column
	private String accountNumber;
	
	@Column
	private String routingNumber;
	
	@Column
	private String institutionName;

	@Column
	private String address1;
	
	@Column
	private String address2;
	
	@Column
	private String address3;

	@OneToOne
	@JoinColumn(name = "cityID")
	private City city;
	
	@OneToOne
	@JoinColumn(name = "provinceID")
	private Province province;
	
	@OneToOne
	@JoinColumn(name = "countryID")
	private Country country;
	
	@Column
	private String postalCode;

	@Column
	@Stereotype("WEBURL") @DisplaySize(40)
	private String institutionURL;

	@Column
	@Stereotype("WEBURL") @DisplaySize(40)
	private String accountURL;

	@Column
	@Stereotype("EMAIL") @DisplaySize(40)
	private String institutionEmail;
	
	@Column
	@Stereotype("TELEPHONE") @DisplaySize(40)
	private String institutionPhone;
	
	@Column
	private String contactName;
	
	@Column
	@Stereotype("EMAIL") @DisplaySize(40)
	private String contactEmail;
	
	@Column
	@Stereotype("TELEPHONE") @DisplaySize(40)
	private String contactPhone;

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getInstitutionURL() {
		return institutionURL;
	}

	public void setInstitutionURL(String institutionURL) {
		this.institutionURL = institutionURL;
	}

	public String getAccountURL() {
		return accountURL;
	}

	public void setAccountURL(String accountURL) {
		this.accountURL = accountURL;
	}

	public String getInstitutionEmail() {
		return institutionEmail;
	}

	public void setInstitutionEmail(String institutionEmail) {
		this.institutionEmail = institutionEmail;
	}

	public String getInstitutionPhone() {
		return institutionPhone;
	}

	public void setInstitutionPhone(String institutionPhone) {
		this.institutionPhone = institutionPhone;
	}

	
}

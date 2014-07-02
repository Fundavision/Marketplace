package com.fundavision.marketplace.actor.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@View (name="SimpleUser", members="firstName; lastName")
@Entity
@Table (name = "User")
public class SystemUser  {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;
	
	@Required
    @Enumerated(EnumType.STRING) 
	private UserType userType = UserType.GUEST ;
	public enum UserType { FRIEND, GUEST }
	
	@Column
	@Required
	private String firstName  ;
	
	@Column
	private String middleName ;
	
	@Column
	@Required
	private String lastName ;
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	
}

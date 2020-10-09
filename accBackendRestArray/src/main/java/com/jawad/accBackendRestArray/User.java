package com.jawad.accBackendRestArray;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentID;
	
	private String firstName;
	
private String lastName;
private int phoneNumber;
private String emailAddress;

@JsonIgnore
private String password;


private String birthdate;
private String gender;


public long getUserId() {
	return studentID;
}
public void setUserID(long id) {
	this.studentID = id;
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(int phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getEmailAddress() {
	return emailAddress;
}
public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getBirthdate() {
	return birthdate;
}

public void setBirthdate(String birthdate) {
	this.birthdate = birthdate;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}



public User(String firstName, String lastName, int phoneNumber, String emailAddress, String password, String birthdate, String gender) {
	
	setFirstName(firstName);
	setLastName(lastName);
	setPhoneNumber(phoneNumber);
	setEmailAddress(emailAddress);
	setPassword(password);
	setBirthdate(birthdate);
	setGender(gender);

	
}

@Override
public String toString() {
	return "User [contact_ID=" + studentID + ", contact_name=" + firstName + ", contact_lastname=" + lastName +"contact_phoneNumber=" + phoneNumber + ", contact_email=" + emailAddress + "contact_pass=" + password + "contact_birth=" + birthdate + "contact_gender=" + gender +"]";

}


}
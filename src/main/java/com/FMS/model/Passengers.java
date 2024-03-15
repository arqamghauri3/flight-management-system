package com.FMS.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "passengers")
public class Passengers {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long passengerID;
	
    @Column(name = "firstName")
	private String firstName;
    
    @Column(name = "lastName")
	private String lastName;
    
    @Column(name = "dateOfBirth")
	private LocalDate dateOfBirth;
	
    @Column(name = "contactNumber")
	private String contactNumber;

    
    
	public Passengers() {
		super();
	}

	public Passengers(String firstName, String lastName, LocalDate dateOfBirth, String contactNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.contactNumber = contactNumber;
	}

	public Long getPassengerID() {
		return passengerID;
	}

	public void setPassengerID(Long passengerID) {
		this.passengerID = passengerID;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Passengers [passengerID=" + passengerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", contactNumber=" + contactNumber + "]";
	}

    
    
}

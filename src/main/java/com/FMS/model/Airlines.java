package com.FMS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "airlines")
public class Airlines {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AirlineID;
	
    @Column(name = "AirlineName")
	private String AirlineName;
	
    @Column(name = "IaaaCode")
	private String IaaaCode;
    
    @Column(name = "CountryName")
	private String CountryName;

	public Airlines() {
		super();
	}

	public Airlines(String airlineName, String iaaaCode, String countryName) {
		super();
		AirlineName = airlineName;
		IaaaCode = iaaaCode;
		CountryName = countryName;
	}

	public Long getAirlineID() {
		return AirlineID;
	}

	public void setAirlineID(Long airlineID) {
		AirlineID = airlineID;
	}

	public String getAirlineName() {
		return AirlineName;
	}

	public void setAirlineName(String airlineName) {
		AirlineName = airlineName;
	}

	public String getIaaaCode() {
		return IaaaCode;
	}

	public void setIaaaCode(String iaaaCode) {
		IaaaCode = iaaaCode;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	@Override
	public String toString() {
		return "Airlines [AirlineID=" + AirlineID + ", AirlineName=" + AirlineName + ", IaaaCode=" + IaaaCode
				+ ", CountryName=" + CountryName + "]";
	}
    
	
	
    
    
}
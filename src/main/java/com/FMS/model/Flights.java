package com.FMS.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class Flights {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long FlightID;
	
    @Column(name = "Date")
	private LocalDate date;
    
    @Column(name = "DepartureTime")
	private String DepartureTime;
    
    @Column(name = "ArrivalTime")
	private String ArrivalTime;
    
    @Column(name = "ToCity")
	private String toCity;

    @Column(name = "FromCity")
	private String fromCity;
        
    @ManyToOne
    @JoinColumn(name = "aircraftID")
	private Aircrafts aircraft;

    @ManyToOne
    @JoinColumn(name = "AirlineID")
	private Airlines airline;

    @Column(name = "Price")
	private String price;

	public Flights() {
		super();
	}
	
	
	


	public Flights(LocalDate date, String departureTime, String arrivalTime, String toCity, String fromCity,
			Aircrafts aircraft, Airlines airline, String price) {
		super();
		this.date = date;
		DepartureTime = departureTime;
		ArrivalTime = arrivalTime;
		this.toCity = toCity;
		this.fromCity = fromCity;
		this.aircraft = aircraft;
		this.airline = airline;
		this.price = price;
	}





	public Aircrafts getAircraft() {
		return aircraft;
	}


	public void setAircraft(Aircrafts aircraft) {
		this.aircraft = aircraft;
	}



	public Airlines getAirline() {
		return airline;
	}



	public void setAirline(Airlines airline) {
		this.airline = airline;
	}



	public Long getFlightID() {
		return FlightID;
	}
	public void setFlightID(Long flightID) {
		FlightID = flightID;
	}
	public void setDate(LocalDate Date) {
		date = Date;
	}
	public LocalDate getDate() {
		return date;
	}
	public void arrivalTime(LocalDate Date) {
		date = Date;
	}
	public String getDepartureTime() {
		return DepartureTime;
	}
	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}
	public String getArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}
	public String getToCity() {
		return this.toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getFromCity() {
		return this.fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}

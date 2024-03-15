package com.FMS.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservations {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservationID;
	
    @ManyToOne
    @JoinColumn(name = "flightID")
	private Flights flight;
	
    @ManyToOne
    @JoinColumn(name = "passengerID")
	private Passengers passenger;
    
    @ManyToOne
    @JoinColumn(name = "paymentID")
	private Payments payment;

    @ManyToOne
    @JoinColumn(name = "userID")
	private Users user;

    
	public Reservations() {
		super();
	}

	

	public Reservations(Flights flight, Passengers passenger, Payments payment, Users user) {
		super();
		this.flight = flight;
		this.passenger = passenger;
		this.payment = payment;
		this.user = user;
	}



	public Long getReservationID() {
		return reservationID;
	}


	public void setReservationID(Long reservationID) {
		this.reservationID = reservationID;
	}



	public Flights getFlight() {
		return flight;
	}


	public void setFlight(Flights flight) {
		this.flight = flight;
	}


	public Passengers getPassenger() {
		return passenger;
	}


	public void setPassenger(Passengers passenger) {
		this.passenger = passenger;
	}


	public Payments getPayment() {
		return payment;
	}


	public void setPayment(Payments payment) {
		this.payment = payment;
	}



	public Users getUser() {
		return user;
	}



	public void setUser(Users user) {
		this.user = user;
	}


	
    
}

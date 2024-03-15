package com.FMS.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FMS.model.Flights;
import com.FMS.model.Passengers;

import jakarta.servlet.http.HttpSession;
import com.FMS.service.*;
@Controller
public class PassengersController {
	
	
	private final FlightsService flightService;
	private final PassengersService passengersService;

	
	public PassengersController(FlightsService flightService, PassengersService passengersService) {
		super();
		this.flightService = flightService;
		this.passengersService = passengersService;
	}

	@PostMapping("/user/passengerForm/")
	public String showPassengerForm(@RequestParam("flightID") Long flightID,@RequestParam("userID") Long userID, HttpSession session) {
		
        session.setAttribute("flightID", flightID);
        session.setAttribute("userID", userID);
        return "passengerForm";

	}
	
	@PostMapping("/user/payment/")
	public String addPassenger(@RequestParam("flightID") Long flightID,@RequestParam("userID") Long userID,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("contactNumber") String contactNumber,@RequestParam("dateOfBirth") LocalDate dateOfBirth, HttpSession session ) {
		Passengers passenger = new Passengers(firstName,lastName,dateOfBirth,contactNumber);
		passengersService.addNewPassenger(passenger);
		Flights flight = flightService.getFlightbyID(flightID);
		session.setAttribute("price", flight.getPrice());
		session.setAttribute("passengerID", passenger.getPassengerID());
		session.setAttribute("flightID", flightID);
		session.setAttribute("userID", userID);
		
		return "paymentForm";
	}
}

package com.FMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.FMS.model.Flights;
import com.FMS.model.Passengers;
import com.FMS.model.Payments;
import com.FMS.model.Reservations;
import com.FMS.model.Users;
import com.FMS.service.FlightsService;
import com.FMS.service.PassengersService;
import com.FMS.service.PaymentsService;
import com.FMS.service.ReservationsService;
import com.FMS.service.UsersService;

import jakarta.servlet.http.HttpSession;


@Controller
public class ReservationsController {

	private final ReservationsService reservationsService;
	private final PassengersService passengersService;
	private final PaymentsService paymentService;
	private final FlightsService flightsService;
	private final UsersService userService;

	@Autowired
	public ReservationsController(ReservationsService reservationsService, PassengersService passengersService,
			PaymentsService paymentService, FlightsService flightsService, UsersService userService) {
		this.reservationsService = reservationsService;
		this.passengersService = passengersService;
		this.paymentService = paymentService;
		this.flightsService = flightsService;
		this.userService = userService;
	}
	
	@PostMapping("/user/reservation/")
	public String confirmForm(@RequestParam("flightID") Long flightID, @RequestParam("passengerID") Long passengerID, @RequestParam("paymentID") Long paymentID, @RequestParam("userID") Long userID, HttpSession session) 
	{
		Passengers passenger = passengersService.getPassengerbyID(passengerID);
		Payments payment = paymentService.getPaymentbyID(paymentID);
		Flights flight = flightsService.getFlightbyID(flightID);
		Users user = userService.getUserByID(userID);
		Reservations reservation = new Reservations(flight, passenger, payment, user);
		session.setAttribute("userID", userID);
		session.setAttribute("flightID", flightID);
		session.setAttribute("passengerID", passengerID);
		reservationsService.addNewReservation(reservation);
		
        return "confirmEmail";
        
	}
	
	@GetMapping("/user/viewBookings/{userID}")
	public String viewReservations(@PathVariable("userID") Long userID, HttpSession session) {
		System.out.println("asdsaddsa");
		Users user = userService.getUserByID(userID);
		session.setAttribute("reservations", reservationsService.getReservationsbyUser(user));
		return "ViewBookings";
	}
	
	@DeleteMapping("/user/deleteReservation/{reservationID}")
	public String deleteReservations(@PathVariable("reservationID") Long reservationID) {
		
		Reservations reservation = reservationsService.getReservationbyID(reservationID);
		System.out.println(reservationID);
		System.out.println(reservation.getPayment().getPaymentID());
		System.out.println(reservation.getPassenger().getPassengerID());
		Long userID = reservation.getUser().getUserID();
		reservationsService.deleteReservation(reservation.getReservationID());
		paymentService.deletePayment(reservation.getPayment().getPaymentID());
		passengersService.deletePassenger(reservation.getPassenger().getPassengerID());
		return "redirect:/user/viewBookings/"+userID;
	}


}

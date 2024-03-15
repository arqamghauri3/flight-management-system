package com.FMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FMS.service.EmailService;
import com.FMS.service.UsersService;

@Controller
public class EmailController {

	private EmailService emailService;
	private UsersService userService;
	
	public EmailController(EmailService emailService, UsersService userService) {
		super();
		this.emailService = emailService;
		this.userService = userService;
	}

	@RequestMapping("/user/sendEmail/")
	public String sendEmail(@RequestParam("flightID") Long flightID,@RequestParam("passengerID") Long passengerID,@RequestParam("userID") Long userID) {
		String email = userService.getUserByID(userID).getEmail();
		String message = "Your Flight: "+flightID+ " has been confirmed! Safe Travels!";
		this.emailService.sendMessage(email, "Flight Confirmation!", message);
		return "dashboard";
	}
}

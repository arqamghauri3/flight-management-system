package com.FMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FMS.model.Aircrafts;
import com.FMS.service.AircraftsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AircraftsController {
	
	@Autowired
	private AircraftsService aircraftsService;
	
    
    @GetMapping("/aircrafts")
    public String showAircraftMain() {
        return "aircraftMain"; 
    }

	@GetMapping("/aircrafts/aircraftform")
	public String showAircraftForm() {
		
		return "aircraftForm";
	}
	
	@PostMapping("/aircrafts/addAircrafts")
	public String addAircraftsData(Aircrafts aircraft, HttpSession session) {
		aircraftsService.addNewAircraft(aircraft);
		session.setAttribute("aircrafts", aircraftsService.getAllAircrafts());
		return "redirect:/aircrafts/getAircrafts";
	}
	
	@GetMapping("/aircrafts/getAircrafts")
	public String getAircraftsData(HttpSession session) {
		session.setAttribute("aircrafts", aircraftsService.getAllAircrafts());
		return "aircraftData";
		
	}
	
	@GetMapping("/aircrafts/update/{aircraftID}")
	public String showUpdateForm(@PathVariable("aircraftID") Long aircraftID, HttpSession session) {
		session.setAttribute("aircraft", aircraftsService.getAircraftByID(aircraftID));
		return "editAircraft";
	}
	
	@PutMapping("/aircrafts/updateAircrafts/{aircraftID}")
	public String updateAircraftData(
			@PathVariable("aircraftID") Long aircraftID,
            @RequestParam(required = false) String productionLine,
            @RequestParam(required = false) String model,
            HttpSession session
			) 
	{
		aircraftsService.updateAircrafts(aircraftID, productionLine, model);
		session.setAttribute("aircrafts", aircraftsService.getAllAircrafts());
		return "redirect:/aircrafts/getAircrafts";
	}
	
	@DeleteMapping("/aircrafts/delete/{aircraftID}")
	public String deleteAircraftData(@PathVariable("aircraftID") Long aircraftID, HttpSession session) {
		aircraftsService.deleteAircrafts(aircraftID);
		session.setAttribute("aircrafts", aircraftsService.getAllAircrafts());
		return "redirect:/aircrafts/getAircrafts";
	}
	
	
}

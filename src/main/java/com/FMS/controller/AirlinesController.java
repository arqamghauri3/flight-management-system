package com.FMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.FMS.model.Airlines;
import com.FMS.service.AirlinesService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class AirlinesController {

    private final AirlinesService airlinesService;

    @Autowired
    public AirlinesController(AirlinesService airlinesService) {
        this.airlinesService = airlinesService;
    }
    
    @GetMapping("/airlines")
    public String showAirlineMain() {
        return "airlineMain"; 
    }

    @GetMapping("/airlines/getAirlines")
    public String showAllAirlines(HttpSession session) {
        session.setAttribute("airline", airlinesService.getAllAirlines());
        return "airlineData";
    }

    @GetMapping("/airlines/airlineForm")
    public String showAddAirlineForm() {
        return "airlineForm";
    }

    @PostMapping("/airlines/add")
    public String handleAddAirlineFormSubmission(Airlines airline, HttpSession session) {
    	
        airlinesService.addNewAirline(airline);
        showAllAirlines(session);
        return "redirect:/airlines/getAirlines";
    }

    @GetMapping(path = "/airlines/update/{airlineID}")
    public String showUpdateAirlineForm(@PathVariable("airlineID") Long airlineID, HttpSession session) {
        session.setAttribute("airline", airlinesService.getAirlineByID(airlineID));
        return "editAirline";
    }

    @PutMapping("/airlines/updateAirlines/{airlineID}")
    public String handleUpdateAirlineFormSubmission(
            @PathVariable Long airlineID,
            @RequestParam(required = false) String airlineName,
            @RequestParam(required = false) String iaaaCode,
            @RequestParam(required = false) String countryName) {
        airlinesService.updateAirline(airlineID, airlineName, iaaaCode, countryName);
        return "redirect:/airlines/getAirlines";
    }

    @DeleteMapping("/airlines/delete/{airlineID}")
    public String deleteAirline(@PathVariable("airlineID") Long airlineID, HttpSession session) {
        airlinesService.deleteAirline(airlineID);
        showAllAirlines(session);
        return "redirect:/airlines/getAirlines";
    }
}

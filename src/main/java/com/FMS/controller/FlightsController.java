package com.FMS.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.FMS.model.Aircrafts;
import com.FMS.model.Airlines;
import com.FMS.model.Flights;
import com.FMS.service.AircraftsService;
import com.FMS.service.AirlinesService;
import com.FMS.service.FlightsService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping()
public class FlightsController {
	private final FlightsService flightsService;
	private final AircraftsService aircraftsService;
	private final AirlinesService airlinesService;
	
    @GetMapping("/flights")
    public String showFlightsMain() {
        return "flightsMain"; 
    }

	
	public FlightsController(FlightsService flightsService, AircraftsService aircraftsService,
			AirlinesService airlinesService) {
		super();
		this.flightsService = flightsService;
		this.aircraftsService = aircraftsService;
		this.airlinesService = airlinesService;
	}


	@GetMapping("/flights/flightform")
    public String showFlightForm() {
        return "flightForm"; 
    }
	
	
//    @PostMapping("/flights/flightform/add")
//    public String handleFlightFormSubmission(Flights flight, HttpSession session) {
//        flightsService.addNewFlight(flight);
//        showAllFlightsData(session);
//        return "redirect:/flights/getFlights";
//    }
    
	@GetMapping("/flights/getFlights")
	public String showAllFlightsData(HttpSession session){
		session.setAttribute("flights", flightsService.getFlights());
		return "flightData";
	}

		
	@RequestMapping("/flights/flightform/add")
	public String registerNewFlights(@RequestParam("airlineID") Long airlineID,@RequestParam("aircraftID") Long aircraftID, @RequestParam("date") LocalDate date, @RequestParam("departureTime") String departureTime, @RequestParam("arrivalTime") String arrivalTime, @RequestParam("toCity") String toCity, @RequestParam("fromCity") String fromCity,  @RequestParam("price") String price,HttpSession session) {
		Aircrafts aircraft = aircraftsService.getAircraftByID(aircraftID);
		Airlines airline = airlinesService.getAirlineByID(airlineID);
		System.out.println(airline);
		System.out.println(aircraft);
		Flights flight = new Flights(date,departureTime,arrivalTime,toCity,fromCity,aircraft,airline,price);
		flightsService.addNewFlight(flight);
		showAllFlightsData(session);
		return "redirect:/flights/getFlights";
	};
	
	@DeleteMapping("/flights/delete/{flightid}")
	public String deleteFlights(@PathVariable("flightid") Long id, HttpSession session) {
		
		flightsService.deleteFlight(id);
		showAllFlightsData(session);
		return "redirect:/flights/getFlights";
	};
	
    @GetMapping("/flights/update/{flightid}")
    public String showEditForm(@PathVariable("flightid") Long id, HttpSession session)
    {
        Flights flight = flightsService.getFlightbyID(id);
        session.setAttribute("flight", flight);
        return "editFlight";
    }

    @PutMapping(path = "/flights/updateFlights/{flightid}")
    public String updateFlight(
            @PathVariable("flightid") Long id,
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) String departureTime,
            @RequestParam(required = false) String arrivalTime,
            @RequestParam(required = false) String toCity,
            @RequestParam(required = false) String fromCity,
            @RequestParam(required = false) String airlineName,
            @RequestParam(required = false) String aircraftID
    ) {
//        flightsService.updateFlight(id, date, departureTime, arrivalTime, toCity, fromCity, airlineName, aircraftID);

        return "redirect:/flights/getFlights";
    }
	
    @PostMapping("flights/getSearchedFlight/{userID}")
    public String getSearchedFlight(@PathVariable("userID") Long userID,@RequestParam("toCity") String toCity, @RequestParam("fromCity") String fromCity, @RequestParam("date") LocalDate date, HttpSession session) {
        List<Flights> flight = flightsService.getSearchedFlights(fromCity, toCity, date);
    	session.setAttribute("flights", flight);
    	session.setAttribute("userID", userID);
        return "searchFlight"; 
    }
    
	@GetMapping("/user/flights/{userID}")
	public String searchFlightsPage(@PathVariable("userID") Long userID, HttpSession session) {
		
		session.setAttribute("userID", userID);
		return "searchFlight";
	}
	
	@GetMapping("/flights/selectAircrafts")
	public String getAircraftsData(HttpSession session) {
		session.setAttribute("aircrafts", aircraftsService.getAllAircrafts());
		return "aircraftsSelect";
		
	}
	
	@PostMapping("/flights/aircraftsSelect/{aircraftID}")
	public String selectAircrafts(@RequestParam("aircraftID") Long aircraftID ,HttpSession session) {
		session.setAttribute("aircraftID", aircraftID);
		System.out.println(aircraftID);
		session.setAttribute("airlines", airlinesService.getAllAirlines());
		return "airlineSelect";
	}

    @RequestMapping("/flights/selectAirlines/{airlineID}/")
    public String showAllAirlines(@PathVariable("airlineID") Long airlineID,@RequestParam("aircraftID")Long aircraftID,HttpSession session) {
        session.setAttribute("airlineID", airlineID);
        session.setAttribute("aircraftID", aircraftID);
        System.out.println(airlineID);
        System.out.println(aircraftID);
        return "flightForm";
    }


}

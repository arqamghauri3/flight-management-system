package com.FMS.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.model.Flights;
import com.FMS.repository.FlightsRepository;

import jakarta.transaction.Transactional;

@Service
public class FlightsService {
	
	private final FlightsRepository flightsRepository;
	
	
	public FlightsService(FlightsRepository flightsRepository) {
		this.flightsRepository = flightsRepository;
	}
	
	public List<Flights> getSearchedFlights(String toCity, String fromCity, LocalDate date){
		return flightsRepository.findByFromCityAndToCityAndDate(fromCity, toCity, date);
	}


	public List<Flights> getFlights(){
		return flightsRepository.findAll();
	}

	
	public Flights getFlightbyID(Long id) {
		return flightsRepository.getReferenceById(id);
		
	};


	public void addNewFlight(Flights flight) {
		flightsRepository.save(flight);
		
		
	}


	public void deleteFlight(Long id) {
		flightsRepository.deleteById(id);
	}

//	@Transactional
//	public void updateFlight(Long id, LocalDate date, String departureTime, String arrivalTime, String toCity,
//			String fromCity, String airlineName, String aircraftID) {
//			Flights flight = flightsRepository.findById(id).orElseThrow(() -> new IllegalStateException("Flight with this ID doesnot exist!"));
//			if(date != null) {
//				flight.setDate(date);
//			}
//			if(departureTime != null) {
//				flight.setDepartureTime(departureTime);
//			}
//			if(arrivalTime != null) {
//				flight.setArrivalTime(arrivalTime);
//			}
//			if(toCity != null) {
//				flight.setToCity(toCity);
//			}
//			if(fromCity != null) {
//				flight.setFromCity(fromCity);
//			}
//			if(airlineName != null) {
//				flight.setAirlineName(airlineName);
//			}
//			if(aircraftID != null) {
//				flight.setAircraftID(aircraftID);
//			}
//	}

}

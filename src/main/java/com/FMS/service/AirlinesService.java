package com.FMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.model.Airlines;
import com.FMS.repository.AirlinesRepository;

import jakarta.transaction.Transactional;

@Service
public class AirlinesService {
	
	private final AirlinesRepository airlinesRepository;
	
	@Autowired
	public AirlinesService(AirlinesRepository airlinesRepository) {
		this.airlinesRepository = airlinesRepository;
	}

	public List<Airlines> getAllAirlines() {
		return airlinesRepository.findAll();
	}

	public Airlines getAirlineByID(Long airlineID) {
		return airlinesRepository.findById(airlineID)
				.orElseThrow(() -> new IllegalStateException("Airline with this name does not exist!"));
	}

	public void addNewAirline(Airlines airline) {
		airlinesRepository.save(airline);
	}

	public void deleteAirline(Long airlineID) {
		airlinesRepository.deleteById(airlineID);
	}
	
	
	@Transactional
	public void updateAirline(Long airlineID,String airlineName, String iaaaCode, String countryName) {
		Airlines airline = airlinesRepository.findById(airlineID).orElseThrow(() -> new IllegalStateException("Airline with this name does not exist!"));
        
		if (airlineName != null) {
			airline.setAirlineName(airlineName);
		}

		if (iaaaCode != null) {
			airline.setIaaaCode(iaaaCode);
		}

		if (countryName != null) {
			airline.setCountryName(countryName);
		}
	}
}

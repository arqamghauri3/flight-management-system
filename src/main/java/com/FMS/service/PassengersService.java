package com.FMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.model.Flights;
import com.FMS.model.Passengers;
import com.FMS.repository.PassengersRepository;

@Service
public class PassengersService {

	private final PassengersRepository passengersRepository;
	
	@Autowired
	public PassengersService(PassengersRepository passengersRepository) {
		this.passengersRepository = passengersRepository;
	}

	public List<Passengers> getPassengers(){
		return passengersRepository.findAll();
	}

	
	public Passengers getPassengerbyID(Long id) {
		return passengersRepository.getReferenceById(id);
		
	};


	public void addNewPassenger(Passengers passengers) {
		passengersRepository.save(passengers);
		
		
	}


	public void deletePassenger(Long id) {
		passengersRepository.deleteById(id);
	}

	
}

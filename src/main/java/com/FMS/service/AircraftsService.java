package com.FMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.model.Aircrafts;
import com.FMS.repository.AircraftsRepository;

import jakarta.transaction.Transactional;

@Service
public class AircraftsService {
	private AircraftsRepository aircraftRepository;
	
	@Autowired
	public AircraftsService(AircraftsRepository aircraftRepository) {
		this.aircraftRepository = aircraftRepository;
	}
	
	public void addNewAircraft(Aircrafts aircraft) {
		aircraftRepository.save(aircraft);
	}
	
	public List<Aircrafts> getAllAircrafts(){
		return aircraftRepository.findAll();
	}
	
	public Aircrafts getAircraftByID(Long aircraftID) {
		return aircraftRepository.getReferenceById(aircraftID);
	}
	
	public void deleteAircrafts(Long aircraftID) {
		aircraftRepository.deleteById(aircraftID);
	}
	
	@Transactional
	public void updateAircrafts(Long aircraftID, String productionLine, String model) {
		Aircrafts aircraft = aircraftRepository.findById(aircraftID).orElseThrow(() -> new IllegalStateException("Aircraft with this ID doesnot exist!"));
		System.out.println(productionLine);
		System.out.println(model);

		if(productionLine != null) {
			aircraft.setProductionLine(productionLine);
		}
		if(model != null) {
			aircraft.setModel(model);
		}
		
		System.out.println(aircraft.toString());
	}

}

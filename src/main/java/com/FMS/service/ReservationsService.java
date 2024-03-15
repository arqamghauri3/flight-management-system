package com.FMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.FMS.model.Reservations;
import com.FMS.model.Users;
import com.FMS.repository.ReservationsRepository;

@Service
public class ReservationsService {
	private final ReservationsRepository reservationsRepository;
	
	@Autowired
	public ReservationsService(ReservationsRepository reservationsRepository) {
		this.reservationsRepository = reservationsRepository;
	}
	
	public List<Reservations> getReservations(){
		return reservationsRepository.findAll();
	}

	public List<Reservations> getReservationsbyUser(Users user){
		return reservationsRepository.findByUser(user);
	}

	
	public Reservations getReservationbyID(Long id) {
		return reservationsRepository.getReferenceById(id);
		
	};


	public void addNewReservation(Reservations reservations) {
		reservationsRepository.save(reservations);
		
		
	}


	public void deleteReservation(Long id) {
		reservationsRepository.deleteById(id);
	}
	
	

}

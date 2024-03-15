package com.FMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FMS.model.Reservations;
import com.FMS.model.Users;

import java.util.List;


public interface ReservationsRepository extends JpaRepository<Reservations, Long>{
	 List<Reservations> findByUser(Users user);
}

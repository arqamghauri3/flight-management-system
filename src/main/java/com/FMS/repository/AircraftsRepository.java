package com.FMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FMS.model.Aircrafts;

@Repository
public interface AircraftsRepository extends JpaRepository<Aircrafts, Long>{

}

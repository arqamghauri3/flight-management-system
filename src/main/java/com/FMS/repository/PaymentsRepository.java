package com.FMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FMS.model.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Long>{

}

package com.FMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FMS.model.Airlines;

@Repository
public interface AirlinesRepository extends JpaRepository<Airlines, Long>{

}

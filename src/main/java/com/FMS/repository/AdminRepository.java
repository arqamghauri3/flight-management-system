package com.FMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FMS.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
	Admin findByUsernameAndPassword(String username, String password);
}

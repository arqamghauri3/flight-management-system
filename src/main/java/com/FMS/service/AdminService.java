package com.FMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.model.Admin;
import com.FMS.model.Users;
import com.FMS.repository.AdminRepository;

@Service
public class AdminService {
	private AdminRepository adminRepository;
	
	@Autowired
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	
	
	public Admin getAdminByUsernameAndPassword(String username, String password) {
		return adminRepository.findByUsernameAndPassword(username, password);
	}
	
	public boolean checkLogin(Admin admin) {
		if(admin == null) {
			return false;
		}
		return true;
	
	}

}

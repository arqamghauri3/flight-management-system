package com.FMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FMS.model.Admin;
import com.FMS.model.Users;
import com.FMS.repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class UsersService {

	private final UsersRepository usersRepository;
	
	@Autowired
	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	public void addNewUser(Users user) {
		usersRepository.save(user);
	}
	
	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}

	public Users getUserByID(Long userID) {
		return usersRepository.getReferenceById(userID);
	}
	
	public void deleteUser(Long userID) {
		usersRepository.deleteById(userID);
	}
	
	public Users getUserByUsernameAndPassword(String username, String password) {
		return usersRepository.findByUsernameAndPassword(username, password);
	}
	
	public boolean checkLogin(Users user) {
		if(user == null) {
			return false;
		}
		return true;
	
	}
	
	@Transactional
	public void updateUser(Long userID,String email, String firstName, String lastName, String username, String password) {
		Users user = usersRepository.findById(userID).get();
		
		if(email != null) {
			user.setEmail(email);
		}
		if(firstName != null) {
			user.setFirstName(firstName);
		}
		if(lastName != null) {
			user.setLastName(lastName);
		}
		if(username != null) {
			user.setUsername(username);
		}
		if(password != null) {
			user.setPassword(password);
		}
	}


}

package com.FMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FMS.model.Airlines;
import com.FMS.model.Users;
import com.FMS.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	
	private final UsersService userService;
	
    @Autowired
    public UsersController(UsersService userService) {
        this.userService = userService;
    }
    
	@GetMapping("/user/dashboard")
	public String dashboard(HttpSession session) {
		if(session.getAttribute("userID") == null) {
			return "userLogin";
		}
			
		return "dashboard";
	}

	@GetMapping("/user/login")
	public String login() {
		
		return "userLogin";
	}
	
	@PostMapping("/user/LoginAction")
	public String LoginConfirm(Users user, HttpSession session) {
		Users users = userService.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		boolean isLogin = userService.checkLogin(users);

		if(isLogin == true) {
			session.setAttribute("userID", users.getUserID());
			System.out.println(users.getUserID());
			return "dashboard";
		}
		else{
			return "redirect:/user/login";
		}

	}
	
	
	@GetMapping("/user/register")
	public String register() {
		
		return "registerUser";
	}

    @PostMapping("/user/add")
    public String addUser(Users user) {
    	userService.addNewUser(user);
        return "redirect:/user/login";
    }

    @GetMapping("/user/logout")
    public String userLogout(HttpSession session) {
		session.setAttribute("userID", null);
		
		return "userLogin";
    }
    
    @GetMapping("/user/profile/{userID}")
    public String openProfile(@PathVariable("userID") Long userID, HttpSession session) {
    	session.setAttribute("userID", userID);
    	return "userProfile";

    }
    
    @PutMapping("/user/profile/update/{userID}")
    public String updateProfile(@PathVariable("userID") Long userID, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
    	userService.updateUser(userID, email, firstName, lastName, username, password);
    	session.setAttribute("userID", userID);
    	return "dashboard";
    }

}

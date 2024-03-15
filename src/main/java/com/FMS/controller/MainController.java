package com.FMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.FMS.model.Admin;
import com.FMS.model.Users;
import com.FMS.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	private final AdminService adminService;
	
	@Autowired
	public MainController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("/")
	public String main() {
		
		return "main";
	}

	@GetMapping("/admin/login")
	public String login() {
		
		return "Login";
	}
	
	@PostMapping("/admin/loginAction")
	public String showLoginPage(Admin admin, HttpSession session) {
		Admin admins = adminService.getAdminByUsernameAndPassword(admin.getUsername(), admin.getPassword());
		boolean isLogin = adminService.checkLogin(admins);

		if(isLogin == true) {
			return "welcome";
		}
			return "Login";
		
	}
	
    @GetMapping("/welcome")
    public String showWelcomePage(HttpSession session) {
    	
		if(session.getAttribute("userID") == null) {
			return "Login";
		}

        return "welcome";
    }
    
    @GetMapping("/adminLogout")
    public String AdminLogout(HttpSession session) {
    	session.setAttribute("adminUsername", null);
    	return "Login";
    }
    
    
}

package edu.kosmo.pse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class LoginController {

	@GetMapping("/")
	public String home() {
		log.info("home..");
		return "home";
	}
	
	@GetMapping("/login/loginForm")
	public String login() {
		log.info("loginForm..");
		return "login/loginForm";
	}
	
}

package edu.kosmo.pse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

	@GetMapping("/")
	public String home() {
		
		return "home";
	}
	
}

package edu.kosmo.pse.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.kosmo.pse.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class LoginController {

	@GetMapping("/")
	public String home(Principal principal, Model model) {
		log.info("home..");
		if(principal != null) {
			String userId = principal.getName();
			model.addAttribute("userId", userId);
		}
		return "home";
	}
	
	@GetMapping("/login/loginForm")
	public String login() {
		log.info("loginForm..");
		return "login/loginForm";
	}
	
}

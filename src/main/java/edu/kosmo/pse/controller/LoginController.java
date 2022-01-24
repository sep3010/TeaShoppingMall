package edu.kosmo.pse.controller;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.kosmo.pse.service.MemberService;
import edu.kosmo.pse.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class LoginController {
	
	@Inject
	private MemberService memberService;

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
	
	@GetMapping("/add/addForm") // 회원가입
	public String memberForm() {
		log.info("memberForm..");		
		return "add/addForm";
	}
	
	@PostMapping("/add/addMember") // 회원가입 완료
	public String addMember(MemberVO memberVO) {
		log.info("addMember..");
		memberService.addMember(memberVO);
		
		return "redirect:/login/loginForm";
	}
	
	@GetMapping("/security/accessDenied") // 403 에러 페이지
	public String accessDenied() {
		log.info("accessDenied..");		
		return "security/accessDenied";
	}	
	
	
}

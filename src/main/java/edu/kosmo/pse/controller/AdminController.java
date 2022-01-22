package edu.kosmo.pse.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kosmo.pse.service.MemberService;
import edu.kosmo.pse.vo.MemberVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RequestMapping("/admin/*")
@Controller
public class AdminController {

	
	@GetMapping("/adminHome") // 관리자 페이지
	public String adminHome() {
		log.info("adminHome..");		
		return "admin/adminHome";
	}
	
	@GetMapping("/user/userHome") // 마이 페이지
	public String userHome() {
		log.info("userHome..");		
		return "user/userHome";
	}

	@GetMapping("/security/accessDenied") // 403 에러 페이지
	public String accessDenied() {
		log.info("accessDenied..");		
		return "security/accessDenied";
	}	
	
	
}

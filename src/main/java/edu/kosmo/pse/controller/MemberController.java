package edu.kosmo.pse.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.kosmo.pse.service.AdminService;
import edu.kosmo.pse.service.MemberService;
import edu.kosmo.pse.vo.MemberVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class MemberController {

	@Inject
	private MemberService memberService;
	
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

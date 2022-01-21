package edu.kosmo.pse.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/add/addForm")
	public String memberForm() {
		log.info("memberForm..");
		
		return "add/addForm";
	}
	
	@PostMapping("/add/addMember")
	public String addMember(MemberVO memberVO) {
		log.info("addMember..");
		memberService.addMember(memberVO);
		
		return "redirect:/login/loginForm";
	}
	
}

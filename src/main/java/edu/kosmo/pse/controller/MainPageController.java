package edu.kosmo.pse.controller;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.kosmo.pse.service.AdminService;
import edu.kosmo.pse.service.MainPageService;
import edu.kosmo.pse.service.MemberService;
import edu.kosmo.pse.vo.MemberVO;
import edu.kosmo.pse.vo.ProductVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RestController
@RequestMapping("/main/*")
public class MainPageController {
	
	@Autowired
	private MainPageService pageService;

	@GetMapping("/tea")
	public ModelAndView getProductList(ModelAndView view) {
		log.info("getProductList()..");
		view.addObject("productList", pageService.getAllTeaList());
		view.setViewName("main/tea");
		return view;
	}
	
	



	
}

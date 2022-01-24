package edu.kosmo.pse.controller;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.kosmo.pse.service.MainPageService;
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
		
	@GetMapping("/menu/{categoryId}")
	public ModelAndView getCategoryList(ModelAndView view, ProductVO productVO, Principal principal) {
		log.info("getCategoryList()..");
		if(productVO.getCategoryId() == 0)
			view.addObject("productList", pageService.getAllTeaList());
		else
			view.addObject("productList", pageService.getCategoryList(productVO.getCategoryId()));
		if(principal != null) {
			String userId = principal.getName();
			view.addObject("userId", userId);
		}
		
		view.setViewName("main/menu");
		return view;
	}

	@GetMapping("/menuDetails/{productId}")
	public ModelAndView getmenuDetail(ModelAndView view, ProductVO productVO, Principal principal) {
		log.info("getmenuDetail()..");		
		view.addObject("product", pageService.getProduct(productVO.getProductId()));

		if(principal != null) {
			String userId = principal.getName();
			view.addObject("userId", userId);
		}
		
		view.setViewName("main/menu");
		return view;
	}
	


	
}

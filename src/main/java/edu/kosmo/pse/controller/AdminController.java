package edu.kosmo.pse.controller;


import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.kosmo.pse.service.AdminService;
import edu.kosmo.pse.vo.ProductVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RequestMapping("/admin/*")
@RestController
public class AdminController {
	
	@Inject
	private AdminService adminService;

	
	@GetMapping("/adminHome") // 관리자 페이지
	public ModelAndView adminHome(ModelAndView view) {
		log.info("adminHome..");	
		view.setViewName("admin/adminHome");
		return view;
	}
	
	@GetMapping("/product/manageProduct") // 상품 관리
	public ModelAndView manageProduct(ModelAndView view) {
		log.info("manageProduct..");	
		view.setViewName("admin/product/manageProduct");
		view.addObject("productList", adminService.getProductList());
		return view;
	}
	
	@DeleteMapping("/product/manageProduct/{productId}")
	public ResponseEntity<String> deleteProduct(ProductVO productVO, Model model) {
		ResponseEntity<String> entity = null;
		log.info("deleteProduct()..");
		try {
			adminService.deleteProduct(productVO.getProductId());
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	@GetMapping("/order/manageOrder") // 주문 관리
	public ModelAndView manageOrder(ModelAndView view) {
		log.info("manageOrder..");
		view.setViewName("admin/order/manageOrder");
		return view;
	}
	
	@GetMapping("/member/manageMember") // 회원 관리
	public ModelAndView manageMember(ModelAndView view) {
		log.info("manageMember..");	
		view.setViewName("admin/member/manageMember");
		return view;
	}

	@GetMapping("/board/manageboard") // 게시판 관리
	public ModelAndView manageboard(ModelAndView view) {
		log.info("manageboard..");
		view.setViewName("admin/board/manageboard");
		return view;
	}
	
	
}

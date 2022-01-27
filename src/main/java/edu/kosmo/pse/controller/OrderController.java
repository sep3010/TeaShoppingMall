package edu.kosmo.pse.controller;

import java.security.Principal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.kosmo.pse.mapper.OrderMapper;
import edu.kosmo.pse.service.MainPageService;
import edu.kosmo.pse.service.OrderService;
import edu.kosmo.pse.vo.CartVO;
import edu.kosmo.pse.vo.ProductVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	


	@PostMapping("/user/cart")
	public ResponseEntity<String> inCart(@RequestBody CartVO cartVO, Principal principal) {
		ResponseEntity<String> entity = null;
		log.info("inCart.. cartVO" + cartVO);
		log.info("productId : " + cartVO.getProductId());
		log.info("userId : " + principal.getName());
		
		// {"productId":"46","cartAmount":1}
		
		try {
			orderService.inCart(cartVO.getProductId(), principal.getName());			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	/*
	// confirm 창에서 이동 장바구니로 이동.
	@PostMapping("/user/cart")
	public ModelAndView confirmGetCart(ModelAndView view, Principal principal) {
		log.info("getCart()..");
		view.addObject("userId", principal.getName());
		view.addObject("cartList", orderService.getCartList(principal.getName()));
		view.setViewName("user/cart");
		return view;
	}
	*/

	
	@GetMapping("/user/cart")
	public ModelAndView getCart(ModelAndView view, Principal principal) {
		log.info("getCart()..");
		view.addObject("userId", principal.getName());
		view.addObject("cartList", orderService.getCartList(principal.getName()));
		view.setViewName("user/cart");
		return view;
	}
	
	



	
}

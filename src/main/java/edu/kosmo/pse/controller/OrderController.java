package edu.kosmo.pse.controller;

import java.security.Principal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	/* // 안됌....ㅠㅠ 질문하기
	@ResponseBody
	@PostMapping("cart.do")
	public ResponseEntity<String> inCart(@RequestBody CartVO cartVO, Principal principal, Model model) {
		ResponseEntity<String> entity = null;
		log.info("inCart.. cartVO" + cartVO);
		
		// {"productId":"46"}
		
		try {
			orderService.inCart(cartVO.getProductId(), principal.getName());			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	*/
	

	@GetMapping("/user/cart/{productId}")
	public ModelAndView inCart(ModelAndView view, ProductVO productVO, Principal principal) {
		log.info("inCart.. productVO " + productVO);
		
		int productId = productVO.getProductId();
		log.info("productId : " + productId);
			
		orderService.inCart(productId, principal.getName());
		
		view.setViewName("redirect:/user/cart");
	
		return view;
	}

	
	@GetMapping("/user/cart")
	public ModelAndView getCart(ModelAndView view, Principal principal) {
		log.info("getCart()..");
		view.addObject("userId", principal.getName());
		view.addObject("cartList", orderService.getCartList(principal.getName()));
		view.setViewName("user/cart");
		return view;
	}
	
	
	@DeleteMapping("/user/cart/{cartId}")
	public ResponseEntity<String> rest_delete(CartVO cartVO, Model model) {
		ResponseEntity<String> entity = null;
		log.info("delete cart..");
		log.info("cartId : " + cartVO.getCartId());
		
		try {
			orderService.deldetCart(cartVO.getCartId());
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}



	
}

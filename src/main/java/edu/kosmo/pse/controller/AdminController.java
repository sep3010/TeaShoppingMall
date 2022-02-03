package edu.kosmo.pse.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.kosmo.pse.page.Criteria;
import edu.kosmo.pse.page.PageVO;
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
	
	/*
	@GetMapping("/product/manageProduct") // 상품 관리 페이지
	public ModelAndView manageProduct(ModelAndView view) {
		log.info("manageProduct()..");	
		view.setViewName("admin/product/manageProduct");
		view.addObject("productList", adminService.getProductList());
		return view;
	}
	*/
	
	/*
	// 페이징 적용 상품 관리 페이지 (처음 메뉴 접속시 무조건 첫번째 페이지를 띄우기 위한 설정)
	@GetMapping("/product/manageProduct") // 상품 관리 페이지
	public ModelAndView manageProductFirst(ModelAndView view) {
		log.info("manageProduct()..");	
		view.setViewName("admin/product/manageProduct");
		int total = adminService.getProductCount();
		int pageNum = 1;
		view.addObject("productList", adminService.getProductList(pageNum));
		view.addObject("currentPageNum", pageNum);
		
		PageVO pageVO = new PageVO(total, pageNum);
		view.addObject("pageMaker", pageVO);
		return view;
	}
	*/
	
	// 페이징 적용 상품 관리 페이지
	@GetMapping("/product/manageProduct/{pageNum}") // 상품 관리 페이지
	public ModelAndView manageProductPaging(PageVO pageVO, ModelAndView view) {
		log.info("manageProductPaging()..");	
		int total = adminService.getProductCount();
		int pageNum = pageVO.getPageNum();
		log.info("pageNum: " + pageVO.getPageNum());
		//Map<String, Object> map = new HashMap<>();
		
		//map.put("currentPageNum", pageNum);
		view.addObject("currentPageNum", pageNum);
		List<ProductVO> productList = adminService.getProductList(pageNum);
		pageVO = new PageVO(total, pageNum);
		view.addObject("productList", productList);
		view.addObject("pageMaker", pageVO);
		view.setViewName("admin/product/manageProduct");
		
		//map.put("productList", productList);
		//map.put("pageMaker", pageVO);
		return view;
	}
	
	
	@DeleteMapping("/product/manageProduct/{productId}") // 상품 삭제
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
	
	@GetMapping("/product/addProductForm") // 상품 등록 페이지
	public ModelAndView addProductFrom(ModelAndView view) {
		log.info("addProductFrom()..");	
		view.setViewName("admin/product/addProductForm");
		return view;
	}
	
	@GetMapping("/product/productDetails/{productId}") // 상품 상세 페이지
	public ModelAndView productDetails(ModelAndView view, ProductVO productVO) {
		log.info("productDetails()..");			
		view.addObject("product", adminService.getProduct(productVO.getProductId()));
		//view.addObject("isPre", adminService.existPrevoiusProduct(productVO.getProductId()));
		//view.addObject("isNext", adminService.existNextProduct(productVO.getProductId()));
		view.setViewName("admin/product/productDetails");
		return view;
	}
	
	// 다음 상품 조회
	@GetMapping("/product/productDetails/next/{productId}") 
	public ModelAndView getNextProduct(ModelAndView view, ProductVO productVO) {
		log.info("getNextProduct()..");		
		int productId = productVO.getProductId(); // 현재 상품 번호
		log.info("ProductId : " + productId); 
		productVO = adminService.getNextProduct(productId);
		productId = productVO.getProductId(); // 다음 상품 번호
		log.info("nextProductId : " + productId); 
		String makeURL = "admin/product/productDetails/" + productId;
		view.setViewName(makeURL);
		return view;
	}
		
	@PostMapping("/product/addProduct") // 상품 등록 페이지에서 등록 버튼을 누를 경우 
	public ModelAndView addProduct(ModelAndView view, ProductVO productVO) {
		log.info("addProduct()..");			
		adminService.addProduct(productVO);
		view.setViewName("redirect:/admin/product/manageProduct/1");
		return view;
	}
	
	@GetMapping("/product/modifyProduct/{productId}") // 상품 수정 페이지
	public ModelAndView modifyProduct(ModelAndView view, ProductVO productVO) {
		log.info("modifyProduct()..");			
		view.addObject("product", adminService.getProduct(productVO.getProductId()));		
		view.setViewName("admin/product/modifyProduct");
		return view;
	}
	
	@PostMapping("/product/modify") // 상품 수정 페이지에서 수정 완료 버튼 누른 경우
	public ModelAndView modify(ModelAndView view, ProductVO productVO) {
		log.info("modifyProduct()..");			
		adminService.modifyProduct(productVO);	
		String URL = "redirect:/admin/product/productDetails/" + productVO.getProductId();
		view.setViewName(URL);
		return view;
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
		view.addObject("memberList", adminService.getMemberList());
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

package edu.kosmo.pse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kosmo.pse.mapper.AdminMapper;
import edu.kosmo.pse.mapper.MemberMapper;
import edu.kosmo.pse.page.Criteria;
import edu.kosmo.pse.vo.MemberVO;
import edu.kosmo.pse.vo.ProductImageVO;
import edu.kosmo.pse.vo.ProductVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	/*
	// 등록된 상품들 리스트 불러오기 (페이징 적용 전)
	public List<ProductVO> getProductList() {
		log.info("getProductList()...");
		return adminMapper.getProductList();		
	}
	*/
	
	// 페이지 번호에 맞게 등록된 상품들 리스트 불러오기 (10개씩)
	public List<ProductVO> getProductList(int pageNum) {
		log.info("getProductList()...");
		
		return adminMapper.getProductList(pageNum);		
	}
	
	// 총 상품 개수
	public int getProductCount() {
		log.info("getProductCount()...");
		return adminMapper.getProductCount();
	}
	
	
	// 상품 상세 내역 조회
	public ProductVO getProduct(int productId) {
		log.info("getProduct()...");
		return adminMapper.getProduct(productId);
	}
	
	// 상품 등록
	@Transactional(rollbackFor = Exception.class)	
	public void addProduct(ProductVO productVO) {
		log.info("addProduct()...");

		adminMapper.insertProduct(productVO);		
	}
	
	// 상품 이미지 등록
	@Transactional(rollbackFor = Exception.class)	
	public void addProductImg(ProductImageVO imageVO) {
		log.info("addProductImg()...");
		adminMapper.insertProductImg(imageVO);		
	}
	
	// 상품 삭제
	@Transactional(rollbackFor = Exception.class)	
	public void deleteProduct(int productId) {
		log.info("deleteProduct()...");
		adminMapper.deleteProduct(productId);		
	}
	
	// 상품 수정
	@Transactional(rollbackFor = Exception.class)	
	public void modifyProduct(ProductVO productVO) {
		log.info("modifyProduct()...");
		adminMapper.updateProduct(productVO);		
	}
	
	// 전체 회원 목록 조회
	public List<MemberVO> getMemberList() {
		log.info("getMemberList()...");
		return memberMapper.getMemberList();	
	}
	
	
}

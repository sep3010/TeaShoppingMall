package edu.kosmo.pse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kosmo.pse.mapper.AdminMapper;
import edu.kosmo.pse.vo.ProductImageVO;
import edu.kosmo.pse.vo.ProductVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	// 등록된 상품들 리스트 불러오기
	public List<ProductVO> getProductList() {
		log.info("getProductList()...");
		return adminMapper.getProductList();		
	}
	
	// 상품 상세 내역 조히
	public ProductVO getProduct() {
		log.info("getProduct()...");
		return adminMapper.getProduct();
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
	
	
}

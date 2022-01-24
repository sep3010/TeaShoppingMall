package edu.kosmo.pse.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kosmo.pse.mapper.MainPageMapper;
import edu.kosmo.pse.vo.ProductVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MainPageService {
	
	@Inject
	private MainPageMapper pageMapper;
	
	// 상품 중 모든 tea 종류의 상품 
	public List<ProductVO> getAllTeaList() {
		log.info("getAllTeaList()...");
		return pageMapper.getAllTeaList();		
	}
	
	// 상품 중 가테고리별 상품 목록
	public List<ProductVO> getCategoryList(int categoryId) {
		log.info("getCategoryList()...");
		return pageMapper.getCategoryList(categoryId);
	}
	
	
	// 상품 상세 내역 조회
	public ProductVO getProduct(int productId) {
		log.info("getProduct()...");
		return pageMapper.getProduct(productId);
	}
	
	
}

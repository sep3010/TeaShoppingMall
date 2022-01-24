package edu.kosmo.pse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kosmo.pse.vo.ProductVO;

@Mapper
public interface MainPageMapper {
	
	// 상품 중 모든 tea 종류의 상품 목록
	public List<ProductVO> getAllTeaList();
	
	// 상품 중 가테고리별 상품 목록
	public List<ProductVO> getCategoryList(int categoryId);	
	
	// 상품 상세 정보 조회
	public ProductVO getProduct(int productId);
	
	
	
}

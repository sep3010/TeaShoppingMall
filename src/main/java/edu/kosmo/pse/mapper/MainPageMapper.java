package edu.kosmo.pse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.kosmo.pse.vo.MemberVO;
import edu.kosmo.pse.vo.ProductVO;

@Mapper
public interface MainPageMapper {
	
	// 상품 중 모든 tea 종류의 상품 목록
	public List<ProductVO> getAllTeaList();
	
	// 상품 중 BlackTea 종류의 상품 목록
	public List<ProductVO> getBlackTeaList();
	
	// 상품 중 GreenTea 종류의 상품 목록
	public List<ProductVO> getGreenTeaList();
	
	// 상품 중 Oolong 종류의 상품 목록
	public List<ProductVO> getOolongList();

	// 상품 중 Rooibos 종류의 상품 목록
	public List<ProductVO> getRooibosList();	

	// 상품 중 Herbal tea 종류의 상품 목록
	public List<ProductVO> getHerbalList();	
	
	// 상품 중 TeaBag 종류의 상품 목록
	public List<ProductVO> getTeaBagList();

	// 상품 중 TeaWare 종류의 상품 목록
	public List<ProductVO> getTeaWareList();	

	// 상품 중 Gift 종류의 상품 목록
	public List<ProductVO> getGiftList();	
	
	// 상품 상세 정보 조회
	public ProductVO getProduct(int productId);
	
	
	
}

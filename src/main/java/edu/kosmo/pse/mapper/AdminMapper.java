package edu.kosmo.pse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.kosmo.pse.vo.ProductImageVO;
import edu.kosmo.pse.vo.ProductVO;

@Mapper
public interface AdminMapper {
	
	/*
	// 등록되어 있는 상품들을 조회 (페이징 적용 전)
	public List<ProductVO> getProductList();
	*/
	
	// 등록되어 있는 상품들을 조회
	public List<ProductVO> getProductList(int pageNum);
	
	// 전체 상품 개수
	@Select("SELECT count(*) AS total FROM product")
	public int getProductCount();
	
	// 상품 상세 정보 조회
	public ProductVO getProduct(int productId);
	
	// 상품 등록
	public void insertProduct(ProductVO productVO);
	
	// 상품 이미지 등록
	@Insert("INSERT INTO product_image VALUES (IMG_SEQ.nextval, #{productId}, #{imgName}, #{imgExtension}, #{imgPath})")
	public void insertProductImg(ProductImageVO imageVO);
	
	// 상품 삭제
	@Delete("DELETE FROM product WHERE product_id = #{productId}")
	public void deleteProduct(int productId);
	
	// 상품 수정
	public void updateProduct(ProductVO productVO);

	// 다음 상품 조회
	public ProductVO getNextProduct(int productId);
	
	
}

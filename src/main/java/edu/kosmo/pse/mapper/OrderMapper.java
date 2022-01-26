package edu.kosmo.pse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import edu.kosmo.pse.vo.CartVO;


@Mapper
public interface OrderMapper {
	
	// 로그인한 회원의 장바구니 내역 불러오기
	public List<CartVO> getCartList(String userId);
	
	// 장바구니에 상품 넣기 (메인 메뉴 화면에서 장바구니에 담기를 눌렀을 경우)
	public void insertCart(@Param("productId") int productId, @Param("cartPrice") int cartPrice, @Param("userId") String userId);
	
	// 로그인한 회원의 기존 장바구니에 같은 상품이 있는지 확인
	public CartVO getInCartProduct(@Param("productId") int productId, @Param("userId") String userId);
	
	// 상품 가격 불러오기
	@Select("SELECT product_price FROM product WHERE product_id = #{productId}")
	public int getProductPrice(int productId);
	
	// 카트에 담겨있는 상품의 수량과 가격을 바꾼다.
	public void updateCart(@Param("productId") int productId, @Param("cartAmount") int cartAmount, @Param("cartPrice") int cartPrice, @Param("userId") String userId);
	
	
}

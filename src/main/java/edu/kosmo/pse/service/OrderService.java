package edu.kosmo.pse.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kosmo.pse.mapper.OrderMapper;
import edu.kosmo.pse.vo.CartVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class OrderService {
	
	@Inject
	private OrderMapper orderMapper;
	
	// 로그인한 회원의 장바구니 내역 불러오기
	public List<CartVO> getCartList(String userId){
		log.info("getCartList()...");
		return orderMapper.getCartList(userId);
	}
	
	// 장바구니에 상품 넣기
	@Transactional(rollbackFor = Exception.class)
	public void inCart(int productId, String userId) {
		log.info("insertCart()..");
		log.info("productId : " + productId);
		int cartAmount = 1;
		
		CartVO cartVO = orderMapper.getInCartProduct(productId, userId);
		
		if(cartVO != null) { // 기존 장바구니에 있으면 update
			// 전달된 cartAmount값에 기존 DB에 있던 cartAmount값을 더해준다.
			cartAmount += cartVO.getCartAmount();
			
			// DB에 저장할 카드에 담긴 해당 상품의 가격을 다시 설정 ( 수량(cartAmount) * 상품 가격 )
			int cartPrice = (cartAmount * cartVO.getProductPrice());
			
			orderMapper.updateCart(productId, cartAmount, cartPrice, userId);
			
		} else { // 장바구니에 없으면 새로 추가 (insert)

			int productPrice = orderMapper.getProductPrice(productId); // 상품번호에 해당하는 상품 가격
			
			int cartPrice = productPrice;
			log.info("cartPrice : " + cartPrice);
			orderMapper.insertCart(productId, cartPrice, userId);
		}
				
	}
	
	// 장바구니에 있는 상품 하나 삭제하기
	@Transactional(rollbackFor = Exception.class)
	public void deldetCart(int cartId) {
		log.info("deldetCart()..");
		
		orderMapper.deleteCart(cartId);				
	}
	
	
}

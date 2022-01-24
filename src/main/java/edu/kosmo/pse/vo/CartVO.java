package edu.kosmo.pse.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
이름           널?       유형           
------------ -------- ------------ 
CART_ID      NOT NULL NUMBER       
PRODUCT_ID   NOT NULL NUMBER       
CART_AMOUNT  NOT NULL NUMBER       
CART_PRICE   NOT NULL NUMBER       
CART_IN_DATE NOT NULL NUMBER       
USER_ID      NOT NULL VARCHAR2(50) 
*/  

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CartVO {
	private int cartId;
	private int productId;
	private int cartAmount;
	private int cartPrice;
	private Date cartInDate;
	private int userId;
	
	private String productName;
	private int weight;
	private int productPrice;
	
}

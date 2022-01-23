package edu.kosmo.pse.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
이름            널?       유형           
------------- -------- ------------ 
PRODUCT_ID    NOT NULL NUMBER       
PRODUCT_NAME  NOT NULL VARCHAR2(50) 
CATEGORY_ID   NOT NULL NUMBER       
BRAND                  VARCHAR2(50) 
WEIGHT                 NUMBER       
COUNT                  NUMBER       
PRODUCT_PRICE NOT NULL NUMBER       
UPDATE_DATE   NOT NULL DATE         
CELL_COUNT    NOT NULL NUMBER       
STOCK         NOT NULL NUMBER  
*/  

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
	private int productId;
	private String productName;
	private int categoryId;
	private String brand;
	private int weight;
	private int count;
	private int productPrice;
	private Timestamp updateDate;
	private int cellCount;
	private int stock;

	private String categoryName;
	
	// private List<ProductImageVO> images;
	
}

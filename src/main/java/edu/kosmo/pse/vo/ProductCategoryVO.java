package edu.kosmo.pse.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
이름            널?       유형           
------------- -------- ------------ 
CATEGORY_ID   NOT NULL NUMBER       
CATEGORY_NAME NOT NULL VARCHAR2(20)  
*/  

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryVO {
	private int categoryId;
	private String categoryName;

	
}

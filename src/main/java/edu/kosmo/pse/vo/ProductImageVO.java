package edu.kosmo.pse.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
이름            널?       유형            
------------- -------- ------------- 
IMG_ID        NOT NULL NUMBER        
PRODUCT_ID    NOT NULL NUMBER        
IMG_NAME      NOT NULL VARCHAR2(50)  
IMG_EXTENSION NOT NULL VARCHAR2(20)  
IMG_PATH      NOT NULL VARCHAR2(300) 
*/  

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageVO {
	private int imgId;
	private int productId;
	private String imgName;
	private String imgExtension;
	private String imgPath;

	
}

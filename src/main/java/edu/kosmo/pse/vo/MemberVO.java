package edu.kosmo.pse.vo;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
이름             널?       유형            
-------------- -------- ------------- 
USER_ID        NOT NULL VARCHAR2(50)  
PASSWORD       NOT NULL VARCHAR2(150)  
USER_NAME      NOT NULL VARCHAR2(30)  
BIRTH          NOT NULL DATE          
PHONE          NOT NULL VARCHAR2(20)  
EMAIL          NOT NULL VARCHAR2(80)  
ZIP_CODE                VARCHAR2(20)  
ADDRESS                 VARCHAR2(200) 
PLATFORM                VARCHAR2(10)  
POINT          NOT NULL NUMBER        
PURCHASE_GRADE NOT NULL VARCHAR2(10)
*/  

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private String userId;
	private String password;
	private String userName;
	private Date birth;
	private String phone;
	private String email;
	private String zipCode;
	private String address;
	private String platform;
	private int point;
	private String purchaseGrade;

	private List<AuthVO> authList;
	
}

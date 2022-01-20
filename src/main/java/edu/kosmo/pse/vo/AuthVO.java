package edu.kosmo.pse.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
이름         널?       유형           
---------- -------- ------------ 
GRADE_ID   NOT NULL NUMBER       
AUTHORITY  NOT NULL VARCHAR2(30) 
GRADE_NAME          VARCHAR2(20) 
*/  

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthVO {
	private int grade_id;
	private String authority;
	private String grade_name;
	
}

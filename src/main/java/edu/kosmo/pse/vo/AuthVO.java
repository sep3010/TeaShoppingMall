package edu.kosmo.pse.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
이름        널?       유형           
--------- -------- ------------ 
USER_ID   NOT NULL VARCHAR2(50) 
AUTHORITY NOT NULL VARCHAR2(30) 
*/  

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthVO {
	private String userId;
	private String authority;
	
}

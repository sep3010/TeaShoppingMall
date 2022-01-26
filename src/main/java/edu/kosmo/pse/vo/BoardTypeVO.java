package edu.kosmo.pse.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
이름              널?       유형           
--------------- -------- ------------ 
BOARD_TYPE_ID   NOT NULL NUMBER       
BOARD_TYPE_NAME NOT NULL VARCHAR2(20)  
*/  

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardTypeVO {

	private int boardTypeId;	
	private String boardTypeName;
	
}

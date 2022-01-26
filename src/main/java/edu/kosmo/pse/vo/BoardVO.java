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
이름            널?       유형             
------------- -------- -------------- 
BOARD_ID      NOT NULL NUMBER         
BOARD_TITLE   NOT NULL VARCHAR2(30)   
BOARD_CONTENT NOT NULL VARCHAR2(1200) 
USER_ID       NOT NULL VARCHAR2(50)   
WRITE_DATE    NOT NULL DATE           
BOARD_HIT     NOT NULL NUMBER         
BOARD_GROUP   NOT NULL NUMBER         
REWRITE_DATE           DATE           
BOARD_TYPE_ID NOT NULL NUMBER         
BOARD_LOCK    NOT NULL VARCHAR2(1)  
*/  

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private String userId;
	private Timestamp writeDate;
	private int boardHit;
	private int boardGroup;
	private Timestamp rewriteDate;
	private int boardTypeId;
	private String boardLock;
	
	private String boardTypeName;
	
}

package edu.kosmo.pse.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
이름             널?       유형             
-------------- -------- -------------- 
BOARD_ID       NOT NULL NUMBER         
BOARD_TITLE    NOT NULL VARCHAR2(30)   
BOARD_CONTENT  NOT NULL VARCHAR2(1200) 
USER_ID        NOT NULL VARCHAR2(50)   
WRITE_DATE     NOT NULL DATE           
BOARD_HIT      NOT NULL NUMBER         
BOARD_GROUP    NOT NULL NUMBER         
REWRITE_DATE            DATE           
BOARD_TYPE_ID  NOT NULL NUMBER         
BOARD_LOCK     NOT NULL VARCHAR2(1)    
PRODUCT_ID              NUMBER         
STAR_RATING             NUMBER         
ORDER_ID                NUMBER         
BOARD_CATEGORY          VARCHAR2(20)   
*/  

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private int rnum; // 게시판 마다 글 번호를 순차적으로 출력하기 위한 rownum값
	
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private String userId;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd  HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp writeDate;
	
	private int boardHit;
	private int boardGroup;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd  HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp rewriteDate;
	
	private int boardTypeId;
	private String boardLock;
	private int productId;
	private int starRating;
	private int orderId;
	private String boardCategory;
	
	private String boardTypeName;
	
}

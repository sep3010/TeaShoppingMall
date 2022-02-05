package edu.kosmo.pse.vo;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
이름           널?       유형           
------------ -------- ------------ 
REPLY_ID     NOT NULL NUMBER       
BOARD_GROUP  NOT NULL NUMBER       
REPLY_STEP   NOT NULL NUMBER       
REPLY_INDENT NOT NULL NUMBER       
BOARD_ID     NOT NULL NUMBER       
USER_ID      NOT NULL VARCHAR2(50)
REPLY_WRITE_DATE NOT NULL DATE
REPLY_CONTENT    NOT NULL VARCHAR2(800)   
*/  

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {
	private int replyId;
	private int boardGroup;
	private int replyStep;
	private int replyIndent;
	private int boardId;
	private String userId;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd  HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp replyWriteDate;
	
	private String replyContent;
	
}

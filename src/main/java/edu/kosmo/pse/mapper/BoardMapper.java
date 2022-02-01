package edu.kosmo.pse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.kosmo.pse.vo.BoardVO;
import edu.kosmo.pse.vo.MemberVO;

@Mapper
public interface BoardMapper {
	
	// notice(공지사항) 게시판 글 목록 불러오기
	public List<BoardVO> getNoticeBoardList(int pageNum);
	
	// 공시사항 글 전체 개수
	@Select("SELECT count(*) AS total FROM board WHERE board_type_id = 1")
	public int getNoticeBoardCount();
			
	// Q&A 게시판 글 목록 불러오기
	public List<BoardVO> getQandABoardList(int pageNum);
	
	// Q&A 글 전체 개수
	@Select("SELECT count(*) AS total FROM board WHERE board_type_id = 2")
	public int getQandABoardCount();
		
	// review(후기) 게시판 글 목록 불러오기
	public List<BoardVO> getReviewBoardList(int pageNum);

	// review 글 전체 개수
	@Select("SELECT count(*) AS total FROM board WHERE board_type_id = 3")
	public int getReviewBoardCount();
	
	
	

}

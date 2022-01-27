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
	public List<BoardVO> getNoticeBoardList();
			
	// Q&A 게시판 글 목록 불러오기
	public List<BoardVO> getQandABoardList();
		
	// review(후기) 게시판 글 목록 불러오기
	public List<BoardVO> getReviewBoardList();

	
	

}

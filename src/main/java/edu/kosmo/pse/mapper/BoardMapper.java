package edu.kosmo.pse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.kosmo.pse.vo.BoardVO;
import edu.kosmo.pse.vo.ReplyVO;


@Mapper
public interface BoardMapper {
	
	// notice(공지사항) 게시판 글 목록 불러오기
	public List<BoardVO> getNoticeBoardList(int pageNum);
	
	// 공시사항 글 전체 개수
	@Select("SELECT count(*) AS total FROM board WHERE board_type_id = 1")
	public int getNoticeBoardCount();
			
	// Q&A 게시판 글 목록 불러오기
	public List<BoardVO> getQuestionBoardList(int pageNum);
	
	// Q&A 글 전체 개수
	@Select("SELECT count(*) AS total FROM board WHERE board_type_id = 2")
	public int getQuestionBoardCount();
		
	// review(후기) 게시판 글 목록 불러오기
	public List<BoardVO> getReviewBoardList(int pageNum);

	// review 글 전체 개수
	@Select("SELECT count(*) AS total FROM board WHERE board_type_id = 3")
	public int getReviewBoardCount();
	
	// 게시판 글 삭제
	@Delete("DELETE FROM board WHERE board_id = #{boardId}")
	public void deleteBoard(int boardId);
	
	// 글 조회
	public BoardVO getBoard(int boardId);
	
	//조회수 증가
	@Update("UPDATE board SET board_hit = board_hit + 1 WHERE board_id = #{boardId}")
	public void updateHit(int boardId);
	
	/*
	// 글 작성
	public void insertBoard(@Param("boardTitle") String boardTitle, 
			@Param("boardContent") String boardContent, @Param("userId") String userId, 
			@Param("boardTypeId") int boardTypeId, @Param("boardLock") String boardLock, 
			@Param("productId") int productId, @Param("starRating") int starRating, 
			@Param("orderId") int orderId, @Param("boardCategory") String boardCategory);
	*/
	
	// 글 작성
	public void insertBoard(BoardVO boardVO);
	
	// 공지사항 글 수정
	public void updateNotice(@Param("boardId") int boardId, 
			@Param("boardTitle") String boardTitle, 
			@Param("boardContent") String boardContent);
	
	// Q&A 글 수정
	public void updateQuestion(@Param("boardId") int boardId, 
			@Param("boardTitle") String boardTitle, 
			@Param("boardContent") String boardContent,
			@Param("boardLock") String boardLock,
			@Param("boardCategory") String boardCategory);
	
	// 해당 게시글에 달린 댓글 불러오기
	@Select("SELECT * FROM reply WHERE board_id = #{boardId} ORDER BY reply_step ASC")
	public List<ReplyVO> getReplyList(int boardId);

}

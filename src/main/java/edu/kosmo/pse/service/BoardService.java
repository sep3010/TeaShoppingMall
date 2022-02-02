package edu.kosmo.pse.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.kosmo.pse.mapper.BoardMapper;
import edu.kosmo.pse.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	// notice(공지사항) 게시판 글 목록 불러오기
	public List<BoardVO> getNoticeBoardList(int pageNum) {
		log.info("getNoticeBoardList()...");
		return boardMapper.getNoticeBoardList(pageNum);		
	}
	
	// 공시사항 글 전체 개수
	public int getNoticeBoardCount() {
		log.info("getNoticeBoardCount()...");
		return boardMapper.getNoticeBoardCount();		
	}
	
	// Q&A 게시판 글 목록 불러오기
	public List<BoardVO> getQuestionBoardList(int pageNum) {
		log.info("getQandABoardList()...");
		return boardMapper.getQuestionBoardList(pageNum);		
	}
	
	// Q&A 글 전체 개수
	public int getQuestionBoardCount() {
		log.info("getQuestionBoardCount()...");
		return boardMapper.getQuestionBoardCount();		
	}

	
	// review(후기) 게시판 글 목록 불러오기
	public List<BoardVO> getReviewBoardList(int pageNum) {
		log.info("getReviewBoardList()...");
		return boardMapper.getReviewBoardList(pageNum);		
	}
	
	// review 글 전체 개수
	public int getReviewBoardCount() {
		log.info("getReviewBoardCount()...");
		return boardMapper.getReviewBoardCount();		
	}
	
	// 게시글 불러오기
	public BoardVO getBoard(int boardId) {
		log.info("getBoard()...");
		boardMapper.updateHit(boardId); // 조회수 추가
		return boardMapper.getBoard(boardId);		
	}
		
	// 게시판 글 삭제
	@Transactional(rollbackFor = Exception.class)
	public void deleteBoard(int boardId) {
		log.info("deleteBoard()..");
		boardMapper.deleteBoard(boardId);
	}
	
	// 게시판 글 작성
	@Transactional(rollbackFor = Exception.class)
	public void insertBoard(BoardVO boardVO) {
		log.info("insertBoard()..");
		log.info("boardVO = " + boardVO);
		
		boardMapper.insertBoard(boardVO);
	}
	
	// 공지사항 글 수정
	@Transactional(rollbackFor = Exception.class)
	public void updateNotice(BoardVO boardVO) {
		log.info("insertBoard()..");
		log.info("boardVO = " + boardVO);
		int boardId = boardVO.getBoardId();
		String boradTitle = boardVO.getBoardTitle();
		String boardContent = boardVO.getBoardContent();
		
		boardMapper.updateNotice(boardId, boradTitle, boardContent);
	}
	
	// 공지사항 글 수정
	@Transactional(rollbackFor = Exception.class)
	public void updateQuestion(BoardVO boardVO) {
		log.info("insertBoard()..");
		log.info("boardVO = " + boardVO);
		int boardId = boardVO.getBoardId();
		String boradTitle = boardVO.getBoardTitle();
		String boardContent = boardVO.getBoardContent();
		String boardLock = boardVO.getBoardLock();
		String boardCategory = boardVO.getBoardCategory();
		
		boardMapper.updateQuestion(boardId, boradTitle, boardContent, boardLock, boardCategory);
	}
	
}

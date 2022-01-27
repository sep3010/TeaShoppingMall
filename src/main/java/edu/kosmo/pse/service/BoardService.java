package edu.kosmo.pse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kosmo.pse.mapper.AdminMapper;
import edu.kosmo.pse.mapper.BoardMapper;
import edu.kosmo.pse.mapper.MemberMapper;
import edu.kosmo.pse.page.Criteria;
import edu.kosmo.pse.vo.BoardVO;
import edu.kosmo.pse.vo.MemberVO;
import edu.kosmo.pse.vo.ProductImageVO;
import edu.kosmo.pse.vo.ProductVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	// notice(공지사항) 게시판 글 목록 불러오기
	public List<BoardVO> getNoticeBoardList() {
		log.info("getNoticeBoardList()...");
		return boardMapper.getNoticeBoardList();		
	}
	
	// Q&A 게시판 글 목록 불러오기
	public List<BoardVO> getQandABoardList() {
		log.info("getQandABoardList()...");
		return boardMapper.getQandABoardList();		
	}
	
	// review(후기) 게시판 글 목록 불러오기
	public List<BoardVO> getReviewBoardList() {
		log.info("getReviewBoardList()...");
		return boardMapper.getReviewBoardList();		
	}
	
	
	

	
}

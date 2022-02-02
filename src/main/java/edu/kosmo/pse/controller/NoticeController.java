package edu.kosmo.pse.controller;


import java.security.Principal;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.kosmo.pse.page.PageVO;
import edu.kosmo.pse.service.BoardService;
import edu.kosmo.pse.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RequestMapping("/main/board/*")
@RestController
public class NoticeController {
	
	@Inject
	private BoardService boardService;
	
	// 공지사항 게시판
	@GetMapping("/notice/{pageNum}") 
	public ModelAndView getNoticeBoardList(ModelAndView view, PageVO pageVO, Principal principal) {
		log.info("getNoticeBoardList..");	
		int total = boardService.getNoticeBoardCount();
		int pageNum = pageVO.getPageNum();
		log.info("pageNum: " + pageVO.getPageNum());
		
		if(principal != null) {
			String userId = principal.getName();
			view.addObject("userId", userId);
		}
		
		view.addObject("currentPageNum", pageNum);		
		view.addObject("boardList", boardService.getNoticeBoardList(pageNum));
		pageVO = new PageVO(total, pageNum);
		view.addObject("pageMaker", pageVO);
		view.setViewName("main/board/notice");
		return view;
	}
	
	// 공지사항 게시글 조회
	@GetMapping("/noticeContent/{boardId}") 
	public ModelAndView getNoticeBoard(ModelAndView view, BoardVO boardVO, Principal principal) {
		log.info("getNoticeBoard..");	
		
		if(principal != null) {
			String userId = principal.getName();
			view.addObject("userId", userId);
		}
			
		view.addObject("board", boardService.getBoard(boardVO.getBoardId()));
		view.setViewName("main/board/noticeContent");
		return view;
	}
	
	
	// 게시판 글 삭제
	@DeleteMapping("/{boardId}") 
	public ResponseEntity<String> deleteBoard(BoardVO boardVO, Model model) {
		ResponseEntity<String> entity = null;
		log.info("deleteBoard()..");
		try {
			log.info("boardId : " + boardVO.getBoardId());
			boardService.deleteBoard(boardVO.getBoardId());
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 공지사항 글 작성 페이지
	@GetMapping("/noticeWrite") 
	public ModelAndView getNoticeWrite(ModelAndView view, Principal principal) {
		log.info("getNoticeBoard..");
		String userId = principal.getName();
		view.addObject("userId", userId);
		view.setViewName("main/board/noticeWrite");
		return view;
	}
	
	/*
	// 게시판 글 등록 ajax..
	@PostMapping("/addNotice") 
	public ResponseEntity<String> insertBoard(BoardVO boardVO, Model model) {
		ResponseEntity<String> entity = null;
		log.info("insertBoard()..");
		try {
			// boardVO.setUserId(principal.getName());
			log.info("boardVO : " + boardVO);
			boardService.insertBoard(boardVO);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	*/
	
	// 공지사항 글 등록
	@PostMapping("/addNotice") 
	public ModelAndView insertBoard(BoardVO boardVO, ModelAndView view) {
		log.info("insertBoard()..");
		log.info("boardVO : " + boardVO);
		boardService.insertBoard(boardVO);
		view.setViewName("redirect:/main/board/notice/1");
		
		return view;
	}
	
	// 게시판 글 수정 페이지
	@GetMapping("/noticeModify/{boardId}") 
	public ModelAndView noticeModify(BoardVO boardVO, ModelAndView view) {
		log.info("noticeModify()..");
		log.info("boardId : " + boardVO.getBoardId());
		view.addObject("board", boardService.getBoard(boardVO.getBoardId()));
		view.setViewName("/main/board/noticeModify");		
		return view;
	}
	
	// 게시판 글 수정 등록
	@PostMapping("/notice/modify") 
	public ModelAndView updateNoticeBoard(BoardVO boardVO, ModelAndView view) {
		log.info("updateNoticeBoard()..");
		log.info("boardVO : " + boardVO);
		boardService.updateNotice(boardVO);
		
		String URL = "redirect:/main/board/noticeContent/" + boardVO.getBoardId();
		view.setViewName(URL);		
		return view;
	}
	
	
}

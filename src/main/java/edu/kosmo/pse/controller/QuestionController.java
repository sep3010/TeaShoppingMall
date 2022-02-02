package edu.kosmo.pse.controller;


import java.security.Principal;

import javax.inject.Inject;

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
public class QuestionController {
	
	@Inject
	private BoardService boardService;
	
	// Q&A 게시판
	@GetMapping("/question/{pageNum}") 
	public ModelAndView getQuestionBoardList(ModelAndView view, PageVO pageVO, Principal principal) {
		log.info("getQuestionBoardList..");	
		int total = boardService.getQuestionBoardCount();
		int pageNum = pageVO.getPageNum();
		log.info("pageNum: " + pageVO.getPageNum());
		
		if(principal != null) {
			String userId = principal.getName();
			view.addObject("userId", userId);
		}
		
		view.addObject("currentPageNum", pageNum);		
		view.addObject("boardList", boardService.getQuestionBoardList(pageNum));
		pageVO = new PageVO(total, pageNum);
		view.addObject("pageMaker", pageVO);
		view.setViewName("main/board/question");
		return view;
	}
	
	
	// Q&A 글 조회
	@GetMapping("/questionContent/{boardId}") 
	public ModelAndView getquestionBoard(ModelAndView view, BoardVO boardVO, Principal principal) {
		log.info("getquestionBoard..");	
		
		if(principal != null) {
			String userId = principal.getName();
			view.addObject("userId", userId);
		}
			
		view.addObject("board", boardService.getBoard(boardVO.getBoardId()));
		view.setViewName("main/board/questionContent");
		return view;
	}
	

	// Q&A 글 작성 페이지
	@GetMapping("/questionWrite") 
	public ModelAndView getquestionWrite(ModelAndView view, Principal principal) {
		log.info("getNoticeBoard..");
		String userId = principal.getName();
		view.addObject("userId", userId);
		view.setViewName("main/board/questionWrite");
		return view;
	}
	
	
	// Q&A 글 등록
	@PostMapping("/addQuestion") 
	public ModelAndView insertBoard(BoardVO boardVO, ModelAndView view) {
		log.info("insertBoard()..");
		log.info("boardVO : " + boardVO);
		boardService.insertBoard(boardVO);
		view.setViewName("redirect:/main/board/question/1");
		
		return view;
	}
	
	
	// Q&A 글 수정 페이지
	@GetMapping("/questionModify/{boardId}") 
	public ModelAndView questionModify(BoardVO boardVO, ModelAndView view, Principal principal) {
		log.info("questionModify()..");
		log.info("boardId : " + boardVO.getBoardId());
		String userId = principal.getName();
		view.addObject("userId", userId);
		view.addObject("board", boardService.getBoard(boardVO.getBoardId()));
		view.setViewName("/main/board/questionModify");		
		return view;
	}
	
	// Q&A 글 수정 등록
	@PostMapping("/question/modify") 
	public ModelAndView updatequestionBoard(BoardVO boardVO, ModelAndView view) {
		log.info("updatequestionBoard()..");
		log.info("boardVO : " + boardVO);
		boardService.updateQuestion(boardVO);
		
		String URL = "redirect:/main/board/questionContent/" + boardVO.getBoardId();
		view.setViewName(URL);		
		return view;
	}
	
	
}

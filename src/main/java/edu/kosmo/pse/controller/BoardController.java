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

import edu.kosmo.pse.page.Criteria;
import edu.kosmo.pse.page.PageVO;
import edu.kosmo.pse.service.AdminService;
import edu.kosmo.pse.service.BoardService;
import edu.kosmo.pse.vo.ProductVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RequestMapping("/main/board/*")
@RestController
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@GetMapping("/notice/{pageNum}") // 공지사항 계시판
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
	

	

	
	
}

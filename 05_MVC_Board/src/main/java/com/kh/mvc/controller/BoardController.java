package com.kh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService service;
	
//	@RequestMapping("board/list")
//	public ModelAndView list() {
//	public String list(Model model) {
//		List<Board> list = service.selectAllBoard();
//		model.addAttribute("list", list);
//		return "board/list";
//		return new ModelAndView("board/list", "list", list);
//	}
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@GetMapping("/list")
	public void list(Model model) {
		List<Board> list = service.selectAllBoard();
		model.addAttribute("list", list);
	}
	
	@PostMapping
	@PutMapping
	@DeleteMapping
	
	@RequestMapping("/insert")
	public ModelAndView insert(Board board) {
		int result = service.insertBoard(board);
		return new ModelAndView("/list");
	}
	
}
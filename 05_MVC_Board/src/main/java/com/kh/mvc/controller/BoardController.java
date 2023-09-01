package com.kh.mvc.controller;


import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;
import com.kh.mvc.model.vo.Paging;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService service;
	
	String path = "/Users/junu/Desktop/spring-workspace/05_MVC_Board/src/main/webapp/upload/";
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
	public void list(Model model, Criteria cri) {
		List<Board> list = service.selectAllBoard(cri);
		model.addAttribute("list", list);
		model.addAttribute("paging", new Paging(cri, service.getTotal()));
	}
	
//	@PostMapping
//	@PutMapping
//	@DeleteMapping
	
	@PostMapping("/insert")
	public String insert(Board board) throws IllegalStateException, IOException {
		fileUpload(board);
		service.insertBoard(board);
		return "redirect:/board/list";
	}
	@GetMapping("/insert")
	public void insert() {
		
	}
	
	@GetMapping("/view") 
	public void view(int no, Model model){
		Board board = service.selectBoard(no);
		model.addAttribute("board", board);
	}
	
	public void fileUpload(Board board) throws IllegalStateException, IOException {
		MultipartFile file = board.getUploadFile();
		System.out.println("file" + file);
		
		if(!file.isEmpty()) {
			
			// 기존에 파일이 있는 경우 삭제!
			if(board.getUrl()!=null) {
				File delFile = new File(path + board.getUrl().replace("/upload/", ""));
				delFile.delete();
			}
			
			
			// 중복 방지를 위한 UUID 적용
			UUID uuid = UUID.randomUUID();
			String filename = uuid.toString() + "_" + file.getOriginalFilename();
			File copyFile = new File(path + filename);
			file.transferTo(copyFile); // 업로드 파일이 지정한 path 위치로 저장
			
			// 데이터 베이스에 경로 저장
			board.setUrl("/upload/" + filename);
		}
	}
	
	@PostMapping("/update")
	public String update(Board board) throws IllegalStateException, IOException {
		
		
		
		fileUpload(board);
		service.updateBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete") 
	public String delete(int no){
		Board board = service.selectBoard(no);
		if(board.getUrl()!=null) {
			File delFile = new File(path + board.getUrl().replace("/upload/", ""));
			delFile.delete();
		}
		service.deleteBoard(no);
		return "redirect:/board/list";
	}
	
	@GetMapping("/update")
	public void update(int no, Model model) {
		model.addAttribute("board", service.selectBoard(no));
	}
	
	@RequestMapping("/download")
	public ModelAndView donloadFile(String filename) {
		HashMap map = new HashMap();
		map.put("path", path);
		return new ModelAndView("downloadView", map);
	}
}

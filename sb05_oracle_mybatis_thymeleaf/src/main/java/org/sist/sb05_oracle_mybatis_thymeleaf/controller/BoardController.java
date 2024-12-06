package org.sist.sb05_oracle_mybatis_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@RequestMapping("/board")
@Controller
@Log
public class BoardController {

		
	@GetMapping("/list")
	public void list() {
	System.out.println("/board/list 컨트롤러 메서드 호출...");
	}
	
}

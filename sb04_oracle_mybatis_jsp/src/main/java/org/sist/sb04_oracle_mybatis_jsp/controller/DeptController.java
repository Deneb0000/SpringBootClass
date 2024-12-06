package org.sist.sb04_oracle_mybatis_jsp.controller;

import java.util.List;

import org.sist.sb04_oracle_mybatis_jsp.domain.DeptVO;
import org.sist.sb04_oracle_mybatis_jsp.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.annotation.Resource;
import lombok.extern.java.Log;


@Controller
@Log
@RequestMapping("/dept")
public class DeptController {

	@Resource
	private DeptService deptService;

	@GetMapping("/list")
	public ModelAndView depList() throws Exception {

		List<DeptVO> list =  this.deptService.getDeptList();
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("list", list);
		mav.setViewName("/dept/list");

		return mav;

	} // deptList



}//class

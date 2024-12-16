package org.sist.sistSpringProject.worknet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/worknet/*")
public class worknetController {
	
	@GetMapping("member/test")
	public String layout() {
		return "worknet/member/test";
	}
	
	@GetMapping("member/test2")
	public String layout1() {
		return "worknet/member/test2";
	}
	

}

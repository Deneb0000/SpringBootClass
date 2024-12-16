package org.sist.sistSpringProject.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about/*")
public class aboutController {
 
	@GetMapping("introduction")
	public String index() {
		return "about/introduction";
	}
	
	@GetMapping("history")
	public String history() {
		return "about/history";
	}
}

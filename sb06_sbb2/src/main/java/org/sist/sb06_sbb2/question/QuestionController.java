package org.sist.sb06_sbb2.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
	
	//private final QuestionRepository questionRepository;
	
	private final QuestionService questionService;
	
	
	/*
	@GetMapping("/question/list")	//질문묵록을 보는
	@ResponseBody
	public String list() {
		return "question list";
	}
	*/
	

	@GetMapping("/list")	//질문묵록을 보는
	public void list(Model model) {
		// List<Question> questionList = this.questionRepository.findAll();
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
	}
	
	///question/detail/2
	@GetMapping("/detail/{id}")	//질문묵록을 보는
	public String detail(@PathVariable("id") Integer id, Model model) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "/question/detail";
			
	}
	
}

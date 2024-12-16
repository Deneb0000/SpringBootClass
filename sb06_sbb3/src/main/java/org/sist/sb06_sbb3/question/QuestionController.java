package org.sist.sb06_sbb3.question;

import java.util.List;

import org.sist.sb06_sbb3.answer.AnswerForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
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
	public String detail(@PathVariable("id") Integer id, Model model
			,AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "/question/detail";
			
	}
	
	//질문 등록하기
	@GetMapping("/create")
	public void questionCreate( QuestionForm questionForm ) {	
		
	}

	//질문 등록하기 1
//	@PostMapping("/create")
//	public String questionCreate(
//			@RequestParam(value = "subject")String subject
//			,@RequestParam(value = "content") String content
//			) {	
//		//1. 질문 등록 작업
//		this.questionService.create(subject, content);
//		//2. 질문 목록으로 리다이텕트
//		return "redirect:/question/list";
//	}
	
	//질문 등록하기 2
	@PostMapping("/create")
	public String questionCreate(
			@Valid QuestionForm questionForm
			, BindingResult bindingResult) {	//@Valid 뒤에 무조건  BindingResult 있어야함
		//1. 질문 등록 작업
		if (bindingResult.hasErrors()) {
			return "/question/create";
		}
		
		String subject = questionForm.getSubject();
		String content = questionForm.getContent();
		this.questionService.create(subject, content);
		//2. 질문 목록으로 리다이텕트
		return "redirect:/question/list";
	}
	
}//class

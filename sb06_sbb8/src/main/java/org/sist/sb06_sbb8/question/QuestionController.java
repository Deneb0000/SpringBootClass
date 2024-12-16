package org.sist.sb06_sbb8.question;

import java.security.Principal;

import org.sist.sb06_sbb8.answer.AnswerForm;
import org.sist.sb06_sbb8.page.Criteria;
import org.sist.sb06_sbb8.page.PageDTO;
import org.sist.sb06_sbb8.user.SiteUser;
import org.sist.sb06_sbb8.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/question/*")

@RequiredArgsConstructor // final
public class QuestionController {

	// private final QuestionRepository questionRepository; // 주입
	private final QuestionService questionService;
	private final UserService userService;

	/*
	// 호출하는 용도로 사용.
	@GetMapping("/question/list")
	@ResponseBody
	public String list() {
		return "question list"; // localhost/question/list
	}
	 */

	/*
	// 1. 질문 리스트 보기(페이징X)
	@GetMapping("list")
	public void list(Model model) { // org.springframewokr model 추가하여 view에 전달..
		//List <Question> questionList = this.questionRepository.findAll();
		List <Question> questionList = this.questionService.getList(); // Repository 대신 서비스로 전달
		model.addAttribute("questionList", questionList); // 모델에 담기. 뷰에서 받기 가능~

	}
	 */

	/*
	// 2. 질문 리스트 보기 (페이징OO)
	@GetMapping("list")
	public void list(Model model, 
					@RequestParam(value="page", defaultValue = "0") int page
					) { // 0 주면 1페이지 됨.
		// 페이징 처리가 된 객체 : paging
		Page<Question> paging = this.questionService.getList(page); 
		model.addAttribute("paging", paging); // paging 안에 페이징관련정보가 다 들어있다..?
	}
	 */

	// 2. 질문 리스트 보기 (페이징OO + 페이징블럭)
//	@GetMapping("list")
//	public void list(Model model, 
//			@RequestParam(value="page", defaultValue = "0") int page
//			) { // 0 주면 1페이지 됨.
//		// 페이징 처리가 된 객체 : paging
//		Page<Question> paging = this.questionService.getList(page); 
//		model.addAttribute("paging", paging); // paging 안에 페이징관련정보가 다 들어있다..?
//
//		Criteria criteria = new Criteria(page+1, 10 ); 
//		int total = (int)paging.getTotalElements();
//		model.addAttribute("pageMaker",  new PageDTO(criteria, total));
//	}
	
	//3. 검색 기능이 포함이 된 페이징 처리
//	@GetMapping("/list")
//	public void list(Model model
//			, @RequestParam(value="page", defaultValue = "0") int page
//			, @RequestParam(value="kw", defaultValue = "") String kw
//			) { // 0 주면 1페이지 됨.
//		// 페이징 처리가 된 객체 : paging
//		Page<Question> paging = this.questionService.getList(page, kw); 
//		model.addAttribute("paging", paging); // paging 안에 페이징관련정보가 다 들어있다..?
//		model.addAttribute("kw", kw);
//
//		Criteria criteria = new Criteria(page+1, 10 ); 
//		int total = (int)paging.getTotalElements();
//		model.addAttribute("pageMaker",  new PageDTO(criteria, total));
//	}
	
	//[4] 검색기능 포함 + Querydsl 페이지/타입/키워드
	   @GetMapping("/list")
	   public void list(Model model
	         , @RequestParam( value = "page", defaultValue = "0") int page 
	         , @RequestParam( value = "type", defaultValue = "s") String type 
	         , @RequestParam( value = "kw", defaultValue = "") String keyword 
	         ) {      
	      // 페이징 처리가 된 객체  : paging
	      Page<Question> paging = this.questionService.getList(page, type, keyword);
	      model.addAttribute("paging", paging);
	      model.addAttribute("kw", keyword);

	      Criteria criteria = new Criteria(page+1, 10 ); 
	      int total = (int)paging.getTotalElements();
	      model.addAttribute("pageMaker",  new PageDTO(criteria, total));

	   }
	



	// 질문 상세 보기
	// localhost/question/detail/2
	@GetMapping("detail/{id}") // Question.java 의 컬럼값.
	public String detail(@PathVariable("id") Integer id, Model model, 
			AnswerForm answerForm) {  // 여기에도 AnswerForm 넣어줘야함.
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question/detail";

	}


	/*
	 * 1.
	// 질문 등록하기     컨트롤러 - 서비스 - 리포지토리
	@PostMapping("/create") 
	public String questionCreate(
			@RequestParam(value="subject") String subject, 
			@RequestParam(value="content") String content
			) { 
		// 1. 질문 등록 작업
		this.questionService.create(subject, content);
		// 2. 질문 목록으로 리다이렉트.

		return "redirect:/question/list";
	}
	 */


	// 질문 등록하기
	@PreAuthorize("isAuthenticated()") // 글쓰기 전 권한을 물어보는 어노테이션. 로그인 안하면 로그인페이지로 이동.
	@GetMapping("/create") 
	public void questionCreate(QuestionForm questionForm) {  
		// 유효성 검사할때 여기에도 매개변수값 넣어줘야함.

	}

	// 2.
	// 질문 등록하기 (유효성 검사 자동)
	@PreAuthorize("isAuthenticated()") // 글쓰기 전 권한을 물어보는 어노테이션. 로그인 안하면 로그인페이지로 이동.
	@PostMapping("/create") 
	public String questionCreate(
			@Valid QuestionForm questionForm, BindingResult bindingResult,  // @Valid + BindingResult는 짝꿍이다.
			Principal principal) { 
		// 1. 유효성검사에 에러 있는지 확인
		if(bindingResult.hasErrors()) { // 에러 있으면?
			return "question/create"; // 다시 포워딩
		}
		// 에러 없으면
		String subject = questionForm.getSubject();
		String content = questionForm.getContent();

		SiteUser siteUser = this.userService.getUser(principal.getName()); // siteUser 넘긴 다음에, create 에 변수 추가 가능하다.
		this.questionService.create(subject, content, siteUser);

		// 2. 질문 목록으로 리다이렉트.
		return "redirect:/question/list";
	}

	//수정버튼 클릭시
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/modify/{id}")
	public String questionModify(
			QuestionForm questionForm
			, @PathVariable("id") Integer id, Principal principal) {
		Question question = this.questionService.getQuestion(id);
		if(!question.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
		}
		questionForm.setSubject(question.getSubject());
		questionForm.setContent(question.getContent());
		return "/question/create";
	}
	
	//수정 처리하는 컨트롤러 메서드
	@PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String questionModify(@Valid QuestionForm questionForm
    		, BindingResult bindingResult
    		, Principal principal
            , @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "/question/create";
        }
        Question question = this.questionService.getQuestion(id);
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }
	
	//삭제 처리하는 메서드
	@PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String questionDelete(Principal principal, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.questionService.delete(question);
        return "redirect:/";
    }
	
	//추천을 처리하는 컨트롤러 메서드
	@PreAuthorize("isAuthenticated()")	//회원아니면 페이지 넘김
    @GetMapping("/vote/{id}")
    public String questionVote(Principal principal	//인증정보
    		, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.vote(question, siteUser);
        return String.format("redirect:/question/detail/%s", id);
    }
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	
}

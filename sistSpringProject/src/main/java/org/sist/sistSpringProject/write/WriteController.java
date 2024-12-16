package org.sist.sistSpringProject.write;

import org.sist.sistSpringProject.answer.AnswerForm;
import org.sist.sistSpringProject.page.Criteria;
import org.sist.sistSpringProject.page.PageDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/customer/consult/*")

@RequiredArgsConstructor // final
public class WriteController {
	
	private final WriteService writeService;

	// 2. 질문 리스트 보기 (페이징OO + 페이징블럭)
	@GetMapping("list")
	public void list(Model model, 
			@RequestParam(value="page", defaultValue = "0") int page
			) { // 0 주면 1페이지 됨.
		// 페이징 처리가 된 객체 : paging
		Page<Write> paging = this.writeService.getList(page); 
		model.addAttribute("paging", paging); // paging 안에 페이징관련정보가 다 들어있다..?
		
		Criteria criteria = new Criteria(page+1, 10 ); 
        int total = (int)paging.getTotalElements();
        model.addAttribute("pageMaker",  new PageDTO(criteria, total));
	}
	
	
	
	// 질문 상세 보기
	// localhost/question/detail/2
	@GetMapping("detail/{id}") // Question.java 의 컬럼값.
	public String detail(@PathVariable("id") Integer id, Model model, 
						AnswerForm answerForm) {  // 여기에도 AnswerForm 넣어줘야함.
		Write write = this.writeService.getWrite(id);
		model.addAttribute("write", write);
		return "question/detail";
		
	}
	
	// 질문 등록하기
	//  <a th:href="@{/question/create}" class="btn btn-primary">질문 등록하기</a>
	@GetMapping("/write") 
	public void writeCreate(WriteForm writeForm) {  
		// 유효성 검사할때 여기에도 매개변수값 넣어줘야함.
		
	}
	
	// 2.
	// 질문 등록하기 (유효성 검사 자동)
	@PostMapping("/write") 
	public String writeCreate(
			@Valid WriteForm writeForm, BindingResult bindingResult  // @Valid + BindingResult는 짝꿍이다.
			) { 
		// 1. 유효성검사에 에러 있는지 확인
		if(bindingResult.hasErrors()) { // 에러 있으면?
			return "consult/write"; // 다시 포워딩
		}
		// 에러 없으면
		String writer = writeForm.getWriter();
		String email1 = writeForm.getEmail1();
		String email2 = writeForm.getEmail2();
		String password = writeForm.getPassword();
		String cInfo = writeForm.getCInfo();
		String phone = writeForm.getPhone();				
		String subject = writeForm.getSubject();
		Integer dStatus = writeForm.getDStatus();
		String content = writeForm.getContent();
		this.writeService.create(writer, email1, email2,password, cInfo, phone, subject, dStatus,content);
		
		// 2. 질문 목록으로 리다이렉트.
		return "redirect:/question/list";
	}
	
	
	
}

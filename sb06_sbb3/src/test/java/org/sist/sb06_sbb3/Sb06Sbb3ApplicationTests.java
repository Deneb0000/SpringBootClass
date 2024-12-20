package org.sist.sb06_sbb3;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.sist.sb06_sbb3.answer.Answer;
import org.sist.sb06_sbb3.answer.AnswerRepository;
import org.sist.sb06_sbb3.question.Question;
import org.sist.sb06_sbb3.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class Sb06Sbb3ApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	
//	@Test
//	void testJpa() {
		//질문을 등록하는 테스트
		
//		Question q1 = new Question();		//insert
//		
//		q1.setSubject("sbb가 무엇인가요?");
//		q1.setContent("sbb에 대해서 알고 싶습니다");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);
//		
//		Question q2 = new Question();
//		
//		q2.setSubject("스프링부트 모델 질문입니다");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
	
	
//	@Test	//select
//	void testJpa() {
//		//모든 질문 조회
//		List<Question> list = this.questionRepository.findAll();
//		System.out.println(">" + list.size());
//		
//		list.stream().forEach(q-> System.out.println(q.getSubject()));
//	}
		
//	@Test		//제목으로 검색
//	void testJpa() {
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		System.out.println(">>" + q.getSubject());
//		
//	}
	
	//Where subject LIKE "%무엇%"
//	@Test		//검색어가 포함되어있는 제목으로 검색 : 쿼리 메소드
//	void testJpa() {
//		List<Question> q = this.questionRepository.findBySubjectContaining("sbb");
//		System.out.println(">>" + q.size());
//		
//	}
	
//	@Test		//검색어가 포함되어있는 제목으로 검색	@쿼리 어노테이션을 이용함 
//	void testJpa() {
//		List<Question> q = this.questionRepository.findBySubjectLike("sbb");
//		System.out.println(">>" + q.size());
//		
//	}
	
//	@Test		// 
//	void testJpa() {
//		Question q = this.questionRepository.findBySubjectAndContent(
//				"sbb가 무엇인가요?","sbb에 대해서 알고 싶습니다.");
//		System.out.println(">>id :" + q.getId());		
//	}
	
//	@Test		//검색어가 포함되어있는 제목으로 검색 : 쿼리 메소드	
//	void testJpa() {
//		List<Question> q = this.questionRepository.findBySubjectLike("%sbb%");
//		System.out.println(">>" + q.size());	
//	}
	
	// 제목 질문 수정
	//UPDATE
	//SET subject = '수정할 값'
	///WHERE id = 1;
//	@Test
//	void testJpa() {
//		Optional<Question> optional = this.questionRepository.findById(1);
//		if (optional.isPresent()) {//존재한다면
//				Question q1 = optional.get()		;
//				q1.setSubject("수정된 제목");
//				this.questionRepository.save(q1);
//		}//if
//	}
	
//	@Test	//데이터를 삭제하는
//	void testJpa() {
//		System.out.println("총 질문 수 : " + this.questionRepository.count() ); //총 레코드 수
//		
//		//void this.questionRepository.deleteAllById(1);
//		Optional<Question> optional = this.questionRepository.findById(1);
//		Question q1 = optional.get();
//		this.questionRepository.delete(q1);
//		System.out.println("총 질문 수 : " + this.questionRepository.count() ); //총 레코드 수
//	}
	
	
	//=========================================================
	// 1. 답변 insert 저장 작업
	@Autowired
	private AnswerRepository answerRepository;
	
//	@Test
//	void testJpa() {
//		
//		Optional<Question> optional = 	this.questionRepository.findById(2);
//		
//		if (optional.isPresent()) {
//
//			Question q= optional.get();
//			
//			Answer a = new Answer();
//			a.setContent("2번째 답글.");
//			a.setCreateDate(LocalDateTime.now());
//			a.setQuestion(q);
//			this.answerRepository.save(a);
//		}
//	}
	
	//질문 2에 대한 모든 답변의 글을 조회
//	@Test
//	void testJpa() {
//		 Optional<Question> optional = this.questionRepository.findById(2);
//	      
//	      if(optional.isPresent()) {
//	         
//	         Question question = optional.get();
//	         
//	         //질문ID 에 해당하는 대답을 조회
//	         List<Answer> answers = this.answerRepository.findByQuestion(question);
//	            
//	           for (Answer answer : answers) {
//	               System.out.println("답변 내용: " + answer.getContent());
//	           }
//	}
	
	//데이터를 가져오는 방식
	//1. 즉시 데이터를 가져오는 방식 Eager
	//2. 지연 데이터를 가져오는 방식 Lazy
	@Transactional
	@Test
	void testJpa() {
		Optional<Question> optional = 	this.questionRepository.findById(2);
		if (optional.isPresent()) {
			Question q = optional.get();
			List<Answer> answerList = q.getAnswerList();
			answerList.stream().forEach(a -> System.out.println("answer :"+ a.getContent()));
		}
		
	}

}

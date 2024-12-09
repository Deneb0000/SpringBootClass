package org.sist.sb06_sbb3.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.sist.sb06_sbb3.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

	private final QuestionRepository questionRepository;
	
	//질문 목록을 가져오는 메서드
	public List<Question> getList(){
		return this.questionRepository.findAll();
	}
	
	//id에 해당하는 질문을 가져오는 메서드
	public Question getQuestion(Integer id) {
		Optional<Question> oQuestion = this.questionRepository.findById(id);
		if (oQuestion.isPresent()) {
			return oQuestion.get(); //			
		}else {
			//강제로 사용자 정의 예외시키겠다
			//excetion 패키지 + DataNotFoundException ㅇ예외 클래스 추가
			throw new DataNotFoundException("question not found");			
		}
	}
	
	//질문을 등록하는 메서드
	public void create(String subject, String content) {
		Question question = new Question();
		question.setSubject(subject);
		question.setContent(content);
		question.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(question);
	}
}//class

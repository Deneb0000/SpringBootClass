package org.sist.sb06_sbb6.answer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.sist.sb06_sbb6.exception.DataNotFoundException;
import org.sist.sb06_sbb6.question.Question;
import org.sist.sb06_sbb6.user.SiteUser;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {

	private final AnswerRepository answerRepository;
	
	// 답변 생성
	public void create(Question question, String content, SiteUser author) { // String content 은 AnswerForm 을 넘겨도 됨. DTO객체로 넘겨도 된다는말임
		
		Answer answer= new Answer();
		
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		
		answer.setAuthor(author); // 작성자 정보 추가.
		
		this.answerRepository.save(answer);
	}//create
	
	// 답변 조회	: 작성자인데 지운적이 없는데 관리자가 지웟을지도 있어서... 의도치 않게 내가 쓴 글도 내가 확인할때 없을수 있어서
    public Answer getAnswer(Integer id) {
        Optional<Answer> answer = this.answerRepository.findById(id);
        if (answer.isPresent()) {
            return answer.get();
        } else {
            throw new DataNotFoundException("answer not found");
        }
    }

    // 답변 수정
    public void modify(Answer answer, String content) {
        answer.setContent(content);
        answer.setModifyDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }
    
    // 답변 삭제
    public void delete(Answer answer) {
        this.answerRepository.delete(answer);
    }
	
}//class

package org.sist.sb06_sbb3.answer;

import java.time.LocalDateTime;

import org.sist.sb06_sbb3.question.Question;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {
	private final AnswerRepository anwAnswerRepository;
	
	public void create(Question question, String content) {
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		
		this.anwAnswerRepository.save(answer);
	}

}
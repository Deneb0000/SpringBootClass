package org.sist.sb06_sbb2.answer;

import java.util.List;

import org.sist.sb06_sbb2.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{
	
	//List<Answer> findByQuestion(Question question);
	
	
	

}
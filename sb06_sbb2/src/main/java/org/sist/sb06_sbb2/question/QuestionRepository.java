package org.sist.sb06_sbb2.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface QuestionRepository extends JpaRepository<Question, Integer>{

	//CRUD 메서드 이미 내장 되어져 있다.
	
	//1. 쿼리 메서드 (약속된 이름)
	Question findBySubject(String subject);
	
	List<Question> findBySubjectContaining(String subject);
	//내부적으로 JPQ로 날라간다
	
	//2.@Query 객체를 다루는 JPQL
//	@Query("SELECT q FROM Question q WHERE q.subject LIKE %:subject%")
//	List<Question> findBySubjectLike(@Param("subject")String subject);
	
	//2-2 쿼리 메소드
	List<Question> findBySubjectLike(String subject);
	
	
	// WHERE subject = ? AND content = ?			OR도 가능
	Question findBySubjectAndContent(String subject, String content);
	
	
}

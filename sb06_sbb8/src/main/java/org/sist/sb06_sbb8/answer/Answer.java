package org.sist.sb06_sbb8.answer;

import java.time.LocalDateTime;
import java.util.Set;

import org.sist.sb06_sbb8.question.Question;
import org.sist.sb06_sbb8.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@Builder // setContent.. 같이 안써도 얘가 알아서 set 붙여줌
public class Answer {
	
	@Id // pk 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate ;
	
	@ManyToOne // n:1
	private Question question ; // FK로 줄거라면(조인), 우리가 만든 Question.java를 줘야함!! 
								// 실제 생성된 컬럼명 : question_id
	
	@ManyToOne // 한명이 여러개의 답변을 달수 있음.
	private SiteUser author;
	
	private LocalDateTime modifyDate; //수정한 날짜 
	
	//좋아요 기능 : 질문 - 회원  다 : 다
		@ManyToMany
		private Set<SiteUser> voter;	//set : 1번밖에 못눌러서 ㅇㅋ
}
 
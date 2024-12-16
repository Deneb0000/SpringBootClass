package org.sist.sb06_sbb7.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.sist.sb06_sbb7.answer.Answer;
import org.sist.sb06_sbb7.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // @Data는 엔티티에서 안쓴다!!!
@Entity // 엔티티에서 setter 는 안쓴다., 있어도 문제는 없다.
public class Question {
	
	@Id // pk 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200) // 크기 지정 가능
	private String subject;
	
	@Column(columnDefinition = "TEXT") // 글자수 제한 없는 문자열
	private String content; 
	
	private LocalDateTime createDate;  // 테이블 생성시 create_date 로 생성됨
	
	
				// cascade = CascadeType.REMOVE : 부모키 없애면 자식들도 삭제(질문삭제시 답글도 삭제)
				// fetch = FetchType.EAGER : 즉시 방식으로 가져옴. 단위테스트할때 유용하다고 함
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER) 
	private List<Answer> answerList; // 하나의 질문에 여러개의 답변을 담기 위해.
	
	@ManyToOne
	private SiteUser author; //작성자
	
	private LocalDateTime modifyDate; //수정한 날짜 
	
	//좋아요 기능 : 질문 - 회원  다 : 다
	@ManyToMany
	private Set<SiteUser> voter;	//set : 1번밖에 못눌러서 ㅇㅋ
	
	
}

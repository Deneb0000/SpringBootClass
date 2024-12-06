package org.sist.sb06_sbb2.question;

import java.time.LocalDateTime;
import java.util.List;

import org.sist.sb06_sbb2.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   @Column(length = 200)
   private String subject;
   
   @Column(columnDefinition = "TEXT")
   private String content;
   
   private LocalDateTime createDate; //
   
   @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)	// 부모가 사라지면 자식도 사라진다 질문을 삭제하면 답글도 제거하겠다는 옵션
   private List<Answer> answersList;                                        						//ㄴ FetchType.EAGER/Lazy 기억하기
   
}

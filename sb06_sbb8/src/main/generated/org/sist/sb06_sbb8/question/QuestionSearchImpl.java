package org.sist.sb06_sbb8.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;

public class QuestionSearchImpl 
	extends QuerydslRepositorySupport //페이징 처리
	implements QuestionSearch{

	public QuestionSearchImpl() {		// <- 문법적인거 부모어쩌구 설정해둬야한다.
		super(Question.class);
	}

	@Override
	   public Page<Question> searchAll(String[] types, String keyword, Pageable pageable) {
	      // Q도메인 객체 생성 : Q도메인을 사용하기 위해서
	      QQuestion question = QQuestion.question;       
	      // SELECT ... FROM question
	      JPQLQuery<Question> query = from(question);
	      
	      if( (types != null && types.length > 0 ) && keyword != null ) {
	         
	         BooleanBuilder booleanBuilder = new BooleanBuilder(); // (
	         //  String [] types = {"s", "c"}         "sc".split("")
	         for (String type : types) {
	            switch (type) {
	            case "s":
	               // subject LIKE ...
	               booleanBuilder.or(question.subject.contains(keyword));
	               break;
	            case "c":
	               // content LIKE ...
	               booleanBuilder.or(question.content.contains(keyword));
	               break;
	            case "a":
	               // content LIKE ...
	               //booleanBuilder.or(answer.content.contains(keyword));
	               break; 
	            } // switch            
	         } // for
	         query.where(booleanBuilder);
	         query.where(question.id.gt(0L));  // 성능 때문에 넣은 문장...
	      } // if
	       
	      // 
	      this.getQuerydsl().applyPagination(pageable, query);
	      
	      // 쿼리 실행
	      List<Question> list = query.fetch();
	      long count = query.fetchCount();
	      
	      return  new PageImpl<>(list, pageable, count);
	   }

}

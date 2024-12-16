package org.sist.sistSpringProject.write;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriteRepository extends JpaRepository<Write, Integer>{

	Write findBySubject(String subject);
	
	List<Write> findBySubjectContaining(String subject);
	
	List<Write> findBySubjectLike(String subject);

	Write findBySubjectAndContent(String subject, String content);
	
		
	//페이징 처리
	Page<Write> findAll(Pageable pageable);
}

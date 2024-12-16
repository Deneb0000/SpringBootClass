package org.sist.sistSpringProject.write;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sist.sistSpringProject.exception.DataNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //final
public class WriteService {
	
	private final WriteRepository writeRepository;
	
	//교육문의 목록 가져오기
	public List<Write> getList(){
		return this.writeRepository.findAll();
	}
	
	//id에 해당하는 질문 가져오는 메서드
	public Write getWrite(Integer id) {
		Optional<Write> op = this.writeRepository.findById(id);
		if(op.isPresent()) { //질문 존재 여부
			return op.get();
		}else {
			throw new DataNotFoundException("not foundCake");
		}//if else		
	}//getWrite
	
	//질문 등록
	public void create(String writer, String email1, String email2,String password
								, String cInfo, String phone, String subject, Integer dStatus ,String content) {
		Write write = new Write();
		write.setWriter(writer);
		write.setEmail1(email1);
		write.setEmail2(email2);
		write.setCInfo(cInfo);
		write.setPhone(phone);
		write.setSubject(subject);
		write.setDStatus(dStatus);
		write.setContent(content);
		write.setCreateDate(LocalDateTime.now());		
	}
	
	//페이징 처리 된 목록
	public Page<Write> getList(int page){
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("id"));
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		return this.writeRepository.findAll(pageable);
	}

}//class

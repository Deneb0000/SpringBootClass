package org.sist.sistSpringProject.write;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Write {

	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20)
	private String writer;
	
	@Column
	private String email1;	
	private String email2;	

	private String password;	
	
	@Column(length = 14)
	private String cInfo;
	
	@Column(length = 14)
	private String phone;
	
	@Column(length = 200)
	private String subject;
	
	private Integer dStatus;

	@Column(columnDefinition = "TEXT")
	private String content;

	private LocalDateTime createDate;
	
//	@OneToOne(mappedBy = "write", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)	//하나의 게시글에 하나의 답변
//	private List<답변> 답변List;
	
}

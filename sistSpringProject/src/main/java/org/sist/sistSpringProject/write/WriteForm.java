package org.sist.sistSpringProject.write;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// DTO 임.

@Setter
@Getter
public class WriteForm {
	
	@NotEmpty(message = "작성자를 입력해주세요.")
	@Size(max=200)
	private String writer;
	
	@NotEmpty(message = "이메일을 입력해주세요.")
	private String email1;
	
	@NotEmpty(message = "이메일 형식이 맞지 않습니다.")
	private String email2;

	@NotEmpty(message = "비밀번호를 입력해주세요.")
	private String password;
	//비밀번호는 영문,숫자,특수문자 6~12자리를 입력해 주세요.	
	//비밀번호에 반복되는 문자 및 숫자가 있습니다.
	
	private String cInfo;

	@NotEmpty(message = "휴대폰 번호를 입력해주세요.")
	private String phone;
	//숫자와 '-'만 입력가능합니다.
		
	@NotEmpty(message = "제목를 입력해주세요.")
	@Size(max=200)
	private String subject;
	
	private Integer dStatus;
	
	@NotEmpty(message = "내용을 입력해주세요.")
	private String content;
}

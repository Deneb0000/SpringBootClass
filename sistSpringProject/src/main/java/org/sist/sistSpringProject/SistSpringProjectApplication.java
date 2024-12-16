package org.sist.sistSpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 앱 시작할때 맨 처음 실행됨.
public class SistSpringProjectApplication { // 프로젝트명 + app... 

	public static void main(String[] args) {
		SpringApplication.run(SistSpringProjectApplication.class, args);
	}

}
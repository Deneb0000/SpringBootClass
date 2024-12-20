package org.sist.sb04_oracle_mybatis_jsp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication	//내부적으로 스프링부트어플리케이션을 사용하는 어노테이션
@MapperScan("org.sist.sb04_oracle_mybatis_jsp.persistence")
public class Sb04OracleMybatisJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sb04OracleMybatisJspApplication.class, args);
	}

}

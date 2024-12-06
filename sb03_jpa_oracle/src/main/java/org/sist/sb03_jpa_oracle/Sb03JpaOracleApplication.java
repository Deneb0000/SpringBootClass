package org.sist.sb03_jpa_oracle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication	//내부적으로 스프링부트어플리케이션을 사용하는 어노테이션
@MapperScan("org.sist.sb03_jpa_oracle.persistence")
public class Sb03JpaOracleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sb03JpaOracleApplication.class, args);
	}

}

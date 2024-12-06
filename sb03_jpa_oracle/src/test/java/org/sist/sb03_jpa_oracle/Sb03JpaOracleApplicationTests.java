package org.sist.sb03_jpa_oracle;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.sist.sb03_jpa_oracle.persistence.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.java.Log;

@SpringBootTest
@Log
class Sb03JpaOracleApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@Autowired
	TimeMapper timeMapper;
	@Test
	void timeMapperTest() {
		System.out.println(">현재시간 : " +this.timeMapper.getTime());
	}
	
	@Autowired
	DataSource dataSource ;
	@Test
	void testConnection() {
		try(Connection con = this.dataSource.getConnection()) {
			log.info(">CONNECTION: " + con);
			
		} catch (Exception e) {
e.printStackTrace();
		}
	}

}

package org.sist.sb03_jpa_oracle.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_sample")
public class Sample {
   
   @Id
   //@GeneratedValue(strategy = GenerationType.IDENTITY)
   //1부터 1씩 증가 시퀀스
   @GeneratedValue(generator = "seq_tblsample", strategy = GenerationType.SEQUENCE)
   @SequenceGenerator(name = "seq_tblsample", sequenceName = "seq_tblsample", 
                                 initialValue = 1, allocationSize = 1 )
   private Long sno; //pk
   
   private String col1; //칼럼1
   
   private String col2; //칼럼2

}

/*
Hibernate:
create table tbl_sample (
	sno number(19,0) not null,
	col1 varchar2(255 char),
	col2 varchar2(255 char),
	primary key (sno));

Hibernate:
create sequence seq_tblsample start with 1 increment by 1
  */

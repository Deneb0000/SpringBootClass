package org.sist.sb06_sbb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
public class helloLombok {

	private final String hello;
	private final int lombok;
	//@data 사용하지 말것 
	public static void main(String[] args) {
		
		//System.out.println("hello world");
		helloLombok helloLombok = new helloLombok("헬로", 5);
				
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
		
		
	}
/*	
	private String hello;
	private int lombok;
	//@data 사용하지 말것 
	public static void main(String[] args) {

		//System.out.println("heool world");
		helloLombok helloLombok = new helloLombok();
		helloLombok.setHello("헬로");
		helloLombok.setLombok(5);
		
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());


	}
	*/

}

package org.sist.sb06_sbb8.util;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;


@Component
public class CommonUtil {

	// 일반 문자열 -> 서실문자열 변환 메서드
	public String markdown(String markdown) {

		Parser parser = Parser.builder().build();
		Node document = parser.parse(markdown);
		HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();

		return htmlRenderer.render(document);

	}

}




//@Component //자동적으로 주입
//public class CommonUtil {
//
//	//일반 문자열을 -> 서식이 있는 문자열로 변환 해주는 메서드
//	public String markdown(String markdown) {
//		
//		//변환해주는 파스 (org.commonmark.parser.Parser) 개체
//		Parser parser = Parser.builder().build();
//		//get set 생성
//		
//		//파싱하자
//		Node document = parser.parse(markdown);
//		
//		//문자열(String)을 돌려서 리턴해준다.
//		HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();
//		return htmlRenderer.render(document);
//	}
//	
//}//class

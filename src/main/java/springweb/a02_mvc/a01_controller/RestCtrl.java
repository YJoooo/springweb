package springweb.a02_mvc.a01_controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import springweb.a02_mvc.a04_vo.Dept;
// 리턴내용이 문자열이나 json문자열 데이터를 처리해주는 ajax활용시,
// 주로 활용된다.
@RestController
public class RestCtrl {
	// http://localhost:7080/springweb/callRest.do
	@RequestMapping(value="callRest.do",produces="text/plain;charset=UTF-8")
	public String callDept() {
		
		return "안녕";
	}
	// new Dept(10,"인사","서울")
	// http://localhost:7080/springweb/callRest2.do
	@RequestMapping(value="callRest2.do",produces="text/plain;charset=UTF-8")
	public String callDept2() {
		// Gson : 객체 ==> 문자열 json 변경
		Gson g = new Gson();
		
		
		return g.toJson(new Dept(10,"인사","서울"));
	}	
	
}

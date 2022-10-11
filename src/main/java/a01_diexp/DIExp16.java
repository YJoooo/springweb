package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Computer;

public class DIExp16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp\\di16.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		Computer com = ctx.getBean("com",Computer.class);
		System.out.println(com);
		com.checkComInfo();
		ctx.close();

/*
ex)  Cpu 사양, 제조사 Computer 종류(조립식/데스크탑/노트북), Cpu checkComInfo()
	1:1관계
 */
	}

}

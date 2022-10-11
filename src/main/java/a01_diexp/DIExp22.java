package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z03_vo.HandPhone;
import a01_diexp.z03_vo.Hperson;

public class DIExp22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp\\di22.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency lookup)으로 id 명으로 객체를 가져온다.
		HandPhone handPhone = ctx.getBean("hp",HandPhone.class);
		System.out.println(handPhone);
		handPhone.setCompany("삼성");
		handPhone.setHnumber("010-1234-1234");
		Hperson hperson = ctx.getBean("hps",Hperson.class);
		hperson.setName("홍길동");
		// 설정된 내용을 객체들 간에 자동 autowiring이 안되어 있기에
		// 직접적으로 코드를 통해 처리하여야 한다.
		hperson.setHandphone(handPhone);
		System.out.println(hperson);
		hperson.myHandphone();
		ctx.close();
				
	}

}

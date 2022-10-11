package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z05_vo.Car;
import a01_diexp.z05_vo.CarRacer;

public class DIExp24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp\\di24.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency lookup)으로 id 명으로 객체를 가져온다.
		//Car c01 = ctx.getBean("c01",Car.class);
		//System.out.println(c01);
		//c01.setName("람보르기니");
		//c01.setMaxspeed(300);
		
		CarRacer cr01 = ctx.getBean("cr01",CarRacer.class);
		System.out.println(cr01);
		cr01.setRname("김연주");
		cr01.driving();
		ctx.close();
		/*
		ex) a01_diexp.z05_vo / Car, CarRacer가 autowiring 되게 처리하세요.
		 */
				
	}

}

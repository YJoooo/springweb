package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.CarRacer;
import a01_diexp.z01_vo.Hperson;

public class DIExp17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp\\di17.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		Hperson hperson = ctx.getBean("hperson",Hperson.class);
		System.out.println(hperson);
		hperson.myHandphone();
		CarRacer carracer = ctx.getBean("carracer",CarRacer.class);
		System.out.println(carracer);
		carracer.driving();
		ctx.close();
	}

}

package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z02_vo.Cpu;
import a01_diexp.z02_vo.Person;

public class DIExp21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp\\di21.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency lookup)으로 id 명으로 객체를 가져온다.
		Person person = ctx.getBean("person",Person.class);
		Cpu cpu = ctx.getBean("cpu",Cpu.class);
		System.out.println(person);
		System.out.println(cpu);
		ctx.close();
		/*
		ex) a01_diexp.z03_vo 패키지 생성,
			클래스 copy 생성하고 @Component 선언
			DIExp22.java
			di22.xml
		 */
				
	}

}

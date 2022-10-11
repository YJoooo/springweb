package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Person;

public class DIExp11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp\\di11.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency lookup)으로 id 명으로 객체를 가져온다.
		Person obj = ctx.getBean("p01",Person.class);
		System.out.println(obj);
		System.out.println(obj.getName());
		System.out.println(obj.getAge());
		System.out.println(obj.getLoc());
		Person person = ctx.getBean("person",Person.class);
		System.out.println(person);
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getLoc());
		// Person
		ctx.close();
		//ex) DIExp12,java, d12.xml 생성
		//		Product vo 생성 물건명 가격 갯수 선언 xml에 property로 할당 출력..
		
	}

}

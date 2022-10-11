package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Person;
import a01_diexp.z01_vo.Product;


public class DIExp12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp\\di12.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		Product prod = ctx.getBean("prod",Product.class);
		Person p01=ctx.getBean("p01",Person.class);
		System.out.println(prod);
		System.out.println(p01);
		System.out.println(prod.getPname());
		System.out.println(prod.getPrice());
		System.out.println(prod.getCnt());
		System.out.println(p01.getName());
		System.out.println(p01.getAge());
		System.out.println(p01.getLoc());
		Person p02 = ctx.getBean("p02", Person.class);
		System.out.println("p02:"+p02);
		System.out.println(p02.getName());
		System.out.println(p02.getAge());
		System.out.println(p02.getLoc());
		ctx.close();
		
	}

}

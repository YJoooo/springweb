package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z04_vo.Mart;
import a01_diexp.z04_vo.Product;

public class DIExp23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp\\di23.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency lookup)으로 id 명으로 객체를 가져온다.
		Product prod = ctx.getBean("prod",Product.class);
		prod.setPname("사과");
		prod.setPrice(500);
		prod.setCnt(15);
		Mart obj = ctx.getBean("mart01",Mart.class);
		obj.setName("이마트");
		obj.shopping();
		System.out.println(obj);
		ctx.close();
				
	}

}

package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Music;

public class DIExp13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp\\di13.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		Music m01 = ctx.getBean("m01",Music.class);
		Music m02 = ctx.getBean("m02",Music.class);
		/*
		ex) Music 음악제목 가수  m01(property로 설정), m02(생성자로 설정)해서,
		xml로 객체 생성 할당하고, main()에서 호출하여 출력하세요.
		
		 */
		System.out.println(m01);
		System.out.println(m01.getMname());
		System.out.println(m01.getSinger());
		System.out.println(m01);
		System.out.println(m02);
		System.out.println(m02.getMname());
		System.out.println(m02.getSinger());
		ctx.close();
				
	}

}

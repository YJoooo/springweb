package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Mart;
import a01_diexp.z01_vo.Note;
import a01_diexp.z01_vo.ParkPerson;

public class DIExp20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp\\di20.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency loopup)으로 id 명으로 객체를 가져온다.
		ParkPerson parkPerson = ctx.getBean("parkPerson",ParkPerson.class);
		System.out.println(parkPerson);
		parkPerson.going();
		Mart mart = ctx.getBean("mart",Mart.class);
		System.out.println(mart);
		mart.shopping();
		Note note=ctx.getBean("note",Note.class);
		System.out.println(note);
		note.wirte();
		ctx.close();
				
	}

}

package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z10_vo.Music;
import a01_diexp.z10_vo.Paper;
import a01_diexp.z10_vo.Pen;

public class DIExp27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="a01_diexp\\di27.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(path);
		// DL(dependency lookup)으로 id 명으로 객체를 가져온다.
		/*
		[1단계:확인] 2. 스프링 컨테이너에 z10_vo 패키지에 클래스를 등록하여, 1:1연관관계가 있는 펜과 종이 객체를 선언하고,
	      코드상 자동 설정관계가 있게 처리하고 호출하세요
	      
	      [1단계:확인] 3. 공통 설정 파일을 java 폴드 밑에 msg/msg01로 설정하고, 좋아하는 음악, 가수를 설정하고,
	            이를 vo로 만들어 호출되게 처리하여 출력결과를 확인하세요.
	    */
		Pen pen = ctx.getBean("pen",Pen.class);
		System.out.println(pen);
		pen.setKind("색연필");
		pen.setPrice(7000);
		pen.setColor("노란색");
		Paper paper = ctx.getBean("paper",Paper.class);
		System.out.println(paper);
		paper.setSize("A4");
		paper.write();
		Music music = ctx.getBean("music",Music.class);
		System.out.println(music.getMname());
		System.out.println(music.getSinger());
		music.song();
		ctx.close();
				
	}

}

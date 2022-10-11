package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.y01_dao.PrjDao;
import springweb.z01_vo.Emp;
import springweb.z01_vo.Product;
//springweb.a01_start.A01_StartController
@Controller
public class A01_StartController {
	// http://localhost:7080/springweb/start.do
	@RequestMapping("/start.do")
	public String start(){
		// 처리할 controller 내용.
				
		return "WEB-INF/views/a01_startView.jsp";
	}	
// ex) A02_SecondController.java
//		WEB-INF/views/a02_View.jsp	
//		http://localhost:7080/springweb/second.do
	// http://localhost:7080/springweb/call01.do?name=홍길동&age=25
	// 요청값 처리
	@RequestMapping("call01.do")
	public String call01(
				@RequestParam("name") String name,
				@RequestParam("age") int age
			
			) {
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
		return"";
		
	}
	//ex) /call02.do?pname=사과&price=12000&cnt=2
	//	console에 물건명 가격 갯수를 출력되게 하세요.
	//http://localhost:7080/springweb/call02.do
		//http://localhost:7080/springweb/call02.do?pname=사과&price=12000&cnt=2 
		@RequestMapping("call02.do")
		public String call02(@RequestParam(value="pname",defaultValue = "") String pname,
					@RequestParam(value="price", defaultValue = "0") int price,
					@RequestParam(value="cnt", defaultValue = "0") int cnt,
					Model d
				) {
			System.out.println("물건명 : "+pname);
			System.out.println("가격 : "+price);
			System.out.println("갯수 : "+cnt);
			//모델 설정
			d.addAttribute("buyInfo", new Product(pname, price, cnt));
			//				Product buyInfor=new Product(pname, price, cnt);
			//				buyInfo.getPname(), buyInfo.getPrice(),buyInfo.getCnt()
			// view - ${buyInfo.pname} ${buyInfo.price} ${buyInfo.cnt}
			return "WEB-INF\\views\\a01_basic\\a01_product.jsp"; // 리턴값 공백시 초기화면으로 이동

		}
		// http://localhost:7080/springweb/call03.do
		//화면은 입력 좋아하는 운동선수 : [	], 성적:[	] [데이터 입력]
		// 입력 버튼 클릭시, 하단에 입력된 정보 출력.
		// a02_player.jsp
		//http://localhost:7080/springweb/call03.do
		@RequestMapping("/call03.do")
		public String call03(@RequestParam(value="name",defaultValue = "") String name,
				@RequestParam(value="point",defaultValue = "0.0") double point,
				Model d
					) {
			System.out.println("운동선수 : "+name);
			System.out.println("점수 : "+point);
			d.addAttribute("playerInfo", "이름은"+name+", 성적은"+point);
			// ${playerInfo}
			return "WEB-INF\\views\\a01_basic\\a02_player.jsp";
		}
		// 객체로 요청값 처리 : usebean property 개념으로 처리가 가능
		// http://localhost:7080/springweb/empList.do
		// http://localhost:7080/springweb/empList.do?ename=홍길동&job=사원
		@RequestMapping("/empList.do")
		public String empList(Emp sch, Model d) { // Emp setEname(), setJob()
			System.out.println("사원명:"+sch.getEname());
			System.out.println("직책명:"+sch.getJob());
			d.addAttribute("emplist", new PrjDao().getEmpList2(sch));
			return "WEB-INF\\views\\a01_basic\\a06_empList.jsp";
		}         
	
}

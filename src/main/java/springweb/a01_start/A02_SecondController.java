package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//springweb.a01_start.A02_SecondController
@Controller
public class A02_SecondController {
	//http://localhost:7080/springweb/second.do
	@RequestMapping("second.do")
	public String second(){
				
		return "WEB-INF\\views\\a02_View.jsp";
	}
	
}

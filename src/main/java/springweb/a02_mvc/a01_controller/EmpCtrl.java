package springweb.a02_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a02_mvc.a02_service.EmpService;
import springweb.a02_mvc.a04_vo.Emp;

@Controller
@RequestMapping("emp.do")
public class EmpCtrl {
	@Autowired(required = false)
	private EmpService service;
	 // http://localhost:7080/springweb/emp.do?method=list
	 @RequestMapping(params="method=list")
	public String empList(Emp sch, Model d) {
		d.addAttribute("empList", service.getEmpList(sch));
		return"WEB-INF\\views\\a02_mvc\\a01_empList.jsp";
	}
	 // http://localhost:7080/springweb/emp.do?method=detail&empno7496
	 @RequestMapping(params="method=detail")
	 public String detail(@RequestParam("no") int empno, Model d){
	 	d.addAttribute("emp", service.getDetail(empno));
	 	return"WEB-INF\\views\\a02_mvc\\a06_empDetail.jsp";
	 }	
	 // http://localhost:7080/springweb/emp.do?method=update
	 @RequestMapping(params="method=update")
	 public String update(Emp upt, Model d){
		 	service.updateEmp(upt);
		 	d.addAttribute("emp", service.getDetail(upt.getEmpno()));
		 	d.addAttribute("proc","upt");
	 	return "WEB-INF\\views\\a02_mvc\\a06_empDetail.jsp";
	 }	
	 // http://localhost:7080/springweb/emp.do?method=delete
	 @RequestMapping(params="method=delete")
	 public String delete(@RequestParam("empno") int empno,Model d){
		 	d.addAttribute("proc","del");
	 	return"WEB-INF\\views\\a02_mvc\\a06_empDetail.jsp";
	 }

}

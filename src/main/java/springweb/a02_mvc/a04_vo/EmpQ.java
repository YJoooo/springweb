package springweb.a02_mvc.a04_vo;
// springweb.a02_mvc.a04_vo.EmpQ
import java.util.Date;

public class EmpQ {
	private int empno;
	private String ename;
	private String div;
	private Date hiredate;
	public EmpQ() {
		// TODO Auto-generated constructor stub
	}
	public EmpQ(int empno, String ename, String div, Date hiredate) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.div = div;
		this.hiredate = hiredate;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

}

package springweb.z01_vo;

import java.util.Date;

public class Emp {
	// sql 결과에 맞게 데이터 유형과 속성을 지정한다.
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private String Hiredate_s;
	private double sal;
	private double comm;
	private int deptno;
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	
	// where 조건문을 검색하기 위해
	public Emp(String ename, String job) {
		super();
		this.ename = ename;
		this.job = job;
	}
	// insert 구문에 데이터를 입력하는 객체를 생성
	public Emp(int empno, String ename, String job, int mgr, String Hiredate_s, double sal, double comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.Hiredate_s = Hiredate_s;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	public Emp(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getHiredate_s() {
		return Hiredate_s;
	}
	public void setHiredate_s(String Hiredate_s) {
		this.Hiredate_s = Hiredate_s;
	}
	
}

package springweb.a02_mvc.a04_vo;

import java.util.Date;

public class Emp {
	// sql 결과에 맞게 데이터 유형과 속성을 지정한다.
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private String hiredate_s;
	private double sal;
	private double comm;
	private int deptno;
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	public Emp(String ename, String job, double sal){
		this.ename=ename;
		this.job=job;
		this.sal=sal;
	}
	public Emp(int empno, String ename, String job){
		this.empno=empno;
		this.ename=ename;
		this.job=job;
		
	}
	public Emp(String ename, int mgr, double sal, int empno){
		this.ename = ename;
		this.mgr = mgr;
		this.sal = sal;
		this.empno = empno;
		
	}

	
	// where 조건문을 검색하기 위해
	public Emp(String ename, String job) {
		super();
		this.ename = ename;
		this.job = job;
	}
	// insert 구문에 데이터를 입력하는 객체를 생성
	public Emp(int empno, String ename, String job, int mgr, String hiredate_s, double sal, double comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate_s = hiredate_s;
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
	public String gethiredate_s() {
		return hiredate_s;
	}
	public void sethiredate_s(String hiredate_s) {
		this.hiredate_s = hiredate_s;
	}
	
}

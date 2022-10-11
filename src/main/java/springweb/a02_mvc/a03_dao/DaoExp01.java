package springweb.a02_mvc.a03_dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import springweb.a02_mvc.a04_vo.Dept;
import springweb.a02_mvc.a04_vo.DeptEmp01;
import springweb.a02_mvc.a04_vo.DeptMsal;
import springweb.a02_mvc.a04_vo.Emp;
import springweb.a02_mvc.a04_vo.EmpQ;
import springweb.a02_mvc.a04_vo.Salgrade;
//springweb.a02_mvc.a03_dao.DaoExp01
@Repository
public interface DaoExp01 {
	public int getEmpCount();
/*
SELECT sal
FROM emp
WHERE empno=7369;

SELECT sum(sal)
FROM emp
WHERE detpno=10;


SELECT job
from emp
where empno=7499; 

select count(*)
from emp
where empno=7369;

메서드 3개 추가 mapper에서 선언처리

*/

	public int getEmpsal();
	public int getEmpsumsal();
	public String getEmpjob();
	public boolean hasEmp();
	public DeptEmp01 getDeptEmp();
	public Salgrade getSalgrade();
	
	public List<String> getEnames();
	public List<Integer> getEmpnos();
	public List<Double> getSalaries();
	public List<String> getJobs();
	public List<Emp> getEmpList30();
	public List<Emp> getmaxdate();
	public List<Emp> getmaxsal();
	public List<Emp> getbetweensal();
	public List<Emp> getQdate();
	public List<Emp> getavgsal();
	
	public List<EmpQ> getEmplList();
	//0711
	public Emp getDetail(int empno);
	public void deleteEmp(String job);
	public List<Emp> getEmpJob(String job);
	public void deleteQua(String div);
	public DeptMsal getDeptMaxSal(int deptno);
	public List<Emp> schEmpList02(Emp sch);
	public void insertEmp02(Emp ins);
	public void updateEmp02(Emp upt);	
	public void insertDept(Dept ins);
	public List<Emp> getEmpList2(Map<String,String> map);
	public List<Dept> getDeptList(Map map);

	//0711과제
	public Emp getAvgSalJob(String job);
	public List<Emp> getSalSch(Map map);
	public void insertSalgrade(Salgrade ins);
	
	//0713
	public void deleteEmp(int empno);
}
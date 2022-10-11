package springweb.a02_mvc.a02_service;
//springweb.a02_mvc.a02_service.EmpService
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a02_mvc.a03_dao.DaoExp01;
import springweb.a02_mvc.a03_dao.EmpDao;
import springweb.a02_mvc.a04_vo.Dept;
import springweb.a02_mvc.a04_vo.DeptMsal;
import springweb.a02_mvc.a04_vo.Emp;

@Service
public class EmpService {
	@Autowired(required = false)
	private EmpDao dao;
	
	@Autowired(required=false)
	private DaoExp01 dao2;
	
	public List<Emp> getEmpList(Emp sch){
		/*
		System.out.println("사원번호가 있는지?"+dao2.hasEmp());
		// mybatis 
		// dao2 = new DaoExp01Imple();
		DeptEmp01 de = dao2.getDeptEmp();
		System.out.println("객체 생성 여부:"+de);
		System.out.println("사원명:"+de.getEname());
		System.out.println("부서번호:"+de.getDname());
		Salgrade salg = dao2.getSalgrade();
		System.out.println("급여등급");
		System.out.println(salg.getGrade());
		System.out.println(salg.getHisal());
		System.out.println(salg.getLosal());
		
		System.out.println("# 다중행데이터 확인 #");
		System.out.println(dao2.getEmpnos().get(0)+"사원정보 갯수:"+dao2.getEmpnos().size());
		System.out.println(dao2.getEnames().get(1)+"사원명 갯수:"+dao2.getEnames().size());
		System.out.println(dao2.getSalaries().get(2)+"급여 갯수:"+dao2.getSalaries().size());
		
		System.out.println(dao2.getJobs().size()+":"+dao2.getJobs().get(0));	
		System.out.println("# 다중 열/다중행 데이터 확인 #");
		System.out.println(dao2.getEmpList30().size());
		
		System.out.println("#과제#");
		System.out.println(dao2.getmaxdate().get(0));
		System.out.println(dao2.getmaxsal().size());
		System.out.println(dao2.getbetweensal().size());
		System.out.println(dao2.getQdate().size());
		System.out.println(dao2.getavgsal().size());
		//0711
		Emp emp = dao2.getDetail(7369);
		if(emp!=null)
			System.out.println("사원명:"+emp.getEname());
		System.out.println("사원명:"+emp.getEname());
		System.out.println("#사원 정보 삭제#");
		dao2.deleteEmp("사원");
		List<Emp> jobList=dao2.getEmpJob("관리자");
		System.out.println("관리자 데이터 건수:" + jobList.size());		
		System.out.println("1/4분기 데이터 삭제");
		dao2.deleteQua("1");
		DeptMsal mxsal = dao2.getDeptMaxSal(10);
		if(mxsal!=null)
		System.out.println("10번부서의 최고급여:"+mxsal.getMsal());
		List<Emp> emschList=dao2.schEmpList02(new Emp("CLARK","MANAGER",2450));
		if(emschList!=null && emschList.size()>0){
			System.out.println("사원정보 검색 건수 : "+emschList.size());
		}
		System.out.println("#사원 정보 등록#");
		dao2.insertEmp02(new Emp(9999,"홍길동","대리"));
		System.out.println("#사원 정보 수정#");
		dao2.updateEmp02(new Emp("홍길동(변경)",5555,3333,7566));
		System.out.println("부서정보 등록");
		dao2.insertDept(new Dept(99,"기획","서울홍대"));			
		Map<String,String> schMap = new HashMap<String,String>();
		schMap.put("ename","A");
		schMap.put("job","MAN");
		List<Emp> emplist2 = dao2.getEmpList2(schMap);
		System.out.println("사원정보조회(Map활용):"+emplist2.size());		
		Map<String,String> dsch = new HashMap<String,String>();
		dsch.put("dname","A");
		dsch.put("loc","O");
		System.out.println("부서정보(map):"+dao2.getDeptList(dsch).size());	
  		Emp jobEmp = dao2.getAvgSalJob("MANAGER");
  		if(jobEmp!=null) System.out.println(jobEmp.getJob()+":"+
  			jobEmp.getSal());
  		Map<String, Double> salmap = new HashMap<String,Double>();
  		salmap.put("start",1000.0);	// boxing 처리는 promote 처리 (x)
  		salmap.put("end",3000.0);
  	    System.out.println("검색된 사원의 건수(1000~3000)"+dao2.getSalSch(salmap).size());
  	    System.out.println("#사원 정보 등록#");
		dao2.insertSalgrade(new Salgrade(7,5001,6000));
		*/
		return dao.getEmpList(sch);
	}

	public List<Emp> getEmpJob(String job){
		return dao2.getEmpJob(job);
	}
	public Emp getAvgSalJob(String job) {
		return dao2.getAvgSalJob(job);
	}
	public DeptMsal getDeptMaxsal(int deptno) {
		return dao2.getDeptMaxSal(deptno);
	}
	public Emp getDetail(int empno){
		return dao.getDetail(empno);
	}
	public void updateEmp(Emp upt){
		dao.updateEmp(upt);
	}
	public void deleteEmp(int empno){
		dao.deleteEmp(empno);
	}
	public List<Dept> getDeptList(Map map) {
		return dao2.getDeptList(map);
	}

	
}

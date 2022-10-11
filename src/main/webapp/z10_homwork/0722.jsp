<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--
07-22
[1단계:개념] 1. 페이징 처리의 기본속성을 처리하는 순서를 기술하고, 해당 속성이 처리되는 형식을 표기하세요.
	sql
	dao
	mapper
	vo
	service
	view
[1단계:개념] 2. 페이지 처리시 default 설정이 필요한 속성과 이유를 기술하세요.
	초기에 화면은 0으로 처리되기에 default 값을 1로 처리한다.
		if(sch.getCurPage()==0) {
			sch.setCurPage(1);
		}
[1단계:개념] 3. 페이지 처리에 있어 예외적인 데이터로 인해 조건 처리하는 내용을 기술하세요.
	마지막번호 5개씩 페이징 되는 번호가 총데이터가 들어갈 번호보다 크면
	int end = sch.getCurPage()*sch.getPageSize();
	if(end>=sch.getCount()) {
		sch.setEnd(sch.getCount());
	}else {
		sch.setEnd(end);
	}
	
[1단계:개념] 4. 페이지 처리에 화면단 요청값에 대한 처리 내용과 방법을 기술하세요.
선언한 한번에 보여줄 데이터 건수(요청값)
[1단계:개념] 5. fullcalendar api의 환경 설정 순서를 기술하세요.
	라이브러리 파일 다운받기
	jsp에 view단 설정
      events: function(info, successCallback, failureCallback{
   	// http://localhost:7080/springweb/calList.do callist
   	 $.ajax({
   		type:"post",
   		url:"${path}/calList.do",
   		dataType:"json",
   		success:function(data){
   			console.log(data.callist)
   			successCallback(data.callist)
   		},
   		error:function(err){
   			console.log(err)
   		}
   	 }); 
     }
   });
   테이블 생성
	model단
	controller
	view단
[1단계:확인] 6. emp 테이블의 list를 ajax 데이터로 가져오는 추가 controller를 선언하고 출력하세요.
	# json 데이터 DB 저장 및 화면 호출 하기
	1. jquery lib 안에 json에 있는 데이터 DB에 저장, 저장 후, controller단에 호출해서 출력 처리
		처리
		[
		 {
		  title: 'Conference',
		  start: '2020-09-11',
		  end : '2020-09-13'
		  }]
		==> 
		create table calendar(
			title varchar2(100),
			start 01 varchar2(50), -- start는 oracle 내장키워드 컬럼명 사용 불가
			end01 varchar2(50),
			allDay number(1) -- 0일때는 true, 1일때는 false로 자동 변환
		);
		# 컬럼명과 property가 다른 경우에는 resultMap을 이용해서 다른 컬럼명과 property를 설정하여 처리한다.
		<resultMap type="calendar" id="calResult">
			<result column="start1" property="start"/>
			<result column="end1" property="end"/>
		</resultMap>
		
			  
	2. controller로 통해서 나오는 json데이터를 ajax를 통해서 접근하고 lib와 함께 화면에 효과적으로 처리를 한다.
	# 처리 순서
	1. DB 구성
		0) json 데이터 확인 및 테이블 컬럼명 및 속성값 결정
		1) 테이블 생성 / 샘플데이터 입력
		2) sql 작성 : 사용할 json 데이터를 로딩할 내용 기준
		3) vo 생성 : property와 column 구분하여 생성
		4) dao/mapper 생성
		5) service
	2. controller단 호출
		1) 초기화면 호출	
		2) 호출할 때, 처리하는 json데이터를 출력할 controller 생성
	3. view단
		1) jquery ajax 호출 및 출력
				
 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
   td{text-align:center;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
   $(document).ready(function(){
      <%-- 
      
      --%>   
   });
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">타이틀</h2>

</div>
<div class="container">
   <form id="frm01" class="form-inline"  method="post">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
       <input class="form-control mr-sm-2" placeholder="제목" />
       <input class="form-control mr-sm-2" placeholder="내용" />
       <button class="btn btn-info" type="submit">Search</button>
    </nav>
   </form>
   <table class="table table-hover table-striped">
      <col width="10%">
      <col width="50%">
      <col width="15%">
      <col width="15%">
      <col width="10%">
    <thead>
    
      <tr class="table-success text-center">
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회</th>
      </tr>
    </thead>   
    <tbody>
       <tr><td></td><td></td><td></td><td></td><td></td></tr>
       <tr><td></td><td></td><td></td><td></td><td></td></tr>
       <tr><td></td><td></td><td></td><td></td><td></td></tr>
    </tbody>
   </table>    
    
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">타이틀</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form id="frm02" class="form"  method="post">
        <div class="row">
         <div class="col">
           <input type="text" class="form-control" placeholder="사원명 입력" name="ename">
         </div>
         <div class="col">
           <input type="text" class="form-control" placeholder="직책명 입력" name="job">
         </div>
        </div>
       </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>
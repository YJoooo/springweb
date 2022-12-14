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
  <h2>사원정보 상세(${emp.empno})</h2>

</div>
<div class="container">
   <form id="frm01" class="form"  method="post">
   	<div class="input-group mb-3">
            <div class="input-group-prepend">
	            <span class="text-center input-group-text">사원번호</span>
	         </div>
	         <input name="empno" class="form-control" 
	            value="${emp.empno}" readonly/>
         <div class="input-group-prepend">
            <span class="text-center input-group-text">관리자번호</span>
         </div>
         <input name="mgr" class="form-control" 
            value="${emp.mgr}"/>   
      </div>
      
      <div class="input-group mb-3">
         <div class="input-group-prepend">
            <span class="text-center input-group-text">사원명</span>
         </div>
         <input name="ename" class="form-control" 
            value="${emp.ename}" /> 
         <div class="input-group-prepend">
            <span class="text-center input-group-text">직책명</span>
         </div>
         <input name="job" class="form-control" 
            value="${emp.job}"/>     
      	</div>
         <div class="input-group mb-3">
            <div class="input-group-prepend">
	            <span class="text-center input-group-text">급여</span>
	         </div>
	         <input name="sal" class="form-control" 
	            value="${emp.sal}" />
	                   <div class="input-group-prepend">
	            <span class="text-center input-group-text">보너스</span>
	         </div>
	         <input name="comm" class="form-control" 
	            value="${emp.comm}" />   
	            
	      <div class="input-group mb-3">          
         <div class="input-group-prepend">
            <span class="text-center input-group-text">입사일</span>
         </div>
         <input name="hiredate_s" class="form-control" 
           value= '<fmt:formatDate value="${emp.hiredate}" pattern="yyyy-MM-dd" />'/>   
      </div>
         <div class="input-group-prepend">
            <span class="text-center input-group-text">부서번호</span>
         </div>
         <input name="deptno" class="form-control" 
            value="${emp.deptno}" />
      </div>
	        
      <div class="text-right">
      	<button type="button" onclick="updateProc()" class="btn btn-success">수정</button>
      	<button type="button" onclick="deleteProc()" class="btn btn-danger">삭제</button>
      	<button type="button" onclick="goMain()" class="btn btn-info">메인화면</button>
      </div>
   </form>
</div>
<script>
function updateProc(){
	if(confirm("수정하시겠습니까")){
		$("form").attr("action","$(path}/emp.do?method=update");
		$("form").submit();
	}
}
function deleteProc(){
	var no = $("[name=empno]").val()
	if(confirm("삭제하시겠습니까?"){
		location.href="${path}/emp.do?method=delete&empno="+empno;
	}
}
var proc = "${proc}"
	if(proc=="upt"){
		if(confirm("수정완료!\n조회화면으로 이동하시겠습니까?")){
			location.href="${path}/emp.do?method=list";
		}
	}
	if(proc=="del"){
		alert("삭제완료\n조회화면으로 이동합니다.");
		location.href="${path}/emp.do?method=list;
	}
function goMain(){
	locatkon.href="${path}/emp.do?method=list";
}	
</script>
</body>
</html>
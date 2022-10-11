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
	   var hi01 = $("#hi01").html()
	   alert("hi01"+hi01)
	});
   $(document).ready(function(){
	   var hi02 = $("#hi02").text()
	   alert("hi02"+hi02)
	});
   $(document).ready(function(){
	   var hi03 = $("#hi03").val()
	   alert("hi03"+hi03)
	});
   // 8. json 형식으로 운동선수이름, 팀, 성적을 선언하고, [성적표시] 클릭시, 테이블에 데이터가 출력되게 하세요
</script>
</head>

<body>
<div style="text-align:center">
<h2 id="hi01">안녕하세요1</h2>
<h2 id="hi02">안녕하세요2</h2>
<input id="hi03" type="text" value="안녕하세요3">
</div>
</body>
</html>
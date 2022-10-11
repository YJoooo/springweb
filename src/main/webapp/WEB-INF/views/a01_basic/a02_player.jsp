<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
  	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<fmt:requestEncoding value="UTF-8"/>              
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/a00_com\a01_common.css" rel="stylesheet">
<style>

</style>
<script src="${path}/a00_com/jquery-3.6.0.js" type="text/javascript"></script>
<script>
	/*
	
	*/
	$(document).ready(function(){
		//$("h1").text("시작!");
	});
</script>
</head>
<body>
<%--

--%>
<h1>운동선수 정보</h1>

<div class="container">
  <form method="post"><!-- url로 요청값이 나타나지 않게 처리 -->
  <div class="row">
    <div class="col-25">
      <label for="name">운동선수</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value="" placeholder="">
    </div>
  </div>
  <div class="row">
  <div class="col-25">
      <label for="point">성적</label>
    </div>
    <div class="col-75">
      <input type="text" id="point" name="point" value="" placeholder="">
    </div>
  </div>
  <div class="row">
    <input type="submit" value="데이터입력">
  </div>
  </form>
</div>
<table>
	<tr><th>${playerInfo}</th></tr>
</table>
</body>
</html>
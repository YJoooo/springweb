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
      # 객체형 배열 처리
      1. v-for = "(단위 객체, index) in 객체형배열"
      		{{단위객체.속성1}} {{단위객체.속성2}} {{단위객체.속성3}}
      --%> 
      var vm = new Vue({
          el:".container",
          data:{msg:"객체형 배열 처리",
        	  plist:[
            	  {name:"사과",price:3000, cnt:2},
            	  {name:"바나나",price:4000, cnt:3},
            	  {name:"딸기",price:12000, cnt:4}
              ],
              bbGame:[
            	  {tname:"ssg",game:"144",w:"67",l:"30",tie:"3",rate:"0.691"},
            	  {tname:"lg",game:"144",w:"59",l:"38",tie:"1",rate:"0.608"},
            	  {tname:"키움",game:"144",w:"59",l:"40",tie:"2",rate:"0.596"}
              ]
          }
      }) 
      // ex) 프로야구 팀 순위 검색해서 팀명 게임수 승 패 무 승률
      //	내용을 선언한 객체형 배열을 모델 데이터를 선언하고, 테이블에 출력되게 처리하세요.
      
      <%--
    <tbody>
       <tr v-for="(prod, idx) in plist">
       		<td>{{idx+1}}</td>
       		<td>{{prod.name}}</td>
       		<td>{{prod.price}}</td>
       		<td>{{prod.cnt}}</td>
       		<td>{{prod.price*prod.cnt}}</td>
	   </tr>
    </tbody>
      
       --%>
   });
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">타이틀</h2>

</div>
<div class="container">
   <h3 align="center">{{msg}}</h3>
   <form id="frm01" class="form"  method="post">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
       <input class="form-control mr-sm-2" placeholder="제목" />
       <input class="form-control mr-sm-2" placeholder="내용" />
       <button class="btn btn-info" type="submit">Search</button>
    </nav>
   </form>
   <table class="table table-hover table-striped">
      <col width="20%">
      <col width="20%">
      <col width="20%">
      <col width="20%">
      <col width="20%">
    <thead>
    
      <tr class="table-success text-center">
        <th>번호</th>
        <th>물건명</th>
        <th>가격</th>
        <th>갯수</th>
        <th>계</th>
      </tr>
    </thead>   
    <tbody>
       <tr v-for="(prod, idx) in plist">
       		<td>{{idx+1}}</td>
       		<td>{{prod.name}}</td>
       		<td>{{prod.price}}</td>
       		<td>{{prod.cnt}}</td>
       		<td>{{prod.price*prod.cnt}}</td>
	   </tr>
    </tbody>
   </table>    
   <table class="table table-hover table-striped">
      <col width="20%">
      <col width="15%">
      <col width="15%">
      <col width="15%">
      <col width="15%">
      <col width="20%">
    <thead>
    
      <tr class="table-success text-center">
        <th>팀명</th>
        <th>게임수</th>
        <th>승</th>
        <th>패</th>
        <th>무</th>
        <th>승률</th>
      </tr>
    </thead>   
    <tbody>
       <tr v-for="(team, idx) in bbGame">
       		<td>{{team.tname}}</td>
       		<td>{{team.game}}</td>
       		<td>{{team.w}}</td>
       		<td>{{team.l}}</td>
       		<td>{{team.tie}}</td>
       		<td>{{team.rate}}</td>
	   </tr>
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
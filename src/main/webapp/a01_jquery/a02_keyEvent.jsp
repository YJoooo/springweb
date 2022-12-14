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
      # 키이벤트
      1. DOM객체에서 key를 입력할 때, 처리되는 이벤트이다.
      2. 자판에는 고유의 코드값을 가지고 있다.
      3. $("선택자").keyup(익명함수) : 해당 요소객체에 key를 입력이 완료
      --%>   
      $("[name=str01]").keyup(function(){
    	  var str= $(this).val()
    	 $("h2").text(str+"의 코드값:"+event.keyCode) 
    	 $(this).val("")
      });
     $("[name=id]").keyup(function(){
    	 if(event.keyCode==13){ // 입력후, enter키를 누를때
    		 var idVal = $(this).val() // 입력된 값
    		 // 입력된 길이가 4~8사이 일때
    		 if(idVal.length>=4 && idVal.length<=8){
    			 // 선택자에 의해서 문자열 표시 및 색상 처리
    			 $("span").text("유효한 아이디 입니다.").css("color","blue")
    		 }else{
    			 $("span").text("아이디 입력범위는(4~8)입니다.").css("color","red")
    		 }
    	 } 
      });
      // ex) [  0  ]X [  0  ]	입력 후, enter키를 입력시 하단에 결과를 출력
      // 	@@ X @@ = @@@
      $(".cal").keyup(function(){
    	 if(event.keyCode==13){
    		 var num01Val = $("[name=num01]").val()
    		 var num02Val = $("[name=num02]").val()
    		 $("#show").text(num01Val+"X"+num02Val+"="+(num01Val*num02Val))
    	 } 
      });
   		// 주요 이벤트
   		// mouseover/mouseout
   		$("h2").mouseover(function(){
   			$(this).css("background-color","yellow")
   		});
   		$("h2").mouseout(function(){
   	   		$(this).css("background-color","blue")
   	   	});
      	// hover(function(){마우스 오버시}, function(){마우스 아웃시})
      	$("[anme=num01]").hover(function(){
      		$(this).css("background-color","red");
   		},function(){
      		$(this).css("background-color","orange")
      	});
      	// # focus() : 해당 요소객체에 focus했을 때.
      	$("[name=num02]").focus(function(){
      		$(this).css("background-color","yellow");
      		$(this).val("")
      	});
      	// # hide()/show()
      	$("[name=str01]").hover(function(){
      		$("h2").hide();
      	},function(){
      		$("h2").show();
      	});
      	// # change() 요소객체의 값이 변경이 될때, 처리하는 이벤트.
      	// $("select").change(function(){})
   });
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>키이벤트</h2>
  이름을 입력:<input name="str01"/><br>
  아이디 입력:<input name="id"/><span></span><br>
  <input name="num01" class="cal" value="0" size="2">X
  <input name="num02" class="cal" value="0" size="2"><br>
  
  <span id="show"></span>

</div>
<div class="container">
   <form id="frm01" class="form-inline"  method="post">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
       <input class="form-control mr-sm-2" placeholder="제목" />
       <input class="form-control mr-sm-2" placeholder="내용" />
       <select name="sel01" class="form-control mr-sm-2" >
       	<option value="7800">관리자</option>
       	<option value="7801">과장</option>
       	<option value="7802">차장</option>
       	<option value="7803">부장</option>
       </select>
       <script>
       	$('[name=sel01]').change(function(){
       		//$(this).val()
       		$("h6").text("선택된 값:"+$(this).val());
       	});
       </script>
       <button class="btn btn-info" type="submit">Search</button>
    </nav>
    <h6></h6>
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
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
# jquery ajax 통신 속성
1. 기본형식
	$.ajax({속성:속성값,.....})
	1) url : 요청 주소 - url mapping(controller의 기능 메서드)
	2) data : 요청 query string ex) id=@@@&pass=@@@
		- 1단계 : data :"id=@@@&pass=@@@"
		- 2단계 : data :$("form").serialize(),
			form 하위에 종속된 모든 요소객체들을 name/value으로 mapping하여 모두 다 자동 query string을 변경하여 전송한다.
		- 3단계 : data:{name:"홍길동",age:25}
			json형 객체로 넘기더라도 자동으로 속성=속성값 형태의 query string으로 만들어 전달한다. ==> ?name=홍길동&age=25
		
	3) type : get/post
	4) dataType : 결과를 받은 데이터 유형 [json], xml, text
	5) success : fuction(data){} : 서버에서 전달해주는 데이터 (data)
	6) error : function(xhr, status, error){}
		: 서버와 통신에 에러가 발생시 처리해주는 메서드.

# backend(서버에서 환경 설정)
1. 모델 데이터를 json데이터로 변경해주는 spring 프레임웍의 lib 컨테이너에서 선언.	
2. ajax 요청한 요청값을 선언 메서드 처리
3. 모델데이터 처리
4. return 컨테이너에 선언한 json  처리 view 호출.
	
      --%>
	$("#btn01").click(function(){
		$.ajax({
			url:"${path}/ajax01.do", // 서버의 주소
			dataType:"json",
			success:function(data){
				// data.모델명
				$("h2").text(data.data01+":"+typeof(data))
			}
			
		});
	});
	// ex) 버튼 2를 클릭시, ajax02.do로 호출해서
	//		모델명 msg라고 선언된 내용.. 반가워요를 호출해서 h2에 출력
	$("#btn02").click(function(){
		$.ajax({
			url:"${path}/ajax02.do",
			dataType:"json",
			success:function(data){
				$("h2").text(data.msg);
				
			}
		})
	});
	$("#btn03").click(function(){
		$.ajax({
			url:"${path}/ajax03.do",
			dataType:"json",
			success:function(data){
				var p01=data.person
				console.log(data.person)
				$("h2").text(p01.name+":"+p01.age+":"+p01.loc);
				
			}
		})
	});
	// ex) btn04 추가 ajax04.do Product 복사해서 모델명 product
	//		물건명 가격 갯수를 h2에 출력..
	$("#btn04").click(function(){
		$.ajax({
			url:"${path}/ajax04.do",
			dataType:"json",
			success:function(data){
				var p01=data.product
				console.log(data.product)
				$("h2").text(p01.pname+":"+p01.price+":"+p01.cnt);
				
			}
		})
	});
	
	
   });
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>타이틀</h2>

</div>
<div class="container">
   <form id="frm01" class="form-inline"  method="post">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
       <input class="form-control mr-sm-2" placeholder="제목" />
       <input class="form-control mr-sm-2" placeholder="내용" />
       <button class="btn btn-info" id="btn05" type="button">serialize처리</button>
       <script>
       $("#btn05").click(funtion(){
    	   // 필기 추가
       })
       </script>
       <button class="btn btn-info" id="btn01" type="button">서버데이터 호출</button>
       <button class="btn btn-info" id="btn02" type="button">서버데이터 호출2</button>
       <button class="btn btn-info" id="btn03" type="button">객체 호출</button>
       <button class="btn btn-info" id="btn04" type="button">객체 호출2</button>
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
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
2022-07-15
오전 정리문제
[1단계:개념] 1. jquery에서  한번에 여러가지 css 속성을 설정하는 방법을 기술하세요
	$("선택자").css("속성1","속성1값")
	$("선택자").css({"속성1":"속성1값","속성2값"
[1단계:확인] 2. jquery에서  each 구문을 통한 객체형 배열 처리의 매개변수을 값을 활용하여, 학생들의 이름/국어/영어/수학 점수를 테이블에 출력하세요
[1단계:개념] 3. jquery에서 ajax 처리를 위한 속성값을 기술하세요
	$.ajex({속성:속성값})
	$.ajex({
		url:"컨트롤러 호출 주소", // 내부 주소, 외부 사이트에 있는 json형식 가져오고, 
		data:"요청 query String",
		dataType:"json", // json 문자열 ==> 객체로 변환
		success:function(data){
			// controller단이나 외부 사이트에 넘겨온 json 데이터 객체
			// data.모델명 : controller에서 모델명을 지정되었을 때..
			},
			error:function(err){
				// 서버에 해당 주소로 접속했을 때, 에러에 대한 처리..
			}
		})
[1단계:확인] 4. 아래의 내용을 처리하는 서버단 ajax controller을 메서드를 선언하세요 
            1) http://localhost:7080/springweb/ajax11.do?name=홍길동&height=175.5&weight=68.5
               화면출력 {"p01",{"name":"홍길동","height":175.5,"weight":68.5}}
               - 요청값에 대한 확인, vo 처리 여부 결정
               - controller 생성 url 기능 메서드 선언
               
            2) http://localhost:7080/springweb/ajax12.do?radius=50.2
               화면출력 {"circle":{radius:50.2,dimension:7912.92}}
[1단계:확인] 5. 아래 내용을 ajax 통해 controller에서 모델 값을 처리를 통해서 입력과 동시에 출력되게 하세요
            물건명 :[    ] 가격:[     ] 수량:[     ]
            ==> @@을 @@@원에 @@게 구매하여 총비용이 @@@ 원입니다.       
            1) 요청값 vo 확인
            2) controller : 
            	http://olocalhost:7080/springweb/ajax13.do?pname=사과&price=3000&cnt=2
            3) 화면 및  이벤트 처리
            	name="pname" name="price" name="cnt"
            	class="prodCls"
            	$(".prodCls").keyup(function(){
            	});
            	
            4) ajax 처리	
				$.ajax(function(){
					url:"${path}/ajax13.do,
					data:$("form").serialze(),
					dataType:"json",
					success:function(data){
						var prod = data.product
						var show=prod.pname+"을 "+prod.price"원에 "+prod.cnt"개 구매하여 총비용이 "+prod.tot"+ 원입니다."
						$("#result").text(show);
					}
				});
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
  [1단계:확인] 2. jquery에서  each 구문을 통한 객체형 배열 처리의 매개변수을 값을 활용하여, 
  		학생들의 이름/국어/영어/수학 점수를 테이블에 출력하세요    
      --%> 
      var studList=[
    	  {name:"홍길동",kor:80,eng:90,math:100},
    	  {name:"김길동",kor:85,eng:92,math:80},
    	  {name:"마길동",kor:87,eng:80,math:90}
      ]
      var addHTML = "";
      $(studList).each(function(idx, stud){
		   addHTML += "<tr><td>"+stud.name+"</td><td>"+stud.kor+"</td><td>"+stud.eng+"</td><td>"+stud.math+"</td></tr>";
      });
      $("#showData").html(addHTML);
      $(".prodCls").keyup(function(){
    	$.ajax({
    		url:"${path}/ajax13.do",
    		data:$("#frm01").serialize(),
    		dataType:"json",
    		success:function(data){
    			var prod = data.prod
    			var show=prod.pname+"을 "+prod.price"원에 "+prod.cnt"개 구매하여 총비용이 "+prod.tot"+ 원입니다."
				$("#resultTxt").text(show);
    		}
    	});  
      })
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
       <input name="pname" value="" class="prodCls form-control mr-sm-2" placeholder="물건명" />
       <input name="price" value="0" class="prodCls form-control mr-sm-2" placeholder="가격" />
       <input name="cnt" value="0" class="prodCls form-control mr-sm-2" placeholder="갯수" />
       <button class="btn btn-info" type="submit">Search</button>
    </nav>
   </form>
   <h3 id="resultTxt"></h3>
   <table class="table table-hover table-striped">
      <col width="25%">
      <col width="25%">
      <col width="25%">
      <col width="25%">
    <thead>
    
      <tr class="table-success text-center">
        <th>이름</th>
        <th>국어</th>
        <th>영어</th>
        <th>수학</th>
      </tr>
    </thead>   
    <tbody id="showData">
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
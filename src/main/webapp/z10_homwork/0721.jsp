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
[1단계:개념] 1. 파일을 다운로드하기 위한 환경 설정을 기술하세요.
	- 다운로드 뷰어
		@Value("${upload}")
		private String path;
		@Override
		protected void renderMergedOutputModel(Map<String, Object> model, 
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			// 1. 요청으로 model로 매핑된 파일 객체 생성.
			String fname = (String)model.get("downloadFileName");
			// 2. 파일 객체 생성.
			File file = new File(path+fname);
			
			// 3. response에 의해 파일객체를 client에 전송
			// 	1) 파일 전송을 위한 contentType설정.
			response.setContentType("application/download;charset=utf-8");
			//	2) 파일의 길이
			response.setContentLength((int)file.length());
			//	3) 파일명이 한글인 경우 한글 encoding, 공백의 경우 ""로 변경..
			fname = URLEncoder.encode(fname,"utf-8").replaceAll("\\+", "");
			//	4) response의 header정보를 통해서 전송
			//		Content-Disposition : attachment;filename="파일명"
			//		Content-Transfer-Encoding : "binary"
			response.setHeader("Content-Disposition", "attachment;filename=\""+fname+"\"");
			response.setHeader("Content-Transfer-Encoding", "binary");
			// 4. 파일을 Stream으로 client에 전송
			//	1) FileInputStream fis: 파일
			FileInputStream fis = new FileInputStream(file);
			//	2) OutputStream 객체
			OutputStream out = response.getOutputStream();
			//	3) FileCopyUtils.copy(fis,out)
			FileCopyUtils.copy(fis,  out);
			//	4) flush 처리
			out.flush();
	- 다운로드 뷰 컨테이너 등록
		<bean id="downloadViewer" class="board.util.DownloadViewer"/>	

	- contoller에서 리턴값 설정
		return "downloadViewer";
		
	<선생님>
	1) 다운로드 viewer 생성
	2) 컨테이너에 다운로드 viewer 등록
	3) 다운로드 할 파일의 위치 : src\main\webapp\z01_upload
		공통파일 선언.
	4) 다운로드 controller 생성
		- 요청값 : 파일명 지정
		- 모델데이터 : 다운로드 viewer에서 선언한 모델명	
		- return "컨데이너의 다운로드 viewer"
		
		
[1단계:확인] 2. 아래와 같은 경로에 파일을 올려놓고 url을 이용하여 파일을 다운로드 할 수 있게 controller를 처리하세요.
            파일 위치 : src\main\webapp\z01_upload
        http://localhost:7080/springweb/download10.do?filename=KakaoTalk_20220707_174916586.png
        @RequestMapping("download10.do")
		public String download10(@RequestParam("filename") String filename, Model d) {
			d.addAttribute("fileView01", filename);
			return "downloadViewer";
		}
		http://localhost:7080/springweb/download11.do?file01=KakaoTalk_20220707_174916586.png
		@RequestMapping("download11.do")
		public String download10(@RequestParam("file01") String file01, Model d) {
			d.addAttribute("fileView01", file01);
			return "downloadViewer";
		}
            
[1단계:확인] 3. 위에 설정한 controller상 경로로 src\main\webapp\z01_upload에 있는 파일을 리스트(직접파일명 입력)하고,
            클릭시, 다운되게 하세요
            
[1단계:개념] 4. 답글을 달기 위하여 필요하는 요청값 처리 구조와 속성을 기술하세요.   
     	1) 데이터 구조
     		no refno subject	content
     		1	0
     		2	0
     		3	1	RE : @@		\n\n===상위글===\n 상위 글 내용
     		
     	2) 화면단
     		상세화면 ==> 등록화면
     		[name = no] ==> [name = refno] 값으로 할당
     		[name = subject] ==> RE :로 접어두기 표기
     		[name = content] ==> \n\n===상위글===\n 상위 글 내용
     		
     		$("#reBtn").click(function(){
     			위 내용으로 데이터 처리
     			$("form").attr("action","${path}/insertBoardForm");
     			$("form").submit();
     		});
     		등록화면 form에서 처리는 일반 등록처리와 동일..
     	3) 계층형 sql 처리
     		select level
     		
     		start with = refno=0
     		connect by prior np	= refno
     		order siblings by no desc
     		
     		계층형으로 상위글 밑에 하위 글들이 먼저 list되고, 그 다음 항목들이 역순위로 출력된다.
     	4) vo 속성으로 level을 추가하여 계층단계별로 공백이 추가되어 계층 레벨별로 리스트 처리
     		<c:forEach begin="1" end="${bd.level}">
     			&nbsp;&nbsp;
     		</c>
     		
     		${bd.subject}			
     			               
[1단계:개념] 5. 페이지 처리를 위한 핵심 sql이 가지는 의미를 기술하세요. 
		rownum : 데이터가 나온 순서대로 1~... 갯수 만큼 numbering, 
				이 기준으로 특정 페이지에서 보이는 데이터를 범위로 지정하여 출력   
		SELECT *
		FROM(
			 select rownum cnt, level, b.*
			 from board b
			 WHERE 1=1
			 start with refno = 0
			 connect by prior no = refno
			 order siblings by no DESC);	
		WHERE cnt BETWEEN ${start} AND #{end}
		1페이지 1~5
		2페이지 6~10
		3페이지 11~15
[1단계:개념] 6. 페이지 처리를 위한 속성을 기술하세요.  
	count : 전체 검색된 데이터가 몇건인지 확인(DB)
	pageSize : 한번에 보여줄 데이터 건수 화면에서 요청값으로 전달(view)
	pageCount : count/pageSize 형식으로 전체 페이지수를 가져올 수 있다.(로직)
	curpage : 요청값으로 화면에서 클릭한 현재 페이지 번호(view)
	start : (curpage-1)*pageSize+1(로직)
	end : curpage*pageSize(로직)
	--- 블럭 처리 ---
	<[1][2][3][4][5]>
	<[6][7][8][9][10]>
	blockSize : 블럭의 크기
	startBlock : 시작 block 페이지번호
	endBlock : 마지막 block 페이지번호
	
	
	
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
        <th>파일명</th>
      </tr>
    </thead>   
    <tbody id="showData">
	       <tr><td>KakaoTalk_20220707_174916586.png</td></tr>
	       <tr><td>KakaoTalk_20220707_174916586.png</td></tr>
	       <tr><td>KakaoTalk_20220707_174916586.png</td></tr>
    </tbody>
   </table> 
   <script>
   	$("#showData td").click(function(){
   		var fname = $(this).text();
   		location.href="${path}/download10.do?filename="+fname;
   	});
   </script>   
    
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
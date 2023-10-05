<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 게시판 작성 jsp -->
	<link href="/Ezen_teamB/css/board/writeboard.css" rel="stylesheet">
</head>
<body>
	<%@include file ="../header.jsp" %>
	
	<div class="webcontainer"> <!-- 글쓰기 전체 구역  -->
		
		<div>
			<h3> 글등록 페이지 </h3>
		</div>
		<div>
		<form class="writeForm">
			
			제목 : <input type="text" name="btitle" class="btitle">
			내용 : <textarea name="bcontent" class="bcontent"></textarea>
			첨부파일 : <input type="file" name="bfile" class="bfile">
			<select name="cno" class="cno">
				
				
			</select>
		
			<button onclick="writeBtn()" type="button">글등록</button>
		</form>	
		</div>
	</div>
		<%@include file = "../footer.jsp" %>
	<script  src="/Ezen_teamB/js/board/writeboard.js" type="text/javascript"></script>
</body>
</html>
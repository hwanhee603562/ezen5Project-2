<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 게시판 수정 jsp -->
</head>
<body>
	<%@include file ="../header.jsp" %>
	
	<div class="webcontainer"> <!-- 글쓰기 전체 구역  -->
		
		<div>
			<h3> 글수정 페이지 </h3>
		</div>
		<div>
		<form class="writeForm">
			<select name="cno" class="cno">
				<option value="1">공지사항</option>
				<option value="2">건의사항</option>
			</select>
			제목 : <input name="btitle" type="text">
			내용 : <textarea name="bcontent"></textarea>
			첨부파일 : <input type="file" name="bfile" class="bfile">
			<button onclick="bUpdate()" type="button">수정</button>
			</form>
		</div>
	</div>
	
	
	
	
	<script  src="/Ezen_teamB/js/board/updateboard.js" type="text/javascript"></script>
</body>
</html>
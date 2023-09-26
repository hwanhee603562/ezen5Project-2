<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 개별게시판 jsp -->
	<link href="/css/board/detailedboard.css" rel="stylesheet">
</head>
<body>
	<%@include file ="../header.jsp" %>
	<div class="webcontainer"> <!-- 페이지 전체 구역 -->
		<h3>상세페이지</h3>
		<div class="boardBox">
		
		
		</div>
		<div>
			<input placeholder="답글을등록해주세요" type="text">
			<button type="button">답글등록</button>
		</div>
		<div>
			<div>답글출력구역</div>
		</div>
	</div>
	
	
	<script  src="/Ezen_teamB/js/board/detailedboard.js" type="text/javascript"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 개별게시판 jsp -->
	<link href="/Ezen_teamB/css/board/detailedboard.css" rel="stylesheet">
</head>
<body>
	<%@include file ="../header.jsp" %>
	<div class="webcontainer"> <!-- 페이지 전체 구역 -->
		<div class="boardTop">
			<h3><a href="mainboard.jsp">가지가지마켓 게시판</a></h3>
		</div>
		<div class="boardContent">
			<div class="boardBox"> <!-- 개별 게시물 출력 구역 -->
				
				
			</div> <!-- 개별 게시물 출력 구역 end -->
		</div>
		<div class="boardBottom"> <!-- 	<= display flex			  -->
			<div>
				<div class="boardReply">
					<input placeholder="답글을등록해주세요" type="text" class="rcontent">
					<button onclick="replyWrite()"type="button">답글등록</button>
					<a href="mainboard.jsp"><button type="button">목록보기</button></a>
				</div>
				<div class="boardReplyContent">
					<div>답글출력구역</div>
				</div>
			</div>
			<div class="bottomBtn">
				<!-- 버튼생성구역 -->
			</div>
		</div>
	</div>
	
	
	<script  src="/Ezen_teamB/js/board/detailedboard.js" type="text/javascript"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 전체 게시판 jsp -->
	<link href="/Ezen_teamB/css/board/mainboard.css" rel="stylesheet">
</head>
<body>
	<%@include file ="../header.jsp" %>
	
	<div class="webcontainer"> <!-- 게시물 전체 구역 -->
		<div class="boardTop"> <!-- 상단 메뉴 -->
			<h3> 게시판 </h3>
			<button onclick="onWriteBtn()" type="button">글쓰기</button>
			<button type="button">전체보기</button>
			<button type="button">공지사항</button>
			<button type="button">건의사항</button>
		</div> <!-- 상단 메뉴 end -->
		
		
		<div class="boardTable"> <!-- 게시물이 출력 -->
			<table>
				<tr>
					<th> 번호 </th>
					<th> 카테고리 </th>
					<th> 제목 </th>
					<th> 작성자 </th>
					<th> 조회수 </th>
					<th> 작성일 </th>
				</tr>
				<tr>
					<td>1</td>
					<td>건의사항</td>
					<td>안녕하세요</td>
					<td>유재석</td>
					<td>0</td>
					<td>2023-09-15</td>
				</tr>
				<tr>
					<td>2</td>
					<td>건의사항</td>
					<td>안녕하세요</td>
					<td>유재석</td>
					<td>0</td>
					<td>2023-09-15</td>
				</tr>
				<tr>
					<td>3</td>
					<td>건의사항</td>
					<td>안녕하세요</td>
					<td>유재석</td>
					<td>0</td>
					<td>2023-09-15</td>
				</tr>
				<tr>
					<td>4</td>
					<td>건의사항</td>
					<td>안녕하세요</td>
					<td>유재석</td>
					<td>0</td>
					<td>2023-09-15</td>
				</tr>
			</table>
			<!-- 
			게시물이 출력되는 구역 
			-->

		</div> <!-- 게시물 출력 end -->
		
		
		<div class="boardBottom"> <!--하단 메뉴 -->
			<select class="key">
				<option>제목</option>
				<option>내용</option>
				<option>작성자</option>
			</select>
			<input class="keyword" type="text" placeholder="검색할내용"> <!-- 검색내용 -->
			<button onclick="boardSearch()" type="button">검색</button>
		</div> <!--하단 메뉴 end -->
		
		
	</div> <!-- 게시물 전체구역 end -->
	
	<script  src="/Ezen_teamB/js/board/mainboard.js" type="text/javascript"></script>
</body>
</html>
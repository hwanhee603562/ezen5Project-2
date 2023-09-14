<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/ezen5project-2/sns/content.css" rel="stylesheet">
 
</head> 
<body> 

	<%@include file = "./header.jsp" %>
	
	<div class="wrap"><!-- content 전체구역 / 모든 각각의 게시물 출력 구역 -->	

		<div class="feedCount">총 피드 수 : </div>
		<input class="searchInput" onkeyup="searchContent()" placeholder="검색">

 
		<div class="outputField"><!-- 게시물 1개 출력되는 구역 -->
 
		</div>

	</div><!-- content 전체구역 end -->


	
	<!-- 최신 JQUERY 불러오기 : AJAX메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script src="/ezen5project-2/sns/content.js" type="text/javascript"></script>

</body>
</html>
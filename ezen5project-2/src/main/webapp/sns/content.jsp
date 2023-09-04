<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="content.css" rel="stylesheet">
</head>
<body>

	<%@include file = "./header.jsp" %>

	<div class="wrap"><!-- content 전체구역 / 모든 각각의 게시물 출력 구역 -->	
		<div class="outputField"><!-- 게시물 1개 출력되는 구역 -->
			<img class="writeImg">			<!-- 작성 사진 -->
			<div class="writeDate">		</div>	<!-- 작성 시간 출력 -->
			<div class="writeContent">  </div>	<!-- 작성 글 출력 -->
			<div class="bottomBtn">				<!-- 하단 버튼 구역 -->
				<button class="updateBtn"> 수정 </button>	<!-- 수정 버튼 -->
				<button class="deleteBtn"> 삭제 </button>	<!-- 삭제 버튼 -->
			</div>
		</div>	
	</div><!-- content 전체구역 end -->


	
	<!-- 최신 JQUERY 불러오기 : AJAX메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script src="content.js" type="text/javascript"></script>
</body>
</html>
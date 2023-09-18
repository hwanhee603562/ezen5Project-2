<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가지가지</title>

	<!-- 부트스트랩 cdn -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<link href="/Ezen_teamB/css/header.css" rel="stylesheet">
</head>
<body>
	
	<!-- 헤더 -->
	<div id="header">
		<div class="mainlogo">	<!-- 로고 -->
			<a href="/Ezen_teamB/jsp/index.jsp">
				<img alt="" src="/Ezen_teamB/jsp/img/mainlogo.png">
			</a>
		</div>
		<!-- 본메뉴 -->
		<ul class="mainmenu">
			<li><a class="registerText" href="#">중고거래</a></li>
			<li><a href="#">물품등록</a></li>
			<li><a href="/Ezen_teamB/jsp/board/mainboard.jsp">게시판</a></li>
		</ul>
		
		<!-- 서브메뉴 -->
		<ul class="submenu">
			<li><a href="#">로그인</a></li>
			<li><a href="#">회원가입</a></li>
		</ul>
	</div>
	

	
	<!-- jquery -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<!-- 부트스트랩 스크립트 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

</body>
</html>
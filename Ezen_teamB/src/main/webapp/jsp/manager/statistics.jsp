<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/Ezen_teamB/css/manager/statistics.css" rel = "stylesheet">
<!-- 통계페이지 -->
</head>
<body>
<<<<<<< HEAD

	통계
	<button onclick="sfsfd()" type="button"> 안녕 </button>
	<script src="/Ezen_teamB/js/manager/statistics.js" type="text/javascript"></script>
=======
	<!-- 날짜 검색 구역 -->
	<div class="dateInput">
		<div class="inputBox">
			<input class="priDate" type="date">
			<p>~</p>
			<input class="nextDate" type="date">
		</div>
		<button onclick="statisSearch()" class="stSearch">검색</button>
	</div>
	<!-- 카테고리 선택 구역 -->
	<div class="categoryInput">
		<div onclick="onCategory(1)" class="act">물품카테고리</div>
		<div onclick="onCategory(2)">거래방식</div>
		<div onclick="onCategory(3)">연령대별</div>
		<div onclick="onCategory(4)">지역별</div>
	</div>
	<!-- 통계 출력 구역 -->
	<div class="printBox">
		
	
	</div>
	
	
>>>>>>> branch '최의선' of https://github.com/hwanhee603562/ezen5Project-2

</body>
</html>
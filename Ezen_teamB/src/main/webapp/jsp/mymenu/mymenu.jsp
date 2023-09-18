<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../../css/mymenu/mymenu.css" rel="stylesheet">
</head>
<body>
	<%@include file = "../header.jsp" %>
	
	<!-- 마이메뉴 페이지 전체구역 -->
	<div class="webcontainer">
		<div class="infoBox">
			<div class="infoTop">
				<div class="infoContent">
					<div class="contentHeader">아이디</div>
					<div class="contentMain">
						<div>칭호 : 처음온손님</div>
						<div>거래활동 0</div>
						<div>판매물품 0</div>
						<div>포인트 30000</div>
					</div>
					<div class="name">이름</div>
					<div class="address">주소</div>
					<div class="email">이메일주소</div>
					<button class="btn btn-outline-dark btn-sm updateBtn">정보수정</button>					
				</div>
			</div>
			<div class="infoBottom">
				<div class="infoCard">
					<ul class="nav nav-tabs nav-fill">
					  <li class="nav-item smenu1" onclick="saleList()">
					    <a onclick="saleList()" id="smenu1" class="nav-link active" aria-current="page" href="#">판매중인상품</a>
					  </li>
					  <li class="nav-item smenu2">
					    <a id="smenu2" class="nav-link" href="#">거래내역</a>
					  </li>
					  <li class="nav-item smenu3">
					    <a id="smenu3" class="nav-link" href="#">찜목록</a>
					  </li>
					  <li class="nav-item smenu4">
					    <a id="smenu4" class="nav-link" href="#">채팅목록</a>
					  </li>
					</ul>
				</div>
				<div class="cardInfo">
				
				</div>
			</div>
		</div>
	</div>	<!-- 마이메뉴 전체구역 end -->
	
	
	
	<script type="text/javascript" src="../../js/mymenu/mymenu.js"></script>
	
</body>
</html>
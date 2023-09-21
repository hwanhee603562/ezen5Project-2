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
					<!-- 회원 정보 출력 구역 -->					
				</div>
			</div>
			<div class="infoBottom">
				<div class="infoCard">
					<ul class="nav nav-tabs nav-fill">
					  <li class="nav-item smenu1">
					    <a onclick="saleList()" id="smenu1" class="nav-link active" aria-current="page" href="#">판매중인상품</a>
					  </li>
					  <li class="nav-item smenu2">
					    <a onclick="transHistory()" id="smenu2" class="nav-link" href="#">거래내역</a>
					  </li>
					  <li class="nav-item smenu3">
					    <a onclick="PrintWishList()" id="smenu3" class="nav-link" href="#">찜목록</a>
					  </li>
					  <li class="nav-item smenu4">
					    <a id="smenu4" class="nav-link" href="#">채팅목록</a>
					  </li>
					</ul>
				</div>
				<div class="printContent">
					<div class="productCount">
						
					</div>
					<div class="cardInfo">
							<!-- 서브메뉴 콘텐츠 출력구역 -->
					</div>
				</div>
			</div> <!-- infoBottom end -->
		</div>
	</div>	<!-- 마이메뉴 전체구역 end -->
	
	
	
	<script type="text/javascript" src="../../js/mymenu/mymenu.js"></script>
	
</body>
</html> 
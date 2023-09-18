<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 전체물품조회 jsp -->

	<link href="/Ezen_teamB/css/item/checkitems.css" rel="stylesheet">
</head>
<body>
	<%@ include file = "../header.jsp" %>
	
	<div class="checkItemsWrap">	<!-- 전체물품조회 전체구역 -->	
	
		<div class="itemCardBox">	<!-- 카드가 출력되는 박스구역 -->
		
			<div class="row row-cols-1 row-cols-md-4 g-4">
				<div class="col">
					<div class="card">
						<img src="/jspweb/img/카드1.png" class="card-img-top" alt="...">
						<div class="card-body">
							<div class="itemCardTitle"> Title </div>
							<div class="itemCardPrice"> price </div>
							<div class="itemCardAdress"> adress </div>
							<div class="itemWatchCount"> 찜 </div>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card">
						<img src="/jspweb/img/카드1.png" class="card-img-top" alt="...">
						<div class="card-body">
							<div class="itemCardTitle"> Title </div>
							<div class="itemCardPrice"> price </div>
							<div class="itemCardAdress"> adress </div>
							<div class="itemWatchCount"> 찜 </div>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card">
						<img src="/jspweb/img/카드1.png" class="card-img-top" alt="...">
						<div class="card-body">
							<div class="itemCardTitle"> Title </div>
							<div class="itemCardPrice"> price </div>
							<div class="itemCardAdress"> adress </div>
							<div class="itemWatchCount"> 찜 </div>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card">
						<img src="/jspweb/img/카드1.png" class="card-img-top" alt="...">
						<div class="card-body">
							<div class="itemCardTitle"> Title </div>
							<div class="itemCardPrice"> price </div>
							<div class="itemCardAdress"> adress </div>
							<div class="itemWatchCount"> 찜 </div>
						</div>
					</div>
				</div>
			</div>

		</div> 	<!-- 카드가 출력되는 박스구역 end -->
		
	</div>	<!-- 전체구역 end -->

	<script src="/Ezen_teamB/js/item/checkitems.js" type="text/javascript"></script>
</body>
</html>
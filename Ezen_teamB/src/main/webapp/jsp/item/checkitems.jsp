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
		
		<h2> 물품 전체보기 </h2>
		<!-- 제품 필터 선택구역 -->
		<div class="topField">
			<div class="searchWord"> 제목검색 <input type="text"> </div>
			<div class="topCategory">	<!-- 대분류 카테고리 설정구역 -->
				<div class="guideLabel"> 대분류 </div>
				<table class="outputUmaincategory">
					<tr>
					    <td> 대분류 </td>
					    <td> 대분류2 </td>
					    <td> 대분류3 </td>
					    <td> 대분류4 </td>
					    <td> 대분류5 </td>
					</tr>
					<tr>
					    <td> 대분류1 </td>
					    <td> 대분류2 </td>
					    <td> 대분류3 </td>
					    <td> 대분류4 </td>
					    <td> 대분류5 </td>
					</tr>
				
				</table>
				<div> 선택된 카테고리 : </div> <div>  </div>
			</div>

			<div class="bottomCategory">	<!-- 소분류 카테고리 설정구역 -->
	
			</div>
			
			
		</div>
		
		<div class="itemCardBox">	<!-- 카드가 출력되는 박스구역 -->
			<div class="row row-cols-1 row-cols-md-5 g-4">
				<div class="col">
					<div class="card">
						<img src="/jspweb/img/카드1.png" class="card-img-top" alt="...">
						<div class="card-body">
							<div class="itemCardTitle"> Title </div>
							<div class="itemCardPrice"> price </div>
							<div class="itemCardAdress"> 거래방식 </div>
							<div class="itemCardAdress"> 거래위치 </div>
							<div class="itemCardAdress"> 안전결제 여부 </div>
							<div class="itemCardAdress"> 등록일자 </div>
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
							<div class="itemCardAdress"> 거래방식 </div>
							<div class="itemCardAdress"> 거래위치 </div>
							<div class="itemCardAdress"> 안전결제 여부 </div>
							<div class="itemCardAdress"> 등록일자 </div>
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
							<div class="itemCardAdress"> 거래방식 </div>
							<div class="itemCardAdress"> 거래위치 </div>
							<div class="itemCardAdress"> 안전결제 여부 </div>
							<div class="itemCardAdress"> 등록일자 </div>
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
							<div class="itemCardAdress"> 거래방식 </div>
							<div class="itemCardAdress"> 거래위치 </div>
							<div class="itemCardAdress"> 안전결제 여부 </div>
							<div class="itemCardAdress"> 등록일자 </div>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 물품 등록 jsp -->
	
	<link href="/Ezen_teamB/css/item/registeritems.css" rel="stylesheet">
</head>
<body>
	<%@ include file = "../header.jsp" %>
	
	<div class="registerItemsWrap">	<!-- registerItems 전체구역 -->
		
		<form class="registerForm">	<!-- form 식별구역 -->
		
			<div class="inputInfoBox">	<!-- 물품정보 입력 박스 -->
				
				제목 : <input name="pname" type="text"><br>
				제품설명 : <textarea name="pcontent" rows="" cols=""></textarea><br>
				
				카테고리 분류 선택 <button type="button"> 카테고리 </button>
				<div name="selectedCategory" class="selectedCategory"> 선택된 카테고리 출력구역 </div>
				<div class="categoryPopup"> <!-- 카테고리 버튼을 클릭했을 때 출력되는 팝업창 -->
					<!-- 구글링 필요 : Javascript 특정 영역 제외 클릭 -->
					<h2> 카테고리 버튼을 클릭했을 때 출력되는 팝업창 </h2>
					<div class="leftCategory">	<!-- 좌측 대분류 구역 -->
						<table>
							<tr>
								<th> 대분류 </th>
							</tr>
							<tr>
								<td> 가전제품 </td>
								<td> 의류 </td>
							</tr>
						</table>
					</div> 
					<div class="rightCategory">	<!-- 우측 대분류에 따른 소분류 구역 -->
						<table>
							<tr>
								<th> 소분류 </th>
							</tr>
							<tr>
								<td> 냉장고 </td>
								<td> TV </td>
							</tr>
						</table>
					</div>
				</div>
				판매가격 : <input name="pprice" type="number"><br>
				<div>
					거래방식 : 
					<input type="checkbox" name="item" value="배송">배송
					<input type="checkbox" name="item" value="대면거래">대면거래
					<input type="checkbox" name="item" value="중개거래">중개거래
				</div>
				
				
				<!-- 거래방식 : 배송일 경우 출력x -->
				<!-- 거래방식 : 대면거래일 경우 대면거래 장소 주소 api로 입력 후 해당 주소위치 맵에 출력 -->
				<!-- 거래방식 : 중개거래일 경우 지도상 중개거래소 선택 -->
				거래장소 : 	<div id="map" style="width:300px;height:350px;"></div>
							<p><em>지도를 클릭해주세요!</em></p> 
							<div id="clickLatlng"></div>
				<div class="safePayment">
					추후 기능 추가시 안전결제 진행
				</div>

			</div>	<!-- 물품정보 입력 박스 end -->
			
		</form>	<!-- form 식별구역 end -->
		<button onclick="registerItems()" type="button"> 등록 </button><button type="button"> 취소 </button>
	</div>

	<script src="/Ezen_teamB/js/item/registeritems.js" type="text/javascript"></script>
</body>
</html>
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
				제품장소 : 	<div id="map" style="width:300px;height:350px;"></div>
							<p><em>지도를 클릭해주세요!</em></p> 
							<div id="clickLatlng"></div>
				
				
			</div>	<!-- 물품정보 입력 박스 end -->
			
		</form>	<!-- form 식별구역 end -->
		
	</div>

	<script src="/Ezen_teamB/js/item/registeritems.js" type="text/javascript"></script>
</body>
</html>
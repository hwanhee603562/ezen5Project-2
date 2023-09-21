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
				
				
				<h2> 상품등록 기본정보 </h2>
				
				<div class="inputDeskBox prtImg">
					<div class="deskInfo">제품이미지</div>
					<div class="rightInputBox">
						<label class="input-file-button" for="uploadFile">
							
							<img class="labelImg" src="/Ezen_teamB/jsp/item/img/uploadImgLogo.png"/>
							
						</label>
						<input onchange="fileUpload(this)" type="file" id="uploadFile" name="file"><br>	
						<span> ※ 이미지는 최대 10개까지 저장가능합니다 </span>
					</div>
				</div>
				
				<div class="outputImg prtSelectImg"> <!-- 선택된 이미지 출력 구역 -->
				</div>
				
				
				<div class="inputDeskBox prtTitle">
					<div class="deskInfo">제목</div>
					<div class="rightInputBox">
						<input name="ptitle" class="ptilte" type="text"><br>
					</div>
				</div>
				 
					
				<div class="inputDeskBox prtContent">
					<div class="deskInfo">제품설명</div>
					<div class="rightInputBox">
						<textarea name="pcontent" rows="" cols=""></textarea><br>
					</div>
				</div>
					
				
				<div class="inputDeskBox prtCategory">
					<div class="deskInfo">카테고리</div>
					<div class="rightInputBox categoryField">
						<div class="umaincategoryBox">
							<ul class="mainUl">
								<!-- 대분류 카테고리 출력 구역 -->
							</ul>
						</div>
						<div class="dsubcategoryBox">
							<ul	class="subUl">
								<li class="defaultCategory"> <div>소분류 선택</div> </li>
							</ul>
						</div>
						
					</div>
				</div>
				<div class="selectCategory prtSelectCategory"> 
					<div>선택한 카테고리 : <p class="checkMain"></p> <p class="checkSub"></p> </div>
					<input name="dno" class="dno" type="text" readonly>  
				</div>
				
				
				
				<div class="inputDeskBox prtTrade">
					<div class="deskInfo">거래방식</div>
					<div class="rightInputBox itradeBox">
						<div onclick="delivery()" class="delivery itrade"> 배송 </div>
						<div onclick="faceToFace()" class="faceToFace itrade"> 대면거래 </div>
						<div onclick="brokerage()" class="brokerage itrade"> 중개거래 </div>
					</div>
				</div>
				
				<!-- 거래방식 - 대면거래일 시 지도출력하여 대면거래 위치 지정 -->
				<!-- 거래방식 - 중개거래일 시 지도출력하여 중개거래소 선택 -->
				<div id="outputMapField" style="display: none;"><!-- 지도 출력되는 구역 -->
					<input type="text" id="sample5_address" placeholder="주소">
					<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
					<div id="map" style="width:100%;height:350px;"></div>
					<div id="clickLatlng"> ※ 행정안전부에서 업데이트되지 않은 도로명주소는 지번주소로 대체됩니다 </div>
					<div class="selectedAddress">
						선택한 위치 : <span>  </span>
					</div>
				</div>
				
				<div class="inputDeskBox prtPrice">
					<div class="deskInfo">판매가격</div>
					<div class="rightInputBox">
						<input name="pprice" class="pprice" type="number"><br>
					</div>
				</div>
				

				<!-- 거래방식 : 배송일 경우 출력x -->
				<!-- 거래방식 : 대면거래일 경우 대면거래 장소 주소 api로 입력 후 해당 주소위치 맵에 출력 -->
				<!-- 거래방식 : 중개거래일 경우 지도상 중개거래소 선택 -->
							
							
				<div class="safePayment">
					추후 기능 추가시 안전결제 진행
				</div>

			</div>	<!-- 물품정보 입력 박스 end -->
			
		</form>	<!-- form 식별구역 end -->
		<div class="bottomBtn">
			<button onclick="registerItems()" type="button" style="background-color: #A287D6;"> 등록 </button><button type="button" style="background-color: white;"> 취소 </button>
		</div>
	</div>
	
	<!-- 카카오지도 api -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c51f4ebd6d93bf1f15d0f4ba2809fea5&libraries=services""></script>
	
	<!-- 카카오 우편번호 서비스 api -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<script src="/Ezen_teamB/js/item/registeritems.js" type="text/javascript"></script>
</body>
</html>
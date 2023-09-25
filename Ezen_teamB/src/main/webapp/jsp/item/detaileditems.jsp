<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 물품상세조회 jsp -->


	<link href="/Ezen_teamB/css/item/detaileditems.css" rel="stylesheet">
	
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	
</head>
<body>
	<%@ include file = "../header.jsp" %>


	<div class="detailedItemsWrap">	<!-- detailedItems 전체구역 -->
		
		<div class="outputImg">	<!-- 이미지 출력구역 -->
			<div id="carouselExampleIndicators" class="carousel slide">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/Ezen_teamB/jsp/item/img/index.png" class="itemImg" alt="...">
					</div>
					<div class="carousel-item">
						<img src="..." class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="..." class="d-block w-100" alt="...">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
		
		
		
		<div class="outputBasicInfo">	<!-- 판매자 id / 등록일자 출력구역 -->
		
			<div class="basicInfoLeft">	<!-- 좌측 id 구역 --> 
				<span> 판매자 : </span> <span class="outputBuyerId">  </span>  
			</div>
			<div class="basicInfoRight"> <!-- 우측 등록일자 구역 -->
				<div class="uploadDate"> 등록일자 </div>
			</div>
		</div>	
			
		<!-- 판매기본 정보와 판매내용을 좌우로 출력하는 구역 -->
		<div class="mainInformation">
			<div class="mainInfoLeft">
				<div class="outputTitle">	<!-- 판매 제목 -->
				판매 제목
					<div class="itemTitle"></div>
				</div>
				
				
				
				<div class="outputTradeMethod">	<!-- 거래방식, 판매가격, 안전결제 사용여부 -->
				거래방식, 판매가격, 안전결제 사용여부
					<div class="tradeInfo">	<!-- 거래방식 -->
						<div class="itemTrade">  </div>
					
					</div>
					
					<div class="priceInfo">	<!-- 판매가격 -->
						<div class="itemPrice"></div>
					
					</div>
					
					<div class="safePaymentInfo">	<!-- 안전결제 사용 여부 -->	
						<div class="itemSafePayment"></div>
					
					</div>
					
					
				</div>
				
			</div>
				
				
				
				
			<div class="mainInfoRight">
				<div class="outputPlace">	<!-- 거래방식에 따른 위치정보 출력 구역 -->
				위치정보
					<div class="adressInfo">	<!-- 거래방식에 따른 주소 출력 -->
					
					
					</div>	
					
					<div class="mapInfo">	<!-- 거래방식에 따른 지도 출력 -->
					
					
					</div>	
				</div>
			</div>
		</div>
			
			
		<div class="outputContent">	<!-- 판매 내용 -->
		판매 내용
		
		</div>
		
		<div class="buttonField">	<!-- 버튼 구역 -->
			<button type="button"> 찜 </button>
			<button type="button"> 가지톡 </button>
		</div>

	</div>	<!-- detailedItems 전체구역 end -->
	
	
	
	<script src="/Ezen_teamB/js/item/detaileditems.js" type="text/javascript"></script>
	
	<!-- 부트스트랩에서 만든 JS 적용 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

	<!-- 카카오지도 api -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c51f4ebd6d93bf1f15d0f4ba2809fea5&libraries=services,clusterer"></script>



</body>
</html>
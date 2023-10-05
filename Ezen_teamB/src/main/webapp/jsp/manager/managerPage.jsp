<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<link href="/Ezen_teamB/css/manager/manager.css" rel="stylesheet">
	
	
	
	<!-- 부트스트랩 css -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
		crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "../header.jsp" %>
	
	<div id="backgroundWrap">
		<div class="managerWrap">	<!-- 관리자 페이지 전체구역 -->
		
			<div class="leftSubOutput">	<!-- 좌측 카테고리 구역 -->
				
				<div onclick="goToMemberList()" class="memberListManager"> 회원 관리 </div>
				<div onclick="goToStatistics()" class="statisticsManager"> 통계 </div>
				<div onclick="goToTradeLog()" class="tradelogManager"> 거래내역 </div>
				<div onclick="goToemEdiation()" class="emediationManager"> 중개거래소 관리 </div>
				
				
				<div class="SubBottomBox">
					<div><button onclick="clearManagerMode()" class="clearManagerMode"> 관리자모드 해제 </button></div>
					<div><a href="/Ezen_teamB/jsp/index.jsp"><button onclick="logout()" class="logoutManagerBtn"> 로그아웃 </button></a></div>
				</div>
						  
			</div>
				
			<div class="rightMainOutput">	<!-- 우측 본문 출력 구역 -->
			
				<%@ include file = "./memberList.jsp" %>
			
			</div>
		
		</div>
	</div>
	
	 
		<!-- 부트스트랩에서 만든 JS 적용 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	
	<script src="/Ezen_teamB/js/manager/manager.js" type="text/javascript"></script>
	
</body>
</html>
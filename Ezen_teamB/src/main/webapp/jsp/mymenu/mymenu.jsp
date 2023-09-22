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
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="exampleModalLabel">회원정보수정</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      	<div class="form-floating mb-3">
			  <input type="text" class="form-control emailInput" id="floatingInput">
			  <label for="floatingInput">이메일</label>
			</div>
			<div class="adressBox">
				<div class="form-floating mb-3">
				  <input type="text" class="form-control adressInput" id="floatingInput addr1" name="addr1">
				  <label for="floatingInput">우편번호</label>
				</div>
				<div>
					<button type="button" class="btn btn-secondary adrbtn" onclick="execPostCode()">
						우편번호 찾기
					</button>
				</div>	<!-- 주소/우편번호 찾기 버튼 -->
			</div>
			<div class="form-floating mb-3">
				  <input type="text" class="form-control adrInput2" id="floatingInput addr2" name="addr2" id="addr2">
				  <label for="floatingInput">도로명주소</label>
				</div>
				<div class="form-floating mb-3">
				  <input type="text" class="form-control adrInput3 id="floatingInput">
				  <label for="floatingInput">상세주소</label>
				</div>
			<div class="form-floating mb-3">
			  <input type="password" class="form-control pwd" id="floatingPassword">
			  <label for="floatingPassword">비밀번호</label>
			</div>
			<div class="form-floating mb-3">
			  <input type="password" class="form-control pwdCk" id="floatingPassword">
			  <label for="floatingPassword">비밀번호확인</label>
			</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	        <button onclick="updateInfo()" type="button" class="btn btn-primary">수정</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<!-- 주소검색 api -->	
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

	<!-- jquery 호출 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<script type="text/javascript" src="../../js/mymenu/mymenu.js"></script>
	
</body>
</html> 
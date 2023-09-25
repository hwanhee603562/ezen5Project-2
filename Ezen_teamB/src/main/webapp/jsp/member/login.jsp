<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 로그인 jsp -->
</head>
<body>
		<%@include file = "../header.jsp" %>	
	로그인 화면
	<div class="container">
		<div><span class="signfont">아이디</span></div> <!-- onkeyup="idcheck()" -->
		<input class="form-floating mb-1 px-3" id="signId" name="signId" maxlength="20" oninput="maxlength(this)"  type="text" placeholder="아이디"><br/>
			
		<div><span class="signfont">비밀번호</span></div>
		<input class="form-floating mb-1 px-3" id="signPwd" name="signPwd" maxlength="20" oninput="maxlength(this)"  type="password" placeholder="비밀번호">

				<div>
					<button class="signbtn btn btn-outline-dark" type="button" onclick="login()">로그인</button>
				</div>


	
	</div><!-- container end -->
	
	
	
	



	<!-- 부트 스트랩 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

	<!-- jquery 호출 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<!-- js -->
	<script src="/Ezen_teamB/js/login/login.js" type="text/javascript"></script>

</body>
</html>
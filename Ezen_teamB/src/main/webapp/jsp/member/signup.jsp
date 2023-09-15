<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css -->
<link href="" rel="stylesheet">

</head>
<body>
		
		<div class="container"><!-- container -->
		
			<h3>가지가지 커뮤니티 회원가입 페이지</h3>
				
			<div> <!-- 회원가입 구역 -->
			
				<div>아이디</div>
				<input id="signId" type="text"><br/>
				<div class="idCheck"><span style="color:red;">아이디 확인</span></div><br/>		<!-- 중복검사, 영문+숫자 조합 최소 5글자 이상 -->
				
				<div>비밀번호</div>
				<div ><span style="color:gray;">영문, 숫자를 포함한 8자 이상의 비밀번호를 입력해주세요.</span></div>
				<input id="signPwd1" type="password">
				<div class="signPwdCheck1"><span style="color:red;">비밀번호 유효성 검사 출력</span></div><br/>
								
				<div>비밀번호 확인</div>
				<input id="signPwd2" type="password">
				<div class="signPwdCheck2"><span style="color:red;">비밀번호확인 유효성 검사 출력</span></div><br/>
				
				<div>휴대폰 인증</div>	<!-- 네이버 클라우드 무료 50건 문자 인증  -->
				
				<div><button><a href="#">회원 가입</a></button></div>
				
					
			</div><!-- 회원가입 구역 end -->
		
		</div> <!-- container end -->
		




	<!-- js -->
	<script src="" type="text/javascript"></script>
</body>
</html>
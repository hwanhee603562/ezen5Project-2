<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../sns/update.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form class="writeForm">
		비밀번호 : <input type="text" name="spw" class="inputSpw">
		첨부파일 : <input name="simg" type="file" class="writeFileUp"> 
		내용작성 : <textarea name="scontent" class="writeContent"></textarea>
	</form>
	<button onclick="onupdate()"> 수정 </button>
	<a href="/ezen5project-2/sns/content.jsp"> <button> 이전 </button> </a>
	<!-- 글 출력 페이지로 이동 -->
	
	<script src="/ezen5project-2/sns/write.js" type="text/javascript"></script>


	<!-- 최신 JQUERY 불러오기 : AJAX메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="../sns/update.js" type="text/javascript"></script>

</body>
</html>
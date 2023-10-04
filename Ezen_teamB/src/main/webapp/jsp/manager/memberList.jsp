<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<link href="/Ezen_teamB/css/manager/memberList.css" rel="stylesheet">

</head>
<body>


	<div>	<!-- 검색구역 -->
		<select>
			<option value="회원아이디"> 아이디 </option>
			<option value="이름"> 이름 </option>
			<option value="주민번호"> 주민번호 </option>
			<option value="이메일"> 이메일 </option>
			<option value="전화번호"> 전화번호 </option>
		</select>
		<input type="text">
	</div>
	
	<div>
		<table class="memberListTable">
			<tr>
				<th> 성명 </th>
				<th> 주민번호 </th>
				<th> 전화번호 </th>
				<th> 이메일 </th>
				<th> 주소 </th>
				<th> 아이디 </th>
				<th> 포인트 </th>
			</tr>
			<tr>
				<td>  </td>
				<td>  </td>
				<td>  </td>
				<td>  </td>
				<td>  </td>
				<td>  </td>
				<td>  </td>
			</tr>
			
		</table>
	</div>



	<script src="/Ezen_teamB/js/manager/memberList.js" type="text/javascript"></script>

</body>
</html>
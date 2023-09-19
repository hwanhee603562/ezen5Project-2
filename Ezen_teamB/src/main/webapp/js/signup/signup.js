console.log('회원가입 스크립트 실행')

/*
function idcheck(){
	console.log('아이디 체크 함수')
	
	// 입력한 id 값 호출
	let signId = document.getElementById('signId').value;
	console.log(signId)
	
	// 아이디 유효성 검사 출력 구역 
	let idcheck = document.querySelector('.idCheck');	
	
	// 아이디 유효성 검사 / 영문 소,대,숫자 필수 // 최소5~20글자 까지
	let idregular = /^[a-zA-Z\d]{5,20}$/
	console.log(idregular.test(signId));
	
	if(idregular.test(signId)){		
		
		$.ajax({
			
			url : "/Ezen_teamB/MemberController",
			method : "get",
			data : {dape : "signId" , data : signId},
			success : result => {
				if(result){idcheck.innerHTML = `사용중인 아이디 입니다`}
				else{idcheck.innerHTML = `사용 가능한 아이이디 입니다.`}
			},
			error : error=>{ console.log(error)}
		})
	}else{
		idcheck.innerHTML = `영문(대,소문자) + 숫자 조합의 5~20 글자만 입력 가능 합니다.`
	} // else end 
}//idcheck end
*/

function signup(){
	
	let signupform = document.querySelectorAll('.signupform')[0];
	
	let signupData = new FormData(signupform);
	console.log(signupData)
	
	$.ajax({
		
		url : "/Ezen_teamB/MemberController",
		method : "post",
		data : signupData,
	    contentType : false,
	    processData : false,		
		success : result => { 
			console.log(result)
			if(result==true){
				alert('회원가입에 성공 하였습니다')
				location.href="/Ezen_teamB/jsp/member/login.jsp"}
			else{alert('회원가입 실패')}			
		},
		error : error =>{console.log(error)}
		
	})// ajax
	
}// signup end







	console.log(" 글쓰기 js ")
	


function writeSns(){
	let form = document.querySelectorAll('.writeForm')[0];
	let formData = new FormData( form );
	
	let id = document.querySelector('.inputSid').value;
	let pw = document.querySelector('.inputSpw').value;
	let content = document.querySelector('.writeContent').value;

	
	// 유효성검사
		// 아이디가 공백인 경우
	if(id.length == 0 || id == null){ 
		alert('아이디를 입력해주세요');
		return;
	}
		// 비밀번호가 공백인 경우
	if(pw.length == 0 || pw == null){
		alert('비밀번호를 입력해주세요');
		return;
	}
		// 내용이 공백인 경우
	if(content.length == 0 || content == null){
		alert('내용을 입력해주세요');
		return;
	}
		// 비밀번호가 6자리를 초과하는 경우
	if(pw.length > 6){
		alert('비밀번호를 6자리 이하로 입력해주세요');
		return;
	}
	if(id.length > 12){
		alert('아이디를 12자리 이하로 입력해주세요');
		return;
	}
	
	
	$.ajax({
		url: "/ezen5project-2/SnsController",
		method: "post",
		data: formData,
		contentType: false,
		processData: false,
		success: r => {
			
			if(r){
				alert('등록 성공');
				location.href = "/ezen5project-2/sns/content.jsp";
			} else {
				alert('등록 실패');
			}
		},
		error: e => {
			alert('글쓰기 실패 [관리자 문의]');
		}
	});
}
function snsDelete(){
	console.log('삭제 버튼')
	let spwd = prompt('비밀번호 입력 : ')
	
	$.ajax({
		url : "/ezen5project-2/SnsController" ,
		method : "delete" ,
		data : {} ,
		success : r => { 
			console.log(r)
			if(r) {
				alert('삭제 성공')
			}else{alert('삭제 실패]비밀번호가 일치하지않습니다.')}
		},
		error : e => { console.log(e) } 
	});
}
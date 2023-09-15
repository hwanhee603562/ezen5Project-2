function writeBtn() {
	console.log( '글등록 버튼' )
	let form = document.querySelectorAll('.writeForm')[0];
	
	let formData = new FormData(form)
	
	$.ajax({
		url : "/Ezen_teamB/BoardController" , 
		method : "post" ,
		data : formData ,
		contentType : false,
		processData : false,
		success : r => { console.log(r) },
		error : e => { console.log(e )}

	})
}
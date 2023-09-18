function onWriteBtn(){
	console.log('글쓰기버튼')
	alert('회원전용입니다.')
	location.href="/Ezen_teamB/jsp/board/writeboard.jsp"
}
function boardSearch(){
	console.log('검색버튼')
}
function getList(){
	$.ajax({
		url :"/Ezen_teamB/BoardController" ,
		method : "get",
		data : {} ,
		success : r => { console.log(r)} ,
		error : e => {console.log(e)}
	})
}
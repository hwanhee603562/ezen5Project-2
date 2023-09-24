
function getItemList(){
	
	$.ajax({
		url: "/Ezen_teamB/ItemController",
		method: "get",
		data: { type : "getItemList" },
		success: s => {
			console.log('성공')
			console.log(s)
		},
		error: e => {
			console.log('에러발생')
		}
	})
	
}
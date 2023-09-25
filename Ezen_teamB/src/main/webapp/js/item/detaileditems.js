let ino = new URL( location.href ).searchParams.get("ino");
let itrade = new URL( location.href ).searchParams.get("itrade");


function getDetailedItems(){
	
	$.ajax({
		
		url: "/Ezen_teamB/ItemController",
		method: "get",
		data: { 
			type : "getDetailedItems", 
			ino : ino,
			let : itrade
		},
		success: s => {
			console.log(s)
			console.log('성공')
		},
		error: e => {
			console.log('에러발생')
		}
		
		
	})
	
}

/* 개별 조회 */

getBoard()
function getBoard(){
	
	let urlParams = new URL(location.href).searchParams
		console.log(urlParams)
	let bno = urlParams.get("bno")
		console.log(bno)
		
	$.ajax({
		url : "/Ezen_teamB/BoardController" ,
		method : "get" ,
		data : { type : 2 , bno : bno } ,
		success : r =>{ console.log('통신 성공')
			
			let boardBox = document.querySelector('.boardBox')
			
			let html =`
				카테고리 : <div> ${r.cname}</div>
				아이디 : <div> ${r.mid} </div>
				작성일 : <div> ${r.bdate} </div>
				제목 : <div> ${r.btitle} </div>
				내용 : <div> ${r.bcontent}</div>
				첨부파일 : <div> ${r.bfile} </div>

			`;
			
			
	
			
			boardBox.innerHTML = html
		
		} ,
		error : e => { console.log('통신 실패')}

	})
	
	
}
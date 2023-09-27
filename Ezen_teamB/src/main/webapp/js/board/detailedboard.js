
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
				첨부파일 : <div> <a href="/Ezen_teamB/BoardFileDownload="${r.bfile}>${r.bfile}</a> </div>

			`;
			html +='<a href="mainboard.jsp"><button type="button">목록보기</button></a>';
			if(r.ishost){
			
				html+=`
					<button onclick="bUpdate(${r.bno})" type="button">수정</button>
					<button onclick="bDelete(${r.bno})" type="button">삭제</button>`;
			}
	
			
			boardBox.innerHTML = html
		
		} ,
		error : e => { console.log('통신 실패')}

	})
	
	
}
// 게시물 수정
function bUpdate(bno){
	location.href=`/Ezen_teamB/jsp/board/updateboard.jsp?bno=${bno}`;
}
// 게시물 삭제
function bDelete(bno) {
	$.ajax({
		url : "/Ezen_teamB/BoardController",
		method : "delete" ,
		data : { bno : bno } ,
		success : r => { console.log("통신성공")
			if(r) {
				alert('삭제 성공')
				location.href="/Ezen_teamB/jsp/board/mainboard.jsp"
			}else { alert('삭제 실패')}
		} ,
		error : e => { console.log("통신실패") }
	})
}






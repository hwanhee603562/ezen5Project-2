
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
			let bottomBtn = document.querySelector('.bottomBtn')
			
			let html =`
				<div class="detailedTop">
				<div> 
					제목 : ${r.btitle} </br>
				 	아이디 :  ${r.mid} 
				 </div>
				<div> 
					${r.cname} </br>
					${r.bdate}
				</div>
				</div>
				
				<div class="detailedMid">
				<div> 내용 : ${r.bcontent} </div>
				<div>첨부파일 :  <a href="/Ezen_teamB/BoardFileDownload="${r.bfile}>${r.bfile}</a></div>
				
				</div>
		

			`;
			boardBox.innerHTML = html
			
			if(r.ishost){
			
				html =`
					<div class="detailbtn">
					<button onclick="bUpdate(${r.bno})" type="button">수정</button>
					<button onclick="bDelete(${r.bno})" type="button">삭제</button>
					</div>
					`;
				
				bottomBtn.innerHTML = html;
				
			}
			
			
			
			
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
// 답글
function replyWrite(){
	console.log("답글")
	
	
}






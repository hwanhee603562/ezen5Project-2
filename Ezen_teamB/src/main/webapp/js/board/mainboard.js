function onWriteBtn(){
	console.log('글쓰기버튼')
	if(""){
		
	}else{alert('회원전용입니다.')}
	
	location.href="/Ezen_teamB/jsp/board/writeboard.jsp"
}

/* 게시물 조회 */
let pageObject = { type : 1 , cno : 0 , listsize : 10 , page : 1 }



function boardSearch(){
	console.log('검색버튼')
}
getList();
function getList(){
	$.ajax({
		url :"/Ezen_teamB/BoardController" ,
		method : "get",
		data : pageObject ,
		success : r => { console.log(r)
			
			let boardTable = document.querySelector('.boardTable');
			
			let html = `
				<tr>
					<th> 번호 </th>
					<th> 카테고리 </th>
					<th> 제목 </th>
					<th> 작성자 </th>
					<th> 조회수 </th>
					<th> 작성일 </th>
				</tr>
			`;
			r.boardList.forEach( b=>{
				html +=`
					
					<tr>
						<td>${b.bno}</td>
						<td>${b.btitle}</td>
						<td>${b.bcontent}</td>
						<td>${b.mid}</td>
						<td>${b.bdate}</td>
					</tr>
				
				
				`;
			})
			boardTable.innerHTML = html;
		
		} ,
		error : e => {console.log(e)}
	})
}
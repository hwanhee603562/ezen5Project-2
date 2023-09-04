

// 실행시 한번 자동출력
printSns();

function printSns(){
	
	$.ajax( { 
       url : "http://localhost/ezen5project-2/SnsController",
       data : "",         // 보내는 데이터
       method : "get",
       success : r =>{console.log('통신성공')
       		
       		let snsContent = document.querySelector('.outputField');
			let html = ``;
      		
      		for(let i =0; i < r.length; i++){
				  html += 
				  `
				  	<div class="contentBox">
					  	<img class="writeImg" src="/ezen5project-2/sns/img/">			<!-- 작성 사진 -->
					  	<div class="writer">${r[i].sid}</div>
						<div class="writeDate">${r[i].sdate}</div>	<!-- 작성 시간 출력 -->
						<div class="writeContent">${r[i].scontent}</div>	<!-- 작성 글 출력 -->
						<div class="bottomBtn">				<!-- 하단 버튼 구역 -->
							<button onclick="updateSns(${r[i].sno}, ${r[i].spwd})" class="updateBtn"> 수정 </button>	<!-- 수정 버튼 -->
							<button onclick="snsDelete(${r[i].sno}, ${r[i].spwd})" class="deleteBtn"> 삭제 </button>	<!-- 삭제 버튼 -->
						</div>
					</div>
				  `
			  }
			  snsContent.innerHTML = html;
       		
		},
       	error : e=>{console.log(e)}
     });
	
}

function updateSns(sno, spwd){
	let spwdCheck = prompt('비밀번호를 입력해주세요.');
	
	if(spwdCheck == spwd){
		location.href = `/ezen5project-2/sns/update.jsp?sno=${sno}`
	}
	
	
}



function snsDelete(sno, spwd){
	console.log('삭제 버튼')
	let spwdCheck = prompt('비밀번호를 입력해주세요. ')
	
	if(spwdCheck == spwd){
		
		$.ajax({
			url : "/ezen5project-2/SnsController" ,
			method : "delete" ,
			data : {sno : sno} ,
			success : r => { 
				console.log(r)
				if(r) {
					alert('삭제 성공')
					printSns();
				}else{alert('삭제 실패')}
			},
			error : e => { console.log(e) } 
		});
	}else{alert('삭제 실패]비밀번호가 일치하지않습니다.')}
	
}




// 실행시 한번 자동출력
printSns();

function printSns(){
	 
	$.ajax( { 
       url : "/ezen5project-2/SnsController",
       data : "",         // 보내는 데이터
       method : "get",
       success : r =>{console.log('통신성공')
       		
       		let snsContent = document.querySelector('.outputField');
			let html = ``;
      		
      		r.snsList.forEach(b => {
				  
				  if( Number(b.sdate) < 60){
					  if(Number(b.sdate) < 1){
						  b.sdate = '조금전'
					  }else{
						  b.sdate = b.sdate + '분전';
					  }
				  }else if(Number(b.sdate) > 525600){
					  b.sdate = Math.floor(Number(b.sdate)/525600) + '년전'
				  } else if(Number(b.sdate) > 60){
					  if(Number(b.sdate)/60 >= 24){
						  b.sdate = Math.floor((Number(b.sdate)/60)/24) + '일전'
					  }else{
						  b.sdate = Math.floor(Number(b.sdate)/60) + '시간전'
					  }
				  }
				  
				  html += 
				  `
				  	<div class="contentBox">

					  	<div class="imgBox"> <img class="writeImg" src="/ezen5project-2/sns/img/${b.simg}">	</div>		<!-- 작성 사진 -->
					  	<div class="writer">${b.sid}</div>
						<div class="writeDate">${b.sdate}</div>	<!-- 작성 시간 출력 -->
						<div class="writeContent">${b.scontent}</div>	<!-- 작성 글 출력 -->
						<div class="bottomBtn">				<!-- 하단 버튼 구역 -->
							<button onclick="updateSns(${b.sno}, '${b.spwd}')" class="updateBtn"> 수정 </button>	<!-- 수정 버튼 -->
							<button onclick="snsDelete(${b.sno}, '${b.spwd}')" class="deleteBtn"> 삭제 </button>	<!-- 삭제 버튼 -->
							<button onclick="reply()"> 답글 </button>
							<div class="replyList">
							`
							// 답글 출력구역
							r.replyList.forEach( c => {
								
								if(c.sno == b.sno){
									html += 
									`
									<div class="replyPrintBox">
										<div class="outputReply"> ${c.rcontent} </div>
										<div>
											<span class="outputTime"> 시간출력구역 </span>
											<span onclick="deleteReply(${c.rno})" class="rdeleteBtn"> x </span>
										</div>
									</div>
									`
								}
							})
	
				 html +=				
							`	
							</div>
						</div>
						
						
						
					</div>
				  `
			  })
			  snsContent.innerHTML = html;
       		
		},
       	error : e=>{console.log(e)}
     });
	
}

// 게시글 수정
function updateSns(sno, spwd){
	let spwdCheck = prompt('비밀번호를 입력해주세요.');
	
	if(spwdCheck == spwd){
		location.href = `/ezen5project-2/sns/update.jsp?sno=${sno}`
	}else{
		alert('비밀번호가 틀렸습니다.')
	}
	
	
}


// 게시글 삭제
function snsDelete(sno, spwd){
 
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





















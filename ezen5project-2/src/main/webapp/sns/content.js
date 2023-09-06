
console.log('통신성공')
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
      		
      		// content 구역 출력 전 총 피드 수 출력
			document.querySelector('.feedCount').innerHTML = `총 피드 수 : ${r.length}`;
      		
      		for(let i =0; i < r.length; i++){

      		r.snsList.forEach(b => {
				  
				  if( Number(b.sdate) < 60){
					  if(Number(b.sdate) < 1){
						  b.sdate = '조금전'
					  }else{
						  b.sdate = b.sdate + '분전';
					  }
				  }else if(Number(b.sdate) > 60){
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

							<button onclick="updateSns(${r[i].sno}, '${r[i].spwd}')" class="updateBtn"> 수정 </button>	<!-- 수정 버튼 -->
							<button onclick="snsDelete(${r[i].sno}, '${r[i].spwd}')" class="deleteBtn"> 삭제 </button>	<!-- 삭제 버튼 -->
							<button onclick="reply(${r[i].sno})"> 답글 </button>

							<div class="replyList">
							`
							// 답글 출력구역
							r.replyList.forEach( c => {
								console.log(c)
								
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
       		}	// 반복문 r.length end
		},	// success end
       	error : e=>{console.log(e)}
     }); // ajax end
	
}	// function end

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


// content 검색기능
function searchContent(){
	let searchWord = document.querySelector('.searchInput').value;
	

		
	$.ajax({
		url: "/ezen5project-2/SearchController",
		method: "get",
		data: {searchWord : searchWord},
		success: r => {
       		
       		let snsContent = document.querySelector('.outputField');
			let html = ``;
			
			// content 구역 출력 전 총 피드 수 출력
			document.querySelector('.feedCount').innerHTML = `총 피드 수 : ${r.length}`;

      		
      		for(let i =0; i < r.length; i++){

      		r.snsList.forEach(b => {
				  
				  if( Number(b.sdate) < 60){
					  if(Number(b.sdate) < 1){
						  b.sdate = '조금전'
					  }else{
						  b.sdate = b.sdate + '분전';
					  }
				  }else if(Number(b.sdate) > 60){
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

							<button onclick="updateSns(${r[i].sno}, '${r[i].spwd}')" class="updateBtn"> 수정 </button>	<!-- 수정 버튼 -->
							<button onclick="snsDelete(${r[i].sno}, '${r[i].spwd}')" class="deleteBtn"> 삭제 </button>	<!-- 삭제 버튼 -->
							<button onclick="reply(${r[i].sno})"> 답글 </button>

							<div class="replyList">
							`
							// 답글 출력구역
							r.replyList.forEach( c => {
								console.log(c)
								
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
       		}
		},
		error: e => {
			console.log('통신실패');
		}
	})
}




// 답글등록 함수
function reply( sno ){
	console.log('답글 응답')
	console.log(sno)
	let rcontent = prompt('답글 입력해주세요');
	let rpwd = prompt('비밀번호를 입력해주세요')
	
	if(rcontent.length == 0 || rcontent == null ){
		alert('답글을 입력해주세요')
		return
	}
	if(rpwd.length == 0 || rpwd == null ){
		alert('비밀번호를 입력해주세요')
		return
	}
		
	
	$.ajax({
		url : "/ezen5project-2/ReplyController" ,
		method : "post" ,
		data : { rcontent : rcontent , rpwd : rpwd , sno : sno} , 
		success : r => { console.log(r)
			if(r){
				alert('등록 성공')
			}else{
				alert('등록 실패')
			}
		 },
		error : e => { console.log(e) } 
	})
	
}






















function deleteReply( rno ){
	
	let rpwd = prompt('답글 비밀번호를 입력하십시오');
	
	$.ajax({
		url : "/ezen5project-2/ReplyController",
		method : "delete",
		data : { rno : rno, rpwd : rpwd },
		success : r =>{
			if(r){
				alert('삭제가 완료되었습니다')
			} else {
				alert('비밀번호가 일치하지 않습니다')
			}
		},
		error : e =>{
			
		}
	})
	
	
}























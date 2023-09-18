
// 실행시 한번 자동출력
printSns();

function printSns(){ 
	 
	$.ajax( { 
       url : "/ezen5project-2/SnsController",
       data : "",         // 보내는 데이터
       method : "get",
       success : r =>{

       		let snsContent = document.querySelector('.outputField');
			let html = ``;
      		
      		// content 구역 출력 전 총 피드 수 출력
			document.querySelector('.feedCount').innerHTML = `총 피드 수 : ${r.snsList.length}`;
      		

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
							<button onclick="reply(${b.sno})"> 답글 </button>
<<<<<<< HEAD
							<button onclick="downloadbtn('${b.simg}')" type="button">다운로드</button>

<<<<<<< HEAD
=======
							<button onclick="downloadbtn()" type="button">다운로드</button>
							
							<div class="userCheck">
								<button onclick="userGood(${b.sno})" type="button"> 좋아용 </button>
								<button onclick="userBad(${b.sno})" type="button"> 싫어용 </button>
							</div>
							
>>>>>>> branch 'master' of https://github.com/hwanhee603562/ezen5Project-2
=======

>>>>>>> branch '최병철' of https://github.com/hwanhee603562/ezen5Project-2
							<div class="replyList">
<<<<<<< HEAD
							` 
=======

								<div class="outputReply" value=""> 답글출력구역 </div>
								<div>
									<span class="outputTime"> 시간출력구역 </span>
									<button onclick="deleteReply()" class="deleteBtn"> x </button>
								</div>

							`
>>>>>>> branch '최병철' of https://github.com/hwanhee603562/ezen5Project-2
							// 답글 출력구역
							r.replyList.forEach( c => {
								if( Number(c.rdate) < 60){
									 if(Number(c.rdate) < 1){
										  c.rdate = '조금전'
									 }else{
										  c.rdate = c.rdate + '분전';
									 }
								}else if(Number(c.rdate) > 60){
									 if(Number(c.rdate)/60 >= 24){
										  c.rdate = Math.floor((Number(c.rdate)/60)/24) + '일전'
									 }else{
										  c.rdate = Math.floor(Number(c.rdate)/60) + '시간전'
									 }
								} 
								 
								if(c.sno == b.sno){
									html += 
									`
									<div class="replyPrintBox">
										<div class="outputReply"> ${c.rcontent} </div>
										<div>
											<span class="outputTime"> ${c.rdate} </span>
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
		},	// success end
       	error : e=>{ console.log('통신실패') }
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
				if(r) {
					alert('삭제 성공')
					printSns();
				}else{alert('삭제 실패')}
			},
			error : e => {} 
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
			document.querySelector('.feedCount').innerHTML = `총 피드 수 : ${r.snsList.length}`;
      		

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
				  console.log(b.simg)
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
							<button onclick="reply(${b.sno})"> 답글 </button>
<<<<<<< HEAD
							<button onclick="downloadbtn('${b.simg}')" type="button">다운로드</button>

=======
							<button onclick="downloadbtn(${b.simg})" type="button">다운로드</button>
							
							<div class="userCheck">
								<button onclick="userGood(${b.sno})" type="button"> 좋아용 </button>
								<button onclick="userBad(${b.sno})" type="button"> 싫어용 </button>
							</div>
							
>>>>>>> branch 'master' of https://github.com/hwanhee603562/ezen5Project-2
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
		},	// success end
		error: e => {
			console.log('통신실패');
		}
	})
}



// 답글등록 함수
function reply( sno ){

	
	// 답글 입력 후 유효성 검사
	let rcontent = prompt('답글 입력해주세요');
	if(rcontent.length == 0 || rcontent == null ){
		alert('답글을 입력해주세요')
		return
	}
	if(rcontent.length > 30){
		alert('답글은 최대 30글자 까지만 입력 가능합니다')
		return;
	}
	
	// 답글 비밀번호 입력 후 유효성 검사
	let rpwd = prompt('비밀번호를 입력해주세요')
	if(rpwd.length == 0 || rpwd == null ){
		alert('비밀번호를 입력해주세요')
		return
	}
	if(rpwd.length < 8){
		alert('비밀번호를 8자리 이상으로 설정하십시오')
		return;
	}
		
	
	$.ajax({
		url : "/ezen5project-2/ReplyController" ,
		method : "post" ,
		data : { rcontent : rcontent , rpwd : rpwd , sno : sno} , 
		success : r => { 
			if(r){
				alert('등록 성공')
			}else{
				alert('등록 실패')
			}
			printSns();
		 },
		error : e => {} 
	})
	
}



function replyprint(){
	
	
	    $.ajax({
      url :  "/ezen5project-2/ReplyController",
      method : "get" , 
      data : {sno : sno} ,
      success : r => {
		  
		let output = document.querySelector('.outputReply')
		for(let i = 0; i<r.length; i++){}
		html = `${d}`
		  
	  } ,
      error :  e => {e}
      });
	
	
	
	
	
	html = ``;
	
	
	
	output.innerHTML=html;
	
	
	
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
				printSns();
			} else {
				alert('비밀번호가 일치하지 않습니다')
			}
		},
		error : e =>{}
	})
	
	
}
// 이미지 다운로드
function downloadbtn(simg){
	
	console.log('다운로드 버튼')
	
	$.ajax({
		url : "/ezen5project-2/ImgDownloadController" ,
		method : "get",
		data : { simg : simg } ,
		success : r => { console.log('성공') } ,
		error : e => { console.log('실패') } 
	});
}

// 게시물 조회시 유저의 무반응/좋아요/싫어요 상태 확인 
	// 		0 : 좋아요	1 : 싫어요
	// 해당 유저의 IP를 DB 데이터와 비교하여 데이터 저장이 없으면 [무반응] 기본 이미지로 변경
	// 해당 유저가 좋아요 혹은 싫어요를 취소할 경우 DB에 해당 데이터 삭제


// 좋아요



// 싫어요
















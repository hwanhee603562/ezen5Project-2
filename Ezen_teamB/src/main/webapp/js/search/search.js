console.log('search js 정상')

// 인풋 박스 최대 글자수 이상 입력 불가
function maxlength(object){
    if (object.value.length > object.maxLength){
      object.value = object.value.slice(0, object.maxLength);
  }    
}



// 아이디 찾기 함수
function idSearch(){ console.log('아이디 찾기 함수 실행')
	
	let mname = document.getElementById('searchName').value;
	console.log('아이디찾기 가져온 아이디 ' + mname)
	let mphone = document.getElementById('searcPhone').value;
		console.log('아이디찾기 가져온 전화번호 ' + mphone)

	$.ajax({
		
		url:"/Ezen_teamB/SearchController",
		method : "get",
		data :{type : "id" , mname : mname , mphone : mphone},
		success : result => {console.log(result)
			if(result=='null'){
				alert('정보가 일치하지 않습니다')
			}else if(result !='null'){
				alert('고객님의 아이디는 '+result+' 입니다' )
			}

			
		},
		error : e =>{console.log(e)}
	});

		
}


// 비밀번호 찾기 함수
function pwdSearch(){ console.log('비밀번호 찾기 함수 실행')
	let mid = document.getElementById('searchId').value;
	console.log('비밀번호찾기 가져온 아이디 ' + mid)	
	let memail = document.getElementById('searchEmail').value;
	console.log('비밀번호찾기 가져온 아이디 ' + memail)	


	$.ajax({
		
		url:"/Ezen_teamB/SearchController",
		method : "get",
		sasync:false,
		data :{type : "pwd" , mid : mid , memail : memail},
		success : result => {console.log(result)

			if(result=='null'){
				alert('정보가 일치하지 않습니다')
			}else if(result !='null'){
				
				alert('고객님의 임시 비밀번호는 '+result+' 입니다' )
			}
			
			
		},
		error : e =>{console.log(e)}
	});
	

	
}
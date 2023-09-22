console.log('마이메뉴 JS');

/* 네비게이션 이벤트 함수 */
document.querySelector('.smenu1').addEventListener("click",(e)=>{
	console.log('1번클릭');
	
	document.getElementById('smenu1').classList.add('active');
	document.getElementById('smenu2').classList.remove('active');
	document.getElementById('smenu3').classList.remove('active');
	document.getElementById('smenu4').classList.remove('active');
})

document.querySelector('.smenu2').addEventListener("click",(e)=>{
	console.log('2번클릭');
	
	document.getElementById('smenu1').classList.remove('active');
	document.getElementById('smenu2').classList.add('active');
	document.getElementById('smenu3').classList.remove('active');
	document.getElementById('smenu4').classList.remove('active');
})

document.querySelector('.smenu3').addEventListener("click",(e)=>{
	console.log('3번클릭');
	
	document.getElementById('smenu1').classList.remove('active');
	document.getElementById('smenu2').classList.remove('active');
	document.getElementById('smenu3').classList.add('active');
	document.getElementById('smenu4').classList.remove('active');
})

document.querySelector('.smenu4').addEventListener("click",(e)=>{
	console.log('4번클릭');
	
	document.getElementById('smenu1').classList.remove('active');
	document.getElementById('smenu2').classList.remove('active');
	document.getElementById('smenu3').classList.remove('active');
	document.getElementById('smenu4').classList.add('active');
})

// 회원정보 출력 함수   ---> 기능 완성후 html 출력기능 함수로 합칠것
infoPrint();
function infoPrint(){console.log('회원정보 출력 함수')
	
	let mno = 2;
	
	$.ajax({ 
	       url : "/Ezen_teamB/MyMenuController",
	       data : {type: '2' , mno: mno},         // 보내는 데이터
	       method : "get",
	       async: false,
	       success : r =>{console.log(r);
	       
				let infoContent = document.querySelector('.infoContent');
				let html = ``;
				
				html +=
				`
					<h3 class="infoTitletxt"> 마이페이지 </h3>
					<div class="contentHeader">${r.mid} <span>회원님</span></div>
					<div class="contentMain">
						<div class="titleTop">처음온손님</div>
						<div class="tradeTop">거래활동 <span>${r.tradelog}</span></div>
						<div class="saleTop">판매물품 <span>${r.saleProduct}</span></div>
						<div class="pointTop">포인트 <span>${r.mpoint}</span></div>
					</div>
					<div class="infoDetail">
						<div class="name">이름 ${r.mname}</div>
						<div class="address"> 주소 ${r.madress}</div>
						<div class="email"> 이메일 ${r.memail}</div>
					</div>
					<button onclick="updateModal()" class="btn btn-outline-dark btn-sm updateBtn"
					data-bs-toggle="modal" data-bs-target="#exampleModal">정보수정</button>
				`
				
				
				
				
				infoContent.innerHTML = html;
				
	       },
	       error : e =>{console.log('통신실패')}
	 });
	
	
}

// 마이메뉴 페이지 출력시 함수 실행
saleList();
// 판매중인상품 리스트 출력 함수
function saleList(){console.log('판매중인상품 리스트')

	let mno = 2;

	$.ajax( { 
	       url : "/Ezen_teamB/MyMenuController",
	       data : {type: '1' , mno: mno, estate : 1},         // 보내는 데이터
	       method : "get",
	       async: false,
	       success : jsonArray =>{console.log(jsonArray);
	       		let cardInfo = document.querySelector('.cardInfo');
	       		let html = ``;
	       		
	       		// 판매중인 상품 숫자 출력
	       		let saleProduct = jsonArray.length
	       		let productCount = document.querySelector('.productCount');
	       		html = `<h4>상품 <span class="countText">${saleProduct}</span></h4>`;   		
	       		productCount.innerHTML = html
	       		
	       		html = 
	       		`
	       			<table class="table table-hover align-middle text-center">
						  <tbody class="tableBody">
	       		`;
	       		
	       		if(jsonArray.length < 1){
					   tableBody.innerHTML = `판매중인 상품이 없습니다.`;
					   return;
				   }
	       		
	       		// 회원번호에 따른 판매중인 상품 출력
	       		jsonArray.forEach((p,i)=>{
					   if(p.itrade == 1){
						   p.itrade = '배송'
					   }else if(p.itrade == 2){
						   p.itrade = '직거래'
					   }else if(p.itrade == 3){
						   p.itrade = '중개소거래'
					   }
					   
					   p.idate = (p.idate).substr(0,10);
					   html += 
					   `
							   		<tr class="tableContent">
								      <th scope="row">${i+1}</th>
								      <td width="10%"><img src="/Ezen_teamB/item/img/${Object.values(p.imgList)[0]}"></td>
								      <td width="30%">${p.ititle}</td>
								      <td width="10%">${p.itrade}</td>
								      <td width="20%">${p.uname}/${p.dname}</td>
								      <td>${p.idate}</td>
								    </tr>
					   `
					   
				   })
				   
				   html += 
				   `
				   			</tbody>
						</table>
				   `
	       		cardInfo.innerHTML = html;
	       		
			},
	       	error : e=>{console.log(e)}
	     });
	
}		// function end


// 거래내역 출력함수
function transHistory(){console.log('거래내역 리스트')

	let mno = 2;
	
	$.ajax( { 
	       url : "/Ezen_teamB/MyMenuController",
	       data : {type: '1' , mno: mno, estate : 2},         // 보내는 데이터
	       method : "get",
	       async: false,
	       success : jsonArray =>{console.log(jsonArray);
	       	
	       		let cardInfo = document.querySelector('.cardInfo');
	       		let html = 
				`
	       			<table class="table table-hover align-middle text-center">
						  <tbody class="tableBody">
	       		`;
				
	       		
	       		// 회원번호에 따른 거래내역 출력
	       		jsonArray.forEach((p,i)=>{
					   console.log(Object.values(p.imgList)[0]);
					   if(p.itrade == 1){
						   p.itrade = '배송'
					   }else if(p.itrade == 2){
						   p.itrade = '직거래'
					   }else if(p.itrade == 3){
						   p.itrade = '중개소거래'
					   }
					   p.idate = (p.idate).substr(0,10);
					   html += 
					   `
					   		<tr class="tableContent">
						      <th scope="row">${i+1}</th>
						      <td width="5%"><img src="/Ezen_teamB/item/img/${Object.values(p.imgList)[0]}"></td>
						      <td>${p.ititle}</td>
						      <td>${p.itrade}</td>
						      <td>${p.uname}/${p.dname}</td>
						      <td>${p.idate}</td>
						      <td><div class="saleComplete">판매완료<div></td>
						    </tr>
					   `
					   
				   })
				 
				 html += 
				   `
				   			</tbody>
						</table>
				   `   
				 
	       		cardInfo.innerHTML = html;
	       		
	       		let saleProduct = jsonArray.length
	       		let productCount = document.querySelector('.productCount');
	       		html = `<h4>상품 <span class="countText">${saleProduct}</span></h4>`;   		
	       		productCount.innerHTML = html
	       },
	       error : e => {}
	
	});
	
}

// 찜목록 출력함수
function PrintWishList(){console.log('찜목록 리스트')
	
	let mno = 2;
	
	$.ajax({
		url : "/Ezen_teamB/MyMenuController",
		async : false,
		data : {type : '3', mno : mno},
		method : "get", 
		success : jsonArray =>{console.log(jsonArray);
		
		let cardInfo = document.querySelector('.cardInfo');
	       		let html = 
				`
	       			<table class="table table-hover align-middle text-center">
						  <tbody class="tableBody">
	       		`;
				
	       		
	       		// 회원번호에 따른 거래내역 출력
	       		jsonArray.forEach((p,i)=>{
					   console.log(Object.values(p.imgList)[0]);
					   if(p.itrade == 1){
						   p.itrade = '배송'
					   }else if(p.itrade == 2){
						   p.itrade = '직거래'
					   }else if(p.itrade == 3){
						   p.itrade = '중개소거래'
					   }
					   p.idate = (p.idate).substr(0,10);
					   html += 
					   `
					   		<tr class="tableContent">
						      <th scope="row">${i+1}</th>
						      <td width="5%"><img src="/Ezen_teamB/item/img/${Object.values(p.imgList)[0]}"></td>
						      <td>${p.ititle}</td>
						      <td>${p.itrade}</td>
						      <td>${p.uname}/${p.dname}</td>
						      <td><div class="saleContinue">판매중<div></td>
						      <td><button onclick="deleteWishList(${p.ino})" class="btn btn-danger wdbtn" type="button">삭제</button></td>
						    </tr>
					   `
					   
				   })
				 
				 html += 
				   `
				   			</tbody>
						</table>
				   `   
				 
	       		cardInfo.innerHTML = html;
	       		
	       		let saleProduct = jsonArray.length
	       		let productCount = document.querySelector('.productCount');
	       		html = `<h4>상품 <span class="countText">${saleProduct}</span></h4>`;   		
	       		productCount.innerHTML = html
		
		},
		error : e=>{console.log('통신실패')}
	})
	
}	// f end


// 회원정보 수정 모달창 함수
function updateModal(){ console.log('회원정보 변경 함수')
	
	let mno = 2;
	
	$.ajax({ 
	       url : "/Ezen_teamB/MemberController",
	       data : {type: '1' , mno: mno},         // 보내는 데이터
	       method : "get",
	       success : r =>{console.log(r);
	       		
	       		let emailInput = document.querySelector('.emailInput');
	       		let pwd = document.querySelector('.pwd');
	       		let pwdCk = document.querySelector('.pwdCk')
	       		emailInput.value = `${r.memail}`
	       		pwd.value = `	${r.mpwd}`
	       		pwdCk.value = `${r.mpwd}`
	       		
	       }
	});
	
}	// updateInfo function end

// 회원정보 수정 함수
function updateInfo(){
	
	let mno = 2
	
	let emailInput = document.querySelector('.emailInput').value;
	let adrInput2 = document.querySelector('.adrInput2').value;
	let adrInput3 = document.querySelector('.adrInput3').value;
	let pwd = document.querySelector('.pwd').value;
	
	$.ajax({ 
	       url : "/Ezen_teamB/MemberController",
	       data : {mno: mno, memail : emailInput,
	       adress1 : adrInput2, adress2 : adrInput3, mpwd : pwd},
	       method : "put",
	       success : r =>{console.log(r);
				if(r){
					alert('회원정보가 수정되었습니다.')
					location.href = "/Ezen_teamB/jsp/member/login.jsp"
				}else{alert('수정 실패')}
	       		
	       }
	});
}	// updateInfo f end


// 찜목록 삭제함수
function deleteWishList(ino){console.log('찜목록 삭제함수')

	let mno = 2;
	
	$.ajax({ 
	       url : "/Ezen_teamB/MemberController",
	       data : {type : "1", ino: ino, mno: mno},         // 보내는 데이터
	       method : "get",
	       success : r =>{console.log('통신성공');
	       		
	       },
	       error: e => {console.log(e)}
	});

}



/* 주소 검색 api */				// 추후 header에서 통일 가능

//팝업 위치를 지정(화면의 가운데 정렬)
var width = 500; //팝업의 너비
var height = 600; //팝업의 높이

// 주소 입력 api
function execPostCode() {
         new daum.Postcode({
		    width: width, //생성자에 크기 값을 명시적으로 지정해야 합니다.
		    height: height,			 
			 
             oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                console.log(data.zonecode);
                console.log(fullRoadAddr);
                
                
                $("[name=addr1]").val(data.zonecode);
                $("[name=addr2]").val(fullRoadAddr);
                
                
                /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
                document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
            }
         }).open({
		    left: (window.screen.width / 2) - (width / 2),
		    top: (window.screen.height / 2) - (height / 2)
		});
}



























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

// 회원정보 출력 함수
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
					<div class="name">이름 ${r.mname}</div>
					<div class="address"> 주소 ${r.madress}</div>
					<div class="email"> 이메일 ${r.memail}</div>
					<button class="btn btn-outline-dark btn-sm updateBtn">정보수정</button>
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
						      <td><button class="btn btn-danger" type="button">x</button></td>
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
	
}































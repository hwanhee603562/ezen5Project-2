


// 전체 물품 출력
getItemList()
function getItemList(){
	
	$.ajax({
		url: "/Ezen_teamB/ItemController",
		method: "get",
		data: { type : "getMainCategory" },
		success: s => {
			
			// 대분류 카테고리 출력
			let html = `<tr>`
			for( let i=0; i<s.length; i++ ){
				
				if( i==5 || ( i>4 && i%5==0 ) ){
					html += `</tr><tr>`
				}
				html += `<td onclick="outputSubCategory(${s[i].uno})"> ${s[i].uname} </td>`
			}
			html += `</tr>`
			
			document.querySelector('.outputUmaincategory').innerHTML = html 
		},
		error: e => {
			console.log('에러발생')
		}
	})
	
}

// 상세 카테고리 출력
function outputSubCategory( uno ){
	
	$.ajax({
		url: "/Ezen_teamB/ItemController",
		method: "get",
		data: { type : "getSubCategory", uno : uno },
		success: s => {
			
			// 소분류 카테고리 출력
			let html = `
				<div class="guideLabel"> 소분류 </div>
					<table class="outputDsubcategory">
						<tr>`
			for( let i=0; i<s.length; i++ ){
				
				if( i==5 || ( i>4 && i%5==0 ) ){
					html += `</tr><tr>`
				}
				html += `<td onclick="outputFilter(${s[i].dno})"> ${s[i].dname} </td>`
			}
			
			// 테이블의 간격을 일정하게 유지하기 위해 
			// 소분류의 길이가 5이하일 경우 5까지 부족한 td의 갯수만큼 추가 
			if( s.length < 5 ){
				
				for(let i=0; i<5-s.length; i++){
					html += `<td></td>`	
				}
			}
			
			html += `</table></tr>`
			
			document.querySelector('.bottomCategory').innerHTML = html 
			
		},
		error: e => {
			console.log('에러발생')
		}
		
	})
}


function outputFilter(){
	
}













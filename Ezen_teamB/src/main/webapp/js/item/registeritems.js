

getMainCategory()
// 1. 카테고리 대분류/소분류 출력
function getMainCategory(){
	
	$.ajax({
		url: "/Ezen_teamB/ItemController",
		method: "get",
		data : {type : "getMainCategory"},
		success: s => {
			
			let mainUl = document.querySelector('.mainUl');
			let mainhtml = ``;
			
			s.forEach( category => {
				mainhtml += `<li> <button onclick="getSubCategory(${ category.uno })" type="button"> ${ category.uname } </button> </li>`;
			});

			mainUl.innerHTML = mainhtml;
			
		},
		error: e => {
			console.log('에러 발생')
		}
	})
	
}

// 2. 대분류 카테고리를 클릭하였을 때 해당되는 소분류 카테고리 출력
function getSubCategory( uno ){
	
	$.ajax({
		url: "/Ezen_teamB/ItemController",
		method: "get",
		data : {type : "getSubCategory", uno : uno},
		success: s => {
			let subUl = document.querySelector('.subUl');
			let subhtml = ``;
			
			// 해당 대분류에 소분류 카테고리가 없으면 등록되어있지 않음을 출력
			if( s.length == 0 ) subhtml += `<li> <button onclick="test(${dname})" type="button"> 현재 소분류 카테고리가<br> 등록되어있지 않습니다 </button> </li>`;
			s.forEach( category => {
				// getSubCategory(${ category.dno })
				subhtml += `<li> <button onclick="" type="button"> ${ category.dname } </button> </li>`;
				
			});

			subUl.innerHTML = subhtml;
			
		},
		error: e => {
			console.log('에러 발생')
		}
	})
}


function registerItems(){
	
	// 1. form dom객체 호출
	let registerForm = document.querySelectorAll('.registerForm')[0];
	let formData = new FormData( registerForm );
	
	console.log(formData)
	
} 
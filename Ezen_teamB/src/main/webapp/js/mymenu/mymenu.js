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

// 마이메뉴 페이지 출력시 함수 실행
saleList();
// 판매중인상품 리스트 출력 함수
function saleList(){console.log('판매중인상품 리스트')

	let mno = 2;

	$.ajax( { 
	       url : "/Ezen_teamB/MyMenuController",
	       data : {type: '1' , mno: mno},         // 보내는 데이터
	       method : "get",
	       success : r =>{console.log('통신성공')
	       		
	       		
			},
	       	error : e=>{console.log(e)}
	     });
	
}
































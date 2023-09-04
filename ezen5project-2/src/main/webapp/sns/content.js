console.log('content.js 실행')

// 실행시 한번 자동출력
printSns();

function printSns(){
	
	$.ajax( { 
       url : "http://localhost/ezen5project-2/SnsController",
       data : "",         // 보내는 데이터
       method : "get",
       success : r =>{console.log('통신성공')
       		
       		
		},
       	error : e=>{console.log(e)}
     });
	
}

























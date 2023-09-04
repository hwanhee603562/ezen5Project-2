console.log('업데이트 sj 실행 되나요')

let sno = new URL(location.href).searchParams.get("sno");

getRead()
// 기존 작성한 게시물내용 출력 함수
function getRead(sno){
	console.log('기존내용 출력 정상작동')
	
	  $.ajax({
      url :  "/ezen5project-2/SnsController",
      method : "get" , 
      data : {sno : sno} ,
      success : r => {
		document.querySelector('.simg').value=`${r.simg}`;
		document.querySelector('.scontent').value=`${r.scontent}`;

	  } ,
      error :  e => {e}
      });
	
} //getRead end


// 수정 함수

function onupdate(sno){
	console.log('수정 정상작동')
	
	
	
	
	
	
}// onupdate end
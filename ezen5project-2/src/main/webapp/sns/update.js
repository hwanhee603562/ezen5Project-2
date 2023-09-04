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
	
	// 전체 정보 가져오기
	let formData = new FormData(document.querySelectorAll('.writeForm')[0]);
	console.log("글수정 formData 값 : " + formData);
	
	formData.set("sno" , sno)
	      //3. ajax에게 첨부파일 전송 하기 // multipart
       $.ajax({
         url :  "/ezen5project-2/SnsController",
         method : "put" , 
         data : formData ,
         contentType : false,
         processData : false,
         success : r => {
			if(r){
				alert('게시물 수정 완료')
				location.href=`/ezen5project-2/sns/header.jsp?sno=${sno}`
			}
			else{alert('게시물 수정 실패')}
         } ,
         error :  e => {e}
         });
         //첨부파일 있을경우 json 방식 불가 , form 객체 전송 타입으로 변환해야된다
	
		
	
	
	
	
	
}// onupdate end
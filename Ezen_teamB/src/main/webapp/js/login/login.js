console.log('로그인 js 실행')


let signId = document.getElementById('signId').value;
let signPwd = document.getElementById('signPwd').value;


	  $.ajax({
      url :  "/jspweb/MemberFindController",
      method : "post" ,   // get 메소드는 정송하는 data 노출=보안에 취약 // 
      data : {signPwd : signId , signPwd : signPwd} ,
      success : r => {
		  if(r){
			  alert('로그인성공')
			  location.href="/Ezen_teamB/index.jsp";
		  }
		  else{alert('로그인실패')
		  document.querySelector('.logincheckbox').innerHTML=`회원 정보가 없습니다`;
		  }
	  } ,
      error :  e => {e}
      });






















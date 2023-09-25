console.log('헤더 js 정상')


let loginState = false;

let loginMid = '';

getMemberInfo()
function getMemberInfo(){
	  $.ajax({
      url :  "/Ezen_teamB/MemberInfoController",
      method : "get" ,
      async : false, 
      data : {type : "info"} ,
      success : r => {
		  console.log('getMemberInfo 결과값 아래꺼')
		  console.log(r)
		  
      let submenu = document.querySelector('.submenu')
      let html = ``;
      	if(r==null){
			  loginState = false; loginMid = '';
			  html +=`
			<li><a href="/Ezen_teamB/jsp/member/login.jsp">로그인</a></li>
			<li><a href="/Ezen_teamB/jsp/member/signup.jsp">회원가입</a></li>		  
			  `			
		}
		else{
			loginState = true; loginMid = r.mid;
			console.log(loginState)
			console.log(r.mid)
			
			html +=`
			<li><a href="/Ezen_teamB/jsp/mymenu/mymenu.jsp">마이페이지</a></li>
			<li> <a onclick="logout()" href="#">로그아웃</a> </li>			
			`
		}
		submenu.innerHTML = html;
			
      } ,
      error :  e => {e}
      });		
	
}

// 로그아웃
function logout(){
	
	  $.ajax({
      url :  "/Ezen_teamB/MemberInfoController",
      method : "get" , 
      data : {type : "logout"} ,
      success : r => {
      alert('로그인이 필요합니다')
      	location.href="/Ezen_teamB/jsp/index.jsp"
      },
      error :  e => {e}
      });	
	

}




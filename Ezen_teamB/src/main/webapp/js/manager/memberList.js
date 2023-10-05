
/* 게시물 조회 조건 객체 */
let pageObject = { maxSize : 14, page: 1, key : '', keyword : '' }
	// * maxSize 	: 하나의 페이지에 최대표시할 멤버수
	// * page		: 현재 출력되는 페이지의 하단 번호
	// * key 		: select 내 옵션 목록
	// * keyword 	: 검색할 데이터(키워드)

getMemberList(1);	// 기본 페이지 번호 1
function getMemberList( page ){
	
	$.ajax({
		url: "/Ezen_teamB/MemberManagement",
		method: "get",
		data: pageObject,
		success: r => {
			console.log('성공')
			console.log(r)
			
			let memberListTable = document.querySelector('.memberListTable');
			
			let html = `
				<tr>
					<th> 성명 </th>
					<th> 생년월일 </th>
					<th> 전화번호 </th>
					<th> 이메일 </th>
					<th> 아이디 </th>
					<th> 포인트 </th>
				</tr>
			`;
			
			
			
			
			
			
			
			
		},
		error: e => {
			console.log('에러발생')
		}
		
		
	})
	
}
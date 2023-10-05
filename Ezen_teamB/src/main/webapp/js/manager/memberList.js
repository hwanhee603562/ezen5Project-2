
/* 게시물 조회 조건 객체 */
let pageObject = { type : 1, listsize : 14, page: 1, key : '', keyword : '' }
	// * type 		: (1:전체조회, 2:개별조회)
	// * listsize 	: 하나의 페이지에 최대표시할 멤버수
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
		},
		error: e => {
			console.log('에러발생')
		}
		
		
	})
	
}
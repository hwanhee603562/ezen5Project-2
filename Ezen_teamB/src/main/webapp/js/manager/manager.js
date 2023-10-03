
// 1. 회원관리
function goToMemberList(){
	
	document.querySelector('.rightMainOutput').innerHTML = `
		<%@ include file = "./memberList.jsp" %>
	`

}

// 2. 통계
function goToStatistics(){
	
	document.querySelector('.rightMainOutput').innerHTML = `
		<%@ include file = "./statistics.jsp" %>
	`

}

// 3. 거래내역
function goToTradeLog(){
	
	document.querySelector('.rightMainOutput').innerHTML = `
		<%@ include file = "./tradelog.jsp" %>
	`

}

// 4. 중개거래소관리
function goToemEdiation(){
	
	document.querySelector('.rightMainOutput').innerHTML = `
		<%@ include file = "./emediation.jsp" %>
	`

}
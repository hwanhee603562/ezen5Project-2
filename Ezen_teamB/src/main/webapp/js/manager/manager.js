


// 1. 회원관리 경로이동
function goToMemberList(){

	fetch('./memberList.jsp')
		.then(response => response.text())
		.then(data => {
			document.querySelector('.rightMainOutput').innerHTML = data;
		})
		.catch(error => {
			console.error('데이터를 가져오는 중 오류 발생:', error);
		});

}

// 2. 통계 경로이동
function goToStatistics(){
	
	fetch('./statistics.jsp')
		.then(response => response.text())
		.then(data => {
			document.querySelector('.rightMainOutput').innerHTML = data;
		})
		.catch(error => {
			console.error('데이터를 가져오는 중 오류 발생:', error);
		});

}

// 3. 거래내역 경로이동
function goToTradeLog(){
	
	fetch('./tradelog.jsp')
		.then(response => response.text())
		.then(data => {
			document.querySelector('.rightMainOutput').innerHTML = data;
		})
		.catch(error => {
			console.error('데이터를 가져오는 중 오류 발생:', error);
		});

}

// 4. 중개거래소관리 경로이동
function goToemEdiation(){
	
	fetch('./emediation.jsp')
		.then(response => response.text())
		.then(data => {
			document.querySelector('.rightMainOutput').innerHTML = data;
		})
		.catch(error => {
			console.error('데이터를 가져오는 중 오류 발생:', error);
		});

}
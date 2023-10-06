

/* 게시물 조회 조건 객체 */
let pageObject2 = { maxSize : 10, page: 1, category : 1, pDate : '', nDate : '' }
	// * maxSize 	: 하나의 페이지에 최대표시할 멤버수
	// * page		: 현재 출력되는 페이지의 하단 번호
	// * category : 출력할 통계 카테고리
	// * pDate : 시작 날짜 범위
	// * nDate : 끝 날짜 범위
	console.log(pageObject2)

// 검색버튼을 눌렀을때 실행되는 함수
function statisSearch(){console.log('검색버튼 클릭')
	let priDate = document.querySelector('.priDate');
	let nextDate = document.querySelector('.nextDate');
	
	console.log(priDate.value);	console.log(nextDate.value);
	
	pageObject2.pDate = priDate.value;
	pageObject2.nDate = nextDate.value;
	
	$.ajax({
		url: "/Ezen_teamB/StatisticsController",
		method: "get",
		async: false,
		data: pageObject2,
		success: r => {console.log(r)
			
			// 카테고리별 html 다르게 출력
			if(pageObject2.category == 1){
				printCateStatics(r)
			}
			else if(pageObject2.category == 2){
				printTradeStatics(r)
			}
			
			
		},
		error : e => {console.log(e)}
	})	
} // function end

// 통계 카테고리 전환 함수
function onCategory(category){
	pageObject2.category = category;
	console.log('오브젝트 카테고리 번호 : ' + pageObject2.category)
	
	statisSearch();
}


// 카테고리별 통계 출력함수
function printCateStatics(r){
	console.log(r)
	
	let printBox = document.querySelector('.printBox');
			let html = ``;
			html +=
			`
				<table class="cStatisticListTable">
				<tr class="tableText">
					<th> 대분류 </th>
					<th> 소분류 </th>
					<th> 판매중인상품 </th>
					<th> 안전결제사용상품 </th>
					<th class="stResult"> 거래량 </th>
				</tr>
			`
			r.forEach( p => {
				
				html +=
				`
					<tr class="tableText">
						<td>${p.mCategory}</td>
						<td>${p.sCategory}</td>
						<td>${p.tState}</td>
						<td>${p.safeState}</td>
						<td class="stResult">${p.count}</td>
					</tr>	
				`
				
			});
			
			html += 
			`
				</table>
			`
			
			printBox.innerHTML = html;	
}

// 거래방식별 통계 출력함수
function printTradeStatics(r){
	
	let gnum1 = 2;
	let gnum2 = 3;
	let gnum3 = 5;
	

	let g_List = [{value : gnum1, name : '배송'},
				{value : gnum2, name : '대면거래'},
				{value : gnum3, name : '안전거래'}]
	
	

	var chartDom = document.getElementById('printGraf');
	var myChart = echarts.init(chartDom);
	var option;
	
	option = {
	  title: {
	    text: 'Referer of a Website',
	    subtext: 'Fake Data',
	    left: 'center'
	  },
	  tooltip: {
	    trigger: 'item'
	  },
	  legend: {
	    orient: 'vertical',
	    left: 'left'
	  },
	  series: [
	    {
	      name: 'Access From',
	      type: 'pie',
	      radius: '50%',
	      data: g_List,
	      emphasis: {
	        itemStyle: {
	          shadowBlur: 10,
	          shadowOffsetX: 0,
	          shadowColor: 'rgba(0, 0, 0, 0.5)'
	        }
	      }
	    }
	  ]
	};
	
	option && myChart.setOption(option);
	
}
























/* ================================ 카테고리 */

getMainCategory()
// 1. 카테고리 대분류/소분류 출력
function getMainCategory(){
	
	$.ajax({
		url: "/Ezen_teamB/ItemController",
		method: "get",
		data : {type : "getMainCategory"},
		success: s => {
			
			let mainUl = document.querySelector('.mainUl');
			let mainhtml = ``;
			
			s.forEach( category => {
				mainhtml += `<li> <button onclick="getSubCategory( ${category.uno}, '${category.uname}' )" type="button"> ${ category.uname } </button> </li>`;
			});

			mainUl.innerHTML = mainhtml;
			
		},
		error: e => {
			console.log('에러 발생')
		}
	})
	
}

// 2. 대분류 카테고리를 클릭하였을 때 해당되는 소분류 카테고리 출력
function getSubCategory( uno, uname ){
	
	// 대분류 카테고리를 선택할 시 '선택한 카테고리' 출력화면을 해당 대분류로 초기화
	document.querySelector('.checkMain').innerHTML = `${uname} > `
	document.querySelector('.checkSub').innerHTML = ``;
	
	$.ajax({
		url: "/Ezen_teamB/ItemController",
		method: "get",
		data : {type : "getSubCategory", uno : uno},
		success: s => {
			let subUl = document.querySelector('.subUl');
			let subhtml = ``;
			
			// 해당 대분류에 소분류 카테고리가 없으면 등록되어있지 않음을 출력
			if( s.length == 0 ) subhtml += `<li> <button onclick="" type="button"> 현재 소분류 카테고리가<br> 등록되어있지 않습니다 </button> </li>`;
			s.forEach( category => {
				subhtml += `<li> <button onclick="selectedCategory( ${category.dno}, '${category.dname}' )" type="button"> ${ category.dname } </button> </li>`;
			});

			subUl.innerHTML = subhtml;
			
		},
		error: e => {
			console.log('에러 발생')
		}
	})
}

// 3. 소분류 카테고리 선택 시 form 객체 생성
function selectedCategory( dno, dname ){
	
	document.querySelector('.checkSub').innerHTML = `${dname}`;
	document.querySelector('.dno').value = `${dno}`;
	
}



/* ============================= 카테고리 end */


/* ============================= 거래방식 */
// JS에서 CSS 제어
let deliveryCSS = document.getElementsByClassName("delivery")[0].style;		// 배송
let faceToFaceCSS = document.getElementsByClassName("faceToFace")[0].style;	// 대면거래
let brokerageCSS = document.getElementsByClassName("brokerage")[0].style;	// 중개거래소


// 1. 거래방식 - 배송 방식 클릭하였을 때
function delivery(){
	deliveryCSS.backgroundColor = "#6AAFE6";
	faceToFaceCSS.backgroundColor = "#EFEFEF";
	brokerageCSS.backgroundColor = "#EFEFEF";
	 
	 document.querySelector('.outputMapField').innerHTML = ``;
	  
}


// 2. 거래방식 - 대면거래 방식 클릭하였을 때
function faceToFace(){
	deliveryCSS.backgroundColor = "#EFEFEF";
	faceToFaceCSS.backgroundColor = "#6AAFE6";
	brokerageCSS.backgroundColor = "#EFEFEF";
	
	document.getElementById("outputMapField").style.display = "block";
	//document.getElementsByClassName("outputMapField")[0].style.display = "block";
	
	
}	// 거래방식 - 대면거래 방식 클릭하였을 때 end
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

	
	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	
	//마커 생성
    var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(37.537187, 127.005476),
        map: map
    });
	
	// 지도에 마커를 표시합니다
	marker.setMap(map);
	
	// 지도에 클릭 이벤트를 등록합니다
	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
	    
	    // 클릭한 위도, 경도 정보를 가져옵니다 
	    var latlng = mouseEvent.latLng; 
	    
	    // 마커 위치를 클릭한 위치로 옮깁니다
	    marker.setPosition(latlng);
	    
	    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
	    message += '경도는 ' + latlng.getLng() + ' 입니다';
	    
	    var resultDiv = document.getElementById('clickLatlng'); 
	    resultDiv.innerHTML = message;
	    
	});
	

    function sample5_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample5_address").value = addr;
                // 주소로 상세 정보를 검색
                geocoder.addressSearch(data.address, function(results, status) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {

                        var result = results[0]; //첫번째 결과의 값을 활용

                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new daum.maps.LatLng(result.y, result.x);
                        // 지도를 보여준다.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // 지도 중심을 변경한다.
                        map.setCenter(coords);
                        // 마커를 결과값으로 받은 위치로 옮긴다.
                        marker.setPosition(coords)
                    }
                });
            }
        }).open();
    }



/* ============================= 거래방식 end */

let fileList = []	// 파일을 저장할 배열 선언


function fileUpload( mimg ){
	console.log(mimg.files[0].name);
	console.log(mimg.files[0]);
	
	
	let fileReader = new FileReader();
	
	fileReader.readAsDataURL( mimg.files[0] );	
	
	
	// 이미지를 출력할 구역 생성
	document.querySelector('.outputImg').innerHTML +=	`
			<img class="ddd" alt="" src=""/>
		` 
	fileList.push( mimg.files[0].name );
	
	console.log(fileList)
	
	fileReader.onload = e => {
		console.log(e.target.result)
		document.querySelector('.ddd').src = e.target.result;	
	}
	
}





function registerItems(){
	
	// 1. form dom객체 호출
	let registerForm = document.querySelectorAll('.registerForm')[0];
	let formData = new FormData( registerForm );
	
	console.log(formData)
	
} 
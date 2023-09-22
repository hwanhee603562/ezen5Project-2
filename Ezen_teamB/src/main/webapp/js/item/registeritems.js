
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

			// 선택된 카테고리를 출력
			subUl.innerHTML = subhtml;
			
		},
		error: e => {
			console.log('에러 발생')
		}
	})
}

// 3. 소분류 카테고리 선택 시 form 객체 생성
	// form 객체 전송을 위해 dno 변수 저장
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


// 현재 거래방식을 저장하는 변수
let itrade = 0;
	// 1 배송, 2 대면거래, 3 중개거래


// 1. 거래방식 - 배송 방식 클릭하였을 때
function delivery(){
	deliveryCSS.backgroundColor = "#6AAFE6";
	faceToFaceCSS.backgroundColor = "#EFEFEF";
	brokerageCSS.backgroundColor = "#EFEFEF";
	 
	 document.getElementById("outputMapField").style.display = "none";
	 itrade = 1;
}







// 2. 거래방식 - 대면거래 방식 클릭하였을 때

	// 대면거래 이용 시 위도 저장
let dlat = '';
	// 대면거래 이용 시 경도 저장
let dlng = '';
	// 대면거래 이용 시 주소값 저장
let itradeplace = ''

function faceToFace(){
	deliveryCSS.backgroundColor = "#EFEFEF";
	faceToFaceCSS.backgroundColor = "#6AAFE6";
	brokerageCSS.backgroundColor = "#EFEFEF";
	
	document.getElementById("outputMapField").style.display = "block";
	//document.getElementsByClassName("outputMapField")[0].style.display = "block";
	
	
	itrade = 2;
	
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
var infowindow = new kakao.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다





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


	// 위 경도 좌표 저장
		// form객체 전송을 위함
	dlat = latlng.getLat();
	dlng = latlng.getLng();
	
	
});
	

// 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
    searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
        if (status === kakao.maps.services.Status.OK) {
            
            itradeplace = !!result[0].road_address ? result[0].road_address.address_name : result[0].address.address_name ;
			
			
            // 마커를 클릭한 위치에 표시합니다 
            marker.setPosition(mouseEvent.latLng);
            marker.setMap(map);
	
			document.querySelector('.selectedAddress span').innerHTML = `${itradeplace}`;
	
        }   
    });
});

function searchAddrFromCoords(coords, callback) {
    // 좌표로 행정동 주소 정보를 요청합니다
    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
}

function searchDetailAddrFromCoords(coords, callback) {
    // 좌표로 법정동 상세 주소 정보를 요청합니다
    geocoder.coord2Address(dlng, dlat, callback);
    
}





// 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'idle', function() {
    searchAddrFromCoords(map.getCenter(), displayCenterInfo);
});

// 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
searchAddrFromCoords(map.getCenter(), displayCenterInfo);


// 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
function displayCenterInfo(result, status) {
    if (status === kakao.maps.services.Status.OK) {
        var infoDiv = document.getElementById('centerAddr');

        for(var i = 0; i < result.length; i++) {
            // 행정동의 region_type 값은 'H' 이므로
            if (result[i].region_type === 'H') {
                infoDiv.innerHTML = result[i].address_name;
                break;
            }
        }
    }    
}

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
					
					// 주소 저장
					itradeplace = result.address_name
					document.querySelector('.selectedAddress span').innerHTML = `${itradeplace}`;

					// 위도 경도 좌표 저장
					dlat = result.y;
					dlng = result.x;
					
					
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


// 3. 거래방식 - 중개거래소 방식 클릭하였을 때
function brokerage(){
	deliveryCSS.backgroundColor = "#EFEFEF";
	faceToFaceCSS.backgroundColor = "#EFEFEF";
	brokerageCSS.backgroundColor = "#6AAFE6";
	
	document.getElementById("outputMapField").style.display = "block";
	
	itrade = 3;
	
}	// 거래방식 - 대면거래 방식 클릭하였을 때 end



/* ============================= 거래방식 end */



/* ============================= 이미지 출력/삭제 */

// input 타입 file 1~10출력구역
for(let i=1; i<=10; i++){
	document.querySelector('.inpuImgBox').innerHTML += `
		<div class="hiddenBox${i}"><input onchange="fileUpload(this, ${i})" type="file" id="uploadFile${i}" name="file" style="display: none"></div>
	`
}


// 1-1 이미지 파일 업로드
function fileUpload( mimg, idNum ){
	

	// 파일을 읽는 객체 생성
	let fileReader = new FileReader();
	// 파일의 정보 읽기
	fileReader.readAsDataURL( mimg.files[0] );	
	
	// 이미지를 출력할 구역 생성
	document.querySelector('.outputImg').innerHTML +=	`
			<div class="outBoxFiled${idNum}">
				<img class="img${idNum}" alt="" src=""/>
				<button onclick="fileDelete(${idNum})" type="button">x</button>
			</div>
		` 
		
		//각 출력되는 이미지에 대한 식별자는 이미지를 담는 배열의 길이로 함

	// 읽어온 파일을 불러옴
	fileReader.onload = e => {
		document.querySelector(`.img${idNum}`).src = e.target.result;	
	}
	
	
	// 파일 라벨의 for 포인터 변경
	let checkImg = false;
		// 10개의 input 파일 타입에 파일 객체가 존재하는지 탐색
	for( let i=1; i<=10; i++ ){
		var fileCheck = document.getElementById(`uploadFile${i}`).value;
		
		// 파일객체가 존재하지 않는 경우
			// 라벨이 가리키는 id식별자( =for )를 변경
		if(!fileCheck){
			document.querySelector('.labelBox').innerHTML = `
					<label class="input-file-button" for="uploadFile${i}">
											
						<img class="labelImg" src="/Ezen_teamB/jsp/item/img/uploadImgLogo.png"/>
											
					</label>
				`;
			checkImg = true;
			break;
		}
	}
	// 등록된 이미지 파일이 10개가 넘었을 경우 
	// 이후 라벨을 클릭할 시 접근을 금지하기 위해
	// 접근 금지 메서드 기능 삽입
	if( !checkImg ){
		document.querySelector('.labelBox').innerHTML = `
				<label onclick='forbidden()' class="input-file-button"">
										
					<img class="labelImg" src="/Ezen_teamB/jsp/item/img/uploadImgLogo.png"/>
										
				</label>
			`;
	}
	
	
}
// 1-2 등록된 이미지 파일이 10개가 넘었을 경우 라벨 클릭 금지
function forbidden(){
	alert('이미지는 최대 10개까지 등록할 수 있습니다')
}

// 2 선택된 이미지 파일 삭제
function fileDelete( idNum ){
	
	// 삭제할 파일 구역을 초기화
	$(`#uploadFile${idNum}`).val('');
	document.querySelector(`.outBoxFiled${idNum}`).innerHTML = ``
	
	
	// 파일 라벨의 for 포인터 변경
	for( let i=1; i<=10; i++ ){
		var fileCheck = document.getElementById(`uploadFile${i}`).value;
		console.log( fileCheck )
		// 파일객체가 존재하지 않는 경우
			// 라벨이 가리키는 id식별자( =for )를 변경
		if(!fileCheck){
			document.querySelector('.labelBox').innerHTML = `
					<label class="input-file-button" for="uploadFile${i}">
											
						<img class="labelImg" src="/Ezen_teamB/jsp/item/img/uploadImgLogo.png"/>
											
					</label>
				`;

			break;
		}
	}

}


/* ============================= 이미지 출력/삭제 end */


function registerItems(){
	
	/* -------- 유효성 검사 -------- */
	
	// 각 입력 구역에 value 확인
	let ptitle = document.querySelector('.ptilte').value	// 입력된 제목
	let pcontent = document.querySelector('.pcontent').value	// 입력된 내용
	let dno = document.querySelector('.dno').value			// 선택된 소분류 카테고리
	let pprice = document.querySelector('.pprice').value	// 입력된 가격
	
	if( ptitle == '' || ptitle == null ){
		alert('제목을 입력하여 주십시오')
		return;
	}
	if( pcontent == '' || pcontent == null ){
		alert('제품설명을 입력하여 주십시오')
		return;
	}
	if( dno == '' || dno == null ){
		alert('카테고리를 선택하여 주십시오')
		return;
	}
	if( itrade < 1 || itrade > 3 ){
		alert('거래방식을 선택하여 주십시오')
		return;
	}
	if( pprice == '' || pprice==null ){
		alert('가격을 입력하여 주십시오')
		return;
	}
	
	// 거래방식이 대면거래임에도 거래위치를 지정하지 않을 경우
	if( itrade==2 && (dlat == '' || dlat == '' || itradeplace=='') ){
		alert('대면거래는 거래위치를 지정하여야 합니다')
		return;
	}
	
	/* -------- 물품등록 전 form 데이터 setting -------- */
	
	// 10개의 인풋박스 중 파일이 첨부되어있지 않은 input 삭제 form데이터 초기화
		// 해당 input박스의 부모요소(div)를 공백으로 초기화
		
	for( let i=1; i<=10; i++ ){
		var fileCheck = document.getElementById(`uploadFile${i}`).value;
		
		if( !fileCheck ){
			document.querySelector(`.hiddenBox${i}`).innerHTML = ``;
		}
	}
	
	// 1. form dom객체 호출
	let registerForm = document.querySelectorAll('.registerForm')[0];
	let formData = new FormData( registerForm );
	
	
	// name식별자에 해당되지 않는 데이터를 폼데이터에 별도로 추가 
	formData.set('itrade', itrade )				// 거래방식 : 1 배송, 2 대면거래, 3 중개거래

	// 서블릿에서 doPost에서 기능 구분을 위해 타입 생성 후 폼데이터에 별도로 추가
	let type = "registerItems"
	formData.set('type', type )
	
	// 거래방식이 '대면거래'일 시 대면거래에 대한 위경도, 주소값 저장
	if( itrade == 2 ){
		formData.set('dlat', dlat)					// 대면거래 이용 시 위도 저장
		formData.set('dlng ', dlng )				// 대면거래 이용 시 경도 저장
		formData.set('itradeplace ', itradeplace )	// 대면거래 이용 시 주소값 저장
	}

	/* -------- ajax 통신 -------- */
	
	$.ajax({
		url: "/Ezen_teamB/ItemController",
		method: "post",
		data: formData,
		contentType: false,
		processData: false,
		success: result =>{
			
			console.log('등록성공')
			
		},
		errror: e =>{
			console.log('제품등록 에러발생')
		}
		
		
	})

} 























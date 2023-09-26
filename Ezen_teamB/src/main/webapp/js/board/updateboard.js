let bno = new URL(location.href).searchParams.get("bno")
getBoard()
function getBoard(){
	console.log(bno)
	$.ajax({
		url : "/Ezen_teamB/BoardController" , 
		method : "get" ,
		data : { type : 2 , bno : bno } ,
		success :  r =>{ console.log('통신성공')
			document.querySelector('.cno').value=`${r.cno}`
			document.querySelector('.btitle').value=`${r.btitle}`
			document.querySelector('.bcontent').innerHTML=`${r.bcontent}`
			document.querySelector('.bfile').innerHTML=`${r.bfile}`
			
			
		} ,
		error : e =>{ console.log('통신실패') }
	})
}

function bUpdate(){
	let writeForm = document.querySelectorAll('.writeForm')[0];
	
	let formdata = new FormData(writeForm);
	
		formdata.set("bno",bno);
		$.ajax({
			url : "/Ezen_teamB/BoardController" ,
			method : "put" ,
			data : formdata ,
			contentType : false ,
			processData : false ,
			success : r => {console.log(r)
			if(r){alert('수정성공')
			location.href = `/Ezen_teamB/jsp/board/detailedboard.jsp?bno=${bno}`
			}else{alert('수정실패')}
			},
			error : e => {console.log(e)}
		
		})
}
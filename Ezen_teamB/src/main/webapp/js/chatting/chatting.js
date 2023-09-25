console.log('채팅페이지')

let loginMid = 'abc1234';

let clientSocket = new WebSocket(`ws://localhost:80/jspweb/serversocket/${loginMid}`);

clientSocket.onerror = e=>{console.log('서버와 오류발생 ' + e)};
clientSocket.onclose = e=>{console.log('서버와 연결끊김 ' + e)};
clientSocket.onmessage = e =>onMsg(e);

function onSend(){ console.log('전송함수');

	let msgvalue = document.querySelector('.msg').value;
	if(msgvalue == '' || msgvalue == '\n'){return;}	// 공백이나 엔터키 입력시 메시지 전송 x
	
	let msg = {type : 'message', content : msgvalue}
	
	clientSocket.send(JSON.stringify(msg));
	document.querySelector('.msg').value = ``;
	
}	// onSend() f end

// 메세지 받았을때 함수
function onMsg(e){
	console.log(e.data);
	
	let msg = JSON.parse(e.data);

	console.log(msg);
	
	msg.msg = JSON.parse(msg.msg)
	console.log(msg.msg)
	
	msg.msg.content = msg.msg.content.replace(/\n/g,'<br>');
}



























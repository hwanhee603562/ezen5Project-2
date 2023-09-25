console.log('채팅페이지')

let loginMid = 'abc1234';

let clientSocket = new WebSocket(`ws://localhost:80/jspweb/serversocket/${loginMid}`);

function onSend(){ console.log('전송함수');

	let msgvalue = document.querySelector('.msg').value;
	if(msgvalue == '' || msgvalue == '\n'){return;}	// 공백이나 엔터키 입력시 메시지 전송 x
	
	let msg = {type : 'message', content : msgvalue}
	
	clientSocket.send(JSON.stringify(msg));
	document.querySelector('.msg').value = ``;
	
}



























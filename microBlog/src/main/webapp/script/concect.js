var Chat = {};
Chat.socket = null;
Chat.connect = (function(host) {
	//创建webSocket，
	if ('WebSocket' in window) {
		Chat.socket = new WebSocket(host);
	} else if ('MozWebSocket' in window) {
		Chat.socket = new MozWebSocket(host);
	} else {
		//Console.log('Error: WebSocket is not supported by this browser.');
		// return;
		Chat.socket = new SockJS(
				"http://localhost:8080/microBlog/sockjs/webSocketServer");
	}
	//建立websocket的事件，可以用来做一些初始化操作
	Chat.socket.onopen = function() {
		$("#button1").click(function(){
			Chat.sendMessage();
		});	
	};
	//绑定关闭事件   
	Chat.socket.onclose = function() {
		document.getElementById('textfield2').onkeydown = null;
	};
	//监听消息
	Chat.socket.onmessage = function(message) {
		Console.log(message.data);
	};
	//出现错误的时候的方法  
	Chat.socket.onerror =function(event){  
    }; 
});

Chat.initialize = function() {
	if (window.location.protocol == 'http:') {
		Chat.connect('ws://' + window.location.host + '/microBlog/chat');
	} else {
		Chat.connect('ws://' + window.location.host + '/microBlog/chat');
	}
};
//发送消息的方法
Chat.sendMessage = (function() {
	var message = document.getElementById('textfield2').value;
	if (message != '') {
		Chat.socket.send(message);
		document.getElementById('textfield2').value = '';
	}
});

var Console = {};
//打印消息的方法 
Console.log = (function(message) {
/*	var console = document.getElementById('console');
	var p = document.createElement('p');
	p.style.wordWrap = 'break-word';
	p.innerHTML = message;
	console.appendChild(p);
	while (console.childNodes.length > 25) {
		console.removeChild(console.firstChild);
	}
	console.scrollTop = console.scrollHeight;*/
	if(message!=''){
		document.getElementById('console1').style.display="block";
	}else{
		document.getElementById('console1').style.display="none";
	}
	
});

Chat.initialize();

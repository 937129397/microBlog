// JavaScript Document
/* 设置全局的对象变量,存储网页中的对象 */
var faceShowTop = new Array(0,80,160,240,320);
var faceminTopi;
var stateminTopi;
var faceShowObj;
var faceintervalId;
var stateintervalId;
var stateShowTop = new Array(5);
var stateShowObj = new Array(5);
var useridtmp = "";
var tmp;
/* 初始化将所有的DIV的初始化给数组faceShowObj  */
function imgChangeInit(){
	faceminTopi = 0;
	faceShowObj = new Array(5);
	faceShowObj[0] = document.getElementById("faceShow1");
	faceShowObj[1] = document.getElementById("faceShow2");
	faceShowObj[2] = document.getElementById("faceShow3");
	faceShowObj[3] = document.getElementById("faceShow4");
	faceShowObj[4] = document.getElementById("faceShow5");
}
/* 实现图像展示部分的图片下滚 */
function imgChange(){
	for(var i=0;i<faceShowTop.length;i++){//判断哪些div已经在下面不可见部分了，然后将其最放到上面
		if(faceShowTop[i]>=320){
			faceShowTop[i]= faceShowTop[faceminTopi] -80;
			faceShowObj[i].style.top = faceShowTop[i] + "px";
			faceminTopi = i;
		}
	}
	for(var i=0;i<faceShowTop.length;i++){//给每个DIV都top增加，实现下滚
		faceShowTop[i] += 1;
		faceShowObj[i].style.top = faceShowTop[i] + "px";
	}
}
/* 实现图像定时滚动*/
function startChangeImg(){
	imgChangeInit();
	faceintervalId = setInterval("imgChange()",100);
}
/* 鼠标悬停时,图片透明度恢复,并且停止图像滚动的效果 */
function imgXianShi(){
	window.clearInterval(faceintervalId);
	var imgObj = event.srcElement;
	imgObj.filters.alpha.opacity = 100;
}
/* 鼠标离开时,设置图像透明度为50，并且恢复定时滚动图片的效果 */
function imgYinShen(){//图片隐藏；
	var imgObj = event.srcElement;
	imgObj.filters.alpha.opacity = 50;
	faceintervalId = setInterval("imgChange()",100);
}
/*讲所有的状态展示的DIV初始化position为决定定位，并且设置top和left，将数值传给数组*/
function stateInit(){
	stateShowObj[0] = document.getElementById("stateShow1");
	stateShowObj[1] = document.getElementById("stateShow2");
	stateShowObj[2] = document.getElementById("stateShow3");
	stateShowObj[3] = document.getElementById("stateShow4");
	stateShowObj[4] = document.getElementById("stateShow5");
	for(var i=0;i<5;i++){//获取所有状态的实际高度
		stateShowTop[i] = stateShowObj[i].offsetTop;
	}
	for(var i=0;i<5;i++){//设置所有状态定位为绝对定位,并相应的设置其top和left值
		stateShowObj[i].style.position = "absolute";
		stateShowObj[i].style.top = stateShowTop[i] + "px";
		stateShowObj[i].style.left = "15px";
	}
	stateminTopi = 0;//当前最上面的DIV的索引
}
/* 实现状态滚动 */
function stateChange(){
	for(var i=0;i<5;i++){//检测哪个状态已经在最下面而且不显示了,就将其放到最上面的DIV的上面
		if(stateShowTop[i]>=320){
			stateShowTop[i] = stateShowTop[stateminTopi] - stateShowObj[i].offsetHeight;
			stateShowObj[i].style.top = stateShowTop[i] + "px";
			stateminTopi = i;
		}
	}
	/* 检测DIV中哪个DIV是正在最上面可显示的DIV的上面 */
	var len;
	for(var i=0;i<5;i++){
		if(stateShowTop[i]+stateShowObj[i].offsetHeight ==0){
			len = stateShowObj[i].offsetHeight;
			break;
		}
	}
	tmp = i;
	stateShowObj[tmp].style.visibility = "hidden";//设置先前选出的那个DIV隐藏
	for(var i = 0;i<5;i++){//设置每个DIV都向下移动先前那个DIV的高度
		stateShowTop[i] +=len;
		stateShowObj[i].style.top = stateShowTop[i] + "px";
	}
	setTimeout("stateXianShi()",200);//延时显示那个DIV
}
/* 启动状态定时滚动效果 */
function startStateChange(){
	stateInit();
	stateintervalId = setInterval("stateChange()",2000);
}
/* 鼠标在状态上悬停时,停止状态滚动,并且设置状态背景色 */
function stateMouseOver(){
	window.clearInterval(stateintervalId);//停止状态滚动
	var stateObj = event.srcElement;//获取事件源
	while(stateObj.tagName!="DIV"){//定位DIV为外层DIV
		stateObj = stateObj.parentElement;
	}
	var pdiv = stateObj;
	if(stateObj.parentElement!=document.getElementById("stateShow"))//设置DIV应该是最外层DIV里面的,而不能定位到外面去
		pdiv = stateObj.parentElement;
	pdiv.style.backgroundColor = "#f9f9f9";
}
/* 鼠标离开时,恢复状态滚动,并恢复背景色 */
function stateMouseOut(){//设置鼠标离开效果
	var stateObj = event.srcElement;
	while(stateObj.tagName!="DIV"){
		stateObj = stateObj.parentElement;
	}
	var pdiv = stateObj;
	if(stateObj.parentElement!=document.getElementById("stateShow"))
		pdiv = stateObj.parentElement;
	pdiv.style.backgroundColor = "#fff";
	stateintervalId = setInterval("stateChange()",2000);
}
/* 设置状态DIV为显示 */
function stateXianShi(){
	stateShowObj[tmp].style.visibility = "visible";
}

/* 提交表单是检测输入的数据是否正确 */
function checkForm(){
	var userId = document.getElementById("userId");
	var userPass = document.getElementById("passWord");
	if(userId.value == "请输入正确邮箱|手机号码")//如果本身是提示语,则继续出错的提示
		return false;
	userId.value = trim(userId.value);//去除id框前后空格
	useridtmp = userId.value;//将输入id传给变量
	/* 如果字符串里面有@字符,则相应进入邮箱检测环节,否则进入手机号检测*/
	if(useridtmp.indexOf("@")>-1){//如果里面有@符号
		/* 如果符合邮箱的规则,并且密码也符合长度的要求 */
		if(useridtmp.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/)!=null && trim(userPass.value).length >=6){
			return true;
		}else{
			return false;
		}
	}else{//进入手机号处理流程
		/* 如果密码长度符合要求 并且也是11位的纯手机号,则返回正确 */
		if(useridtmp.match(/[^\d]/g)==null && useridtmp.length==11 && userPass.value.length >=6){
			return true;
		}else{//否则进入出错提示
			if(useridtmp.match(/[^\d]/g)!=null || useridtmp.length<11){
				userId.value = "请输入正确邮箱|手机号码"
				userId.style.backgroundColor = "#B9E3AB"
			}
			return false;
		}
	}
}
function userIdfocus(){//输入框获得焦点
	var userId = document.getElementById("userId");
	userId.style.backgroundColor = "#FFF"
	userId.value = useridtmp;
	userId.select();
}

function userPassfocus(){//密码框获得焦点
	document.getElementById("userPass").select();
}

window.onload = function(){
	startStateChange();	
	startChangeImg();
	var imgObj = document.getElementById("faceShow").getElementsByTagName("img");
	for(var i=0;i<imgObj.length;i++){
		imgObj[i].onmouseover = imgXianShi;
		imgObj[i].onmouseout = imgYinShen;
	}
	stateShowObj[0] = document.getElementById("stateShow1");
	stateShowObj[1] = document.getElementById("stateShow2");
	stateShowObj[2] = document.getElementById("stateShow3");
	stateShowObj[3] = document.getElementById("stateShow4");
	stateShowObj[4] = document.getElementById("stateShow5");
	for(var i=0;i<5;i++){
		stateShowObj[i].onmouseover = stateMouseOver
		stateShowObj[i].onmouseout = stateMouseOut
	}
	document.getElementById("userId").onmouseover = userIdfocus;
	document.getElementById("userId").onfocus = userIdfocus;
	document.getElementById("userId").onblur = checkForm;
	document.getElementById("userPass").onmousemove = userPassfocus
}
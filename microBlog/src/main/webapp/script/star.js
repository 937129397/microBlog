// JavaScript Document
var i=0; 	//循环量
var left=0;	//向左偏移变量	
var delay = 100 ;//新闻移动延时
var stay = 3000 ;//新闻停留时间
var mouse = 0 ;  //鼠标事件 0表示离开 1表示进入 
var randomnum; //随机数变量
var mail3;//用于获取E-mail提示框DIV对象
var password13;	//用于获取创建密码提示框DIV对象
var password23; //用于获取密码确认提示框DIV对象
var yangzhen3;	//用于获取验证码提示框DIV对象
var mailresult; //用于记录邮箱是否合法
var resultnum;	//用于记录密码中是否有数字
var resultword;	//用于记录密码中是否有字母
var resultsix;  //用于记录密码是否有6位
var lastPassword;//用于记录用于第一次输入的密码
var str;		//用于记录第二次用户输入的密码
var value ;		//用于记录用户输入的验证码
var isStop;		//新闻时候停止
/* 加载函数 */
window.onload = function(){
	var topText =document.getElementById("topText");
	topText.onfocus = quickZC;
	getnum();
}
/* 快速注册 */
function quickZC(){
	var flash1 = document.getElementById("flash1");
	flash1.style.visibility = "visible";
	var mainTop = document.getElementById("mainTop");
	mainTop.style.height = 300;
	var topTextDIV = document.getElementById("topTextDIV");
	var ZCButton = document.getElementById("ZCButton");
	topTextDIV.style.display = "none" ;
	ZCButton.style.display = "none" ;
	
}
/* 正则表达式提取left数值 */
function execRegleft(reg,str){
	var result = reg.exec(str);
	return(result);
}
/* 正则表达式验证返回ture或flase */
function execReg(reg,str){
	var result = reg.test(str);
	return result;
}
/* 验证邮箱是否正确 */
function checkMail(){
	var mailInput = document.getElementById("mailInput");
	var str = mailInput.value;
	var reg = /^\w+@\w+\.\w+$/; 	// 判断邮箱格式正则
	mailresult = execReg(reg,str);
	mail3 = document.getElementById("mail3");
	if(mailresult){															//格式正确
		mail3.innerHTML = '<img src="'+'images/right.gif">'+"正 确";
		mail3.style.backgroundColor = "transparent";
		mail3.style.borderColor = "transparent";
		document.getElementById("password13").style.visibility = "visible" ;
		document.getElementById("password13").style.backgroundColor = "#F2F2F2";
	    document.getElementById("password13").style.borderColor = "#CCCCCC";
		document.getElementById("password13").style.border = 1 ;
		document.getElementById("password13").style.borderStyle = "solid" ;
	}
	else{																//格式错误
		mail3.style.borderColor ="#EBB1B1";
		mail3.style.backgroundColor = "#FFD6D6";
		mail3.innerHTML = "请输入正确E-mail的地址";		
	}		
}
/* 验证密码是否符合标准 */
function checkPassword(){
	var passwordInput = document.getElementById("passwordInput");
	password13 = document.getElementById("password13");
	var str = passwordInput.value;
	var regnum = /[0-9]+/;
	var regword = /[a-zA-Z]+/;
	var regsix = /[a-zA-z0-9]{6,12}/;
	resultnum = execReg(regnum,str);	//验证是否有数字
	resultword = execReg(regword,str); 	//验证是否有字母
	resultsix = execReg(regsix,str);	//验证是否有6位
	if(resultword==true&&resultnum==true&&resultsix==true){
		document.getElementById("password13").style.visibility = "visible" ;
		password13.innerHTML = '<img src="'+'images/right.gif">'+"正 确";
		password13.style.backgroundColor = "transparent";
		password13.style.borderColor = "transparent";
	}
	else{
		document.getElementById("password13").style.visibility = "visible" ;
		password13.style.borderColor ="#EBB1B1";
		password13.style.backgroundColor = "#FFD6D6";
		password13.innerHTML = "密码至少包含一个数字和字母且不能小于6位,最长不能超过12位！";	
	}
}
/* 验证2次密码是否一致 */
function isSame(){
	var passwordInput = document.getElementById("passwordInput");
	lastPassword = passwordInput.value;
	var passwordTwice = document.getElementById("passwordTwice");
	str = passwordTwice.value ;
	var password23 = document.getElementById("password23");
	if(str == ""){
		document.getElementById("password23").style.visibility = "visible" ;
		password23.style.borderColor ="#EBB1B1";
		password23.style.backgroundColor = "#FFD6D6";
		password23.innerHTML = "密码不能为空！";	
	}
	else if(lastPassword == str){
		document.getElementById("password23").style.visibility = "visible" ;		
		password23.innerHTML = '<img src="'+'images/right.gif">'+"正 确";
		password23.style.backgroundColor = "transparent";
		password23.style.borderColor = "transparent";
	}
	else{
		document.getElementById("password23").style.visibility = "visible" ;
		password23.style.borderColor ="#EBB1B1";
		password23.style.backgroundColor = "#FFD6D6";
		password23.innerHTML = "两次密码不一致！";	
	}
}
/* 产生随机数 */
function getnum(){
	randomnum = Math.floor(Math.random()*(9999-1000+1)+1000);
	document.getElementById("picyanzheng").innerHTML = randomnum ;
}
/* 确定验证码是否正确 */
function checkIsRight(){
	var yangzhen3 = document.getElementById("yangzhen3");
	var checkIsRight = randomnum;
	var yangzhen = document.getElementById("yangzhen");
	value = yangzhen.value ;
	if(value == randomnum){
		document.getElementById("yangzhen3").style.visibility = "visible" ;	
		yangzhen3.innerHTML = '<img src="'+'images/right.gif">'+"正 确";
		yangzhen3.style.backgroundColor = "transparent";
		yangzhen3.style.borderColor = "transparent";
	}
	else{
		document.getElementById("yangzhen3").style.visibility = "visible" ;	
		yangzhen3.style.borderColor ="#EBB1B1";
		yangzhen3.style.backgroundColor = "#FFD6D6";
		yangzhen3.innerHTML = "验证码不符！";	
	}
}
/* 注册收起函数 */
function hangUp(){
	var flash1 = document.getElementById("flash1");
	flash1.style.visibility = "hidden";
	var mainTop = document.getElementById("mainTop");
	mainTop.style.height = 80;
	var topTextDIV = document.getElementById("topTextDIV");
	var ZCButton = document.getElementById("ZCButton");
	topTextDIV.style.display = "block" ;
	ZCButton.style.display = "block" ;
}
/* 检查用户的所有信息是否填写成功 */
function checkAll(){
	var a = (lastPassword == str);
	var b = (value == randomnum);
	if(mailresult==true&&resultword==true&&resultnum==true&&resultsix==true&&a==true&&b==true){
		window.open("CustomerIndex.html");
	}
	else{
		window.alert("用户输入信息不全或不正确，无法注册！");
	}
}
/* 新闻停止 */
function ting(){
	isStop = 1;
}
/* 新闻继续 */
function goon(){
	isStop = 0;
}
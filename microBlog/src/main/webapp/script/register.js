// JavaScript Document.
/* 网页中的对象存储变量  */
var userID;//用户名输入框对象
var userName;//用户姓名输入框对象
var userTel;//用户手机号输入框对象
var userMail;//邮箱输入框对象
var userPass;//密码输入框对象
var userRpass;//重复密码输入框对象
var verify;//验证码输入框对象
var img1;//用户名状态图片
var img2;//用户姓名状态图片
var img3;//用户手机号状态图片
var img4;//邮箱状态图片
var img5;//密码状态图片
var img6;//重复密码状态图片
var img7;//验证码状态图片
var passtmp;//密码缓存
var verifytmp;//验证码缓存
/* 初始化上面的这些对象变量 */
function init(){
	userID = document.getElementById("userID");
	userName = document.getElementById("userName");
	userTel = document.getElementById("userTel");
	userMail = document.getElementById("userMail");
	userPass = document.getElementById("userPass");
	userRpass = document.getElementById("userRpass");
	verify = document.getElementById("verify");
	img1 = document.getElementById("img1");
	img2 = document.getElementById("img2");
	img3 = document.getElementById("img3");
	img4 = document.getElementById("img4");
	img5 = document.getElementById("img5");
	img6 = document.getElementById("img6");
	img7 = document.getElementById("img7");
}
/* 检测用户ID输入框 */
function checkUserId(imgobj,textobj){
	imgobj.style.visibility = "visible";//设置图片显示
	textobj.value = trim(textobj.value);//去前后空格
	if(textobj.value.length==0){//输入的长度判断，出错之后的处理
		textobj.style.backgroundColor = "#B9E3AB";//设置背景色
		imgobj.src = "images/err.png";//设置出错图片
		return false;
	}
    /* 输入长度判断通过之后,外面的处理 */
	textobj.style.backgroundColor = "#fff";//设置背景色
	imgobj.src = "images/ok.png";//设置正确图片
	return true;
}
/* 对象获得对象时的操作 */
function getfocus(textobj,imgobj){
	imgobj.style.visibility = "hidden";//设置相应的图像对象隐藏
	textobj.style.backgroundColor = "#fff";//设置相应的输入框背景色为白色
}
/* 检测用户名的长度大于等于4,则通过检测 */
function checkUserName(imgobj,textobj){
	imgobj.style.visibility = "visible";//设置图像对象显示
	textobj.value = trim(textobj.value);//去前后空格
	if(textobj.value.length<4){//字符串长度小于四则进行出错处理
		textobj.style.backgroundColor = "#B9E3AB";//设置背景色
		imgobj.src = "images/err.png";//设置出错图片的显示
		return false;
	}
	/* 字符串长度通过检测,则进行正确的处理 */
	textobj.style.backgroundColor = "#fff";//
	imgobj.src = "images/ok.png";
	return true;
}
/* 
	检测用户手机号,去掉前后空格后,如果时纯11位的数字
	则转到正确处理,否则,转为出错处理.
	设置输入框背景色,设置状态提示img
 */
function checkUserTel(imgobj,textobj){
	imgobj.style.visibility = "visible";//设置图片框显示
	textobj.value = trim(textobj.value);//去前后空格
	if(textobj.value.match(/[^\d]+/g)!=null){//检测中间是否有非数字字符
		textobj.style.backgroundColor = "#B9E3AB";//设置出错背景色
		imgobj.src = "images/err.png";//设置出错状态图
		return false;
	}
	/* 手机号通过检测之后的处理，11位纯数字 */
	if(textobj.value.match(/\d+/g)!=null && textobj.value.match(/\d+/g)[0].length == 11){
		textobj.style.backgroundColor = "#fff";
		imgobj.src = "images/ok.png";
		return true;
	}
	textobj.style.backgroundColor = "#B9E3AB";
	imgobj.src = "images/err.png";
	return false;
}
/* 
	检测邮箱，如果邮箱是/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/的时候
	就通过检测，进入正确处理。否则就进入出错处理
*/
function checkUserMail(imgobj,textobj){
	imgobj.style.visibility = "visible";//显示图片框，并
	textobj.value = trim(textobj.value);//
	if(textobj.value.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/)==null){
		textobj.style.backgroundColor = "#B9E3AB";
		imgobj.src = "images/err.png";
		return false;
	}
	/* 正确处理 */
	textobj.style.backgroundColor = "#fff";
	imgobj.src = "images/ok.png";
	return true;
}
/* 检测创建的密码,长度大于6位通过检测,否则则设置提示 */
function checkUserPass(imgobj,textobj){
	imgobj.style.visibility = "visible";
	textobj.value = trim(textobj.value);
	if(textobj.value.length<6){
		textobj.style.backgroundColor = "#B9E3AB";
		imgobj.src = "images/err.png";
		return false;
	}
	textobj.style.backgroundColor = "#fff";
	imgobj.src = "images/ok.png";
	passtmp = textobj.value;
	return true;
}
/* 重复密码和上面密码检测,如果对则通过检测,否则就不通过 */
function checkUserRpass(imgobj,textobj){//检测重复的密码
	imgobj.style.visibility = "visible";
	textobj.value = trim(textobj.value);
	if(textobj.value.length<6 || passtmp!=textobj.value){//密码长度大于等6位,并且和创建密码一样
		textobj.style.backgroundColor = "#B9E3AB";
		imgobj.src = "images/err.png";
		return false;
	}
	/* 通过检测的处理  */
	textobj.style.backgroundColor = "#fff";
	imgobj.src = "images/ok.png"; 
	return true;
}
/* 检测验证码输入是否和生成的验证码一样！如果一样就回复背景色和设置图片状态，否则，就设置背景色
	和设置图片状态
 */
function checkVertyCode(imgobj,textobj){
	imgobj.style.visibility = "visible";
	textobj.value = trim(textobj.value);
	if(textobj.value!=verifytmp){//验证码检测失败
		textobj.style.backgroundColor = "#B9E3AB";
		imgobj.src = "images/err.png";
		return false;
	}
	/* 验证码检测成功 */
	textobj.style.backgroundColor = "#fff";
	imgobj.src = "images/ok.png"; 
	return true;
}
/* 设置纯数字的4位数的验证码，并将验证码存入全局变量，方便做验证操作 */
function createCode(){//生成验证码
	verifytmp = Math.floor(Math.random()*(9999-1000+1)+1000);//生成4位数的验证码
	var yanzhengma = document.getElementById("yanzhengma");
	yanzhengma.innerHTML = verifytmp;//将验证码写入Web页面
}
/* 验证协议复选框,如果已勾选就设置注册按钮可用,如果未勾选中设置不可用 */
function deal(cb,btn){
	if(cb.checked == true){
		btn.disabled = false;
	}else{
		//btn.disabled = "false";
		//document.getElementById("yanzhengma").setAttribute(name,value);
		btn.disabled = true;
	}
}
/* 表单提交时检测，如果检测通过就提交表单，如果通不过，就不提交 */
function checkForm(){
	if(checkUserId(img1,userID)==false) return false;
	if(checkUserName(img2,userName)==false) return false;
	if(checkUserTel(img3,userTel)==false) return false;
	if(checkUserMail(img4,userMail)==false) return false;
	if(checkUserPass(img5,userPass)==false) return false;
	if(checkUserRpass(img6,userRpass)==false) return false;
	if(checkVertyCode(img7,verify)==false) return false;
	return true;
}
/* 函数绑定 */
window.onload = function(){
	init();//初始化对象
	createCode();//初始化验证码
	nowday();//获取当前时间并填充
	var monthobj = document.getElementById("month");//获取对行啊
	var yearobj =  document.getElementById("year");//
	//当年、月修改时，日期作相应改变
	yearobj.onchange = changeday;//日期下拉菜单函数绑定
	monthobj.onchange = changeday;//日期下拉菜单函数绑定
}
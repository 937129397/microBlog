// JavaScript Document

var useridtmp = "";//用户id的恢复变量
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
/* 输入框获得焦点时,设置背景色,并且将原来的提示语放回到输入框中 */
function userIdfocus(){
	var userId = document.getElementById("userId");
	userId.style.backgroundColor = "#FFF"
    userId.value = useridtmp;
	userId.select();
}
/* 密码框获得焦点时,就全选里面内容 */
function userPassfocus(){
	document.getElementById("passWord").select();
}
/* 函数绑定,获得焦点事件,失去焦点事件,鼠标悬停事件,鼠标离开事件 */
window.onload = function(){
	document.getElementById("userId").onmouseover = userIdfocus;
	document.getElementById("userId").onfocus = userIdfocus;
	document.getElementById("userId").onblur = checkForm;
	document.getElementById("passWord").onmousemove = userPassfocus
}
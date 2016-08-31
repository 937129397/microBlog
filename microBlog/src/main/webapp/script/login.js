// JavaScript Document

var useridtmp = "";//用户id的恢复变量
/* 提交表单是检测输入的数据是否正确 */
/* 输入框获得焦点时,设置背景色,并且将原来的提示语放回到输入框中 */
function userIdfocus(){
	var userId = document.getElementById("userLoad");
	userId.style.backgroundColor = "#FFF"
    userId.value = useridtmp;
	userId.select();
}
/* 密码框获得焦点时,就全选里面内容 */
function userPassfocus(){
	document.getElementById("password").select();
}
/* 函数绑定,获得焦点事件,失去焦点事件,鼠标悬停事件,鼠标离开事件 */
window.onload = function(){
	document.getElementById("userLoad").onmouseover = userIdfocus;
	document.getElementById("userLoad").onfocus = userIdfocus;
	document.getElementById("password").onmousemove = userPassfocus
}

$(function(){
	   $("#login").click(function(){
		   var userId = document.getElementById("userLoad");
		   var userPass = document.getElementById("password");
			if(userId.value == "请输入正确邮箱|手机号码")//如果本身是提示语,则继续出错的提示
				return false;
			userId.value = trim(userId.value);//去除id框前后空格
			useridtmp = userId.value;//将输入id传给变量
			/* 如果字符串里面有@字符,则相应进入邮箱检测环节,否则进入手机号检测*/
			if(useridtmp.indexOf("@")>-1){//如果里面有@符号
				/* 如果符合邮箱的规则,并且密码也符合长度的要求 */
				if(useridtmp.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/)!=null && trim(userPass.value).length >=6){
					var params={
							"email":$("#userLoad").val(),
							 "password":$("#password").val(),
					};
					$.ajax({
						  type: 'POST',
						  url: "user_loginByEmail.action",
						  data:params,
						  dataType: 'JSON',
						  success: function( data ){
							 if( data.code==1){
								 alert( '登录成功...');
								 location.href='index.html';
							 }else{
								 alert('登录失败,原因:'+ data.msg);
							 }
						  }
					});
				}else{
					alert("请输入正确格式的登录名和密码");
				}
			}else{//进入手机号处理流程
				/* 如果密码长度符合要求 并且也是11位的纯手机号,则返回正确 */
				if(useridtmp.match(/[^\d]/g)==null && useridtmp.length==11 && userPass.value.length >=6){
					var params={
							"telephone":$("#userLoad").val(),
							 "password":$("#password").val(),
					};
					$.ajax({
						  type: 'POST',
						  url: "user_loginByTelephone.action",
						  dataType: 'JSON',
						  success: function( data ){
							 if( data.code==1){
								 alert( '登录成功...');
								 location.href='index.html';
							 }else{
								 alert('登录失败,原因:'+ data.msg);
							 }
						  }
					});
				}else{//否则进入出错提示
					if(useridtmp.match(/[^\d]/g)!=null || useridtmp.length<11){
						userId.value = "请输入正确邮箱|手机号码"
						userId.style.backgroundColor = "#B9E3AB"
					}
					alert("请输入正确格式的登录名和密码");
				}
			}
		   
	   });
}); 
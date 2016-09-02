$(function(){
	$.ajax({
		url:"concern_getConcernInfo.action",
		type:"POST",
		dataType:"Json",
		success:function(data){
			if(data.code==1){
			var htmlstr='<table width="765" border="0" cellpadding="0" cellspacing="0" id="tb1">';
			htmlstr+='<tr>';
			htmlstr+=' <td width="21" rowspan="7" class="td1"></td>';
			htmlstr+='<td height="60" align="center" valign="middle" bgcolor="#FFFFFF" class="td2">';
			htmlstr+='<img src="images/MainRightFirstLineTitle.gif" width="48" height="48" alt="" /></td>';
			htmlstr+='<td height="60" class="td3"><font color="#000000" size="3"><b>你关注的人</b></font></td>';
			htmlstr+='<td rowspan="7" class="td1 height"></td>';
			htmlstr+='</tr>';
			htmlstr+='<tr>';
			htmlstr+='<td height="47" align="center" valign="middle" bgcolor="#e3f1fa" class="td2 font1">详细</td>';
			htmlstr+='<td height="45" align="center" valign="middle" bgcolor="#e3f1fa" class="td4 font1"> 列表';
			htmlstr+='<form id="form2" name="form2" method="post" action="">';
			htmlstr+='<div id="search">';
			htmlstr+='<input type="text" name="textfield2" id="textfield2" />';
			htmlstr+='<img src="images/sousuo1.gif" alt="" width="27" height="25" align="absmiddle" />';
			htmlstr+='</div>';
			htmlstr+='</form></td>';
			htmlstr+='</tr>';
			for (var i = 0; i < data.obj.length; i++) {
				htmlstr+=' <tr>';
				htmlstr+='<td height="105" align="center" valign="middle" class="td2">';
				htmlstr+='<img src="'+data.obj.pic+'" width="54" height="54" alt="" /></td>';
				htmlstr+='<td height="105" align="left" valign="bottom" class="td3">';
				htmlstr+='<font color="#005dc3" size="3" face="微软小黑"><b>'+data.obj.nickname+'</b></font>';
				htmlstr+='<img src="images/1.gif" width="17" height="15" alt="" />';
				htmlstr+='<br /><font color="#000000" size="2">'+data.obj.sign+'</font>';
				htmlstr+='<div id="focus1"><img src="images/ok.png" alt="" width="16" height="16" align="texttop" /> 已关注';
				htmlstr+='<img src="images/focus.gif" alt="" width="43" height="30" align="absbottom" /></div></td>';
				htmlstr+=' </tr>';
			}
			htmlstr+='<tr>';
			htmlstr+='<td height="35" class="td2"></td>';
			htmlstr+='<td height="35" class="td3"></td>';
			htmlstr+='</tr>';
			htmlstr+='</table>';
			htmlstr+='<table width="200" border="0" cellpadding="0" cellspacing="0" id="tb2">';
			htmlstr+='<tr>';
			htmlstr+=' <td height="65" align="left" class="font2" ><a href="MyWB.html" id="userLogin"></a>';	
			htmlstr+=' </td>';
			htmlstr+='</tr>';
			htmlstr+='<tr>';
			htmlstr+='<td height="60" class="font2"><br /><br />';
			htmlstr+='<div id="mainRightPostionFirstLineWord2">';
			htmlstr+='<ul id="ul1">';
			htmlstr+='<li><a href="MyWB.html" class="a1" id="webCount"><font class="style1" ></font></a><br /><font class="style2">微博</font></li>';
			htmlstr+='<li><a href="friend.html" class="a1" id="concernCount"><font class="style1" ></font></a><br /><font class="style2">关注</font></li>';
			htmlstr+=' <li><a href="focusonyou.html" class="a1" id="fansCount"><font class="style1" ></font></a><br /><font class="style2">粉丝</font></li>';
			htmlstr+='</ul>';
			htmlstr+='</div>';
			htmlstr+='</tr>';
			htmlstr+='<tr>';
			htmlstr+='<td height="101" align="left" valign="top">';
			htmlstr+='<div id="search1"><form id="form1" name="form1" method="post" action="">';
			htmlstr+='<input name="textfield" type="text" class="form3" id="textfield" />';
			htmlstr+='<img src="images/sousuo2.gif" alt="" width="27" height="25" align="middle" /> ';
			htmlstr+='</form>';
			htmlstr+='</div><br />';
			htmlstr+=' &nbsp;&nbsp;&nbsp;<font color="#666666" size="3">我关注的话题</font></td>';
			htmlstr+='</tr>';
			htmlstr+=' <tr>';
			htmlstr+='<td height="126"> &nbsp;&nbsp;&nbsp;<font color="#666666" size="3">我关注的</font><br />';
			for (var i = 1; i <= data.obj.length; i++) {
				htmlstr+='<img src="'+data.obj.pid+'" alt="" width="54" height="54" class="img" />';
				if(i%3==0){
					htmlstr+='<br />'
				}
				htmlstr+='&nbsp;&nbsp;<font color="#005dc3"> '+data.obj.nickname+'</font>';
			}
			htmlstr+='</td>';
			htmlstr+='</tr>';
			
			htmlstr+='<tr>';
			htmlstr+='<td height="95"> &nbsp;&nbsp;&nbsp;熊猫网微博的成长，离不开你们。';
			htmlstr+='<br /> &nbsp;&nbsp;&nbsp;<font color="#005dc3"> 有意见请（点击）</font>';
			htmlstr+='<p> &nbsp;&nbsp;&nbsp;<font color="#005dc3"> 不良信息举报中心</font></p></td>';
			htmlstr+='</tr>';
			htmlstr+='</table>';
			}else{
				alert(data.msg);
			}
			$("#banner").html(htmlstr);
		}
	});
});
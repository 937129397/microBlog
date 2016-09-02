$(function(){
	var value="";
	var val="";
	
	$.ajax({
		url:"user_getOwnBlogCount.action",
		type:"POST",
		dataType:"JSON",
		success:function(data){
			if(data.code==1){
				value=data.obj;
			}else{
				alert(data.msg);
			}
			$("#webCount").html(value);
		}
	});
	
	
	$.ajax({
		url:"concern_getFansCount.action",
		type:"POST",
		dataType:"JSON",
		success:function(data){
			if(data.code==1){
				value=data.obj;
			}else{
				alert(data.msg);
			}
			$("#fansCount").html(value);
		}
	});
	
	$.ajax({
		url:"concern_getConcernCount.action",
		type:"POST",
		dataType:"JSON",
		success:function(data){
			if(data.code==1){
				value=data.obj;
			}else{
				alert(data.msg);
			}
			$("#concernCount").html(value);
		}
	});
	
	
	$.ajax({
		url:"user_getUserInfo.action",
		type:"POST",
		dataType:"JSON",
		success:function(data){
			if(data.code==1){
				value=data.obj.nickname;
				val=data.obj.sign;
			}else{
				alert(data.msg);
			}
			$("#sign").html(val);
			$("#userLogin").html(value);
			$("#userLogin1").html(value);
		}
		
	});
	
});

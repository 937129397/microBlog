$(function(){
	var val="";
	var val1="";
	var val2="";
	var val3="";
	var value="";
	
	$.ajax({
		url:"user_getAllCount.action",
		type:"POST",
		dataType:"JSON",
		success:function(data){
			if(data.code==1){
				val1=data.obj.blogCount;
				val2=data.obj.fanCount;
				val3=data.obj.concernCount;
			}else{
				alert(data.msg);
			}
			$("#webCount").html(val1);
			$("#fansCount").html(val2);
			$("#concernCount").html(val3);
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

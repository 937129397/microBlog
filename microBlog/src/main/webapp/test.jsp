<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>文件上传</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script src="script/jquery-1.9.1.js"></script>
<script src="script/ajaxFileUpload.js"></script>

<script type="text/javascript">
       
        function sub(){
        	$.ajaxFileUpload({
			url:"blog_savaBolg.action",
			secureuri:false,
			fileElementId:["f1","f2","f3"],
			
			data:{"text":111111},//表单的非文件域
			dataType:'Json',
			complete:function(){
				
			},
			success:function(data,status){
				alert(data.code+"--"+data.obj);
			},
			error:function(data,status,e){
				alert(e);
			}	
		});
        }
        
        </script>
</head>

<body>

	<form action="blog_savaBolg.action" enctype="multipart/form-data" method="post">
		文件1:<input type="file" name="file" id="f1"><br /> 文件2:<input
			type="file" name="file" id="f2"><br /> 文件3:<input type="file"
			name="file" id="f3"><br /> <input type="submit" onclick="sub()" value="上传" />
	</form>
</body>
</html>
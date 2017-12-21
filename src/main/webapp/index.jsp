<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="message"/>
	<button>发送消息</button>
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("button").on('click', ()=>{
				$.ajax({
					url:'${pageContext.request.contextPath}/message/send',
					type:'post',
					data:{
						message:$("#message").val()
					},
					dataType:'text',
					success:function(data){
						if(data !== ''){
							alert("发送完毕...");
						}
					},
					error:function(){
						alert('发送失败...');
					}
				});
			});
		});
	</script>
</body>
</html>
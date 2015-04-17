<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js" ></script>
	<script type="text/javascript">
		$(function(){
			$('#loginForm input[name=userCode]').select();
		});
		function checkForm(){
			var userCode = $('#loginForm input[name=userCode]').val();
			var password = $('#loginForm input[name=password]').val();
			if(!$.trim(userCode)){
				$('#error_msg').html('账号不能为空，请重新输入！');
				$('#loginForm input[name=userCode]').select();
				return false;
			}
			if(!$.trim(password)){
				$('#error_msg').html('密码不能为空，请重新输入！');
				$('#loginForm input[name=password]').select();
				return false;
			}
			$('#loginForm').submit();
		}	
	</script>
  </head>
  
  <body>
    <div class="login_panel">
	    <h3 class="login_title">管理员登陆</h3>
    	<form id="loginForm" action="${pageContext.request.contextPath }/admin/userLogin.action" method="post">
    		<p id="error_msg">${msg }</p>
	    	<p>
	    		<label for="userCode">账号：</label>
	    		<input type="text" name="userCode" id="userCode" />
	    	</p>
	    	<p>
	    		<label for="password">密码：</label>
	    		<input type="password" name="password" id="password" />
	    	</p>
	    	<p>
	    		<input type="button" onclick="checkForm()" value="登陆">
	    	</p>
	    </form>
    </div>
  </body>
</html>

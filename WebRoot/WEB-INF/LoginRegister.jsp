<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>LoginRegister</title>
	<link rel="stylesheet" type="text/css" href="./css/LoginRegister.css">
		<script type="text/javascript">
			function identy_login(value)
			{
				if(value=="student")
				{
					var path = "student_login";
					$('#Login').attr("action",path);
				}
				if(value=="teacher")
				{
					var path = "teacher_login";
					$('#Login').attr("action",path);
				}
			}
			function identy_register(value)
			{
				if(value=="student")
				{
					var path = "student_register";
					$('#Register').attr("action",path);
					$('#CardId').css("display","");
				}
				if(value=="teacher")
				{
					var path = "teacher_register";
					$('#Register').attr("action",path);
					$('#CardId').css("display","none");
				}
			}
	function checkForm(){
     var flag=true;
     var message=student_login.returnMsg.value;
     if(message!='null'){
      alert(message);
      flag=false;
     }
     return flag;
    }
	</script>
</head>
<body onload="checkForm()">
	<div class="LoginRegister_Can">
		<div class="label">Register</div>
		<form class="form login" Method="post" id="Login" action="student_login" style="display: block">
		<h2 class="title">Login</h2>
		<div class="AccountSelect">
			<span>账户类型：</span>
			<select class="identy_select" checked="checked"  onchange="identy_login(this.options[this.options.selectedIndex].value)">
				<option name="identy" value="student" >学 生</option>
				<option name="identy" value="teacher" >教 员</option>
			</select>
		</div><br>
			<input type="text" class="input username" placeholder="请输入用户名" name="user_id"><br>
			<input type="password" class="input password" placeholder="请输入密码" name="user_password"><br>
			<div class="checkboxstyle AutoLoginWords">
			<input type="checkbox" class="AutoLogin" id="AutoLoginCheckBox">
			<label for="AutoLoginCheckBox"></label> 
			</div><br>
			<input type="submit" class="button" id="LoginSubmit" value="登   录">
		</form>
		<form class="form" style="display: none" method="post" id="Register" action="student_register" target="_parent">
		<h2 class="title">Register</h2>
		<div class="AccountSelect">
			<span>账户类型：</span>
			<select class="identy_select" onchange="identy_register(this.options[this.options.selectedIndex].value)">
				<option name="identy" value="student" checked="checked" >学 生</option>
				<option name="identy" value="teacher" >教 员</option>
			</select>
			</div><br>
			<span class="NoticeText" style="display:none"></span><br>
			<input type="hidden" id="returnMsg" value="<%=request.getSession().getAttribute("returnMsg") %>">
			<input type="text" class="input username" name="username" id="username" placeholder="请输入登录用户名"><br>
			<input type="password" class="input password"  name="password" id="password" placeholder="请输入密码"><br>
			<input type="password" class="input password"  name="passwordagain" id="passwordagain" placeholder="请再次输入密码"><br>
			<input type="text" class="input"  name="name" id="name" placeholder="姓名"><br>			
			<input type="text" class="input Tele"  name="Tele" id='Tele' placeholder="请输入电话号码"><br>
			<input type="text" class="input CardId"  name="CardId" id="CardId" placeholder="请输入身份证号"><br>
			<input type="submit" class="button"  id="RegisterSubmit" value="注  册">
		</form>
	</div>

<script  src="./js/jquery-3.2.1.min.js"></script>
<script  src="./js/main.js"></script>
</body>
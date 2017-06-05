<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<script src="./js/jquery.min.js"></script>
	<script type="text/javascript">
		
		$(function(){
			$('.label').click(function(){
			  if($(this).text()=="Login")
			  	$(this).text("Register");
			  else
			  	$(this).text("Login");
			  $(this).toggleClass ("labelTopLeft");
			  $('.form').animate({
			    height: "toggle", 	
			    opacity: "toggle"
			  }, "slow");
			});
		})
		
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
	<script type="text/javascript">
			function identy_login(value)
			{
				if(value==0)
				{
					var path = "student_login";
					$('.login').attr("action",path);
				}
				if(value==1)
				{
					var path = "teacher_login";
					$('.login').attr("action",path);
				}
			}
			function identy_register(value)
			{
				if(value==0)
				{
					var path = "student_register.";
					$('.login').attr("action",path);
				}
				if(value==1)
				{
					var path = "teacher_register";
					$('.login').attr("action",path);
				}
			}
	</script>
</head>
<body onload="checkForm()">

	<div class="LoginRegister_Can">
		<div class="label">Register</div>
		<form id="student_login" class="form login" action="student_login" style="display: block" method="POST">
		<input type="hidden" id="returnMsg" value="<%=request.getSession().getAttribute("returnMsg") %>">
		<h2 class="title">Login</h2>
		<div class="AccountSelect">
			<span>账户类型：</span>
			<select class="identy_select">
				<option name="identy" value="student" onclick="identy_login(0)">学 员</option>
				<option name="identy" value="teacher" onclick="identy_login(1)">教 员</option>
			</select>
		</div><br>
			<input type="text" class="input username" placeholder="请输入用户名" name="user_id"><br>
			<input type="password" class="input password" placeholder="请输入密码" name="user_password"><br>
			<div class="checkboxstyle AutoLoginWords">
			<input type="checkbox" class="AutoLogin" id="AutoLoginCheckBox">
			<label for="AutoLoginCheckBox"></label> 
			</div><br>
			<input type="submit" class="button" value="登   录">
		</form>
		<form class="form register" action="student_register" style="display: none" method="POST">
		<h2 class="title">Register</h2>
		<div class="AccountSelect">
			<span>账户类型：</span>
			<select class="identy_select">
				<option name="identy" value="student" checked="checked" onclick="identy_register(0)">学 员</option>
				<option name="identy" value="teacher" onclick="identy_register(1)">教 员</option>
			</select>
			</div><br>
			<input type="text" class="input username" placeholder="请输入用户名" name="id"><br>
			<input type="password" class="input password" placeholder="请输入密码"><br>
			<input type="password" class="input password" placeholder="请再次输入密码"><br>
			<input type="text" class="input CardId" placeholder="请输入身份证号"><br>
			<input type="text" class="input Tele" placeholder="请输入电话号码"><br>
			<input type="submit" class="button " value="注  册">
		</form>
	</div>

</body>
<%@ page language="java"
 import="java.util.* ,com.homeedu.*"
 

 pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//从这里获取后端传过来的值。
String name="教员";
if(request.getAttribute("loginUser")!=null){
	name=request.getAttribute("name").toString();
 }
 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Home Education </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  
  <a href="teaHome" ><%=name %> </a><br>
 <a href="login">转到登录页面</a>
  </body>
</html>
<%@page language="java" import="java.util.*" import="com.homeedu.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="utf-8">
	<title>家教</title>
</head>

<frameset  rows="60,*">
	<frame name="top" src="top"  frameborder="0" border="0"></frame>
	<frame name="content" src="mainPage"  frameborder="0" border="0"></frame>
</frameset>
</html>

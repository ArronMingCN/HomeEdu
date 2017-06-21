<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//System.out.println(basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="./css/index.css">
	<script type="text/javascript" src="./js/jquery.min.js"></script>
	<title>家教</title>
	<script>
	$(function gotopage()
	{
	window.location.href="index";
	})
	</script>
</head>
<body onload="gotopage()">
</body>
</html>
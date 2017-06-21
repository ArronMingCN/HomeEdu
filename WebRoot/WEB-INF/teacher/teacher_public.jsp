<%@page language="java" import="java.util.*" import="com.homeedu.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>家教</title>
	<link rel="stylesheet" type="text/css" href="./css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="./css/default.css">

	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
	<style type="text/css">
		table td{
			padding-top: 8px;
		}
	</style>
</head>
<body>
	<div class="htmleaf-container">
		<div class="profile-card-wrap">
			  <input id="check" type="checkbox" class="check"><label for="check" class="toggle"> + </label>

			  <div class="content" data-text="">

			    <div class="title">个人信息</div>

				<table class="custom-table">
					<tr>
						<td>用户名：</td>
						<td>${teacher.getName()}教员</td>
					</tr>
					<tr>
						<td>学校：</td>
						<td>${teacher.getSchool() }</td>
					</tr>
					<tr>
						<td>专业：</td>
						<td>${teacher.getMajor() }</td>
					</tr>
					<tr>
						<td>擅长科目：</td>
						<td>${teacher.getCourse1() }</td>
					</tr>
					<tr>
						<td>简介：</td>
						<td>${teacher.getIntroduction()}</td>
					</tr>
					<tr>
						<td>联系我：</td>
						<td>${teacher.getTelephone() }</td>
					</tr>
				</table>

			  </div>
			<div class="link-info">
				<div class="photo"></div>
			</div>
		</div>

	</div>
	
</body>
</html>
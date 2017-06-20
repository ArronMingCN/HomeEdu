<%@page language="java" import="java.util.*" import="com.homeedu.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>家教</title>
	<link rel="stylesheet" type="text/css" href="./css/index.css">
	<link rel="stylesheet" type="text/css" href="./css/order_show.css">
</head>
<body>
	<nav class="nav-top">
		<div class="nav-content">
			<div class="nav-logo">HomeEdu</div>
			<div class="nav-title">
				<ul class="nav-title-list">
					<li><a href="#">首页</a></li>
					<li><a href="#">学员信息</a></li>
					<li><a href="#">教员信息</a></li>
					<li>
					<a href="#">资讯中心</a>
					<img src="./images/navsub.png">
						<div class="nav-sub">
							<ul>
								<li><a href="#">学习宝典</a></li>
								<li><a href="#">名师指点</a></li>
								<li><a href="#">家长课堂</a></li>
							</ul>
						</div>
					</li>
					<li><a href="#">关于我们</a></li>
					<li><a href="#">联系我们</a></li>
				</ul>
			</div>
			<div class="nav-sign-group">
				<ul>
					<li>
						<div class="log-in">
							<a href="info_add.html">赵女士</a>
						</div>						
					</li>
					<li>
						<div class="log-in">
							<a href="Logout.html">注销</a>
						</div>						
					</li>
				</ul>
			</div>			
			<div style="clear: both;"></div> 
		</div>
	</nav>
	<div class="order-contain">
		<div class="content">
			<div class="content-title">订单信息</div>
			<div class="content-line1"></div>
			<div class="content-line2"></div>
			<div class="order-student">
				<div class="title">
					<div class="title-line"></div>
					<h3>学员信息</h3>
				</div>
				<div class="info">
					<div class="custom-table">
						<table>
							<tr>
								<td>订单编号：</td>
								<td>${message.getId()+100}</td>
							</tr>
							<tr>
								<td>联系人：</td>
								<td>${message.getSurname()}</td>
							</tr>
							<tr>
								<td>求教科目：</td>
								<td>${message.getCourse1() }</td>
							</tr>
							<tr>
								<td>学生年级：</td>
								<td>${message.getStudent_status() }</td>
							</tr>
							<tr>
								<td>授课薪酬：</td>
								<td>${message.getSalary() }</td>
							</tr>
							<tr>
								<td>所在位置：</td>
								<td>${message.getTeach_location() } </td>
							</tr>
							<tr>
								<td>学员性别：</td>
								<td>${message.getStudent_gender() }</td>
							</tr>
							<tr>
								<td>学员概述：</td>
								<td>${message.getStudent_grade() }</td>
							</tr>
							<tr>
								<td>授课时间：</td>
								<td>${message.getTeach_time() }</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="order-teacher">
				<div class="title">
					<div class="title-line"></div>
					<h3>需要这样的教员</h3>
				</div>
				<div class="info">
					<div class="custom-table">
						<table>
							<tr>
								<td>性别：</td>
								<td>${message.getTeach_gender() }</td>
							</tr>
							<tr>
								<td>教员要求</td>
								<td>${message.getTeach_request() }</td>
							</tr>
							<tr>
								<td>教学方式：</td>
								<td>教员上门</td>
							</tr>
							<tr>
								<td>教员类型：</td>
								<td>大学生</td>
							</tr>
							
						</table>
					</div>
				</div>
				<div class="bottom">
					<a href="#" class="btn">申请订单</a>
					<br><br>不是东大家教网老师？
					<a href="LoginRegister">马上去注册</a>
				</div>
			</div>
			<div style="clear: both;"></div>
		</div>
	</div>
	<footer class="footer"><p class="center-text">端牛溜溜 版权所有 2015-2017 湘ICP备8888888 </p></footer>
</body>
</html>
<%@page language="java" import="java.util.*" import="com.homeedu.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//System.out.println(basePath);

Parent par=(Parent)request.getSession().getAttribute("LOGIN_STUDENT");
Teacher teacher=(Teacher)request.getSession().getAttribute("LOGIN_TEACHER");
String user="登录";
String url="LoginRegister";
String registerAndloginout="注册";
String url2="LoginRegister";
String loginUrl="LoginRegister";
if(par!=null){
	user=par.getName()+"家长";
	registerAndloginout="注销";
	url="parent_center";
	url2="login_out";
	loginUrl="#";
}else if(teacher!=null){
System.out.println(teacher.toString());
	user=teacher.getName()+"教员";
	registerAndloginout="注销";
	url="teacher_center";
	url2="login_out";
	loginUrl="#";
}else{

}

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="./css/index.css">
	<title>家教</title>
	
	<nav class="nav-top">
		<div class="nav-content">
			<div class="nav-logo">HomeEdu</div>
			<div class="nav-title">
				<ul class="nav-title-list">
					<li><a target="content" href="mainPage">首页</a></li>
					<li><a target="content" href="student_info">学员信息</a></li>
					<li><a target="content" href="teacher_info">教员信息</a></li>
					<li>
				
					<li><a target="content" href="study">学习宝典</a></li>
					<li><a target="content" href="aboutUs">关于我们</a></li>
					<li><a href="#">联系我们</a></li>
				    <li><a target="content" href="<%=url%>">个人中心</a></li>
				</ul>
			</div>
			<div class="nav-sign-group">
				<ul>
					<li>
						<div class="nav-group">
							<a target="_parent" href="<%=loginUrl%>"><%=user%></a>
						</div>						
					</li>
					<li>
						<div class="nav-group">
							<a  target="_parent" href="<%=url2%>"><%=registerAndloginout %></a>
						</div>						
					</li>
				</ul>
			</div>			
			<div style="clear: both;"></div> 
		</div>
	</nav>
</html>
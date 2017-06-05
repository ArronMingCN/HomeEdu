<%@ page language="java" import="java.util.*" import="com.homeedu.entity.Parent" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//System.out.println(basePath);
Parent par=(Parent)request.getSession().getAttribute("LOGIN_USER");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="./css/bootstarp.min.css">
	<link rel="stylesheet" type="text/css" href="./css/index.css">
	<link rel="stylesheet" type="text/css" href="./css/info_add.css">
	<script type="text/javascript" src="./js/jquery.min.js"></script>
	<title>家教</title>
	<script type="text/javascript">
		$(function() {
			$('.form_input').focus(function() {
				$(this).parents('.custom-form').addClass('input--filled')
			});
			$('.form_input').blur(function() {
				if($(this).val() == ''){$(this).parents('.custom-form').removeClass('input--filled')}
			});
		})
	</script>
	<script type="text/javascript">  
	 //选择封面图片  
	    function preview(file){  
	         var prevDiv = document.getElementById('preview');  
	         if (file.files && file.files[0]){  
	         var reader = new FileReader();  
	         reader.onload = function(evt){  
	         prevDiv.innerHTML = '<img src="' + evt.target.result + '" width="130px" height="150px"/>';  
	        }  
	         reader.readAsDataURL(file.files[0]);  
	        }else{  
	         prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';  
	         }  
	    }  
	</script>  

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
							<a href="#"><%=par.getName()+"家长"%></a>
						</div>						
					</li>
					<li>
						<div class="log-in">
							<a href="login_out">注销</a>
						</div>						
					</li>
				</ul>
			</div>			
			<div style="clear: both;"></div> 
		</div>
	</nav>
	<div class="contain">
		<div class="content">
			<div class="content-title">完善信息</div>
			<div class="content-line1"></div>
			<div class="content-line2"></div>
			<form class="content-form" action="#" method="post">
			<div class="content-left">
				<div class="img" id="preview"><img src="./images/teacher01.jpg" width="130px" height="150px"></div>  
				<input name = "image" type="file" class="file" onchange="preview(this)" />  
				<table class="custom-table">
					<tr>
						<td>用户名：</td>
						<td>猫的树</td>
					</tr>
				</table>
			</div>
			<div class="content-right">
					<div class="custom-form-list">
						<span class="custom-form">
							<input class="form_input" type="text" name="teacher_tel" />
							<label class="form_label">
								<span class="form_label_content">电话</span>
							</label>
						</span>
						<span class="custom-form">
							<input class="form_input" type="text" name="teacher_school" />
							<label class="form_label">
								<span class="form_label_content">学校</span>
							</label>
						</span>
						<span class="custom-form">
							<input class="form_input" type="text" name="teacher_major" />
							<label class="form_label">
								<span class="form_label_content">专业</span>
							</label>
						</span>
						<span class="custom-form">
							<input class="form_input" type="text" name="teacher_no" />
							<label class="form_label">
								<span class="form_label_content">学号</span>
							</label>
						</span>
						<span class="custom-form">
							<input class="form_input" type="text" name="teacher_gpa" />
							<label class="form_label">
								<span class="form_label_content">GPA</span>
							</label>
						</span>
						<span class="custom-form">
							<input class="form_input" type="text" name="teacher_subject" />
							<label class="form_label">
								<span class="form_label_content">擅长科目</span>
							</label>
						</span>
						<span class="custom-form">
							<input class="form_input" type="text" name="teacher_description" />
							<label class="form_label">
								<span class="form_label_content">简介</span>
							</label>
						</span>
					</div>
					<input class="center-block" type="submit" value="Submit"/>
			</div>
			</form>
			<div style="clear: both;"></div> 
		</div>
	</div>
	<footer class="footer"><p class="center-text">端牛溜溜 版权所有 2015-2017 湘ICP备8888888 </p></footer>
</body>
</html>
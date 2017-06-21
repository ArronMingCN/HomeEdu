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
	
	<div class="contain">
		<div class="content">
			<div class="content-left">
				<div class="img" id="preview"><img src="./images/teacher01.jpg" width="130px" height="150px"></div>  
				<input name = "image" type="file" class="file" onchange="preview(this)" />  
				<table class="custom-table">
					<tr>
						<td>用户名：</td>
						<td>${teacher.getName()}</td>
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
						<td>${teacher.getIntroduction() }</td>
					</tr>
				</table>
				<a target="content" href="teacher_info_add" class="btn">修改信息</a>
				<a target="content" href="teacher_center" class="btn">历史订单</a>
			</div>
			<div class="content-right">
				<form class="publishform" method="POST" action="do_teacher_info_add">
						<div class="custom-form-list">
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
				
				</form>
			</div>
			<div style="clear: both;"></div> 
		</div>
	</div>
	<footer class="footer"><p class="center-text">端牛溜溜 版权所有 2015-2017 湘ICP备8888888 </p></footer>
</body>
</html>
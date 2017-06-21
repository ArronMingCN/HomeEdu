<%@page language="java" import="java.util.*" import="com.homeedu.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//System.out.println(basePath);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="./css/bootstarp.min.css">
	<link rel="stylesheet" type="text/css" href="./css/index.css">
	<link rel="stylesheet" type="text/css" href="./css/info_add.css">
	<link rel="stylesheet" type="text/css" href="./css/student_profile.css">
	<script type="text/javascript" src="./js/jquery.min.js"></script>
	<title>家教</title>
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
		<script type="text/javascript">
				function onload()
				{
					var today1 = new Date();
					var today;
					var month,date;
					if((today1.getMonth() + 1 )<10)
						month="0"+(today1.getMonth()+1);
					if(today1.getDate()<10)
						date="0"+today1.getDate();
					today = (today1.getFullYear()) +"-" + month + "-" + date;
					var h=document.getElementById("time").value;
					document.getElementById("time").value=today;
				};
				
		</script>

</head>
<body onload="onload()">
	
	<div class="contain">
		<div class="content">
			<div class="content-title">教员个人中心</div>
			<div class="content-line1"></div>
			<div class="content-line2"></div>
			<div class="content-left">
				<div class="img" id="preview"><img src="./images/teacher01.jpg" width="130px" height="150px"></div>  
				<input name = "image" type="file" class="file" onchange="preview(this)" />  
				<table class="custom-table">
					<tr>
						<td>用户名：</td>
						<td>猫的树</td>
					</tr>
					<tr>
						<td>学校：</td>
						<td>东北大学</td>
					</tr>
					<tr>
						<td>专业：</td>
						<td>计算机科学与技术</td>
					</tr>
					<tr>
						<td>擅长科目：</td>
						<td>高中数学</td>
					</tr>
					<tr>
						<td>简介：</td>
						<td></td>
					</tr>
				</table>
				<a href="info_add.html" class="btn">修改信息</a>
			</div>
			<div class="content-right">
		<div class="rightdiv" style="display:block;">
			<form class="publishform"  method="POST" action="addNewMessage">
				
				<!--<span>辅导科目:</span>
				<select id="teachsubject" class="select">
					<option>高中物理</option>
					<option>高中语文</option>
					<option>高中数学</option>
				</select><br>*/
				<span>辅导年级:</span>
				<select id="teachgrade" class="select">
					<option>高中一年级</option>
					<option>高中二年级</option>
					<option>高中三年级</option>
				</select><br>-->
				<span>辅导年级:</span>
				<input type="text" placeholder="如：高中一年级" id="teachgrade"><br>
				<span>辅导科目:</span>
				<input type="text" placeholder="如：高中语文" id="teachsubject"><br>
				<span>辅导方式:</span>
				<select id="teachmethod" class="select">
					<option>教员上门</option>
					<option>学员上门</option>
					<option>商量议定</option>
				</select><br>
				<span>授课地址:</span>
				<input type="text" placeholder="如：和平区" id="teacharea"><br>
				<span>薪水标准:</span>
				<input type="text" placeholder="金额" id="salarystandardMoney">/ 每
				<select id="salarystandardTime" id="salarystandardTime">
					<option>0.5</option>
					<option>1</option>
					<option>1.5</option>
					<option>2</option>
				</select>小时<br>
				<span>辅导时间:</span>
				<input type="date" value="" id="time"><br>
				<div class="submitdiv"><input type="submit" value="发布"></div>
			</form>
		</div>
			</div>
			<div style="clear: both;"></div> 
		</div>
	</div>
	<footer class="footer"><p class="center-text">端牛溜溜 版权所有 2015-2017 湘ICP备8888888 </p></footer>
</body>
</html>
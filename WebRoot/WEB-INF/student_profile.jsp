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
			<div class="content-title">学员个人中心</div>
			<div class="content-line1"></div>
			<div class="content-line2"></div>
			<div class="content-left">
				<table class="custom-table">
					<tr>
						<td>用户名：</td>
						<td>${parent.getId()}</td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td>${parent.getName() }家长</td>
					</tr>
				</table>
				<a target="content" href="parent_center" class="btn">发布</a>
				<a target="content" href="parentMessages" class="btn">历史订单</a>
			</div>
			<div class="content-right">
		<div class="rightdiv" style="display:block;">
			<form target="_parent" class="publishform" method="POST" action="addNewMessage">
				<span>联系人:</span>
				<input type="text" placeholder="如：王先生、黄女士" name="contactName"><br>
				<span>辅导年级:</span>
				<input type="text" placeholder="如：高中一年级" name="teachStatus"><br>
				<span>辅导科目:</span>
				<input type="text" placeholder="如：高中语文" name="teachSubject"><br>
				<span>授课要求:</span>
				<input type="text" placeholder="" name="teachRequest"><br>
				<span>学生成绩情况:</span>
			<input type="text" placeholder="" name="teachGrade"><br>
				<span>学生性别:</span>
				<select name="student_gender" class="select">
					<option>男</option>
					<option>女</option>
				</select><br>
				<span>教员性别:</span>
				<select name="teacher_gender" class="select">
					<option>男</option>
					<option>女</option>
					<option>均可</option>
				</select><br>
			
				<span>辅导方式:</span>
				<select name="teachWay" class="select">
					<option>教员上门</option>
					<option>学员上门</option>
					<option>商量议定</option>
				</select><br>
				<span>授课地址:</span>
				<input type="text" placeholder="如：和平区" name="teachLocation"><br>
				<span>薪水标准:</span>
			<input type="text" placeholder="如：100每小时" name="teachSalary"><br>
				<span>辅导时间:</span>
				<input type="text" placeholder="如：一周三次，每次2小时" name="teachTime"><br>
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
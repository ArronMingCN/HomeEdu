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
	<script type="text/javascript" src="./js/jquery.min.js"></script>
	<script type="text/javascript">
		function goPage(pno,psize){
			var itable = document.getElementById("idData");
			var num = itable.rows.length-1;//表格所有行数(所有记录数)
			console.log(num);
			var totalPage = 0;//总页数
			var pageSize = psize;//每页显示行数
			//总共分几页 
			if(num/pageSize > parseInt(num/pageSize)){   
				totalPage=parseInt(num/pageSize)+1;   
			}else{   
				totalPage=parseInt(num/pageSize);   
			}   
			var currentPage = pno;//当前页数
			var startRow = (currentPage - 1) * pageSize+1;//开始显示的行
			var endRow = currentPage * pageSize;//结束显示的行
			endRow = (endRow > num)? num : endRow;
			console.log(endRow);
			//遍历显示数据实现分页
			for(var i=1;i<(num+1);i++){    
				var irow = itable.rows[i];
				if(i>=startRow && i<=endRow){
					irow.style.display = "table-row";    
				}else{
					irow.style.display = "none";
				}
			}
			var tempStr = '';
			if(currentPage!=1){
				tempStr += "<li><a href=\"#\" onClick=\"goPage("+(currentPage-1)+","+psize+")\">&laquo;Previous</a></li>&nbsp;&nbsp;";
			}
			if(currentPage!=totalPage){
				tempStr += "<li><a href=\"#\" onClick=\"goPage("+(currentPage+1)+","+psize+")\">&nbsp;&nbsp;&nbsp;Next&nbsp;&nbsp;&nbsp;&raquo;</a></li>";
			}
			$('.pager').html(tempStr);
			var pageinfo = "<div class=\"center-text-order\">共"+num+"条记录 分"+totalPage+"页 当前第"+currentPage+"页</div>";
			$('.pager').append(pageinfo);  
		}
	</script>
	<style type="text/css">
		.center-text-order {
			margin: 0px;
		   text-align: center;
		   line-height: 25px;
		   letter-spacing: .1rem;
		   color: #999;
		}
		.custom-table ul li a {
			color: #999;
		}
	</style>
</head>
<body onload="goPage(1,5)">
	<div class="order-contain">
		<div class="content">
			<div class="content-title">订单信息</div>
			<div class="content-line1"></div>
			<div class="content-line2"></div>
			<div class="order-left">
				<div class="order-top">
					<div class="title">
						<div class="title-line"></div>
						<h3>学员信息</h3>
					</div>
					<div class="info">
						<div class="custom-table">
							<table>
							<tr>
								<td>订单编号：</td>
								<td>N${message.getId()+100}</td>
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
			</div>
			<div class="order-right">
					<div class="title">
						<div class="title-line"></div>
						<h3>申请的教员</h3>
					</div>
				<div class="custom-table">
					<table width="100%" id="idData">
					<tbody>
						<tr class="table-line">
							<th width="20%">姓名</th>
							<th width="20%">性别</th>
							<th width="40%">专业</th>
							<th width="20%">是否选择</th>
						</tr>
					</tbody>
					<c:forEach items="${listOfTeachers }" var="list">
						<tr class="center-text table-line">
							<td>${list.getName() }</td>
							<td>${list.getGender() }</td>
							<td>${list.getMajor() }</td>
							<td><a  href="confirmTeacher?id=${list.getId()}&msgId=${message.getId()}" class="btn-choose">want</a></td>
						</tr>
				</c:forEach>
					</table>
					<ul class="pager center-text" role="fanye"></ul>
				</div>
			</div>
			<div style="clear: both;"></div>
		</div>
	</div>
	<footer class="footer"><p class="center-text">端牛溜溜 版权所有 2015-2017 湘ICP备8888888 </p></footer>
</body>
</html>
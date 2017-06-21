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
	<link rel="stylesheet" type="text/css" href="./css/student_profile.css">
	<script type="text/javascript" src="./js/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="./css/tab.css" />	
	<script type="text/javascript" src="./js/jquery.min.js"></script>
	<script type="text/javascript" src="./js/jquery.tools.min.js"></script>
	<script type="text/javascript" src="./js/jquery.easing.1.3.js"></script>
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
		function goPage1(pno,psize){
			var itable = $("#order_info1");
			var num = itable.children('.info').length;//表格所有行数(所有记录数)
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
			for(var i=1;i<num+1;i++){    
				var irow = itable.children('.info').eq(i-1);
				if(i>=startRow && i<=endRow){
					irow.show();
				}else{
					irow.hide();
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
			var pageinfo = "<div class=\"center-text\">共"+num+"条记录 分"+totalPage+"页 当前第"+currentPage+"页</div>";
			$('.pager').append(pageinfo);  
		}
	</script>

	<script type="text/javascript">
		function goPage2(pno,psize){
			var itable = $("#order_info2");
			var num = itable.children('.info').length;//表格所有行数(所有记录数)
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
			for(var i=1;i<num+1;i++){    
				var irow = itable.children('.info').eq(i-1);
				if(i>=startRow && i<=endRow){
					irow.show();
				}else{
					irow.hide();
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
			var pageinfo = "<div class=\"center-text\">共"+num+"条记录 分"+totalPage+"页 当前第"+currentPage+"页</div>";
			$('.pager').append(pageinfo);  
		}
	</script>

	<script type="text/javascript">
	
		$(function() {
			
			var indicator = $('#indicator'),
					indicatorHalfWidth = indicator.width()/2,
					lis = $('#tabs').children('li');

			$("#tabs").tabs("#content section", {
				effect: 'fade',
				fadeOutSpeed: 0,
				fadeInSpeed: 400,
				onBeforeClick: function(event, index) {
					var li = lis.eq(index),
					    newPos = li.position().left + (li.width()/2) - indicatorHalfWidth;
					indicator.stop(true).animate({ left: newPos }, 600, 'easeInOutExpo');
				}
			});	

		});

	</script>

	<style type="text/css">
		.info {
			border:solid 1px #ddd;
			margin-bottom: 10px;
			padding: 8px;
		}
		.info:hover {
			border: solid 2px #33b5e5;
		}
		tr {
			color: #666;
		}

	</style>
</head>
<body onLoad="goPage1(1,3)">
	
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
				<a target="content" href="parent_center" class="btn">发布订单</a>
				<a target="content" href="parentMessages" class="btn">历史订单</a>
			</div>
			<div class="content-right">
				<nav class="tab_nav">		
					<ul id="tabs">
						<li onclick="goPage1(1,3)"><a class="current" href="#">未安排</a></li>
						<li onclick="goPage2(1,3)"><a href="#">已安排</a></li>
					</ul>
					<span id="indicator"></span>
				</nav>
				
				<div id="content">	
					<section>				
							<div id="order_info1">
							<c:forEach items="${bookinglist}" var="list">
							<div  onclick="window.location.href='chooseTeacher?id=${list.getId()}'" class="info">
								<div  class="custom-table">
									<table >
										<tr >
											<td>订单编号：</td>
											<td>N${list.getId()+100}</td>
										</tr>
										<tr>
											<td>求教科目：</td>
											<td>${list.getCourse1()}</td>
										</tr>
										<tr>
											<td>授课薪酬：</td>
											<td>${list.getSalary()}</td>
										</tr>
										<tr>
											<td>所在位置：</td>
											<td>${list.getTeach_location()} </td>
										</tr>
										<tr>
											<td>授课时间：</td>
											<td>${list.getTeach_time()}</td>
										</tr>
										<tr>
											<td>发布时间：</td>
											<td>${list.getCreated_at()}</td>
										</tr>
									</table>
								</div>
							</div>
							</c:forEach>
							
							</div>		
					</section>
				
					<section>		
							<div id="order_info2">
							<c:forEach items="${successlist}" var="list">
							<div class="info">
								<div class="custom-table">
									<table>
										<tr>
											<td>订单编号：</td>
											<td>N${list.getId()+100}</td>
										</tr>
										<tr>
											<td>求教科目：</td>
											<td>${list.getCourse1()}</td>
										</tr>
										<tr>
											<td>授课薪酬：</td>
											<td>${list.getSalary()}</td>
										</tr>
										<tr>
											<td>所在位置：</td>
											<td>${list.getTeach_location()} </td>
										</tr>
										<tr>
											<td>授课时间：</td>
											<td>${list.getTeach_time()}</td>
										</tr>
										<tr>
											<td>达成时间：</td>
											<td>${list.getDeal_time()}</td>
										</tr>
									</table>
								</div>
							</div>
							</c:forEach>
							</div>		
					</section>
				</div>

				<br>
				<ul class="pager center-text" role="fanye"></ul>
			</div>
			<div style="clear: both;"></div> 
		</div>
	</div>
	<footer class="footer"><p class="center-text">端牛溜溜 版权所有 2015-2017 湘ICP备8888888 </p></footer>
</body>
</html>
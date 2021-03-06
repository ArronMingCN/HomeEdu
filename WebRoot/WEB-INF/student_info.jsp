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
	<link rel="stylesheet" type="text/css" href="./css/students_info.css">
	<script type="text/javascript" src="./js/jquery.min.js"></script>
	<title>家教</title>

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
			var pageinfo = "<div class=\"center-text\">共"+num+"条记录 分"+totalPage+"页 当前第"+currentPage+"页</div>";
			$('.pager').append(pageinfo);  
		}
	</script>

</head>
<body onLoad="goPage(1,5)">
	<div class="contain">
		<div class="content">
			<div class="content-title">学员信息</div>
			<div class="content-line1"></div>
			<div class="content-line2"></div>
			<button class="info_btn"><a target="content" href="parent_center">家长发布</a></button>
			<div class="custom-table">
				<table width="100%" id="idData">
				<tbody>
					<tr class="table-line">
						<th width="10%">家长称呼</th>
						<th width="10%">辅导方式</th>
						<th width="20%">辅导科目</th>
						<th width="15%">辅导年级</th>
						<th width="20%">薪酬标准</th>
						<th width="15%">发布时间</th>
						<!--<th width="10%">状态</th>  -->
					</tr>
				</tbody>
				<c:forEach items="${listOfMessages}" var="list">
					<tr onclick="window.location.href='showMessageDetail?id=${list.getId()}'"
					 class="center-text table-line">
						<td >${list.getSurname()}</td>
						<td>${list.getTeach_type()} </td>  
						<td>${list.getCourse1()}</td>
						<td>${list.getStudent_status()}</td>
						<td>${list.getSalary()}</td>
						<td>${list.getCreated_at()}</td>
						<!--  <td><a href="showMessageDetail?id=${list.getId()}}">详细内容</a></td>-->
					</tr>
				</c:forEach>
					<!-- 
					<tr class="center-text table-line">
						<td>赵学员</td>
						<td>教员上门</td>
						<td>高中物理</td>
						<td>高中一年级</td>
						<td>200元/1.5小时</td>
						<td>2017-5-31</td>
						<td>已安排</td>
					</tr>
					<tr class="center-text table-line">
						<td>赵学员</td>
						<td>教员上门</td>
						<td>高中物理</td>
						<td>高中一年级</td>
						<td>200元/1.5小时</td>
						<td>2017-5-31</td>
						<td>超过时限</td>
					</tr> -->
				</table>
				<br><br>
				<ul class="pager center-text" role="fanye"></ul>
			</div>
		</div>
	</div>
</body>
</html>
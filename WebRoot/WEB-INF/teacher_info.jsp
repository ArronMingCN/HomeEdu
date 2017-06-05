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
<body onLoad="goPage(1,2)">
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
			<div style="clear: both;"></div> 
		</div>
	</nav>
	<div class="contain">
		<div class="content">
			<div class="content-title">教员信息</div>
			<div class="content-line1"></div>
			<div class="content-line2"></div>
			<div class="custom-table">
				<table width="100%" id="idData">
				<tbody>
					<tr class="table-line">
						<th width="10%">姓名</th>
						<th width="10%">性别</th>
						<th width="10%">辅导方式</th>
						<th width="20%">擅长科目</th>
						<th width="20%">薪酬标准</th>
						<th width="15%">教员身份</th>
						<th width="15%">加入时间</th>
					</tr>
				</tbody>
					<tr class="center-text table-line">
						<td>赵学员</td>
						<td>女</td>
						<td>教员上门</td>
						<td>高中物理</td>
						<td>100元/1小时</td>
						<td>本科在读</td>
						<td>2017-5-31</td>
					</tr>
					<tr class="center-text table-line">
						<td>赵学员</td>
						<td>女</td>
						<td>双方协商</td>
						<td>高中物理</td>
						<td>可商议</td>
						<td>本科在读</td>
						<td>2017-5-31</td>
					</tr>
					<tr class="center-text table-line">
						<td>赵学员</td>
						<td>女</td>
						<td>学员上门</td>
						<td>高中物理</td>
						<td>200元/1小时</td>
						<td>培训机构老师</td>
						<td>2017-5-31</td>
					</tr>
				</table>
				<br><br>
				<ul class="pager center-text" role="fanye"></ul>
			</div>
		</div>
	</div>
</body>
</html>
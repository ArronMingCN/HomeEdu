<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//System.out.println(basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="./css/index.css">
	<title>家教</title>
	<style>
	body,ul{margin: 0; padding: 0;}
	li{list-style: none;}
	.loopimgdiv{
	    width: 100%;
	    height: 470px;
	    margin-bottom: 50px;
	}
	#Marquee_x { overflow:hidden;} 
	#Marquee_x ul li { float:left;overflow:hidden} /* 横向滚动必须让所有li左浮动 */

	</style>
	<script src="./js/jquery.min.js"></script>
	<script src="./js/myfocus-2.0.4.min.js"></script>
	<script src="./js/jQuery-jcMarquee.js"></script>
	<script src="./js/jQuery.SuperSlide.js"></script>
    <script type="text/javascript">
		myFocus.set({
		    id:'imgbox',//焦点图盒子ID
		    //pattern: 'mF_tbhuabao',//风格应用的名称
		    time:2,//切换时间间隔(秒)
		    trigger:'click',//触发切换模式:'click'(点击)/'mouseover'(悬停)
		    txtHeight:'default'//文字层高度设置(像素),'default'为默认高度，0为隐藏
		});
    </script>
	<script>
	$(function(){
		$(".case-demo .case-grid-rsp").hide();
		$(".case-demo").hover(function(){
			$(this).find(".case-grid-rsp").stop().fadeTo(500,0.5)
		},
		function(){
			$(this).find(".case-grid-rsp").stop().fadeTo(500,0)
		});
	});
	</script>
	<script>
	$(function(){
	    $('#Marquee_x').jcMarquee(
	    { 
	    	'marquee':'x',
	    	'margin_right':'10px',
	    	'speed':20 
	    });
		// DIVCSS5提示：10px代表间距，第二个20代表滚动速度
	});
	</script>
<!-- 	<script>
	jQuery(".scrollBox").slide(
		{ 
			titCell:".list li", 
			mainCell:".piclist", 
			effect:"left",
			vis:4,
			scroll:4,
			delayTime:800,
			trigger:"click",
			easing:"easeOutCirc"
		});
	</script> -->
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
						<div class="three-d">
							<a href="LoginRegister">登录</a>
							<a href="LoginRegister">登录</a>
						</div>						
					</li>
					<li>
						<div class="three-d">
							<a href="LoginRegister.html">注册</a>
							<a href="LoginRegister.html">注册</a>
						</div>						
					</li>
				</ul>
			</div>			
			<div style="clear: both;"></div> 
		</div>
	</nav>

	<div class="loopimgdiv" id="imgbox">
		<div class="pic">
			<ul class="banner_imgs" >
				<li><a href="#"><img src="./images/image01.png" height="470" alt=""></a></li>
				<li><a href="#"><img src="./images/image05.jpg" height="470" alt=""></a></li>
				<li><a href="#"><img src="./images/image07.jpg" height="470" alt=""></a></li>
				<li><a href="#"><img src="./images/image08.jpg" height="470" alt=""></a></li>
				<li><a href="#"><img src="./images/image09.jpg" height="470" alt=""></a></li>
				<li><a href="#"><img src="./images/image10.jpg" height="470" alt=""></a></li>
			</ul>
		</div>
	</div> 

	<div id="server">
		<div class="server-title">最新学员</div>
		<p class="server-description">——STUDENTS——</p>
		<div class="server-contain">
			<div class="server-demo">
				<div class="server-demo-text">
					<h4 class="server-demo-title">
					￥450/小时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高中地理
					</h4>
					<p class="server-demo-address">浑南新区</p>
					<p class="server-demo-description">
					赵女士发布&nbsp;&nbsp;&nbsp;&nbsp;2017-5-22
					</p>
				</div>
			</div>
			<div class="server-demo">
				<div class="server-demo-text">
					<h4 class="server-demo-title">
					￥450/小时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高中地理
					</h4>
					<p class="server-demo-address">浑南新区</p>
					<p class="server-demo-description">
					赵女士发布&nbsp;&nbsp;&nbsp;&nbsp;2017-5-22
					</p>
				</div>
			</div>
			<div class="server-demo">
				<div class="server-demo-text">
					<h4 class="server-demo-title">
					￥450/小时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高中地理
					</h4>
					<p class="server-demo-address">浑南新区</p>
					<p class="server-demo-description">
					赵女士发布&nbsp;&nbsp;&nbsp;&nbsp;2017-5-22
					</p>
				</div>
			</div>
			<div class="server-demo">
				<div class="server-demo-text">
					<h4 class="server-demo-title">
					￥450/小时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高中地理
					</h4>
					<p class="server-demo-address">浑南新区</p>
					<p class="server-demo-description">
					赵女士发布&nbsp;&nbsp;&nbsp;&nbsp;2017-5-22
					</p>
				</div>
			</div>
			<div class="server-demo">
				<div class="server-demo-text">
					<h4 class="server-demo-title">
					￥450/小时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高中地理
					</h4>
					<p class="server-demo-address">浑南新区</p>
					<p class="server-demo-description">
					赵女士发布&nbsp;&nbsp;&nbsp;&nbsp;2017-5-22
					</p>
				</div>
			</div>
			<div class="server-demo">
				<div class="server-demo-text">
					<h4 class="server-demo-title">
					￥450/小时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高中地理
					</h4>
					<p class="server-demo-address">浑南新区</p>
					<p class="server-demo-description">
					赵女士发布&nbsp;&nbsp;&nbsp;&nbsp;2017-5-22
					</p>
				</div>
			</div>
			<div class="server-demo">
				<div class="server-demo-text">
					<h4 class="server-demo-title">
					￥450/小时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高中地理
					</h4>
					<p class="server-demo-address">浑南新区</p>
					<p class="server-demo-description">
					赵女士发布&nbsp;&nbsp;&nbsp;&nbsp;2017-5-22
					</p>
				</div>
			</div>
			<div class="server-demo">
				<div class="server-demo-text">
					<h4 class="server-demo-title">
					￥450/小时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高中地理
					</h4>
					<p class="server-demo-address">浑南新区</p>
					<p class="server-demo-description">
					赵女士发布&nbsp;&nbsp;&nbsp;&nbsp;2017-5-22
					</p>
				</div>
			</div>

			<div style="clear: both;"></div> 
		</div>
	</div>
	<div id="case">
		<div class="animation-fade case-title" data-animate="fade">金牌教员</div>
		<p class="case-description">
		——Teachers——
		<br>
		<br>
		最专业的教学服务，为您赢得更高的起点
		</p>
		<div class="case-contain animation-delay-300 animation-fadeInUp" id="Marquee_x" data-animate="fadeInUp">
		<ul>
			<li>

			<div class="case-demo">
				<a href="#">
					<div class="case-demo-task"></div>
					<img src="./images/teacher01.jpg" width="130" height="150">
				</a>
				<div class="case-grid-rsp"></div>
				<div class="case-demo-text">
					<h4 class="case-demo-title">姓名</h4>
					<p class="case-demo-description">擅长科目：英语</p>
				</div>
			</div>
			<div class="case-demo">
				<a href="#">
					<div class="case-demo-task"></div>
					<img src="./images/teacher02.jpg" width="130" height="150">
				</a>
				<div class="case-grid-rsp"></div>
				<div class="case-demo-text">
					<h4 class="case-demo-title">姓名</h4>
					<p class="case-demo-description">擅长科目：英语</p>
				</div>
			</div>
			<div class="case-demo">
				<a href="#">
					<div class="case-demo-task"></div>
					<img src="./images/teacher03.jpg" width="130" height="150">
				</a>
				<div class="case-grid-rsp"></div>
				<div class="case-demo-text">
					<h4 class="case-demo-title">姓名</h4>
					<p class="case-demo-description">擅长科目：英语</p>
				</div>
			</div>
			<div class="case-demo">
				<a href="#">
					<div class="case-demo-task"></div>
					<img src="./images/teacher04.jpg" width="130" height="150">
				</a>
				<div class="case-grid-rsp"></div>
				<div class="case-demo-text">
					<h4 class="case-demo-title">姓名</h4>
					<p class="case-demo-description">擅长科目：英语</p>
				</div>
			</div>
			<div class="case-demo">
				<a href="#">
					<div class="case-demo-task"></div>
					<img src="./images/teacher05.jpg" width="130" height="150">
				</a>
				<div class="case-grid-rsp"></div>
				<div class="case-demo-text">
					<h4 class="case-demo-title">姓名</h4>
					<p class="case-demo-description">擅长科目：英语</p>
				</div>
			</div>
			<div class="case-demo">
				<a href="#">
					<div class="case-demo-task"></div>
					<img src="./images/teacher06.jpg" width="130" height="150">
				</a>
				<div class="case-grid-rsp"></div>
				<div class="case-demo-text">
					<h4 class="case-demo-title">姓名</h4>
					<p class="case-demo-description">擅长科目：英语</p>
				</div>
			</div>
			</li>
		</ul>
		</div>
		<div style="clear: both;"></div> 
	</div>
	<div id="news">
		<div class="news-title">资讯中心</div>
		<p class="news-description">——NEWS——</p>
		<div class="news-contain">
			<div class="news-left">
				<img src="./images/news.jpg" width="410" height="237">
				<div class="news-content">
					<div class="news-date">
						<p class="news-month-day">09-21</p>
						<p class="news-year">2016</p>
					</div>
					<div class="news-text">
						<h4 class="news-text-title">记忆中的蘑菇汤</h4>
						<p class="news-text-description">&nbsp;小时候，常听奶奶说，“冬吃萝卜，夏吃姜，一年四季喝菌汤”。我以前只知道菌菇汤很好喝，长大了才知道</p>
					</div>
					<div style="clear: both;"></div> 
				</div>
			</div>
			<div class="news-right">
				<div class="news-content">
					<div class="news-date">
						<p class="news-month-day">09-21</p>
						<p class="news-year">2016</p>
					</div>
					<div class="news-text">
						<h4 class="news-text-title">记忆中的蘑菇汤</h4>
						<p class="news-text-description">&nbsp;小时候，常听奶奶说，“冬吃萝卜，夏吃姜，一年四季喝菌汤”。我以前只知道菌菇汤很好喝，长大了才知道</p>
					</div>
					<div style="clear: both;"></div> 
				</div>
				<div class="news-content">
					<div class="news-date">
						<p class="news-month-day">09-21</p>
						<p class="news-year">2016</p>
					</div>
					<div class="news-text">
						<h4 class="news-text-title">记忆中的蘑菇汤</h4>
						<p class="news-text-description">&nbsp;小时候，常听奶奶说，“冬吃萝卜，夏吃姜，一年四季喝菌汤”。我以前只知道菌菇汤很好喝，长大了才知道</p>
					</div>
					<div style="clear: both;"></div> 
				</div>
				<div class="news-content">
					<div class="news-date">
						<p class="news-month-day">09-21</p>
						<p class="news-year">2016</p>
					</div>
					<div class="news-text">
						<h4 class="news-text-title">记忆中的蘑菇汤</h4>
						<p class="news-text-description">&nbsp;小时候，常听奶奶说，“冬吃萝卜，夏吃姜，一年四季喝菌汤”。我以前只知道菌菇汤很好喝，长大了才知道</p>
					</div>
					<div style="clear: both;"></div> 
				</div>
			</div>
			<div style="clear: both;"></div> 
		</div>
	</div>
	 -->
	<footer class="footer"><p class="center-text">端牛溜溜 版权所有 2015-2017 湘ICP备8888888 </p></footer>
</body>
</html>
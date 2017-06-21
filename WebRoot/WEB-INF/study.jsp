<%@page language="java" import="java.util.*" import="com.homeedu.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML>
<html>
<head>
<title>学习宝典</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8" />

<link href="./css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!--Custom-Theme-files-->
<link href="./css/style.css" rel='stylesheet' type='text/css' />
<script src="./js/modernizr.custom.js"></script>
<script src="./js/jquery.min.js"> </script>
<!--/script-->
</head>
<body>

	<div class="full">
			<div class="col-md-3 top-nav gallery-sec">
				     <div class="logo">
						<a href="#"><h1>学习宝典</h1></a>
					</div>
					<div class="top-menu">
					<ul class="cl-effect-16">
						<li><a href="#" data-hover="语文">语文</a></li> 
						<li><a href="#" data-hover="数学" class="active" >数学</a></li>
						<li><a href="#" data-hover="英语">英语</a></li>
						<li><a href="#" data-hover="物理">物理</a></li>
						<li><a href="#" data-hover="化学">化学</a></li>
						<li><a href="#" data-hover="政治">政治</a></li>
						<li><a href="#" data-hover="历史">历史</a></li>
					</ul>
			    </div>
			</div>
	<div class="col-md-9 main">
	  <!--grids-->
	   <div class="gallery-section">
	     <h3 class="tittle">数 学</h3>
         <div class="categorie-grids cs-style-1">
				 <div class="col-md-4 cate-grid grid">
					<figure>
						<img src="./images/gen2.jpg" alt="">
						<figcaption>
							<h3>如何做笔记</h3>
							<span>为帮助学生理顺知识，培养学生灵活运用知识分析问题，解决问题的能力，形成完整的知识体系，归纳了下面的学习方法。</span>
							<a class="example-image-link" href="./images/gen2.jpg" data-lightbox="example-1" data-title="Interior Design">阅读</a>
						</figcaption>
					</figure>
				 </div>
				 <div class="col-md-4 cate-grid grid">
					 <figure>
						<img src="./images/gen1.jpg" alt="">
						<figcaption>
							<h3>更好的学习语文</h3>
							<span>学习起来需要花费更多的时间和精力，而且短期内不见得有很大成效。它需要长期的积淀积累，才能实现知识和能力的提升。 </span>
							<a class="example-image-link" href="./images/gen1.jpg" data-lightbox="example-1" data-title="Interior Design">阅读</a>
						</figcaption>
					</figure>
				 </div>


				 <div class="col-md-4 cate-grid grid">
					 <figure>
						<img src="./images/gen3.jpg" alt="">
						<figcaption>
							<h3>学习策略训练</h3>
							<span>实际上，他们的问题在于，从来没有人教过他们如何学习。</span>
							<a class="example-image-link" href="./images/gen3.jpg" data-lightbox="example-1" data-title="Interior Design">阅读</a>
						</figcaption>
					</figure>
				 </div>

				 <div class="col-md-4 cate-grid grid">
					<figure>
						<img src="./images/gen4.jpg" alt="">
						<figcaption>
							<h3>好作文的技巧</h3>
							<span>在语文的学习中，作文辅导成为我们家长较为头疼的问题。很多孩子对作文的畏难情绪和厌烦心理十分严重。</span>
							<a class="example-image-link" href="./images/gen4.jpg" data-lightbox="example-1" data-title="Interior Design">阅读</a>
						</figcaption>
					</figure>
				 </div>

				 <div class="col-md-4 cate-grid grid">
					 <figure>
						<img src="./images/gen6.jpg" alt="">
						<figcaption>
							<h3>学习数学的方法</h3>
							<span>数学这门学科是神圣的，是无数学者研究的成果。</span>
							<a class="example-image-link" href="./images/gen6.jpg" data-lightbox="example-1" data-title="Interior Design">阅读</a>
						</figcaption>
					</figure>
				 </div>

				 <div class="col-md-4 cate-grid grid">
					<figure>
						<img src="./images/gen5.jpg" alt="">
						<figcaption>
							<h3>学习物理的方法</h3>
							<span>物理固然有复杂性的一面，但是只要我们抓住物理学的特点，掌握正确的学习方法，这门功课是完全可以学好的。 </span>
							<a class="example-image-link" href="./images/gen5.jpg" data-lightbox="example-1" data-title="Interior Design">阅读</a>
						</figcaption>
					</figure>
				 </div>

				<div class="col-md-4 cate-grid grid">
					<figure>
						<img src="./images/gen1.jpg" alt="">
						<figcaption>
							<h3>期末复习策略</h3>
							<span>为帮助学生理顺知识，培养学生灵活运用知识分析问题，解决问题的能力，形成完整的知识体系，归纳了下面的学习方法。</span>
							<a class="example-image-link" href="./images/gen7.jpg" data-lightbox="example-1" data-title="Interior Design">阅读</a>
						</figcaption>
					</figure>
				 </div>
				 <div class="col-md-4 cate-grid grid">
					 <figure>
						<img src="./images/gen3.jpg" alt="">
						<figcaption>
							<h3>高中物理轻松学习</h3>
							<span>对于高一同学，开始学高中物理时，感党同初中物理大不一样，好象高中物理同初中物理间有一道鸿沟。</span>
							<a class="example-image-link" href="./images/gen3.jpg" data-lightbox="example-1" data-title="Interior Design">阅读</a>
						</figcaption>
					</figure>
				 </div>


				 <div class="col-md-4 cate-grid grid">
					 <figure>
						<img src="images/gen2.jpg" alt="">
						<figcaption>
							<h3>考前焦虑解决</h3>
							<span>考试之前，许多考生因为不同原因产生考前焦虑，这不仅会影响考试，更加会给身体健康造成威胁！ </span>
							<a class="example-image-link" href="./images/gen2.jpg" data-lightbox="example-1" data-title="Interior Design">阅读</a>
						</figcaption>
					</figure>
				 </div>
			 <div class="clearfix"></div>
		 </div>
	 </div>
     <div class="clearfix"> </div>
</body>
</html>
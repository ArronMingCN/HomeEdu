<%@page language="java" import="java.util.*" import="com.homeedu.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>关于我们</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<div class="header">
	<div class="container">
    	<div class="row">
        	<div class="col-md-12 col-sm-12 col-xs-12">
            	<div class="logo pull-left col-md-6 col-sm-6 col-xs-12">
                	<h1>ABOUT US</h1>
                </div>
            </div>
            <div class="col-md-12 col-sm-12 col-xs-12">
            	<div class="main-title text-center">
                	<h2>网络编程第X小组</h2>
                    <p><strong>我们是一个团结进取的小组，在这个繁忙又烦躁的日子里，我们能坚持一心，坚持到最后，为大家呈上我们的作品，真心为自己感到骄傲与自豪<br><br>谢谢你们</strong></p>
					<br><br><br><br><br>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="about text-center">
	<div class="container">
    	<div class="row">
        	<div class="col-md-12">
            	<div class="title">
                	<h3>成员介绍</h3>
                </div>
                <div class="desc">
                </div>
            </div>
            <div class="featurebox col-md-12 col-sm-12 col-xs-12">
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<div class="feature text-left">
                	<h4>赵 思洋</h4>
                    <p>这姑娘长得很讨人喜欢，圆圆的脸，弯弯的眉，水灵灵的眼睛，有一个微微翘起的小鼻子，使她显得又稚气、又逗人。</p>
                </div>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<div class="feature text-left">
                	<h4>黄 梅雪</h4>
                    <p>她个头比我稍矮，两个很大的“刷子’’衬托着一张娃娃脸，黑黑的眉毛下，长睫毛的阴影里，一双像秋水一样明澈的眼睛，翘起的鼻子显得很调皮。</p>
                </div>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<div class="feature text-left">
                	<h4>向 奎名</h4>
                    <p>这男孩长得虎头虎脑，特别是睫毛下那双黑葡萄似的眼睛，滴溜溜地不停地四下张望，充满着强烈的求知欲望。</p>
                </div>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<div class="feature text-left">
                	<h4>王 一超</h4>
                    <p>他四十多岁，人长得高大、结实，下巴上浓密的络腮胡子看来已有好久没刮了，活像一把用棕毛串成的板刷。一头花白的短发更衬出他的忠厚。</p>
                </div>
            </div>
			<div class="col-md-6 col-sm-6 col-xs-12">
            	<div class="feature text-left">
                	<h4>韩 宇</h4>
                    <p>那孩子穿着宽大的、掉光了扣子的破棉大衣，打腰上紧紧缠了两道棕绳；下身穿一条短短的单裤，露出两条细瘦的小腿；脚下趿着一双，大概是他父亲的布鞋，有很长一截拖在后跟外头。</p>
                </div>
            </div>
			<div class="col-md-6 col-sm-6 col-xs-12">
            	<div class="feature text-left">
                	<h4>罗 涛</h4>
                    <p>他顶大不过10岁，溜溜圆的脑瓜儿剃个光葫芦头，一对乌亮亮的大眼睛，宛若两汪澄清的湖水：两道浓黑的眉毛，好似湖上野鸭张开的翅膀。</p>
                </div>
            </div>
            </div>
        </div>
    </div>
</div>
<div class="footer" id="footer">
	<div class="container">
    	<div class="row">
        	<div class="col-md-12">
        	<div class="footer-title text-center">
            	<h3>联系我们</h3>
                <p>提交你的电子邮件给我们，我们将及时的联系你以便讨论加盟事宜</p>
            </div>
            <div class="subscribeform" style="height:100px">
            	<form class="subscribe_form" action="#" method="post">
	                <input required value="" placeholder="请输入你的电子邮箱" class="email" id="email" name="email" type="email">
	                <input class="subscribe" name="email" value="提交" type="submit">
	            </form>
            </div>
             </div>
             <div class="col-md-12 text-center footer-line">
             	<p>再一次谢谢你们，感谢！</p>
             </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.countdown.min.js"></script>

</body>
</html>

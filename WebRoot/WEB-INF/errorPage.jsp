<%@page language="java" import="java.util.*" import="com.homeedu.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML>
<HEAD>
<TITLE>错误页面</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<STYLE type=text/css>
body{
	margin:0px;
	padding:0px;
	background:#6fa8dc;
}
.tipInfo{position:relative;
	margin:150px auto 100px;
	border: 4px solid #c0ece7;
	border-color: rgba(192,237,232,07);border-radius:5px;derbackground:#c0ece7;
	background: rgba(192,237,232,07);
	width: 400px;
}
.tipInfo .in{background: #fff;padding: 0 10%}
.tipInfo .in h2{line-height:50px;font-size: 30px;color: #e94c3c;border-bottom: 1px dashed #aacdd5;padding: 18px 0}
.tipInfo .in p{padding:30px 0 50px 0;text-align: center;color: #289575}
.tipInfo .in p span{margin:0 5px}
.tipInfo .in p span a{color:black;margin: 0 10px}
</STYLE>
<BODY>
         <div class="tipInfo">
                <div class="in">
                    <div class="textThis">
                        <h2>XX网站提示您：</h2>
                        <p>
							<span>${errorMessage }</br>页面将在</span>
							<span><b id="wait">5</b>秒</span>
							后跳转到网站首页！<a target="_parent" id="href" href="index">立即返回首页</a>
						</p>
                        <script type="text/javascript">                            (function() {
                                var wait = document.getElementById('wait'), href = document.getElementById('href').href;
                                var interval = setInterval(function() {
                                    var time = --wait.innerHTML;
                                    if (time <= 0) {
                                        location.href = href;   
                                        clearInterval(interval);
                                    }
                                    ;
                                }, 1000);
                            })();
                        </script>
                    </div>
                </div>
            </div>
</DIV></DIV>
</BODY></HTML>

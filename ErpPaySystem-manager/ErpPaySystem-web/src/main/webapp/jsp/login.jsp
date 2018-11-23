 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/login.css">
    <script type="text/javascript" src="<%=request.getContextPath() %>/resource/js/jquery.min.js"></script>
	<script language="javascript" type="text/javascript">
        if (window.top != null && window.top.location != window.location) {
            window.top.location = window.location;
        }
        
    	if (window.top.location.href!=location.href) {
        	window.top.location.href=location.href;
    	}
    </script>
	<title>后台登陆</title>
</head>
<body>
	<div id="login_top">
		<div id="welcome">
			欢迎使用教学质量与教学改革工程管理系统
		</div>
		<div id="back">
			<a href="#">返回首页</a>&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href="#">帮助</a>
		</div>
	</div>
	<div id="login_center">
		<div id="login_area">
			<div id="login_form">
				<form action="dologin" method="post">
					<div id="login_tip">
						用户登录&nbsp;&nbsp;UserLogin
					</div>
					<div><input type="text" name="usercode" class="username"></div>
					<div><input type="password" name="password" class="pwd"></div>
					<div id="btn_area">
						<input type="submit" name="submit" id="sub_btn" value="登&nbsp;&nbsp;录">&nbsp;&nbsp;
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="login_bottom">
		版权所有
	</div>
</body>
</html>
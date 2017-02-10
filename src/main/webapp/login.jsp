<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录</title>
<link rel="stylesheet" type="text/css" href="${ctx}/static/login/css/login.css" />
<script type="text/javascript" src="${ctx}/static/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${ctx}/static/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/static/login/js/login.js"></script>

</head>

<body>
<input type="hidden" id="path" value="${ctx}" />
<div class="login-box">
	<h1>学生管理系统</h1>
	<form method="post" action="">
		<div class="name">
			<label>账 号：</label>
			<input type="text" name="username" id="username" autofocus="autofocus"/>
		</div>
		<div class="password">
			<label>密  码：</label>
			<input type="password" name="password" id="password"/>
		</div>
		<div class="login">
			<button type="button" class="loginBtn" tabindex="5">登录</button>
		</div>
	</form>
</div>

<div class="screenbg">
	<ul>
		<li><a href="javascript:;"><img src="${ctx}/static/login/images/0.jpg"></a></li>
	</ul>
</div>

</body>
</html>

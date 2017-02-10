<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>	
<head>
<title>绑定手机号</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${ctx}/static/login/css/style.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<!--//webfonts-->
<script type="text/javascript" src="${ctx}/static/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${ctx}/static/login/js/binding.js"></script>
<script type="text/javascript" src="${ctx}/static/layer_mobile/layer.js"></script>
</head>
<body>
<input type="hidden" value="${ctx}" id="path">
<input type="hidden" value="${weixin}" id="weixin">
 <!--SIGN UP-->
<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
			<div class="clear"> </div>
	<div class="avtar">
		<img src="${ctx}/static/login/images/avtar.png" />
	</div>
			<form>
				<input type="text" class="text" placeholder="请输入手机号码...."/>
			</form>
	<div class="signin">
		<input type="submit" class="login" value="立刻绑定" >
	</div>
</div>

</body>
</html>
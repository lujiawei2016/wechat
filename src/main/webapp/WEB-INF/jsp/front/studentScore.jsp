<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html lang="en" >
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${ctx}/static/studentScore/studentScore.css">
<title>${studentName}成绩</title>
</head>
<body>
	<div class="title">${studentName}成绩</div>
	<ul class="pricing_table">
		<c:forEach var="score" items="${scoreList}">
			<li class="price_block">
				<div class="price">
					<div class="price_figure">
						<span class="price_number">${score.title}</span>
					</div>
				</div>
				<ul class="features">
					<li>语文成绩：${score.china}</li>
					<li>数学成绩：${score.math}</li>
					<li>英语成绩：${score.english}</li>
					<li>成长积分：${score.growthIntegral}</li>
					<li>活跃度：${score.active}</li>
					<li>班干部分数：${score.leader}</li>
				</ul>
				<div class="footer">
					<a href="javascript:;" class="action_button">Buy Now</a>
				</div>
			</li>
		</c:forEach>
		<!-- <li class="price_block">
			<div class="price">
				<div class="price_figure">
					<span class="price_number">$9.99</span>
					<span class="price_tenure">per month</span>
				</div>
			</div>
			<ul class="features">
				<li>2GB Storage</li>
				<li>5 Clients</li>
				<li>10 Active Projects</li>
				<li>10 Colors</li>
				<li>Free Goodies</li>
				<li>24/7 Email support</li>
			</ul>
			<div class="footer">
				<a href="javascript:;" class="action_button">Buy Now</a>
			</div>
		</li>
		<li class="price_block">
			<div class="price">
				<div class="price_figure">
					<span class="price_number">$19.99</span>
					<span class="price_tenure">per month</span>
				</div>
			</div>
			<ul class="features">
				<li>5GB Storage</li>
				<li>10 Clients</li>
				<li>20 Active Projects</li>
				<li>20 Colors</li>
				<li>Free Goodies</li>
				<li>24/7 Email support</li>
			</ul>
			<div class="footer">
				<a href="javascript:;" class="action_button">Buy Now</a>
			</div>
		</li>
		<li class="price_block">
			<div class="price">
				<div class="price_figure">
					<span class="price_number">$999</span>
				</div>
			</div>
			<ul class="features">
				<li>Unlimited Storage</li>
				<li>Unlimited Clients</li>
				<li>Unlimited Projects</li>
				<li>Unlimited Colors</li>
				<li>Free Goodies</li>
				<li>24/7 Email support</li>
			</ul>
			<div class="footer">
				<a href="javascript:;" class="action_button">Buy Now</a>
			</div>
		</li> -->
	</ul>
	<script src="${ctx}/static/studentScore/prefixfree.min.js" type="text/javascript"></script>
</body>
</html>

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
			</li>
		</c:forEach>
	</ul>
	<script src="${ctx}/static/studentScore/prefixfree.min.js" type="text/javascript"></script>
</body>
</html>

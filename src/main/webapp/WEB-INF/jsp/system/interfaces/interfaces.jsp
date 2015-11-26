<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>接口</title>
<link rel="stylesheet" href="static/css/amazeui.min.css">
<script src="static/js/jquery-1.8.3.min.js"></script>
<script src="static/js/amazeui.min.js"></script>
</head>
<body>
	<section data-am-widget="accordion"
		class="am-accordion am-accordion-default"
		data-am-accordion='{ "multiple": true }'>
		<c:forEach items="${interfaces}" var="inter">
			<dl class="am-accordion-item">
				<dt class="am-accordion-title">${inter.NAME }</dt>
				<dd class="am-accordion-bd am-collapse ">
					<!-- 规避 Collapase 处理有 padding 的折叠内容计算计算有误问题， 加一个容器 -->
					<div class="am-accordion-content">${inter.DESCRIPTION }</div>
				</dd>
			</dl>
		</c:forEach>
	</section>
</body>
</html>
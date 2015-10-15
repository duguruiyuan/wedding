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

<meta charset="utf-8" />
<title></title>

<meta name="description" content="overview & stats" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="static/css/bootstrap.min.css" rel="stylesheet" />
<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
<link rel="stylesheet" href="static/css/font-awesome.min.css" />
<!-- 下拉框 -->
<link rel="stylesheet" href="static/css/chosen.css" />

<link rel="stylesheet" href="static/css/ace.min.css" />
<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
<link rel="stylesheet" href="static/css/ace-skins.min.css" />

<link rel="stylesheet" href="static/css/datepicker.css" />
<link rel="stylesheet" href="static/css/common.css" />
<!-- 日期框 -->
<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="static/js/jquery.tips.js"></script>

<script type="text/javascript">
	$(top.hangge());

	//保存
	function save() {
		if ($("#PRICE").val() == "") {
			$("#PRICE").val(0);
		} else if (isNaN(Number($("#PRICE").val()))) {

			$("#PRICE").tips({
				side : 3,
				msg : '输入数字',
				bg : '#AE81FF',
				time : 3
			});

			$("#PRICE").focus();
			$("#PRICE").val(0);
			return false;
		}

		$("#userForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
</script>
</head>
<body>
	<form action="order/${msg }.do" name="userForm" id="userForm"
		method="post">
		<input type="hidden" name="ID" id="ID"
			value="${pd.ID }" />
		<div id="zhongxin">
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<th>订单编号</th>
					<td><label>${pd.ID }</label></td>
				</tr>
				<tr>
					<th>购买用户</th>
					<td><label>${pd.USERNAME}</label></td>
				</tr>
				<tr>
					<th>产品名称</th>
					<td><label>${pd.NAME}</label></td>
				</tr>
				<tr class="info">
					<th>订单状态</th>
					<td><select class="chzn-select" name="STATUS" id="STATUS"
						data-placeholder="请选择订单状态" style="vertical-align: top;"
						title="订单状态">
							<option value=""></option>
							<c:forEach items="${orderStates}" var="o">
								<option value="${o.name }"
									<c:if test="${o.name == pd.STATUS }">selected</c:if>>${o.name }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<th>订单金额</th>
					<td><input type="text" id="PRICE" name="PRICE"
						value="${pd.PRICE }" /></td>
				</tr>
				<tr>
					<th>创建日期</th>
					<td><label>${pd.CREATED_DATE}</label></td>
				</tr>
				<tr>
					<td style="text-align: center;" colspan="2"><a
						class="btn btn-mini btn-primary" onclick="save();">保存</a> <a
						class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a></td>
				</tr>
			</table>
			<div></div>
		</div>

		<div id="zhongxin2" class="center" style="display: none">
			<br /> <br /> <br /> <br /> <br /> <img
				src="static/images/jiazai.gif" /><br />
			<h4 class="lighter block green">提交中...</h4>
		</div>
	</form>
	<!-- 引入 -->
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");
	</script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/ace-elements.min.js"></script>
	<script src="static/js/ace.min.js"></script>
	<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script>
	<!-- 下拉框 -->
	<script type="text/javascript"
		src="static/js/bootstrap-datepicker.min.js"></script>
	<!-- 日期框 -->
	<script type="text/javascript">
		$(function() {

			//单选框
			$(".chzn-select").chosen();
			$(".chzn-select-deselect").chosen({
				allow_single_deselect : true
			});

			//日期框
			$('.date-picker').datepicker();

		});
	</script>

</body>
</html>
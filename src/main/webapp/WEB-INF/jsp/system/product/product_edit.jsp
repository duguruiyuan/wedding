<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
		debugger;
		if ($("#new_price").val() == "") {
			$("#new_price").val(0);
		} else if (isNaN(Number($("#new_price").val()))) {

			$("#new_price").tips({
				side : 3,
				msg : '输入数字',
				bg : '#AE81FF',
				time : 3
			});

			$("#new_price").focus();
			$("#new_price").val(0);
			return false;
		}

		$("#userForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
</script>
</head>
<body>
	<form action="product/${msg }.do" name="userForm" id="userForm"
		method="post">
		<input type="hidden" name="id" id="id" value="${pd.id }" />
		<div id="zhongxin">
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<th>商品名称</th>
					<td><input type="text" name="name" id="name"
						value="${pd.name }" maxlength="32" placeholder="这里输入商品名称"
						title="名称" /></td>
				</tr>
				<tr>
					<th>老价格</th>
					<td><input type="number" name="old_price" id="old_price"
						value="${pd.old_price }" maxlength="32" placeholder="这里输入老价格"
						title="老价格" /></td>
				</tr>
				<tr>
					<th>新价格</th>
					<td><input type="number" name="new_price" id="new_price"
						value="${pd.new_price }" maxlength="32" placeholder="这里输入新价格"
						title="新价格" /></td>
				</tr>
				<tr class="info">
					<th>是否推荐</th>
					<td><select class="chzn-select" name="recommend"
						id="recommend" data-placeholder="请选择是否推荐"
						style="vertical-align: top;" title="是否推荐">
							<option value="1" <c:if test="${pd.recommend}">selected</c:if>>是</option>
							<option value="0" <c:if test="${!pd.recommend}">selected</c:if>>否</option>
					</select></td>
				</tr>
				<tr>
					<th>商品分类</th>
					<td><select class="chzn-select" name="type_id" id="type_id"
						data-placeholder="请选择商品类别" style="vertical-align: top;"
						title="商品类别">
							<option value=""></option>
							<c:forEach items="${productTypes}" var="o">
								<option value="${o.zdId }"
									<c:if test="${o.zdId == pd.type_id }">selected</c:if>>${o.name }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<th>商品详情</th>
					<td><textarea id="detail" name="detail" rows="10" cols="60">
						${pd.detail }
					</textarea></td>
				</tr>
				<tr>
					<th>商品信息</th>
					<td><textarea id="info" name="info" rows="10" cols="60">
						${pd.info }
					</textarea></td>
				</tr>
				<tr>
					<th>购买须知</th>
					<td><textarea id="notice" name="notice" rows="10" cols="60">
						${pd.notice }
					</textarea></td>
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
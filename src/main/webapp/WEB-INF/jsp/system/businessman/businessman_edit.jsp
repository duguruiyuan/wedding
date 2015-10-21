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
		debugger;
		if ($("#name").val() == "") {

			$("#name").tips({
				side : 3,
				msg : '输入商户名称',
				bg : '#AE81FF',
				time : 3
			});
			$("#name").focus();
			return false;
		}

		if ($("#phone").val() == "") {

			$("#phone").tips({
				side : 3,
				msg : '输入联系方式',
				bg : '#AE81FF',
				time : 3
			});
			$("#phone").focus();
			return false;
		}

		if ($("#address").val() == "") {

			$("#address").tips({
				side : 3,
				msg : '输入地址',
				bg : '#AE81FF',
				time : 3
			});
			$("#address").focus();
			return false;
		}

		$("#userForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
</script>
</head>
<body>
	<form action="businessMan/${msg }.do" name="userForm" id="userForm"
		method="post">
		<input type="hidden" name="id" id="id" value="${pd.id }" />
		<div id="zhongxin">
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<th>商户名称</th>
					<td><input type="text" name="name" id="name"
						value="${pd.name }" maxlength="32" placeholder="这里输入商品名称"
						title="名称" /></td>
				</tr>
				<tr>
					<th>联系方式</th>
					<td><input type="number" name="phone" id="phone"
						value="${pd.phone }" maxlength="32" placeholder="这里输入联系方式"
						title="联系方式" /></td>
				</tr>
				<tr>
					<th>类别</th>
					<td><select class="chzn-select" name="type_id" id="type_id"
						data-placeholder="请选择商家类别" style="vertical-align: top;"
						title="商家类别">
							<option value=""></option>
							<c:forEach items="${businessManTypes}" var="o">
								<option value="${o.zdId }"
									<c:if test="${o.zdId == pd.type_id }">selected</c:if>>${o.name }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<th>备注</th>
					<td><textarea name="remark" id="remark" placeholder="这里输入备注"
							title="备注">${pd.remark } </textarea></td>
				</tr>
				<tr class="info">
					<th>团购</th>
					<td><select class="chzn-select" name="tuan_flag"
						id="tuan_flag" data-placeholder="请选择是否团购"
						style="vertical-align: top;" title="是否团购">
							<option value="1" <c:if test="${pd.tuan_flag}">selected</c:if>>是</option>
							<option value="0" <c:if test="${!pd.tuan_flag}">selected</c:if>>否</option>
					</select></td>
				</tr>
				<tr class="info">
					<th>促销</th>
					<td><select class="chzn-select" name="cu_flag" id="cu_flag"
						data-placeholder="请选择是否促销" style="vertical-align: top;"
						title="是否促销">
							<option value="1" <c:if test="${pd.cu_flag}">selected</c:if>>是</option>
							<option value="0" <c:if test="${!pd.cu_flag}">selected</c:if>>否</option>
					</select></td>
				</tr>
				<tr class="info">
					<th>定</th>
					<td><select class="chzn-select" name="ding_flag"
						id="recommend" data-placeholder="请选择是否促销"
						style="vertical-align: top;" title="是否促销">
							<option value="1" <c:if test="${pd.cu_flag}">selected</c:if>>是</option>
							<option value="0" <c:if test="${!pd.cu_flag}">selected</c:if>>否</option>
					</select></td>
				</tr>
				<tr class="info">
					<th>排</th>
					<td><select class="chzn-select" name="pai_flag" id="pai_flag"
						data-placeholder="请选择是否促销" style="vertical-align: top;"
						title="是否促销">
							<option value="1" <c:if test="${pd.pai_flag}">selected</c:if>>是</option>
							<option value="0" <c:if test="${!pd.pai_flag}">selected</c:if>>否</option>
					</select></td>
				</tr>
				<tr>
					<th>地址</th>
					<td><input type="text" name="remark" id="remark"
						value="${pd.remark }" maxlength="32" placeholder="这里输入地址"
						title="地址" /></td>
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
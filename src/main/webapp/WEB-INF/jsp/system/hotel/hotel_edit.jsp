<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		
		<link rel="stylesheet" href="static/css/datepicker.css" /><!-- 日期框 -->
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		
<script type="text/javascript">
	
	
	//保存
	function save(){
			if($("#NAME").val()==""){
			$("#NAME").tips({
				side:3,
	            msg:'请输入酒店名称',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#NAME").focus();
			return false;
		}
		if($("#AREA").val()==""){
			$("#AREA").tips({
				side:3,
	            msg:'请输入酒店所属区域',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#AREA").focus();
			return false;
		}
		if($("#STAR").val()==""){
			$("#STAR").tips({
				side:3,
	            msg:'请输入星级',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#STAR").focus();
			return false;
		}
		if($("#STANDARDMEALFROM").val()==""){
			$("#STANDARDMEALFROM").tips({
				side:3,
	            msg:'请输入餐标价格开始',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#STANDARDMEALFROM").focus();
			return false;
		}
		if($("#STANDARDMEALTO").val()==""){
			$("#STANDARDMEALTO").tips({
				side:3,
	            msg:'请输入餐标价格结束',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#STANDARDMEALTO").focus();
			return false;
		}
		if($("#HASPARKINGLOT").val()==""){
			$("#HASPARKINGLOT").tips({
				side:3,
	            msg:'请输入是否有车位',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#HASPARKINGLOT").focus();
			return false;
		}
		if($("#SALESMAN").val()==""){
			$("#SALESMAN").tips({
				side:3,
	            msg:'请输入酒店销售名称',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#SALESMAN").focus();
			return false;
		}
		if($("#SALESPHONE").val()==""){
			$("#SALESPHONE").tips({
				side:3,
	            msg:'请输入酒店销售手机',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#SALESPHONE").focus();
			return false;
		}
		if($("#SALESTEL").val()==""){
			$("#SALESTEL").tips({
				side:3,
	            msg:'请输入酒店销售电话',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#SALESTEL").focus();
			return false;
		}
		if($("#BANQUETHALLNAME").val()==""){
			$("#BANQUETHALLNAME").tips({
				side:3,
	            msg:'请输入宴会厅名称',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#BANQUETHALLNAME").focus();
			return false;
		}
		if($("#TABLENUMBER").val()==""){
			$("#TABLENUMBER").tips({
				side:3,
	            msg:'请输入桌数',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#TABLENUMBER").focus();
			return false;
		}
		if($("#REMARKS").val()==""){
			$("#REMARKS").tips({
				side:3,
	            msg:'请输入备注',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#REMARKS").focus();
			return false;
		}
		if($("#ADDRESS").val()==""){
			$("#ADDRESS").tips({
				side:3,
	            msg:'请输入地址',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#ADDRESS").focus();
			return false;
		}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="hotel/${msg }.do" name="Form" id="Form" method="post">
		<input type="hidden" name="HOTEL_ID" id="HOTEL_ID" value="${pd.HOTEL_ID}"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:100px;text-align: right;padding-top: 13px;">酒店名称:</td>
				<td><input type="text" name="NAME" id="NAME" value="${pd.NAME}" maxlength="32" placeholder="这里输入酒店名称" title="酒店名称"/></td>
			</tr>
			<tr>
				<td style="width:100px;text-align: right;padding-top: 13px;">酒店所属区域:</td>
				<td><input type="text" name="AREA" id="AREA" value="${pd.AREA}" maxlength="32" placeholder="这里输入酒店所属区域" title="酒店所属区域"/></td>
			</tr>
			<tr>
				<td style="width:100px;text-align: right;padding-top: 13px;">星级:</td>
				<td><input type="text" name="STAR" id="STAR" value="${pd.STAR}" maxlength="32" placeholder="这里输入星级" title="星级"/></td>
			</tr>
			<tr>
				<td style="width:100px;text-align: right;padding-top: 13px;">餐标价格开始:</td>
				<td><input type="number" name="STANDARDMEALFROM" id="STANDARDMEALFROM" value="${pd.STANDARDMEALFROM}" maxlength="32" placeholder="这里输入餐标价格开始" title="餐标价格开始"/></td>
			</tr>
			<tr>
				<td style="width:100px;text-align: right;padding-top: 13px;">餐标价格结束:</td>
				<td><input type="text" name="STANDARDMEALTO" id="STANDARDMEALTO" value="${pd.STANDARDMEALTO}" maxlength="32" placeholder="这里输入餐标价格结束" title="餐标价格结束"/></td>
			</tr>
			<tr>
				<td style="width:100px;text-align: right;padding-top: 13px;">是否有车位:</td>
				<td><input type="text" name="HASPARKINGLOT" id="HASPARKINGLOT" value="${pd.HASPARKINGLOT}" maxlength="32" placeholder="这里输入是否有车位" title="是否有车位"/></td>
			</tr>
			<tr>
				<td style="width:100px;text-align: right;padding-top: 13px;">酒店销售名称:</td>
				<td><input type="text" name="SALESMAN" id="SALESMAN" value="${pd.SALESMAN}" maxlength="32" placeholder="这里输入酒店销售名称" title="酒店销售名称"/></td>
			</tr>
			<tr>
				<td style="width:100px;text-align: right;padding-top: 13px;">酒店销售手机:</td>
				<td><input type="text" name="SALESPHONE" id="SALESPHONE" value="${pd.SALESPHONE}" maxlength="32" placeholder="这里输入酒店销售手机" title="酒店销售手机"/></td>
			</tr>
			<tr>
				<td style="width:100px;text-align: right;padding-top: 13px;">酒店销售电话:</td>
				<td><input type="text" name="SALESTEL" id="SALESTEL" value="${pd.SALESTEL}" maxlength="32" placeholder="这里输入酒店销售电话" title="酒店销售电话"/></td>
			</tr>
			<tr>
				<td style="width:100px;text-align: right;padding-top: 13px;">宴会厅名称:</td>
				<td><input type="text" name="BANQUETHALLNAME" id="BANQUETHALLNAME" value="${pd.BANQUETHALLNAME}" maxlength="32" placeholder="这里输入宴会厅名称" title="宴会厅名称"/></td>
			</tr>
			<tr>
				<td style="width:100px;text-align: right;padding-top: 13px;">桌数:</td>
				<td><input type="number" name="TABLENUMBER" id="TABLENUMBER" value="${pd.TABLENUMBER}" maxlength="32" placeholder="这里输入桌数" title="桌数"/></td>
			</tr>
			<tr>
				<td style="width:100px;text-align: right;padding-top: 13px;">备注:</td>
				<td><input type="text" name="REMARKS" id="REMARKS" value="${pd.REMARKS}" maxlength="32" placeholder="这里输入备注" title="备注"/></td>
			</tr>
			<tr>
				<td style="width:100px;text-align: right;padding-top: 13px;">地址:</td>
				<td><input type="text" name="ADDRESS" id="ADDRESS" value="${pd.ADDRESS}" maxlength="32" placeholder="这里输入地址" title="地址"/></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
		</table>
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
		
	</form>
	
	
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript">
		$(top.hangge());
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
			
		});
		
		</script>
</body>
</html>
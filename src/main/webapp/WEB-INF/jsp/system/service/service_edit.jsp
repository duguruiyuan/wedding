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
			if($("#THEME").val()==""){
			$("#THEME").tips({
				side:3,
	            msg:'请输入主题名称',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#THEME").focus();
			return false;
		}
		if($("#INTRODUCTION").val()==""){
			$("#INTRODUCTION").tips({
				side:3,
	            msg:'请输入主题介绍',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#INTRODUCTION").focus();
			return false;
		}
		if($("#ZAMBIANUMBER").val()==""){
			$("#ZAMBIANUMBER").tips({
				side:3,
	            msg:'请输入赞数',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#ZAMBIANUMBER").focus();
			return false;
		}
		if($("#SERVICEITEMS").val()==""){
			$("#SERVICEITEMS").tips({
				side:3,
	            msg:'请输入服务项目',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#SERVICEITEMS").focus();
			return false;
		}
		if($("#PRICE").val()==""){
			$("#PRICE").tips({
				side:3,
	            msg:'请输入套餐价格',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#PRICE").focus();
			return false;
		}
		if($("#DETAIL").val()==""){
			$("#DETAIL").tips({
				side:3,
	            msg:'请输入细节介绍',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#DETAIL").focus();
			return false;
		}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="service/${msg }.do" name="Form" id="Form" method="post">
		<input type="hidden" name="SERVICE_ID" id="SERVICE_ID" value="${pd.SERVICE_ID}"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">主题名称:</td>
				<td><input type="text" name="THEME" id="THEME" value="${pd.THEME}" maxlength="32" placeholder="这里输入主题名称" title="主题名称"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">主题介绍:</td>
				<td><input type="text" name="INTRODUCTION" id="INTRODUCTION" value="${pd.INTRODUCTION}" maxlength="32" placeholder="这里输入主题介绍" title="主题介绍"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">赞数:</td>
				<td><input type="text" name="ZAMBIANUMBER" id="ZAMBIANUMBER" value="${pd.ZAMBIANUMBER}" maxlength="32" placeholder="这里输入赞数" title="赞数"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">服务项目:</td>
				<td><input type="text" name="SERVICEITEMS" id="SERVICEITEMS" value="${pd.SERVICEITEMS}" maxlength="32" placeholder="这里输入服务项目" title="服务项目"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">套餐价格:</td>
				<td><input type="text" name="PRICE" id="PRICE" value="${pd.PRICE}" maxlength="32" placeholder="这里输入套餐价格" title="套餐价格"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">细节介绍:</td>
				<td><input type="text" name="DETAIL" id="DETAIL" value="${pd.DETAIL}" maxlength="32" placeholder="这里输入细节介绍" title="细节介绍"/></td>
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
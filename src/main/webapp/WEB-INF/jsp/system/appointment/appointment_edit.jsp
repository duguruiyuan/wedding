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
			if($("#PHONE").val()==""){
			$("#PHONE").tips({
				side:3,
	            msg:'请输入手机号码',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#PHONE").focus();
			return false;
		}
		if($("#ISLUCKYDAY").val()==""){
			$("#ISLUCKYDAY").tips({
				side:3,
	            msg:'请输入是否黄道吉日',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#ISLUCKYDAY").focus();
			return false;
		}
		if($("#ISWEEKEND").val()==""){
			$("#ISWEEKEND").tips({
				side:3,
	            msg:'请输入是否双休日',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#ISWEEKEND").focus();
			return false;
		}
		if($("#ISEVENNUMBERS").val()==""){
			$("#ISEVENNUMBERS").tips({
				side:3,
	            msg:'请输入是否双号日',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#ISEVENNUMBERS").focus();
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
		if($("#SMSVERIFICATIONCODE").val()==""){
			$("#SMSVERIFICATIONCODE").tips({
				side:3,
	            msg:'请输入短信验证码',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#SMSVERIFICATIONCODE").focus();
			return false;
		}
		if($("#CREATETIME").val()==""){
			$("#CREATETIME").tips({
				side:3,
	            msg:'请输入创建时间',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#CREATETIME").focus();
			return false;
		}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="appointment/${msg }.do" name="Form" id="Form" method="post">
		<input type="hidden" name="APPOINTMENT_ID" id="APPOINTMENT_ID" value="${pd.APPOINTMENT_ID}"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">手机号码:</td>
				<td><input type="text" name="PHONE" id="PHONE" value="${pd.PHONE}" maxlength="32" placeholder="这里输入手机号码" title="手机号码"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">是否黄道吉日:</td>
				<td><input type="text" name="ISLUCKYDAY" id="ISLUCKYDAY" value="${pd.ISLUCKYDAY}" maxlength="32" placeholder="这里输入是否黄道吉日" title="是否黄道吉日"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">是否双休日:</td>
				<td><input type="text" name="ISWEEKEND" id="ISWEEKEND" value="${pd.ISWEEKEND}" maxlength="32" placeholder="这里输入是否双休日" title="是否双休日"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">是否双号日:</td>
				<td><input type="text" name="ISEVENNUMBERS" id="ISEVENNUMBERS" value="${pd.ISEVENNUMBERS}" maxlength="32" placeholder="这里输入是否双号日" title="是否双号日"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">桌数:</td>
				<td><input type="text" name="TABLENUMBER" id="TABLENUMBER" value="${pd.TABLENUMBER}" maxlength="32" placeholder="这里输入桌数" title="桌数"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">短信验证码:</td>
				<td><input type="text" name="SMSVERIFICATIONCODE" id="SMSVERIFICATIONCODE" value="${pd.SMSVERIFICATIONCODE}" maxlength="32" placeholder="这里输入短信验证码" title="短信验证码"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">创建时间:</td>
				<td><input class="span10 date-picker" name="CREATETIME" id="CREATETIME" value="${pd.CREATETIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="创建时间" title="创建时间"/></td>
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
﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<!-- jsp文件头和头部 -->
<%@ include file="../admin/top.jsp"%>
</head>
<body>
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<div class="row-fluid">
					<!-- 检索  -->
					<form action="order/listOrder.do" method="post" name="userForm"
						id="userForm">
						<table border="0px">
							<tr>
								<td><span class="input-icon"> <input
										autocomplete="off" id="nav-search-input" type="text"
										name="USERNAME" value="${pd.USERNAME }" placeholder="这里输入购买用户" />
										<i id="nav-search-icon" class="icon-search"></i>
								</span></td>
								<td><span class="input-icon"> <input autocomplete="off"
										id="nav-search-input" type="text" name="PRODUCTNAME"
										value="${pd.PRODUCTNAME }" placeholder="这里输入产品名称" /> <i id="nav-search-icon" class="icon-search"></i>
								</span></td>
								<td><input class="span10 date-picker" name="lastLoginStart"
									id="lastLoginStart" value="${pd.lastLoginStart}" type="text"
									data-date-format="yyyy-mm-dd" readonly="readonly"
									style="width: 88px;" placeholder="开始日期" /></td>
								<td><input class="span10 date-picker" name="lastLoginEnd"
									id="lastLoginEnd" value="${pd.lastLoginEnd}" type="text"
									data-date-format="yyyy-mm-dd" readonly="readonly"
									style="width: 88px;" placeholder="结束日期" /></td>
								<td style="vertical-align: top;"><select
									class="chzn-select" name="STATUS" id="STATUS"
									data-placeholder="状态" style="vertical-align: top; width: 79px;">
										<option value="">全部</option>
										<c:forEach items="${orderStates}" var="o">
											<option value="${o.name }"
												<c:if test="${o.name == pd.STATUS }">selected</c:if>>${o.name }</option>
										</c:forEach>
								</select></td>
								<td style="vertical-align: top;"><button
										class="btn btn-mini btn-light" onclick="search();" title="检索">
										<i id="nav-search-icon" class="icon-search"></i>
									</button></td>
								<c:if test="${QX.cha == 1 }">
									<td style="vertical-align: top;"><a
										class="btn btn-mini btn-light" onclick="toExcel();"
										title="导出到EXCEL"><i id="nav-search-icon"
											class="icon-download-alt"></i></a></td>
								</c:if>
							</tr>
						</table>
						<!-- 检索  -->


						<table id="table_report"
							class="table table-striped table-bordered table-hover">

							<thead>
								<tr>
									<th class="center"><label><input type="checkbox"
											id="zcheckbox" /><span class="lbl"></span></label></th>
									<th>序号</th>
									<th>订单编号</th>
									<th>购买用户</th>
									<th>产品名称</th>
									<th>状态</th>
									<th>价格</th>
									<th><i class="icon-time hidden-phone"></i>创建日期</th>
									<th class="center">操作</th>
								</tr>
							</thead>

							<tbody>

								<!-- 开始循环 -->
								<c:choose>
									<c:when test="${not empty orderList}">
										<c:if test="${QX.cha == 1 }">
											<c:forEach items="${orderList}" var="order" varStatus="vs">

												<tr>
													<td class='center' style="width: 30px;"><label><input
															type='checkbox' name='ids' /><span class="lbl"></span></label></td>
													<td class='center' style="width: 30px;">${vs.index+1}</td>
													<td>${order.id }</td>
													<td>${order.username }</td>
													<td>${order.name }</td>
													<td>${order.status }</td>
													<td>${order.price }</td>
													<td>${order.created_date }</td>
													<td style="width: 60px;" class="center">
														<div class='hidden-phone visible-desktop btn-group'>
															<c:if test="${QX.edit != 1 && QX.del != 1 }">
																<span
																	class="label label-large label-grey arrowed-in-right arrowed-in"><i
																	class="icon-lock" title="无权限"></i></span>
															</c:if>
															<c:if test="${QX.edit == 1 }">
																<a title="编辑" onclick="editOrder('${order.id }');"
																	class="btn btn-mini btn-info" data-rel="tooltip"
																	title="" data-placement="left"><i class="icon-edit"></i></a>
															</c:if>
															<c:choose>
																<c:when test="${user.USERNAME=='admin'}"></c:when>
																<c:otherwise>
																	<c:if test="${QX.del == 1 }">
																		<a title="取消订单"
																			onclick="delOrder('${order.id }','${order.id }');"
																			class="btn btn-mini btn-danger" data-rel="tooltip"
																			title="" data-placement="left"><i
																			class="icon-trash"></i> </a>
																	</c:if>
																</c:otherwise>
															</c:choose>
														</div>
													</td>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${QX.cha == 0 }">
											<tr>
												<td colspan="100" class="center">您无权查看</td>
											</tr>
										</c:if>
									</c:when>
									<c:otherwise>
										<tr class="main_info">
											<td colspan="100" class="center">没有相关数据</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
						<div class="page-header position-relative">
							<table style="width: 100%;">
								<tr>
									<td style="vertical-align: top;">
										<%-- <c:if test="${QX.add == 1 }">
					<a class="btn btn-small btn-success" onclick="add();">新增</a>
					</c:if> --%> <c:if test="${QX.del == 1 }">
											<a class="btn btn-small btn-danger"
												onclick="makeAll('确定要删除选中的数据吗?');" title="批量删除"><i
												class='icon-trash'></i></a>
										</c:if>
									</td>
									<td style="vertical-align: top;"><div class="pagination"
											style="float: right; padding-top: 0px; margin-top: 0px;">${page.pageStr}</div></td>
								</tr>
							</table>
						</div>
					</form>
				</div>




				<!-- PAGE CONTENT ENDS HERE -->
			</div>
			<!--/row-->

		</div>
		<!--/#page-content-->
	</div>
	<!--/.fluid-container#main-container-->

	<!-- 返回顶部  -->
	<a href="#" id="btn-scroll-up" class="btn btn-small btn-inverse"> <i
		class="icon-double-angle-up icon-only"></i>
	</a>

	<!-- 引入 -->
	<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/ace-elements.min.js"></script>
	<script src="static/js/ace.min.js"></script>

	<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script>
	<!-- 下拉框 -->
	<script type="text/javascript"
		src="static/js/bootstrap-datepicker.min.js"></script>
	<!-- 日期框 -->
	<script type="text/javascript" src="static/js/bootbox.min.js"></script>
	<!-- 确认窗口 -->
	<!-- 引入 -->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<!--提示框-->
	<script type="text/javascript">
		
		$(top.hangge());
		
		//检索
		function search(){
			top.jzts();
			$("#userForm").submit();
		}
		
		//新增
		function add(){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="新增订单";
			 diag.URL = '<%=basePath%>happuser/goAddU.do';
			 diag.Width = 450;
			 diag.Height = 355;
			 diag.CancelEvent = function(){ //关闭事件
				 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					 if('${page.currentPage}' == '0'){
						 top.jzts();
						 setTimeout("self.location=self.location",100);
					 }else{
						 nextPage(${page.currentPage});
					 }
				}
				diag.close();
			 };
			 diag.show();
		}
		
		//修改
		function editOrder(id){
			top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑订单";
			 diag.URL = '<%=basePath%>order/goEditOrder.do?ID='+id;
			 diag.Width = 350;
			 diag.Height = 355;
			 diag.CancelEvent = function(){ //关闭事件
				 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					 nextPage(${page.currentPage});
				}
				diag.close();
			 };
			 diag.show();
		}
		
		//删除
		function delOrder(userId,msg){
			bootbox.confirm("确定要取消订单["+msg+"]吗?", function(result) {
				if(result) {
					top.jzts();
					var url = "<%=basePath%>happuser/deleteU.do?USER_ID="+userId+"&tm="+new Date().getTime();
					$.get(url,function(data){
						nextPage(${page.currentPage});
					});
				}
			});
		}
		
		</script>

	<script type="text/javascript">
		
		$(function() {
			
			//下拉框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
			
			//复选框
			$('table th input:checkbox').on('click' , function(){
				var that = this;
				$(this).closest('table').find('tr > td:first-child input:checkbox')
				.each(function(){
					this.checked = that.checked;
					$(this).closest('tr').toggleClass('selected');
				});
					
			});
			
		});
		
		
		//批量操作
		function makeAll(msg){
			bootbox.confirm(msg, function(result) {
				if(result) {
					var str = '';
					var emstr = '';
					var phones = '';
					for(var i=0;i < document.getElementsByName('ids').length;i++)
					{
						  if(document.getElementsByName('ids')[i].checked){
						  	if(str=='') str += document.getElementsByName('ids')[i].value;
						  	else str += ',' + document.getElementsByName('ids')[i].value;
						  	
						  	if(emstr=='') emstr += document.getElementsByName('ids')[i].id;
						  	else emstr += ';' + document.getElementsByName('ids')[i].id;
						  	
						  	if(phones=='') phones += document.getElementsByName('ids')[i].alt;
						  	else phones += ';' + document.getElementsByName('ids')[i].alt;
						  }
					}
					if(str==''){
						bootbox.dialog("您没有选择任何内容!", 
							[
							  {
								"label" : "关闭",
								"class" : "btn-small btn-success",
								"callback": function() {
									//Example.show("great success");
									}
								}
							 ]
						);
						
						$("#zcheckbox").tips({
							side:3,
				            msg:'点这里全选',
				            bg:'#AE81FF',
				            time:8
				        });
						
						return;
					}else{
						if(msg == '确定要删除选中的数据吗?'){
							top.jzts();
							$.ajax({
								type: "POST",
								url: '<%=basePath%>happuser/deleteAllU.do?tm='+new Date().getTime(),
						    	data: {USER_IDS:str},
								dataType:'json',
								//beforeSend: validateData,
								cache: false,
								success: function(data){
									 $.each(data.list, function(i, list){
											nextPage(${page.currentPage});
									 });
								}
							});
						}else if(msg == '确定要给选中的用户发送邮件吗?'){
							sendEmail(emstr);
						}else if(msg == '确定要给选中的用户发送短信吗?'){
							sendSms(phones);
						}
						
					}
				}
			});
		}
		
		//导出excel
		function toExcel(){
			var USERNAME = $("#nav-search-input").val();
			var lastLoginStart = $("#lastLoginStart").val();
			var lastLoginEnd = $("#lastLoginEnd").val();
			var PRODUCTNAME = $("#PRODUCTNAME").val();
			var STATUS = $("#STATUS").val();
			window.location.href='<%=basePath%>order/excel.do?USERNAME='+USERNAME+'&lastLoginStart='+lastLoginStart+'&lastLoginEnd='+lastLoginEnd+'&PRODUCTNAME='+PRODUCTNAME+'&STATUS='+STATUS;
		}
	</script>
</body>
</html>


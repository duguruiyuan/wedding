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
<!-- jsp文件头和头部 -->
<%@ include file="../admin/top.jsp"%>
</head>
<body>
	<div class="container-fluid" id="main-container">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<div class="row-fluid">
					<!-- 检索  -->
					<form action="businessMan/listBusinessMan.do" method="post"
						name="userForm" id="userForm">
						<table border="0px">
							<tr>
								<td><span class="input-icon"> <input
										autocomplete="off" id="nav-search-input" type="text"
										name="name" value="${pd.name }" placeholder="这里输入商户名称" /> <i
										id="nav-search-icon" class="icon-search"></i>
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
									class="chzn-select" name="status" id="status"
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
									<th>商户名称</th>
									<th>联系方式</th>
									<th>类别</th>
									<th>备注</th>
									<th>评分</th>
									<th>团购</th>
									<th>促销</th>
									<th>定</th>
									<th>排</th>
									<th>地址</th>
									<th>销量</th>
									<th><i class="icon-time hidden-phone"></i>创建日期</th>
								</tr>
							</thead>

							<tbody>

								<!-- 开始循环 -->
								<c:choose>
									<c:when test="${not empty businessManList}">
										<c:if test="${QX.cha == 1 }">
											<c:forEach items="${businessManList}" var="businessMan"
												varStatus="vs">

												<tr>
													<td class='center' style="width: 30px;"><label><input
															type='checkbox' name='ids' /><span class="lbl"></span></label></td>
													<td class='center' style="width: 30px;">${vs.index+1}</td>
													<td>${businessMan.name }</td>
													<td>${businessMan.phone }</td>
													<td>${businessMan.type_id }</td>
													<td>${businessMan.remark }</td>
													<td>${businessMan.grade }</td>
													<td><c:choose>
															<c:when test="${businessMan.tuan_flag}">是</c:when>
															<c:otherwise>
															否
														</c:otherwise>
														</c:choose></td>
													<td><c:choose>
															<c:when test="${businessMan.cu_flag}">是</c:when>
															<c:otherwise>
															否
														</c:otherwise>
														</c:choose></td>
													<td><c:choose>
															<c:when test="${businessMan.ding_flag}">是</c:when>
															<c:otherwise>
															否
														</c:otherwise>
														</c:choose></td>
													<td><c:choose>
															<c:when test="${businessMan.pai_flag}">是</c:when>
															<c:otherwise>
															否
														</c:otherwise>
														</c:choose></td>
													<td>${businessMan.address }</td>
													<td>${businessMan.sales_count }</td>
													<td>${businessMan.created_date }</td>
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
	<script type="text/javascript" src="static/js/bootbox.min.js"></script>
	<!-- 确认窗口 -->
	<!-- 引入 -->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>

	<script type="text/javascript">
		$(function() {
			$(top.hangge());

			//下拉框
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


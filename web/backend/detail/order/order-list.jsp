<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>餐馆王平台</title>


	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="${ctx}/style/js/jquery.js"></script>
	<script type="text/javascript" src="${ctx}/style/js/page_common.js"></script>
	<link href="${ctx}/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${ctx}/style/css/index_1.css" />
	<script type="text/javascript">
		setInterval(function(){
			// window.location.href = "/wirelessplatform/client.html?method=list";
			window.location.href = "/order?method=findAll";
		},1000 * 50);
	</script>
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="../style/images/title_arrow.gif" /> 餐厅订单列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>订单编号</td>
					<td>餐桌名</td>
					<td>下单日期</td>
					<td>总金额</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
			<c:forEach items="${orders}" var="order" varStatus="vs">

				<tr height="60">
					<td>${order.id}</td>
					<c:forEach items="${tables}" var="table" varStatus="vs">
						<c:if test="${order.tableId == table.id }">
							<td>${table.tableName}</td>
						</c:if>




					</c:forEach>
					<td>${order.createTime}</td>
					<td>${order.totalPrice/100}</td>

					<c:if test="${order.payStatus == 0}">
						<td>未结账&nbsp;&nbsp;&nbsp;</td>
					</c:if>

					<c:if test="${order.payStatus == 1}">
						<td>已支付&nbsp;&nbsp;&nbsp;</td>
					</c:if>

					<c:if test="${order.payStatus == 2}">
						<td>已取消&nbsp;&nbsp;&nbsp;</td>
					</c:if>




					<td>
						<a href="/orderdetail?method=findOrderDetailAll&orderId=${order.id}" class="FunctionButton">详细</a>

						<a href="orderdetail?method=payMoney&orderId=${order.id}" class="FunctionButton">结账</a>

					</td>
				</tr>
			</c:forEach>

			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
		</div>
	</div>
</body>
</html>

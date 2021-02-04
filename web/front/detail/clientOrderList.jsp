<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../ctx.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="style/css/index.css" />
	<script type="text/javascript">
		// 通知服务员结账
		function pay(orderId, money) {
			alert('尊敬的顾客,您好!已经通知服务员结账，请稍等!');
			location.href = "/pay?method=payMoney&orderId=" + orderId + "&money=" + money;
		}
	</script>
</head>

<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 餐车div -->
			<div id="count">
				<table align="center" width="100%">
					<tr height="40">
				 		<td align="center" width="20%">菜名</td>
				 		<td align="center" width="20%">单价</td>
				 		<td align="center" width="20%">数量</td>
				 		<td align="center" width="20%">小计</td>
				 	</tr>
					
				<c:forEach items="${sessionScope.order_detail_list}" var="orderDetail">
					<tr height="60">
					 		<td align="center" width="20%">${orderDetail.foodName}</td>
					 		<td align="center" width="20%">￥${orderDetail.price/100}</td>
					 		<td align="center" width="20%">${orderDetail.num}</td>
					 		<td align="center" width="20%">${orderDetail.totalPrice/100.0}</td>
					</tr>
				</c:forEach>

					<tr>
						<td colspan="6" align="right">总计:
							<span style="font-size:36px;">&yen;</span>
							<label
								id="counter" style="font-size:36px">${sessionScope.order_total_price/100.0}</label>
						</td>
					</tr>
					<tr>
						<td colspan="6" style="margin-left: 100px; text-align: center;"align="right">
							<input type="hidden" name="bId" value="">
							<input type="button" value="结账" class="btn_next" lang="" onclick="pay(${sessionScope.orderId}, ${sessionScope.order_total_price})" />
						</td>
					</tr>
				</table>
			</div>
		</div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
					<li class="dish_num"></li>
					<li>
						<a href="clientOrderList.jsp">

							<img src="style/images/call2.gif" />
						</a>
					</li>
				</ul>
			</div>

			<div id="dish_2">
				<ul>

					<c:forEach items="${sessionScope.front_types}" var="type">
						<li>
							<a href="/front?method=findFoodByPage&typeId=${type.typeId}">${type.typeName}</a>
						</li>
					</c:forEach>
					
				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="/front?method=findFoodByPage" method="post">
					<table width="166px">
						<tr>
							<td>
								<span style="font-size: 20px">菜品名称:</span><input type="text" value="${foodName}" id="dish_name" name="foodName" class="select_value"/>
								<%--<input type="hidden" value="selectFood" name="method">--%>
							</td>
						</tr>
						<tr>
							<td><input type="submit" id="sub" value="" /></td>
						</tr>
						<tr>
							<td>
								<a href="/front?method=findFoodByPage">
									<img src="${ctx}/detail/style/images/look.gif" />
								</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>

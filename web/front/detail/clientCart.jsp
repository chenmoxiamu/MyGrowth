<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../ctx.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${ctx}/detail/style/css/index.css" />
	<script src="${ctx}/detail/style/js/jquery.js"></script>
	<script type="text/javascript">
		/** // 删除菜品项
		function removeSorder(node) {
			var gid = node.lang;
			window.location.href = "/wirelessplatform/sorder.html?method=removeSorder&gid="+gid;
		}
		
		// 修改菜品项数量
		function alterSorder(node) {
			var snumber = node.value;
			var gid = node.lang;
			window.location.href = "/wirelessplatform/sorder.html?method=alterSorder&gid="+gid+"&snumber="+snumber;
		}
		*/
		// 下单
		function genernateOrder() {
			window.location.href = "clientOrderList.jsp";
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
				 		<td align="center" width="20%">操作</td>
				 	</tr>
					<!-- 输出餐车项-->
					<c:forEach items="${sessionScope.front_cart}" var="cartItem">
					<tr height="60">
					 		<td align="center" width="20%">${cartItem.foodName}</td>
					 		<td align="center" width="20%">￥${cartItem.price/100.0}</td>
					 		<td align="center" width="20%">
					 			<input type="text" value="${cartItem.num}" size="3" lang="3" onblur="alterSorder(this)"/>
					 		</td>
					 		<td align="center" width="20%">${cartItem.totalPrice/100.0}</td>
					 		<td align="center" width="20%">
								<%--这个this就是前这条记录，也就是餐车项--%>
					 			<input type="button" value="删除" class="btn_next" lang="3" onclick="deleteCartItem(this, ${cartItem.foodId})" />
					 		</td>
				 	</tr>
					</c:forEach>
					<tr>
						<td colspan="6" align="right">总计:
							<span style="font-size:36px;">&yen;
								<span id="totalPrice" style="font-size:36px;">${sessionScope.cart_total_price/100.0}</span>
							</span>
							<label
								id="counter" style="font-size:36px"></label>
						</td>
					</tr>
					<tr>
						<td colspan="6" style="margin-left: 100px; text-align: center;"align="right">
							<input type="hidden" name="bId" value="">
							
									<input type="button" value="下单" class="btn_next" onclick="generatorOrder()" />
								
							
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
						<a href="clientOrderList.html">
							<img src="${ctx}/detail/style/images/call2.gif" />
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

<script>
	//删除餐车项
	function deleteCartItem(obj, foodId) {
		console.log(obj);
		var url = "/foodcart?method=deleteByFoodId&foodId=" + foodId;
		$.get(url, null, function (result) {
			if(result.success) {
				//修改总价
				$("#totalPrice").text(result.tprice /100.0);
				//删除当前行
				$(obj).parent().parent().remove();
			} else {
				alert("删除失败");
			}
		}, "json");
	}





	//创建订单
	function generatorOrder() {

		location.href = "/order?method=generatorOrder";
	}
</script>


</html>

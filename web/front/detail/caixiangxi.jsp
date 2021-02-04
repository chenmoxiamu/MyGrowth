<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../ctx.jsp"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>餐馆王平台</title>


	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="${ctx}/detail/style/js/jquery.js"></script>
	<script type="text/javascript" src="${ctx}/detail/style/js/page_common.js"></script>
	<link href="${ctx}/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${ctx}/detail/style/css/index_1.css" />
	<link href="${ctx}/detail/style/css/index.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/detail/style/css/dis_message.css" />
</head>
<body style="text-align: center">
	<div id="all">
		<!--左边菜品详细信息 -->
		<div id="menu1">
			<div class="menu2" style="text-align:center;">
				<img src="${ctx}/detail/style/images/order_detials_bg.png" />
			</div>
			<div class="menu3">
				<div class="menu3_left">
					<img src="${pageContext.request.contextPath}${food.image}"
						style="width:270px; height:290px;" />
				</div>
				<div class="menu3_right">
					<p>菜名:${food.foodName}</p>
					<p>价格:&nbsp;&nbsp;&yen;&nbsp;${food.price/100.0}</p>
					<p style="font-size: 25px">简介: ${food.foodDesc}</p>
				</div>
			</div>
			<div class="menu4">
				
				<a href="/foodcart?method=add&foodId=${food.foodId}&num=1" style="background:url(${ctx}/detail/style/images/img/order_left_corner_bg.png);">放入餐车</a>
				<a href="#" onclick="javascript:history.go(-1);" style="background:url(${ctx}/detail/style/images/img/order_right_corner_bg.png);">返回</a>
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
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../ctx.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>餐馆王平台</title>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="${ctx}/detail/style/js/jquery.js"></script>
	<script type="text/javascript" src="${ctx}/detail/style/js/page_common.js"></script>
	<link href="${ctx}/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${ctx}/detail/style/css/index_1.css" />
	<link href="${ctx}/detail/style/css/index.css" rel="stylesheet" type="text/css" />
	<style>
		.food-page{
			cursor: pointer;
		}
	</style>
</head>
<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 显示菜品的div -->
			<div id="top">
				<ul>
					<!-- 循环列出餐品 -->
					<c:forEach items="${pageBean.list}" var="food">
						<%--点击菜品项到菜品详情--%>
						<li onclick="toFoodDetail(${food.foodId});">
							<dl>
								<dt>
									<img width="214px" height="145px" src="${pageContext.request.contextPath}${food.image}" />

								</dt>
								<dd class="f1">
									<span style="font-size: 15px">${food.foodName}</span>
								</dd>
								<dd class="f2">
									<span style="font-size: 15px"><b>&yen;</b>${food.price/100.0}</span>
								</dd>
							</dl>
						</li>
					</c:forEach>
				</ul>
			</div>
			
			<!-- 底部分页导航条div -->
			<div id="foot">
				<%-- 上一页 --%>
						<span
							style="float:left; line-height:53PX; margin-left:-50px; font-weight:bold; ">
							<span class="food-page" onclick="prev(${pageBean.pageNo});">&lt;&lt;</span>
						</span>
					
				
				<div id="btn">
					<ul>
						<!-- 参看 百度, 谷歌是 左 5 右 4 -->
						<c:forEach var="page" begin="1" end="${pageBean.totalPages}">
							<li >
								<%--如果当前页等于pageBean中的pageNo标签变蓝--%>
								<a <c:if test="${page == pageBean.pageNo}">style='color:blue;'</c:if>
								   href="/front?method=findFoodByPage&pageNo=${page}" >${page}
								</a>
							</li>
						</c:forEach>
					</ul>
				</div>
					<%-- 下一页 --%>
						<span style="float:right; line-height:53px; margin-right:10px; font-weight:bold; ">
							<span class="food-page" onclick="next(${pageBean.pageNo});">&gt;&gt;</span>
						</span>
				
			</div>
			
		</div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
				<li class="dish_num"></li>
					<li>
						<a href="/order?method=clientOrderList.jsp">
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
									<%--查看菜单按钮--%>
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
	//上一页
	function prev(pageNo) {
		if(pageNo > 1) {
			location.href = "/front?method=findFoodByPage&pageNo=" + (pageNo-1);
		}
	}

	//下一页
	function next(pageNo) {
		if(pageNo < ${pageBean.totalPages}) {
			location.href = "/front?method=findFoodByPage&pageNo=" + (pageNo+1);
		}
	}

	function toFoodDetail(id) {
		location.href = "/front?method=findFoodById&foodId=" + id;
	}

</script>

</html>

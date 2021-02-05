<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
 	<!-- 包含公共的JSP代码片段 -->
	
<title>餐馆王平台</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="${ctx}/style/js/jquery.js"></script>
	<script type="text/javascript" src="${ctx}/style/js/page_common.js"></script>
	<link href="${ctx}/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${ctx}/style/css/index_1.css" />

</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 餐桌列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
	<form action="/table?method=search" method="get">
		<input type="hidden" name="method" value="search">
		&nbsp;&nbsp;桌名：<input type="text" name="keyword" placeholder="请输入餐桌名称"  title="请输入餐桌名称">
		<input type="submit" value="搜索">
	</form>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>编号</td>
				<td>桌名</td>
				<td>状态</td>
				<td>预定时间</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
<%--		<tbody id="TableData" align="center">--%>
<%--		<c:forEach items="${types}" var="type" varStatus="vs">--%>
<%--			<tr>--%>
<%--				<td>${vs.index + 1}</td>--%>
<%--				<td>${type.typeName}</td>--%>
<%--				<td>--%>
<%--					<a href="/foodtype?method=findById&id=${type.typeId}" class="FunctionButton">更新</a>--%>
<%--					<a href="/foodtype?method=delete&id=${type.typeId}" class="FunctionButton" onclick="return delConfirm(${type.typeId});">删除</a>--%>
<%--				</td>--%>
<%--			</tr>--%>
<%--		</c:forEach>--%>
<%--		</tbody>--%>
<%--        <tbody id="TableData">--%>
		<tbody>
		<c:forEach items="${tables}" var="table" varStatus="vs">
			<tr>
				<!--编号-->
				<td align="center">${vs.index+1}</td>
				<!--桌名-->
				<td align="center"> ${table.tableName}</td>
				<!--订单状态-->
				<td align="center">
					<c:if test="${table.status eq '0'}">空闲</c:if>
					<c:if test="${table.status eq '1'}">预订</c:if>
			    </td>
				<!--预订时间-->
				<td align="center">
					<c:if test="${empty table.reservationTime}"></c:if>
					<c:if test="${not empty table.reservationTime}">
						${table.reservationTime}
					</c:if>
				</td>
				<!--操作-->
				<td align="center">
					<c:if test="${table.status eq '1'}">
						<a href="/table?method=reservetables&id=${table.id}&status=1" class="FunctionButton">退桌</a>
					</c:if>
					<c:if test="${table.status eq '0'}">
						<a href="/table?method=reservetables&id=${table.id}&status=0" class="FunctionButton">预订</a>
					</c:if>
					<c:if test="${table.status eq '1'}">
<%--						<a href="#" onClick="return delConfirm();"class="FunctionButton">不可删除</a>--%>
					</c:if>
					<c:if test="${table.status eq '0'}">
						<a href="/table?method=deleteTable&id=${table.id}" onClick="return delConfirm();"class="FunctionButton">删除</a>
					</c:if>

				</td>
			</tr>
		</c:forEach>
        </tbody>

    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="${ctx}/table/table-save.jsp">添加</a></div>

    </div> 
</div>
</body>
</html>

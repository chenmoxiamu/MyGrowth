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

</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 菜品列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="/food?method?search" method="get">
			<input type="hidden" name="method" value="search">
			&nbsp;&nbsp;菜品名称:<input type="text" name="keyword" placeholder="请输入菜品名称" title="请输入菜品名称">
			<input type="submit" value="搜索">
		</form>
	</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>菜编号</td>
				<td>菜名</td>
				<td>所属菜系</td>
				<td>价格</td>
                <td>会员价格</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">

			<c:forEach items="${foods}" var="food" varStatus="vs">
				<tr class="TableDetail1">
					<td>${vs.index+1}</td>
					<td>${food.foodName}</td>
				<c:forEach items="${types}" var="type">
					<c:if test="${food.typeId == type.typeId}">

						<td>${type.typeName}</td>
					</c:if>
				</c:forEach>

					<td>${food.price/100}</td>
					<td>${food.vipPrice/100}</td>
					<td>
						<a href="/food?method=findById&id=${food.foodId}"  class="FunctionButton">更新</a>
						<a  href="/food?method=deleteFood&id=${food.foodId}" onClick="return delConfirm();"class="FunctionButton">删除</a>
					</td>
				</tr>


			</c:forEach>

        
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="/food?method=saveui">添加</a></div>
    </div> 
</div>

</body>
</html>

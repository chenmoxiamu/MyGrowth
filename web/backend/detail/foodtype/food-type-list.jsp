<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
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
		$(function(){
			//onMouseOver ：当鼠标悬浮时触发
			$("#delBtn").onMouseOver(function(){
				$.get("/foodtype?method=findFoodIsExist&typeId="+this.value,null,function(data){
					if (data==1){
						$("#delMsg").html("该菜系下仍有菜品，请先清空该菜系下的菜品").css("color","red");
						$("#delBtn").attr("disabled",true);
					}else {
						$("#delBtn").removeAttr("disabled");
					}
				})
			});

		});
	</script>
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${ctx}/style/images/title_arrow.gif" /> 菜系列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="/foodtype" method="post">
			<input type="hidden" name="method" value="search">
			&nbsp;&nbsp;菜类别名称: <input type="text" name="keyword" value="${keyword}" placeholder="请输入菜类别名称" title="请输入菜类别名称">
			<input type="submit" value="搜索">
		</form>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>菜类别编号</td>
					<td>菜类别名称</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData" align="center">
				<c:forEach items="${types}" var="type" varStatus="vs">
					<tr>
						<td>${vs.index + 1}</td>
						<td>${type.typeName}</td>
						<td>
							<a href="/foodtype?method=findById&id=${type.typeId}" class="FunctionButton">更新</a>


							<a id="delBtn" href="/foodtype?method=delete&id=${type.typeId}" class="FunctionButton" onclick="return delConfirm(${type.typeId});">删除</a>
							<span id="delMsg"></span>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="${ctx}/foodtype/food-type-save.jsp">添加</a>
			</div>
		</div>
	</div>

</body>
</html>

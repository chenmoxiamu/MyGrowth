﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
		$(function(){
			$("#newFoodTypeName").change(function(){
				$.get("/foodtype?method=checkFoodTypeName&newFoodTypeName="+this.value,null,function(data){
					if (data==1){
						$("#foodTypeMsg").html("该菜系名已存在").css("color","red");
						$("#addBtn").attr("disabled",true);
					}else{
						$("#foodTypeMsg").html("该菜系名可用").css("color","green");
						$("#addBtn").removeAttr("disabled");
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

			<img border="0" width="13" height="13" src="${ctx}/style/images/title_arrow.gif"/>  添加菜类别

		</div>
	</div>
	<div id="TitleArea_End"></div>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="/foodtype" method="post">
		<input type="hidden" name="method" value="save">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
			<img width="4" height="7" border="0" src="${ctx}/style/images/item_point.gif"> 菜类别信息&nbsp;
		</div>
		<!-- 本段表单字段 -->
		<div class="ItemBlockBorder">
			<div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<tr>
							<td width="80px">菜类别名称</td>
							<td>
								<input id="newFoodTypeName" type="text" name="foodName" class="InputStyle" value=""/> *
								<label id="foodTypeMsg"></label>
								<input type="hidden" name="cid" value="" />

							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<!-- 表单操作 -->
		<div id="InputDetailBar">

			<input id="addBtn" type="submit" value="添加" class="FunctionButtonInput">

			<a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
		</div>
	</form>

</div>




</body>
</html>

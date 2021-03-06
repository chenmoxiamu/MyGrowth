﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
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
	function openWin(){
		window.open('common_page_list.html');
		this.close();
	}
	</script>

	<script type="text/javascript">
		$(function(){
			$("#newTableName").change(function(){
				$.get("/table?method=checkTableName&newTableName="+this.value,null,function(data){
					if (data==1){
						$("#tableMsg").html("桌名已存在").css("color","red");
						$("#addBtn").attr("disabled",true);
					}else{
						$("#tableMsg").html("桌名可用").css("color","green");
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
			<img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/>  添加新桌
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="/table?method=saveTable" method="post">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="../style/images/item_point.gif"> 新桌信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<tr>
							<td width="80px">新桌名字</td>
							<td><input id="newTableName" type="text" name="newTableName" class="InputStyle"/>*<p><span id="tableMsg"></span></p></td>

						</tr>
					</table>
				</div>
            </div>
        </div>
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
            <input type="submit" id="addBtn" value="添加" class="FunctionButtonInput">
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
	
</div>

</body>
</html>

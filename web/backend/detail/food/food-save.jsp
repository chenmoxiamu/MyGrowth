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
			
				
				
					<img border="0" width="13" height="13" src="${ctx}/style/images/title_arrow.gif"/> 添加新菜品
				
			
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="/food" method="post" enctype="multipart/form-data"><%-- enctype="multipart/form-data" --%>
		<input name="method" type="hidden" value="save"/>
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="${ctx}/style/images/item_point.gif"> 菜品信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
							<td width="80px">菜系</td>
							<td>
                            <select name="typeId" style="width:80px">
								<%-- 展示菜类别列表
								 	传到后的值是 typeId
								 	显示的值是 typeName
								 --%>
								<c:forEach items="${types}" var="type">
			   						<option value="${type.typeId}">${type.typeName}</option>
								</c:forEach>
                            </select>
                             *</td>
						</tr>
						<tr>
							<td width="80px">菜名</td>
							<td><input type="text" name="foodName" class="InputStyle" value=""/> *</td>
						</tr>
						<tr>
							<td>价格</td>
							<td><input type="text" name="price" class="InputStyle" value=""/> *</td>
						</tr>
                        <tr>
							<td>会员价格</td>
							<td><input type="text" name="vipPrice" class="InputStyle" value=""/> *</td>
						</tr>
						
						<tr>
							<td>简介</td>
							<td><textarea name="foodDesc" class="TextareaStyle"></textarea></td>
						</tr>
						<tr>
							<td width="80px">菜品图片</td>
							<td>
								<input type="file" name="image"/> *
							</td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
            
				
				
					 <input type="submit" value="添加" class="FunctionButtonInput">
				
			
            
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
</div>
</body>
<script>
	function upload(){
		$.ajax({
			type: "post",
			contentType : "multipart/form-data",
			data : { imageUrl : $("#imageUrl").val()},
			url : "/test",
			success : function (data) {

			}
		});
	}
</script>
</html>

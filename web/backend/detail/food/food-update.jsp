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
			
				
					<img border="0" width="13" height="13" src="${ctx}/style/images/title_arrow.gif"/> 更新新菜品
				
				
			
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="/food?method=update" method="post" enctype="multipart/form-data">
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
									<%--如果遍历的菜系名为根据回显的菜系名则选中--%>
										<option value="${type.typeId}"
											<c:if test="${type.typeId == food.typeId}">selected</c:if>
										>${type.typeName}</option>
									</c:forEach>
								</select>
								<%--隐藏域，用于传递值--%>
                             *<input type="hidden" name="foodId" value="${food.foodId}" /></td>
						</tr>
						<tr>
							<td width="80px">菜名</td>
							<td><input type="text" name="foodName" class="InputStyle" value="${food.foodName}"/> *</td>
						</tr>
						<tr>
							<td>价格</td>
							<td><input type="text" name="price" class="InputStyle" value="${food.price}"/> *</td>
						</tr>
                        <tr>
							<td>会员价格</td>
							<td><input type="text" name="mprice" class="InputStyle" value="${food.vipPrice}"/> *</td>
						</tr>
						
						<tr>
							<td>简介</td>
							<td><textarea name="introduce" class="TextareaStyle">${food.foodDesc}</textarea></td>
						</tr>
						<tr>
							<td width="80px">菜品图片</td>
							<td>
								<%-- 项目虚拟路径 + 图片地址  -- 可以展示该图片 --%>
									<img src="${pageContext.request.contextPath}${food.image}"
										 style='max-width:68px;width:68px;width:expression(width>68?"68px":width "px");max-width: 68px;'>

									<input type="hidden" name="img" value="${food.image}"/>

									<input type="file" name="image" value="${food.image}"/> *
							</td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
            
				
					 <input type="submit" value="修改" class="FunctionButtonInput">

            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>


	<%--22:<img src="${pageContext.request.contextPath}${food.image}" ><br>--%>

    <%--<img src="https://test-guohuanyang.oss-cn-hangzhou.aliyuncs.com/2d00ad63a6b14ee0a56ff1bbd61d4815.jpg" alt="">--%>

</div>

</body>
</html>

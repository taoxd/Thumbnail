<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body>
	<div class="demo">
		<div class="bheader">
			<h2>--图片上传--</h2>
		</div>
		<div class="bbody">
			<form id="upload_form" enctype="multipart/form-data" method="post"
				action="<%=basePath%>upAction/up">
				<h2>请上传图片</h2>
				<div>
					<input type="file" name="image" id="image">
					<input type="submit" value="上传">
				</div>
			</form>
		</div>
	</div>
	<div>
		<%=path%>
	</div>
	<div>
		<%=basePath%>
	</div>
</body>
</html>
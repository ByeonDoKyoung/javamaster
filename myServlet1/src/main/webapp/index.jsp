<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir = "/WEB-INF/tags" prefix = "my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Expression Language -->
	<p>${'maeng' == 'maeng' ? true : false}</p>
	<a href = "main.do">메인컨트롤 이동</a>
	<!--<jsp:forward page = "main.do"></jsp:forward> -->
	<my:lines/>
</body>
</html>
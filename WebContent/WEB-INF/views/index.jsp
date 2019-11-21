<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// ContextPath가 "/"이 아니라 "/board"일 경우
String rPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<a style="text-decoration:none" href="${rootPath}/views/user/userList">User List 가기</a><br>
	<a style="text-decoration:none" href="${rootPath}/views/file/fileList">File List 가기</a><br>
	<a style="text-decoration:none" href="${rootPath}/views/photo/list">Photo Board 보기</a><br>

<%-- 	rootPath: ${rootPath}<br> --%>
<%-- 	jsPath: ${jsPath}<br> --%>
<%-- 	cssPath: ${cssPath}<br> --%>
</body>
</html>
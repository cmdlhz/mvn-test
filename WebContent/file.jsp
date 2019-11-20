<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
<form method="POST" action="/file" enctype="multipart/form-data">
	File : <input type="file" name="f1"><br><br>
	ID : <input type="text" name="id"><br><br>
	<button type="button" class="btn btn-outline-success">파일 전송</button>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Final <%= request.getParameter("a") %></h4>
	<ul>
		<c:forEach items="${list}" var="name">
			<li>${name}</li>
		</c:forEach>
	</ul>
</body>
</body>
</html>

<!-- http://localhost/views/source?a=1&a=2&a=3 -->
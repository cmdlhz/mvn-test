<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET form</title>
</head>
<body>
<!-- form tag에 method 없으면 get 방식 -->
<!-- form tag의 단점 : 화면이 바뀜 -->
<form action="/getForm">
	<input type="text" name="name"></input>
	<button>SEND</button>
</form>
</body>
</html>
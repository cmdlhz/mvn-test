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
<!-- get은 바디 영역이 없음. URL에 담기는데. URL 길이 제한 때문에 반드시 POST로 보내야 함 -->
<!-- enctype="multipart/form-data" 이거여야 함! -->
<form method="POST" action="/file" enctype="multipart/form-data">
	File : <input type="file" name="f1"><br><br>
	ID : <input type="text" name="id"><br><br>
	<button>파일 전송</button> <!-- default일 때만 submit 역할을 함 / type을 "button"으로 줘야함 -->
</form>
</body>
</html>
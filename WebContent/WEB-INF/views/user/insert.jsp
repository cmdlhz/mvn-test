<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<h3 align="center"><b>게시물 작성</b></h3>
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<td><input type="text" id="uiId" placeholder="Enter your ID."></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="uiName" placeholder="Enter your name."></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="text" id="uiPwd" placeholder="Enter password."></td>
			</tr>
			<tr>
				<th>Password Check</th>
				<td><input type="text" id="uiPwdCheck" placeholder="Enter password again."></td>
			</tr>
			<tr>
				<th colspan="2"><button type="button" class="btn btn-outline-success" onclick="save()">저장</button></th>
			</tr>
		</table>
	</div>
<button type="button" class="btn btn-outline-primary" onclick="goPage('/user/userList')">목록</button>
<script>
function save(){
	var uiId = document.getElementById("uiId");
	var uiName = document.getElementById("uiName");
	var uiPwd = document.getElementById("uiPwd");
	var uiPwdCheck = document.getElementById("uiPwdCheck");

	if(uiId.value.trim().length < 2){
		alert("An ID should contain more than 2 characters.");
		uiId.value = "";
		uiId.focus();
		return false;
	}
	if(uiName.value.trim().length < 2){
		alert("A name should contain more than 2 characters.");
		uiName.value = "";
		uiName.focus();
		return false;
	}
	if(uiPwd.value.trim().length < 5){
		alert("A password should contain more than 5 characters.");
		uiPwd.value = "";
		uiPwd.focus();
		return false;
	}
	if(uiPwd.value != uiPwdCheck.value){
		alert("Passwords do NOT match!");
		uiPwdCheck.value = "";
		uiPwdCheck.focus();
		return false;
	}
	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/views/user/insert');
	xhr.setRequestHeader('Content-Type', 'application/json');
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = JSON.parse(xhr.responseText);
			// ???????
		}
	}
	return true;
}
</script>
</body>
</html>
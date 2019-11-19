<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>

</head>
<body>
${param.uiNum}
	<div class="container">
		<h3 align="center"><b>User Info</b></h3>
		<table class="table table-bordered">
			<tr>
				<th>이름</th>
				<td data-id="uiName"></td>
			</tr>
			<tr>
				<th>ID</th>
				<td data-id="uiId"></td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="button" class="btn btn-outline-success" onclick="update()">Update</button>
					<button type="button" class="btn btn-outline-danger" onclick="update()">Delete</button>
					<button type="button" class="btn btn-outline-primary" onclick="goPage('/user/userList')">목록</button>
				</th>
			</tr>
		</table>
	</div>
<script>
var user;

window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/user/view?uiNum=${param.uiNum}');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			user = JSON.parse(xhr.responseText);
			var tds = document.querySelectorAll('td[data-id]');
			
			for (var i = 0; i < tds.length; i++) {
			    console.log("tds[i] : " + tds[i]);
			    
			    var td = tds[i];
			    var key = td.getAttribute('data-id');
			    
			    console.log("key : " + key);
			    td.innerHTML = user[key];

				console.log(xhr.responseText);
			}
		}
	}
	xhr.send();
}
function delete(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/user/delete');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			user = JSON.parse(xhr.responseText);
			alert(res.msg);
			if(res.result == 'true'){
				goPage('user/userList');
			}
		}
	}
	var param = {
		uiNum : user.uiNum
	}
	xhr.send(JSON.stringify(user));
	
}
</script>
</body>
</html>
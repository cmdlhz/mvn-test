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
	<div class="container">
		<h3 class="display-3" align="center">User Info</h3>
		<table class="table table-bordered">
			<tr>
				<th>#</th>
				<td data-id="uiNum"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td data-id="uiName"></td>
			</tr>
			<tr>
				<th>ID</th>
				<td data-id="uiId"></td>
			</tr>
			<tr>
				<th>Active</th>
				<td data-id="active"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" class="btn btn-outline-warning" onclick="editable(this)">editable</button>
					<button type="button" class="btn btn-outline-success" onclick="updateUser()">Update</button>
					<button type="button" class="btn btn-outline-danger" onclick="deleteUser()">Delete</button>
					<button type="button" class="btn btn-outline-primary" onclick="goPage('/user/userList')">목록</button>
				</td>
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
// 			console.log("** xhr.responseText **  :  " + xhr.responseText);
			
			user = JSON.parse(xhr.responseText);
// 		    console.log("** user **  :" + user);
			
			var tds = document.querySelectorAll('td[data-id]');
			
			for (var i = 0; i < tds.length; i++) {			    
			    var td = tds[i];
			    var key = td.getAttribute('data-id');
// 			    console.log("key : " + key);
			    td.innerHTML = user[key];
			}
		}
	}
	xhr.send();
}

function editable(btn){
	var tds = document.querySelectorAll('td[data-id=active], td[data-id=uiName]');
	for(var i=0; i<tds.length; i++){
		var td = tds[i];
		var id = td.getAttribute('data-id');
		td.innerHTML = '<input type="text" id="' + id + '" value ="' + user[id] + '">';
	}
}

// 버튼을 2개 만들어서 조건에 따라 보이게, 안 보이게 하는 것이 나음
function updateUser(){
	console.log("update btn : activated");
	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/user/update');
	xhr.onreadystatechange = function(){
// 		console.log("xhr.readystate : " + xhr.readystate);
// 		console.log("xhr.status : " + xhr.status);
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("xhr.responseText : " + xhr.responseText);
			var res = JSON.parse(xhr.responseText);
			alert(res.msg);
			if(res.result == 'true'){
				goPage('/user/userList');
			}
		}
	}
	var param = {
		uiNum : user.uiNum,
		uiName : document.querySelector('#uiName').value,
		active : document.querySelector('#active').value
	}
	xhr.send(JSON.stringify(param));
}

function deleteUser(){
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/user/delete');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
// 			console.log("xhr.readystate : " + xhr.readyState);
// 			console.log("xhr.status : " + xhr.status);
			console.log("xhr.responseText : " + xhr.responseText);
			var res = JSON.parse(xhr.responseText);
			alert(res.msg);
			if(res.result == 'true'){
				goPage('/user/userList');
			}
		}
	}
	var param = {
		uiNum : user.uiNum
	}
	xhr.send(JSON.stringify(param));
	
}
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
<div class="container">
	<h1 class="display-3" align="center">User List</h1>
	<table class="table table-bordered">
	 <thead class="thead-dark">
	    <tr>
	      <th scope="col">ID</th>
	      <th scope="col">이름</th>
	      <th scope="col">작성일</th>
	      <th scope="col">작성시간</th>
	    </tr>
	  </thead>
	  <tbody id="tBody">
	  	<tr>
	  	  <td colspan="5" align="center">내용 없음</td>
	  	</tr>
	  </tbody>
	  <tbody>
	  	<tr>
	  		<td colspan="5" align="center"><button type="button" class="btn btn-outline-primary" onclick="goPage('/user/insert')">Sign Up</button></td>
	  	</tr>
	  </tbody>
	</table>
</div>
<!-- goPage(url) @ bt>js>common.js : location.href = '/views' + url; -->
</body>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/user/list');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == xhr.DONE){
// 			console.log(xhr.readyState);
			 if(xhr.status == 200){
// 				 	console.log(xhr.status);
// 				 	console.log(xhr.responseText);
				 	
					var userList = JSON.parse(xhr.responseText);
					var tBody = document.getElementById('tBody');
					var html = '';
					for(var user of userList){
						html += '<tr>';
						html += '<td onclick="goPage(\'/user/view?uiNum=' + user.uiNum + '\')">' + user.uiId + '</td>';
						html += '<td>' + user.uiName + '</td>';
						html += '<td>' + user.credat + '</td>';
						html += '<td>' + user.cretim + '</td>';
						html += '</tr>';
					}
					tBody.innerHTML = html;
				}
		}
	}
	xhr.send();
}
</script>
</html>
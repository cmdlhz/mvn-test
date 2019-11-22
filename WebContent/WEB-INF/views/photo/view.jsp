<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
<div class="container text-center">
	<h1 class="display-3" align="center">View</h1>
	<table class="table table-bordered">
		<thead class="thead-dark">
			<tr>
				<th style="width:10%">#</th>
				<td data-id="pbNum">#</td>
			</tr>
			<tr>
		      	<th style="width:10%">Title</th>
		      	<td data-id="pbTitle">Title</td>
			</tr>
			<tr>
				<th style="width:10%">Content</th>
				<td data-id="pbContent">Content</td>
			</tr>
			<tr>
				<th style="width:10%">Img 1</th>
				<td data-id="pbImg1">Img 1</td>
			</tr>
			<tr>
				<th style="width:10%">Img 2</th>
				<td data-id="pbImg2">Img 2</td>
			</tr>
			<tr>
				<th style="width:10%">Views</th>
				<td data-id="pbCnt">Views</td>
			</tr>
		</thead>
		<tbody>
	  		<tr>
	  			<td colspan="12" align="center">
					<button type="button" class="btn btn-outline-success" onclick="goPage('/photo/update')">Update</button>
					<button type="button" class="btn btn-outline-danger" onclick="goPage('/photo/delete')">Delete</button>
	  				<button type="button" class="btn btn-outline-primary" onclick="goPage('/photo/list')">LIST</button>
	  			</td>
	  		</tr>
	  </tbody>
	</table>
</div>
<script>
var post;

window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/photo/view?pbNum=${param.pbNum}');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			post = JSON.parse(xhr.responseText);
			var tds = document.querySelectorAll('td[data-id]');
			for(var i=0; i<tds.length; i++){
				var td = tds[i];
				var key = td.getAttribute('data-id');
				console.log("key : " + key);
				td.innerHTML = post[key];
			}
		}
	}
	xhr.send();
}
</script>
</body>
</html>






















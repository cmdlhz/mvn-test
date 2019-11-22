<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Photo Board</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
<div class="container text-center" >
	<h1 class="display-3" align="center">Photo Board</h1>
	<table class="table table-bordered">
	 <thead class="thead-dark">
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Title</th>
	      <th scope="col">Content</th>
	      <th scope="col">Img 1</th>
	      <th scope="col">Img 2</th>
	      <th scope="col">credat</th>
	      <th scope="col">cretim</th>
	      <th scope="col">creusr</th>
	      <th scope="col">moddat</th>
	      <th scope="col">modtim</th>
	      <th scope="col">modusr</th>
	      <th scope="col">Views</th>
	    </tr>
	  </thead>
	  <tbody id="tBody">
	  	<tr>
	  	  <td colspan="12" align="center">내용 없음</td>
	  	</tr>
	  </tbody>
	  <tbody>
	  	<tr>
	  		<td colspan="12" align="center">
	  			<button type="button" class="btn btn-outline-primary" onclick="goPage('/photo/insert')">ADD</button>
	  			<button type="button" class="btn btn-outline-dark" onclick="location.href='http://localhost'">INDEX</button>
	  		</td>
	  	</tr>
	  </tbody>
	</table>
</div>
</body>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/photo/list');
	
	xhr.onreadystatechange = function(){
// 		console.log("xhr.readyState : " + xhr.readyState);
// 	 	console.log("xhr.status : " + xhr.status);
	 	
		if(xhr.readyState == xhr.DONE && xhr.status == 200){
		 	
			var photoList = JSON.parse(xhr.responseText);
			console.log("xhr.responseText : " + xhr.responseText);
			var tBody = document.getElementById('tBody');
			console.log("tBody : " + tBody);
			var html = '';
			for(var photo of photoList){
				html += '<tr>';
// 				html += '<td>' + photo.pbNum + '</td>';
				html += '<td><button type="button" class="btn btn-outline-info" onclick="goPage(\'/photo/view?pbNum=' + photo.pbNum + '\')">' + photo.pbNum + '</td>';
				html += '<td onclick="goPage(\'/photo/view?pbNum=' + photo.pbNum + '\')">' + photo.pbTitle + '</td>';
				html += '<td>' + photo.pbContent + '</td>';
				html += '<td><img src="/img/' + photo.pbImg1 + '" width=100></td>';
				html += '<td><img src="/img/' + photo.pbImg2 + '" width=100></td>';
				html += '<td>' + photo.credat + '</td>';
				html += '<td>' + photo.cretim + '</td>';
				html += '<td>' + photo.creusr + '</td>';
				html += '<td>' + photo.moddat + '</td>';
				html += '<td>' + photo.modtim + '</td>';
				html += '<td>' + photo.modusr + '</td>';
				html += '<td>' + photo.pbCnt + '</td>';
				html += '</tr>';
			}
			tBody.innerHTML = html;
		}
	}
	xhr.send();
}
</script>
</html>














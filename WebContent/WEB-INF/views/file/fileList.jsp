<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File List</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>

</head>
<body>
<div class="container">
	<h1 class="display-3" align="center">File List</h1>
	<table class="table table-bordered">
	 <thead class="thead-dark">
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">ID</th>
	      <th scope="col">Name</th>
	      <th scope="col">File Location</th>
	    </tr>
	  </thead>
	  <tbody id="tBody">
	  	<tr>
	  	  <td colspan="5" align="center">파일 없음</td>
	  	</tr>
	  </tbody>
	</table>
</div>
</body>
<script>
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/file/list');
	xhr.onreadystatechange = function(){
		console.log("xhr.readyState : " + xhr.readyState);
		if(xhr.readyState == xhr.DONE){
			 if(xhr.status == 200){
				 	console.log("xhr.status : " + xhr.status);
				 	console.log("xhr.responseText : " + xhr.responseText);

					var fileList = JSON.parse(xhr.responseText);
					var tBody = document.getElementById('tBody');
					var html = '';
					for(var file of fileList){
						html += '<tr>';
						html += '<td>' + file.ftNum + '</td>';
						html += '<td>' + file.ftId + '</td>';
						html += '<td>' + file.ftName + '</td>';
						html += '<td><img src="' + file.ftFile + '" width=100></td>';
						html += '</tr>';
					}
					console.log(file.ftFile);
					tBody.innerHTML = html;
				}
		}
	}
	xhr.send();
}
</script>
</html>
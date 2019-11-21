<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Photo</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<h3>Title :</h3> <input type="text" id="pbTitle" /><br><br>
		<h3>Content :</h3> <textarea type="text" id="pbContent"></textarea><br><br>
		<h3>작성자 :</h3> <input type="number" id="creusr" /><br><br>
		<h3>Img 1 :</h3> <input type="file" id="pbImg1" /><br><br> <!-- array 형태로 저장됨 -->
		<h3>Img 2 :</h3> <input type="file" id="pbImg2" /><br><br> <!-- array 형태로 저장됨 -->
		<progress id="pro" value="0" max="100"></progress><br><br>
		<div id="rDiv"></div>
		<button type="submit" class="btn btn-outline-success" onclick="upload()">UPLOAD</button>
	</div>
</body>
<script>
function upload(){
	var xhr = new XMLHttpRequest();
	
	xhr.upload.addEventListener('progress', function(e){
		console.log("event : " + e);
		var percentage = (e.loaded/e.total) * 100;
		pro.value = percentage;
		rDiv.innerHTML = Math.floor(percentage) + '%';
	});
	
	var pro = document.querySelector('#pro');
	var formData = new FormData();
	
	console.log("creusr : " + document.querySelector('#creusr').value);
	console.log("creusr : " + document.querySelector('#pbImg1').files[0]);
	
	formData.append('pbTitle', document.querySelector('#pbTitle').value);
	formData.append('pbContent', document.querySelector('#pbContent').value);
	formData.append('creusr', document.querySelector('#creusr').value);
	formData.append('pbImg1', document.querySelector('#pbImg1').files[0]);
	formData.append('pbImg2', document.querySelector('#pbImg2').files[0]);
	
	for(var i=0; i<formData.length; i++){
		console.log("formData : " + formData[i]);
	}
	
	xhr.open('POST', '/photo/insert');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = JSON.parse(xhr.responseText);
			console.log("res.msg : " + res.msg);
			if(res.result == 'true'){
				 goPage('/photo/list');
			} else {
				
			}
		}
	}	
	xhr.send(formData);
}
</script>
</html>
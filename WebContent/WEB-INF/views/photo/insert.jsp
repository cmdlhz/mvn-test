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
<!-- 		<progress id="pro" value="0" max="100"></progress><br><br> -->
<!-- 		<div id="rDiv"></div> -->
		<button onclick="upload()">UPLOAD</button>
	</div>
</body>
<script>
function upload(){
	var formData = makeFormData();
// 	for(var obj of formData.entries()){
// 		console.log(obj);
// 	}
	var conf = {
	 	method : 'POST',
	 	url : '/photo/insert',
	 	func : function(res){
	 		res = JSON.parse(res);
	 		console.log(res);
	 	},
	 	data : formData // 없다면 ''라고 하면 됨
	}
	send(conf);
}


//	xhr.upload.addEventListener('progress', function(e){
//// 		console.log("event : " + e);
//		var percentage = (e.loaded/e.total) * 100;
//		pro.value = percentage;
//		rDiv.innerHTML = Math.floor(percentage) + '%';
//	});
//	var pro = document.querySelector('#pro');

//	var formData = new FormData();

//	console.log("creusr : " + document.querySelector('#creusr').value);
//	console.log("pbImg1 (name) : " + document.querySelector('#pbImg1').files[0].name);
//	console.log("pbImg1 (type) : " + document.querySelector('#pbImg1').files[0].type);

//	formData.append('pbTitle', document.querySelector('#pbTitle').value);
//	formData.append('pbContent', document.querySelector('#pbContent').value);
//	formData.append('creusr', document.querySelector('#creusr').value);
//	formData.append('pbImg1', document.querySelector('#pbImg1').files[0]);
//	formData.append('pbImg2', document.querySelector('#pbImg2').files[0]);
	
//	xhr.open('POST', '/photo/insert');



/*
 * 공통 만들기
 */
 
//function makeFormData(){
//	var objs = document.querySelectorAll('input[id], textarea[id]');
// 	console.log(objs.length);
//	for(var i=0; i<objs.length; i++){
//		var obj = objs[i];
//		if(obj.type == 'file'){
// 			if(obj.files.length != 0){ // 이러면 undefined가 안들어감
// 				formData.append(obj.id.obj.files[0]); // undefined가 들어가면 에러나서
// 			}
//		} else {
//			formData.append(obj.id.obj.value);
//		}
//	}
//	return formData;
//}

// function getXhr(conf){
// 	var xhr = new XMLHttpRequest();
// 	xhr.open(conf.method.conf.url);
// 	xhr.onreadystatechange = function(){
// 		if(xhr.readyState == 4 && xhr.status == 200){
// 			xhr.func(xhr.responseText); 
// 		}
// 	}
// 	return xhr;
// }

// function submit(){
// 	var xhr = getXhr({
// 		method : 'POST',
// 		url : '/photo/insert',
// 		func : function(res){
// 			res = JSON.parse(res);
// 			alert(res.msg);
// 		}
// 	});
// 	var fd = makeFormData();
// 	xhr.send(fd);
// }
</script>
</html>



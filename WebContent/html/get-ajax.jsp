<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax form</title>
</head>
<body>
<input type="text" id="name"></input>
<button onclick="submit()">SEND</button>
<script>
function submit(){
	var name = document.querySelector('#name');
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/getForm?name=' + name.value);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == xhr.DONE && xhr.status == 200){
			console.log(xhr.responseText);
		}
	}
	xhr.send();
}
</script>
</body>
</html>
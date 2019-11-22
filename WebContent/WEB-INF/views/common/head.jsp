<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="ver" value="1.0.1"/>
<script src="${jsPath}/jquery-3.4.1.slim.js?ver=${ver}"></script>
<script src="${jsPath}/bootstrap.js?ver=${ver}"></script>
<script src="${jsPath}/bootstrap.bundle.js?ver=${ver}"></script>
<script src="${jsPath}/common.js?ver=${ver}"></script>

<link rel="stylesheet" href="${cssPath}/bootstrap.css?ver=${ver}" />
<link rel="stylesheet" href="${cssPath}/bootstrap-reboot.css?ver=${ver}" />
<link rel="stylesheet" href="${cssPath}/bootstrap-grid.css?ver=${ver}" />

<script>
function makeFormData(){
	// 사실 validation 처리도 공통으로 해야 함 (파일이 아닌 것도 빈 문자열이 들어가면 안 됨 / not null로 설정했으므로)
	var objs = document.querySelectorAll('input[id], textarea[id]');
	var formData = new FormData();
	
	for(var i=0; i<objs.length; i++){
		var obj = objs[i];
// 		console.log(obj.value);
		if(obj.type == 'file'){
			if(obj.files.length){ // 데이터가 있다면 append - 없으면 false
				formData.append(obj.id, obj.files[0]);	
			}
		} else {
			formData.append(obj.id, obj.value);
		}
	}
	return formData;
}

function send(conf){
	var xhr = new XMLHttpRequest();
	xhr.open(conf.method, conf.url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			conf.func(xhr.responseText);
		}
	}	
	xhr.send(conf.data);
}
</script>
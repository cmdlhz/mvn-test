/**
 * 
 */

// 무조건 ViewsController를 타게 만들 거임
function goPage(url){
	location.href = '/views' + url;
}

// 크롬에 안 나옴 그래서 1. cache 지우기 2. inprivate 창에서 열기
// 근데 사용자한테 일일히 그렇게 하기는 힘드니까
// 물음표 뒤의 버젼 올리기 (common.js)
// <script src="${jsPath}/common.js?ver=1"></script>
//function ajax(conf){
//	var xhr = new XMLHttpRequest();
//	xhr.open(conf.method, conf.url);
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			conf.callback(xhr.responseText);
//		}
//	}
//	xhr.send();
//}
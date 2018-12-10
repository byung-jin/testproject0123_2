<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header페이지</title>
<script type="text/javascript" 
         src="http://code.jquery.com/jquery-latest.js"></script>
         
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>         


<style type="text/css">
	#header,#footer{
/* 		border:1px solid black; */
		height: 80px;
 		background-color: orange; 
/* 		text-align: center;/*텍스트나 인라인태그를 정렬*/ */
/* 		line-height:80px;/*부모박스의 높이와 동일하게 주면 가운데 정렬효과(단 1줄일때)*/  */
	}
	#container{
/* 		border:1px solid black; */
		width: 1000px; 
		height: 400px;
		margin: 0 auto;/* 0: 위아래, auto: 좌우를 자동으로 위치설정*/
		overflow: auto;/*범위를 벗어나는 부분을 어떻게 처리할건지..*/
	}
	a{text-decoration: none;}
</style>
<script type="text/javascript">
	function boardList(){
		location.href="AnsController.do?command=boardlist";
	}
</script>
</head>
<body>
<div id="header" >
	<h1 class="text-center"><a href="index.jsp">게시판 만들기</a></h1>
</div>
</body>
</html>







<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
<style type="text/css">
	#replyform{
		display: none;
	}
</style>
<script type="text/javascript">
	//답글폼 보여주기
	function replyForm(){
// 		var replyFormDiv=document.getElementById("replyform");
// 		replyFormDiv.style.display="block";
		//jquery를 이용해서 보여주기(애니메이션효과)
		$("#replyform").show();//폼 보여주기
		
		//replyform의 새로방향의 가장 위에 위치를 구함
		var replyPosition=$("#replyform").offset().top;
// 		alert(typeof replyPosition);//typeof : 값의 타입을 구해줌
// 		alert(replyPosition);
		//scrollTop속성을 2초동안 보여준다.---> 지연시간을 줘서 움직이는것처럼 보여줌
		$("#container").animate({
			"scrollTop":replyPosition
		},1000);
	}
</script>
</head>
<body>
<div id="container">
<h1>게시글 상세보기</h1>
<table class="table table-hover">
	<tr>
		<th>번 호</th>
		<td>${dto.seq}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${dto.id}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${dto.regdate}</td>
	</tr>
	<tr>
		<th>제 목</th>
		<td>${dto.title}</td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea rows="10" cols="60" readonly="readonly">${dto.content}</textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<button onclick="updateForm('${dto.seq}')">수정</button>
			<button onclick="delBoard('${dto.seq}')">삭제</button>
			<button onclick="replyForm()">답글달기</button>
			<button onclick="location.href='boardlist.do'">글목록</button>
		</td>
	</tr>
</table>
<!-- --------------답글폼시작 -->
<div id="replyform">
<hr/>
<h1>답글작성</h1>
<form action="replyboard.do" method="post">
<input type="hidden" name="seq" value="${dto.seq}"/>
<table border="1">
	<col width="100px"><col width="400px">
	<tr>
		<th>작성자</th>
		<td><input type="text" name="id"/></td>
	</tr>
	<tr>
		<th>제 목</th>
		<td><input type="text" name="title" /></td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea rows="10" cols="60" name="content" ></textarea> </td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="답글등록">
		</td>
	</tr>
</table>
</form>
</div>
</div>
<script type="text/javascript">
	//수정폼으로 이동
	function updateForm(seq){
		location.href="updateform.do?seq="+seq;
	}
	//게시글 삭제로 이동
	function delBoard(seq){
		location.href="delboard.do?seq="+seq;
	}
</script>
<%@include file="footer.jsp" %>
</body>
</html>






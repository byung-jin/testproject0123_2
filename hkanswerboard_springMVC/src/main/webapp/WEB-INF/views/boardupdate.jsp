<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<div id="container">
<h1>게시글 수정하기</h1>
<form action="boardupdate.do" method="post">
<input type="hidden" name="seq" value="${dto.seq}"/>
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
		<td><input type="text" name="title" value="${dto.title}"/></td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea rows="10" cols="60" name="content">${dto.content}</textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="수정완료"/>
			<button type="button" onclick="boardList()">글목록</button>
		</td>
	</tr>
</table>
</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>









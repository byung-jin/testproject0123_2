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
<h1>게시글작성</h1>
<form action="insertboard.do" method="post">
<table class="table table-hover">
	<col width="100px"><col width="400px">
	<tr>
		<th>작성자</th>
		<td><input class="form-control" type="text" name="id"/></td>
	</tr>
	<tr>
		<th>제 목</th>
		<td><input class="form-control" type="text" name="title" /></td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea class="form-control" rows="10" cols="60" name="content" ></textarea> </td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" class="btn btn-primary" value="글등록">
		</td>
	</tr>
</table>
</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
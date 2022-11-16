<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="BbsServlet" method="post">
이름: <input type="text" name="name"></br>
제목: <input type="text" name="subject"></br>
내용:</br> <textarea name="memo" cols="20" cols="100"></textarea></br>
<input type="submit" value="전송">
</form>
</body>
</html>
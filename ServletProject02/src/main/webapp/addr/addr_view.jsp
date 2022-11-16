<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>

</head>
<body>
<h3>상세보기</h3>
<form action="update.addr" method="post">

	<table>
		<tr>
			<th>번호</th>
			<td><input type="text" name="num" value="${address.num}" readonly="readonly"> </td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" value="${address.name}"> </td>
		</tr>
			<tr>
			<th>우편번호</th>
			<td><input type="text" name="zipcode" value="${address.zipcode}"  size=7></td>
		</tr>
			<tr>
			<th>주소</th>
			<td><input type="text" name="addr" value="${address.addr}" size=50> </td>
		</tr>
			<tr>
			<th>전화번호</th>
			<td><input type="text" name="tel" value="${address.tel}"></td>
		</tr>
		<tr>
		<td colspan="2">
			<input type="submit"  value="수정">
			<input type="reset"  value="취소">
			<input type="button" value="삭제" 
			onclick="location.href='delete.addr?num=${address.num}'"/>
		</td>
		</tr>
	</table>
</form>
</body>
</html>
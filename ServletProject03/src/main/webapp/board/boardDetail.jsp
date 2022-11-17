<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
  <h2>Bordered List</h2>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>글번호</th>
        <th>작성자</th>
        <th>글제목</th>
        <th>이메일</th>
        <th>조회수</th>
        <th>날짜</th>
      </tr>
    </thead>
    <tbody>
		<c:forEach items="${arr}" var="address">
			<tr>
			<td>${address.num}</td>
			<td><a href="bdetail?num=${address.num}">${address.userid}</a></td>
			<td>${address.subject}</td>
			<td>${address.email}</td>
			<td>${address.readcount}</td>
			<td>${address.regdate}</td>
			</tr>
		</c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="../include/footer.jsp"%>
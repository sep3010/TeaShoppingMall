<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   <title>마이 페이지</title>
</head>

<body>

<h1>마이 페이지</h1>

<p>
	<a href="${pageContext.request.contextPath}/user/userDetails">회원정보 수정</a>
</p>

<p>
	<a href="${pageContext.request.contextPath}/user/cart">장바구니</a>
</p>

<table width="700" border="1">
	<tr>
		<td>적립금</td>
		<td>구매 등급</td>
	</tr>
	<tr>
		<td>${member.point}</td>
		<td>${member.purchaseGrade}</td>
	</tr>
	<tr>
		<td>
			<a href="${pageContext.request.contextPath}/user/userWish">위시리스트</a>
		</td>
		<td>
			<a href="${pageContext.request.contextPath}/user/orders">주문 내역</a>
		</td>
	</tr>
	
</table>


<h3><a href="<c:url value="/" />">홈</a></h3>

</body>
</html>
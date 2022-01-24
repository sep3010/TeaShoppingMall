<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <%@ include file="/WEB-INF/include/header.jspf" %>
    <title>회원 관리</title>
</head>

<body>

<h1>회원 관리</h1>

<table width="700" border="1">
	<tr>
		<td>번호</td>
		<td>회원 아이디</td>
		<td>회원 이름</td>
		<td>생년월일</td>
		<td>연락처</td>
		<td>이메일</td>
		<td>가입 플랫폼</td>
		<td>포인트</td>
		<td>구매 등급</td>
		<td>탈퇴</td>
	</tr>
	<c:forEach var="member" items="${memberList}" varStatus="status">
		<tr>
			<td>${status.count}</td> <!-- 현재 몇번째 반복인지 나타낸다. 1부터 시작한다. -->
			<td>${member.userId}</td>
			<td>${member.userName}</td>
			<td>${member.birth}</td>
			<td>${member.phone}</td>
			<td>${member.email}</td>
			<td>${member.platform}</td>
			<td>${member.point}</td>
			<td>${member.purchaseGrade}</td>
			<td><a class="delete" data-productId='${product.productId}'
				href="${pageContext.request.contextPath}/admin/product/manageProduct/${product.productId}">삭제</a></td>					
		</tr>
	</c:forEach>
</table>

<h3>[<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]</h3>
<h3>[<a href="<c:url value="/admin/product/manageProduct" />">상품 관리</a>]</h3>

</body>
</html>
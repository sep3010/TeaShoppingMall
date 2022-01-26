<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">

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
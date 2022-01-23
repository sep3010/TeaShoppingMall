<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<%@ include file="/WEB-INF/include/header.jspf" %>
<title>Home</title>

</head>
<body>    <!-- 로그인 되지 않았다면 참 -->
	<sec:authorize access="isAnonymous()">
		<p>
			<a href="<c:url value="/login/loginForm" />">로그인</a>
		</p>
	</sec:authorize>
	<!-- 로그인을 했다면 참 -->
	<sec:authorize access="isAuthenticated()">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<p>
				${userId} 관리자님 환영합니다.
			</p>
			<a href="${pageContext.request.contextPath}/admin/adminHome">관리자 페이지</a>
		</sec:authorize>
		<sec:authorize access="!hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')">
			<p>
				${userId}님 환영합니다.
			</p>
			<a href="${pageContext.request.contextPath}/user/userHome">마이 페이지</a>
		</sec:authorize>
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="로그아웃" />
		</form:form>
	</sec:authorize>
</body>
</html>

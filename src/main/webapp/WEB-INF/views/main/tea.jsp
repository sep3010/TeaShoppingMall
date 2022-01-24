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
	<a href="${pageContext.request.contextPath}/user/cart">장바구니</a>
	
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="#">Navbar</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle active" href="/main/tea" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          TEA
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="#">Black Tea</a>
	          <a class="dropdown-item" href="#">Green Tea</a>
	          <a class="dropdown-item" href="#">Oolong</a>
	          <a class="dropdown-item" href="#">Rooibos</a>
	          <a class="dropdown-item" href="#">Herbal tea</a>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" href="#">Something else here</a>
	        </div>
	      </li>	
	      <li class="nav-item active">
	        <a class="nav-link" href="#">Tea Bag</a>
	      </li>
	      <li class="nav-item active">
	        <a class="nav-link" href="#">Teaware</a>
	      </li>
	      <li class="nav-item active">
	        <a class="nav-link" href="#">Gift</a>
	      </li>
	      <li class="nav-item dropdown active">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Board
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="#">Notice</a>
	          <a class="dropdown-item" href="#">Q&A</a>
	          <a class="dropdown-item" href="#">Review</a>
	        </div>
	      </li>	
	    </ul>
	    <form class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	    </form>
	  </div>
	</nav>
	
	<section>
		<c:forEach var="product" items="${productList}">
			<div class="card" style="width: 18rem;">
			  <img class="card-img-top" src=".../100px180/" alt="Card image cap">
			  <div class="card-body">
			    <h5 class="card-title">
			    	<a href="${pageContext.request.contextPath}/main/productDetails/${product.productId}" class="active">${product.productName}</a>
			    </h5>
			    <a href="#" class="btn btn-primary">위시리스트</a>
			    <a href="#" class="btn btn-primary">장바구니</a>
			  </div>
			</div>		
		
		
		</c:forEach>

	
	
	
	</section>
	
	
</body>
</html>

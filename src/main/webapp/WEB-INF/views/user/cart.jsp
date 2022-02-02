<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
	
	<!-- csrf meta tag -->
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	
    <title>장바구니</title>
	<script type="text/javascript">
		// csrf
	    const token = $("meta[name='_csrf']").attr("content");
	    const header = $("meta[name='_csrf_header']").attr("content");
		
		$(document).ready( function() {
			
			$(".delete").click(function(event) {
			       event.preventDefault();
			       console.log("ajax 호출!");
			       
			       let trObj = $(this).parent().parent();
			       
			       console.log($(this).attr("href"));
			       
			       $.ajax({
			           type : "DELETE",
			           url : $(this).attr("href"),
			           beforeSend: function(xhr) {
                           xhr.setRequestHeader("X-CSRF-Token", "${_csrf.token}");
                        },
			           success: function (result) {       
			           console.log(result); 
			             if(result == "SUCCESS"){
			                     //getList();
			                   $(trObj).remove();  
			                             
			                }                       
			              },
			              error: function (e) {
			                  console.log(e);
			              }         
			       
			       });   
			    
			    });   
	    });
	
	</script>	
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
			<p>${userId} 관리자님 환영합니다.</p>
			<a href="${pageContext.request.contextPath}/admin/adminHome">관리자 페이지</a></p>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER')">
			<p>${userId}님 환영합니다.</p>
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
			<p><a href="${pageContext.request.contextPath}/user/userHome">마이 페이지</a></p>
		</sec:authorize>
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="로그아웃" class="btn" />
		</form:form>
	</sec:authorize>
	<a href="${pageContext.request.contextPath}/user/cart">장바구니</a>
	
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="/">Navbar</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle active" href="" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          TEA
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <h4 class="dropdown-header"><a href="${pageContext.request.contextPath}/main/menu/${0}">Tea</a></h4>	
	          <a class="category dropdown-item" href="${pageContext.request.contextPath}/main/menu/${1}">Black Tea</a>
	          <a class="category dropdown-item" href="${pageContext.request.contextPath}/main/menu/${2}">Green Tea</a>
	          <a class="category dropdown-item" href="${pageContext.request.contextPath}/main/menu/${3}">Oolong</a>
	          <a class="category dropdown-item" href="${pageContext.request.contextPath}/main/menu/${4}">Rooibos</a>
	          <a class="category dropdown-item" href="${pageContext.request.contextPath}/main/menu/${5}">Herbal tea</a>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" href="#">Something else here</a>
	        </div>
	      </li>	
	      <li class="nav-item active">
	        <a class="category nav-link" href="${pageContext.request.contextPath}/main/menu/${6}">Tea Bag</a>
	      </li>
	      <li class="nav-item active">
	        <a class="category nav-link" href="${pageContext.request.contextPath}/main/menu/${7}">Teaware</a>
	      </li>
	      <li class="nav-item active">
	        <a class="category nav-link" href="${pageContext.request.contextPath}/main/menu/${8}">Gift</a>
	      </li>	
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle active" href="" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          BOARD
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="category dropdown-item" href="${pageContext.request.contextPath}/main/board/notice">Notice</a>
	          <a class="category dropdown-item" href="${pageContext.request.contextPath}/main/board/question/${1}">Q&A</a>
	          <a class="category dropdown-item" href="${pageContext.request.contextPath}/main/board/review/${1}">Review</a>
	        </div>
	      </li>
	    </ul>
	    <form class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	    </form>
	  </div>
	</nav>

<h1>장바구니</h1>
<form:form name="" action="${pageContext.request.contextPath}/" method="POST">
	<input type="hidden" value="${userId}" name="userId"/>
	<table width="700" border="1">
		<tr>
			<td>선택</td>
			<td>상품</td>
			<td>상품명</td>
			<td>수량</td>
			<td>금액</td>
			<td>삭제</td>
		</tr>
		<c:forEach var="cart" items="${cartList}" varStatus="status">			
			<input type="hidden" value="${cartAmount}" name="cartAmount"/>
			<tr>
				<c:if test="${empty cartList}">
					<h2>장바구니에 담긴 상품이 없습니다.</h2>
				</c:if>
				<td><input type="checkbox" name="productId" value="${productId}"></td>
				<td>상품 이미지</td>
				<td>${cart.productName}</td>
				<td>${cart.cartAmount}</td>
				<td>${cart.cartPrice}</td>
				<td><a class="delete" data-cartId='${cart.cartId}'
					href="${pageContext.request.contextPath}/user/cart/${cart.cartId}">삭제</a></td>
			</tr>	
		</c:forEach>
	</table>
	<button type="submit" class="btn">주문하기</button>
</form:form>

</body>
</html>
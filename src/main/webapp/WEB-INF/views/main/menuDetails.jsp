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

<!-- header 태그의 CSS(navbar와 로그인 상태 부분) -->
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resources/header/css/style_hearder.css">

    <title>상품 상세</title>
		
</head>

<body>    
    <header> 
        <div id="loginBar" class="mt-3">
            <!-- 로그인 되지 않았다면 참 -->
            <sec:authorize access="isAnonymous()">
                <p class="login mr-3">
                    <a href='<c:url value="/login/loginForm"/>'>LOGIN</a>
                </p>
                <p class="login mr-4">
                    <a href="${pageContext.request.contextPath}/add/addForm">회원가입</a>
                </p>
            </sec:authorize>
            <!-- 로그인을 했다면 참 -->
            <sec:authorize access="isAuthenticated()">
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <p class="welcome">${userId} 관리자님 환영합니다.</p>
                    <p class="welcome"><a href="${pageContext.request.contextPath}/admin/adminHome">관리자 페이지</a></p>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_USER')">
                    <p class="welcome">${userId}님 환영합니다.</p>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
                    <p class="welcome"><a href="${pageContext.request.contextPath}/user/userHome">My Page</a></p>
                </sec:authorize>
                <p><a href="${pageContext.request.contextPath}/user/cart"><img src="${pageContext.request.contextPath}/resources/header/cart.png"></a></p>
                <form:form id="logout" class="mr-4" action="${pageContext.request.contextPath}/logout" method="POST">
                    <input class="btn" type="submit" value="LOGOUT"/>
                </form:form>
            </sec:authorize>
        </div>
        

        <nav class="navbar navbar-custom navbar-expand-lg navbar-light pt-0">
            <a class="navbar-brand py-0" href="${pageContext.request.contextPath}/"><img class="logo" src="${pageContext.request.contextPath}/resources/header/logo_bright.png"></a>
            
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
          
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link" href="${pageContext.request.contextPath}/main/menu/${0}" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Tea
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <a class="dropdown-item" href="${pageContext.request.contextPath}/main/menu/${1}">Black Tea</a>
                      <a class="dropdown-item" href="${pageContext.request.contextPath}/main/menu/${2}">Green Tea</a>
                      <a class="dropdown-item" href="${pageContext.request.contextPath}/main/menu/${3}">Oolong</a>
                      <a class="dropdown-item" href="${pageContext.request.contextPath}/main/menu/${4}">Rooibos</a>
                      <a class="dropdown-item" href="${pageContext.request.contextPath}/main/menu/${5}">Herbal tea</a>
                    </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/main/menu/${6}">Tea Bag</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/main/menu/${7}">Teaware</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/main/menu/${8}">Gift</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        BOARD
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <a class="dropdown-item" href="${pageContext.request.contextPath}/main/board/notice/${1}">Notice</a>
                      <a class="dropdown-item" href="${pageContext.request.contextPath}/main/board/question/${2}">Q&A</a>
                      <a class="dropdown-item" href="${pageContext.request.contextPath}/main/board/question/${3}">Review</a>
                    </div>
                </li>
              </ul>
              <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0 mr-2" type="submit">Search</button>
              </form>
            </div>
          </nav>
    </header>
	
	<div>이미지</div>
	
	<table width="700" border="1">
		<tr>
			<td>상품명</td>
			<td>${product.productName}</td>
		</tr>
		<tr>	
			<td>상품 분류</td>
			<td>${product.categoryName}</td>
		</tr>
		<tr>
			<td>브랜드명</td>
			<td>${product.brand}</td>
		</tr>
		<tr>
			<td>내용량(무게/개수)</td>
			<c:if test="${product.weight != 0 && product.count == 0}">
				<td>${product.weight}g</td>
			</c:if>
			<c:if test="${product.count != 0 && product.weight == 0}">
				<td>${product.count}개입</td>
			</c:if>
			<c:if test="${product.count == 0 && product.weight == 0}">
				<td>입력값 없음</td>
			</c:if>
			<c:if test="${product.count != 0 && product.weight != 0}">
				<td>${product.weight}g * ${product.count}개</td>
			</c:if>
		<tr>
			<td>판매가</td>
			<td>${product.productPrice}원</td>
		</tr>
		<tr>
			<td>판매량</td>
			<td>${product.cellCount}개</td>
		</tr>
		<tr>
			<td>재고량</td>
			<td>${product.stock}개</td>
		</tr>

	</table>
<h3>[<a href="<c:url value="/admin/product/modifyProduct/${product.productId}" />">수정하기</a>]</h3>
<h3>[<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]</h3>
<h3>[<a href="<c:url value="/admin/product/manageProduct" />">상품 목록</a>]</h3>
</body>
</html>
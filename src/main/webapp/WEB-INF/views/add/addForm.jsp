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

<!-- csrf meta tag -->
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<!-- header 태그의 CSS(navbar와 로그인 상태 부분) -->
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resources/header/css/style_hearder.css">

	<title>회원가입</title>
	
<script type="text/javascript">
	// csrf
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	//Ajax spring security header..
	$(document).ajaxSend(function(e, xhr, options){
		xhr.setRequestHeader(header, token);
	});


</script>	
</head>


<body>    
	
    <header> 
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

<h1>회원가입</h1>

<c:url value="/add/addMember" var="addUMemberUrl" />

<form:form name="addForm" action="${addUMemberUrl}" method="POST">
    <p>
        <label for="userId">아이디</label>
        <input type="text"  name="userId" class="id"/>
    </p>
    <p>
        <label for="password">비밀번호</label>
        <input type="password" name="password" class="pw"/>
    </p>
    <p>
        <label for="userName">이름</label>
        <input type="text" name="userName" class="name"/>
    </p>
    <p>
        <label for="birth">생년월일</label>
        <input type="date" name="birth" class="birth"/>
    </p>
    <p>
        <label for="phone">전화번호</label>
        <input type="tel" name="phone" class="tel"/>
    </p>
    <p>
        <label for="email">이메일</label>
        <input type="email" name="email" class="email"/>
    </p>
    <p>
        <label for="zipCode">우편번호</label>
        <input type="text" name="zipCode" class="zip"/>
    </p>
    <p>
        <label for="address">주소</label>
        <input type="text" name="address" class="addr"/>
    </p>
    <button type="submit" class="btn" id="submit">가입하기</button>
</form:form>
</body>
</html>

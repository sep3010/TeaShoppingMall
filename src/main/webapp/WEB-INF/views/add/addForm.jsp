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

	<title>회원가입</title>
</head>


<body>

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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <%@ include file="/WEB-INF/include/header.jspf" %>
	<title>회원가입</title>
</head>

<body>

<h1>회원가입</h1>

<c:url value="/add/addMember" var="addUMemberUrl" />

<form:form name="frmMember" action="${addUMemberUrl}" method="POST">
    <p>
        <label for="userId">아이디</label>
        <input type="text"  name="userId" />
    </p>
    <p>
        <label for="password">비밀번호</label>
        <input type="password" name="password"/>
    </p>
    <p>
        <label for="userName">이름</label>
        <input type="text" name="userName"/>
    </p>
    <p>
        <label for="birth">생년월일</label>
        <input type="date" name="birth"/>
    </p>
    <p>
        <label for="phone">전화번호</label>
        <input type="tel" name="phone"/>
    </p>
    <p>
        <label for="email">이메일</label>
        <input type="email" name="email"/>
    </p>
    <p>
        <label for="zipCode">우편번호</label>
        <input type="text" name="zipCode"/>
    </p>
    <p>
        <label for="address">주소</label>
        <input type="text" name="address"/>
    </p>  
    <button type="submit" class="btn">가입하기</button>
</form:form>
</body>
</html>

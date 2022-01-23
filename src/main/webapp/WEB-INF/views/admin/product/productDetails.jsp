<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <%@ include file="/WEB-INF/include/header.jspf" %>
    <title>상품 상세</title>
		
</head>

<body>

<h1>상품 상세</h1>
	<table width="700" border="1">
		<tr>
			<td>상품번호</td>
			<td>${product.productId}</td>
		</tr>
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
			<td>${product.productPrice}</td>
		</tr>
		<tr>
			<td>등록일자</td>
			<td>${product.updateDate}</td>
		</tr>
		<tr>
			<td>판매량</td>
			<td>${product.cellCount}</td>
		</tr>
		<tr>
			<td>재고량</td>
			<td>${product.stock}</td>
		</tr>

	</table>

<h3>[<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]</h3>
<h3>[<a href="<c:url value="/admin/product/manageProduct" />">상품 목록</a>]</h3>
</body>
</html>
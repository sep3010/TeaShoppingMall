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

    <title>상품 상세</title>
	<script type="text/javascript">
		$(document).ready( function() {
	        if(${product.categoryId} == $("select option").val()){
	            $("option").attr("selected", "selected");
	        }
	    });
	
	</script>	
</head>

<body>

<h1>상품 상세</h1>
<form:form name="modify" action="${pageContext.request.contextPath}/admin/product/modify" method="POST">
	<input type="hidden" value="${product.productId}" name="productId"/>
	<table width="700" border="1">
		<tr>
			<td>상품번호</td>
			<td>${product.productId}"</td>
		</tr>
		<tr>
			<td>상품명</td>
			<td><input type="text"  name="productName" value="${product.productName}"/></td>
		</tr>
		<tr>	
			<td>상품 분류</td>
			<td>
				<select name="categoryId">
					<option value="1">BLACK TEA</option>
					<option value="2">GREEN TEA</option>
					<option value="3">OOLONG</option>
					<option value="4">ROOIBOS</option>
					<option value="5">HERBAL TEA</option>
					<option value="6">TEA BAG</option>
					<option value="7">TEAWARE</option>
					<option value="8">GIFT</option>
				</select>			
			</td>
		</tr>
		<tr>
			<td>브랜드명</td>
			<td><input type="text"  name="brand" value="${product.brand}"/></td>
		</tr>
		<tr>
			<td>내용량(무게/개수)</td>
			<td><input type="text"  name="weight" value="${product.weight}"/></td>
		<tr>
			<td>판매가</td>
			<td><input type="text"  name="productPrice" value="${product.productPrice}"/></td>
		</tr>
		<tr>
			<td>재고량</td>
			<td><input type="text"  name="stock" value="${product.stock}"/></td>
		</tr>
	</table>
	<button type="submit" class="btn">완료</button>
</form:form>
<h3>[<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]</h3>
<h3>[<a href="<c:url value="/admin/product/manageProduct" />">상품 목록</a>]</h3>
</body>
</html>
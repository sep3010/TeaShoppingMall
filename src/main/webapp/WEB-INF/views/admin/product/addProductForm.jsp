<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <%@ include file="/WEB-INF/include/header.jspf" %>
    <title>상품 등록</title>
    <script type="text/javascript">

    </script>
</head>

<body>

<h1>상품 등록</h1>
	<form:form name="frmProduct" action="${pageContext.request.contextPath}/admin/product/addProduct" method="POST">
		<table width="700" border="1">
			<tr>
				<td>상품명</td>
				<td><input type="text"  name="productName"/></td>
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
				<td><input type="text"  name="brand"/></td>
			</tr>
			<tr>
				<td>무게</td>
				<td><input type="number"  name="weight"/>g</td>
			</tr>
			<tr>
				<td>개수</td>
				<td><input type="number"  name="count"/>개입</td>
			</tr>
			<tr>
				<td>판매가</td>
				<td><input type="number"  name="productPrice"/></td>
			</tr>
			<tr>
				<td>재고량</td>
				<td><input type="number"  name="stock"/></td>
			</tr>
			<tr>
				<td>상품 이미지</td>
				<td><input type="file" multiple="multiple" accept="image/*" name="file"/></td>
			</tr>

		</table>
		<button type="submit" class="btn">상품 등록</button>
	</form:form>

<h3>[<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]</h3>

</body>
</html>
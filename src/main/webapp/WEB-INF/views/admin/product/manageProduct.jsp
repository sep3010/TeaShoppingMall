<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <%@ include file="/WEB-INF/include/header.jspf" %>
    <title>상품 관리</title>
    <script type="text/javascript">
		$(document).ready(() => {
		    $(".delete").click( (event) => {
		       event.preventDefault();
		       
		       let trObj = $(this).parent().parent();
		       
		       console.log($(this).attr("href"));
		       
		       $.ajax({
		           type : "DELETE",
		           url : $(this).attr("href"),
		           success: (result) => {       
		           console.log(result); 
		             if(result == "SUCCESS"){
		                   $(trObj).remove();  	                             
		                }                       
		              },
		              error: (e) => {
		                  console.log(e);
		              }         
		       
		       });   
		    
		    });   
		 
		});
    </script>
</head>

<body>

<h1>상품 관리</h1>
	<table width="700" border="1">
		<tr>
			<td>상품 번호</td>
			<td>상품명</td>
			<td>상품 분류</td>
			<td>브랜드명</td>
			<td>내용량(무게/개수)</td>
			<td>판매가</td>
			<td>등록일</td>
			<td>판매수량</td>
			<td>재고량</td>
			<td>등록 삭제</td>
		</tr>
		<c:forEach var="product" items="${productList}">
			<tr>
				<td>${product.productId}</td>
				<td>${product.productName}</td>
				<td>${product.categoryName}</td>
				<td>${product.brand}</td>
				<c:if test="${product.weight != 0 && product.count == 0}">
					<td>${product.weight}g</td>
				</c:if>
				<c:if test="${product.count != 0 && product.weight == 0}">
					<td>${product.count}개입</td>
				</c:if>
				<c:if test="${product.count == 0 && product.weight == 0}">
					<td>입력값 없음</td>
				</c:if>
				<td>${product.productPrice}</td>
				<td>${product.updateDate}</td>
				<td>${product.cellCount}</td>
				<td>${product.stock}</td>
				<td><a class="delete" data-productId='${product.productId}'
					href="${pageContext.request.contextPath}/admin/product/manageProduct/${product.productId}">삭제</a></td>					
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10"><a href="">상품 등록</a></td>
		</tr>
	</table>


<h3>[<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]</h3>

</body>
</html>
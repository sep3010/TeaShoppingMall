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

    <title>Q&A</title>
    <script type="text/javascript">
	 	// csrf
	    var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
	    
	    //Ajax spring security header
		$(document).ajaxSend(function(e, xhr, options){
			xhr.setRequestHeader(header, token);
		});
    
		$(document).ready(function () {
		    $(".delete").click( function (event) {
		       event.preventDefault();
		       
		       let trObj = $(this).parent().parent();
		       
		       console.log($(this).attr("href"));
		       
		       const deleteCheck = confirm("글을 삭제 하시겠습니까?");
		       
		       if(deleteCheck == true){
		       
			       $.ajax({	
			           type : "DELETE", 
			           url : $(this).attr("href"),
			           success: function (result) {       
			           console.log(result); 
			             if(result == "SUCCESS"){
			                   $(trObj).remove();  	                             
			                }                       
			              },
			              error: (e) => {
			                  console.log(e);
			              }         
			       
			       });  
		       
		       }
		       else{
		    	   console.log("삭제 취소");
		       }
		    
		    }); // $(".delete").click
		    
		   
		 
		});
    
	
    </script>
</head>

<body>    
	<!-- 로그인 되지 않았다면 참 -->
	<sec:authorize access="isAnonymous()">
		<p>
			<a href="<c:url value="/login/loginForm" />">로그인</a>
		</p>
	</sec:authorize>
	<!-- 로그인을 했다면 참 -->
	<sec:authorize access="isAuthenticated()">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<p>${userId} 관리자님 환영합니다.</p>
			<p><a href="${pageContext.request.contextPath}/admin/adminHome">관리자 페이지</a></p>
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
	          <a class="category dropdown-item" href="${pageContext.request.contextPath}/main/board/notice/${1}">Notice</a>
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



<h1>Q&A</h1>
	<table width="700" border="1">
		<tr>
			<td>번호</td>
			<td>분류</td>
			<td>제목</td>
			<td>작성자</td>
			<td>
				<c:choose>
					<c:when test="${!empty board.rewriteDate}">
						수정일						
					</c:when>
					<c:otherwise>
						작성일						
					</c:otherwise>					
				</c:choose>				
			</td>
			<td>조회수</td>
			<sec:authorize access="isAuthenticated()">
				<sec:authorize access="hasRole('ROLE_ADMIN')">					
					<td>삭제</td>					
				</sec:authorize>		
			</sec:authorize>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.rnum}</td>
				<td>${board.boardCategory}</td>
				<td>
					<c:if test="${board.boardLock eq 'Y'}"> <%-- 비공개글 일때 --%>
						<sec:authorize access="isAnonymous()"> <%-- 로그인 하지 않았을 때 --%>
							<i class="fas fa-lock"></i>${board.boardTitle}
						</sec:authorize>
						<sec:authorize access="isAuthenticated()"> <%-- 로그인 했을 때 --%>							
							<c:if test="${userId eq board.userId}">
								<a href="${pageContext.request.contextPath}/main/board/questionContent/${board.boardId}">${board.boardTitle}</a>
							</c:if>
							<c:if test="${userId ne board.userId}">
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<a href="${pageContext.request.contextPath}/main/board/questionContent/${board.boardId}">${board.boardTitle}</a>
								</sec:authorize>
								<sec:authorize access="hasRole('ROLE_USER')">
									<i class="fas fa-lock"></i>${board.boardTitle}
								</sec:authorize>
							</c:if>						
						</sec:authorize>					
					</c:if>
					<c:if test="${board.boardLock eq 'N'}"> <%-- 공개글 일때 --%>
						<a href="${pageContext.request.contextPath}/main/board/questionContent/${board.boardId}">${board.boardTitle}</a>
					</c:if>
				</td>				
				<td>${board.userId}</td>
				<td>
					<c:choose>
						<c:when test="${!empty board.rewriteDate}">
							${board.rewriteDate}						
						</c:when>
						<c:otherwise>
							${board.writeDate}						
						</c:otherwise>					
					</c:choose>				
				</td>
				<td>${board.boardHit}</td>
				<sec:authorize access="isAuthenticated()">
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td>
							<a class="delete" href="${pageContext.request.contextPath}/main/board/${board.boardId}">삭제</a>
						</td>
					</sec:authorize>		
				</sec:authorize>
			</tr>	
		</c:forEach>
		
		<sec:authorize access="isAuthenticated()">
			<sec:authorize access="hasAnyRole('ROLE_USER, ROLE_ADMIN')">
				<tr>
					<td colspan="6">
						<a href="${pageContext.request.contextPath}/main/board/questionWrite">글쓰기</a>
					</td>
				</tr>
			</sec:authorize>		
		</sec:authorize>

	</table>
	
	<!-- 페이징 바 -->

	<c:if test="${pageMaker.pre}"> 
       <a href="${pageContext.request.contextPath}/main/board/notice/${pageMaker.startPage - 1}">&#171;</a>
    </c:if>
    
    <c:if test="${currentPageNum > 1}">
       <a href="${pageContext.request.contextPath}/main/board/notice/${currentPageNum - 1}">&lt;</a>
    </c:if>

      <!-- 링크를 걸어준다 1-10페이지까지 페이지를 만들어주는것  -->
    <c:forEach var="idx" begin="${pageMaker.startPage}" end="${pageMaker.endPage}" >
    	<c:choose>
    		<c:when test="${idx eq currentPageNum}">
    			<span>${idx}</span>
    		</c:when>
    		
    		<c:otherwise>
    			<a href="${pageContext.request.contextPath}/main/board/notice/${idx}">${idx}</a>
    		</c:otherwise>	    	
    	</c:choose>    	
    </c:forEach>
    
    <c:if test="${currentPageNum < pageMaker.realEnd}">
       <a href="${pageContext.request.contextPath}/main/board/notice/${currentPageNum + 1}">&gt;</a>
    </c:if>
      
    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
       <a href="${pageContext.request.contextPath}/main/board/notice/${pageMaker.endPage +1}">&#187;</a>
    </c:if>


</body>
</html>
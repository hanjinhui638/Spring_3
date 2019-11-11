<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp"/>
</head>
<body>
<c:import url="../layout/nav.jsp"/>
	<!-- <img alt="" src="../resources/images/au53.jpg"> 프론트 ->resources -->
	
	<div class="container">
		<h2>NOTICE LIST</h2>
		<table class="table">
			<thead>
				<tr>
					<th>NUM</th>
					<th>TITLE</th>
					<th>WRIGHT</th>
					<th>DATE</th>
					<th>HIT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var = "dto" varStatus="st"> 
					
				<tr>
					<td>${dto.num}</td>
					<td><a href = "./noticeSelect?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.reg_date}</td>
					<td>${dto.hit}</td>
				<%-- 	<td>${dto.hit}: ${st.last}</td> --%>
				</tr>
				</c:forEach>
			
			</tbody>
		</table>
			<div>
					<ul class="pagination">
					<c:forEach begin ="1" end="${totalPage}" var="i">
						  <li><a href="./noticeList?curPage=${i}">${i}</a></li>
					</c:forEach>
					</ul>
			
			</div>
		
		
			<%-- <div>
				<c:forEach begin="1" end = "10" var = "i" varStatus="st">	<!-- 역으로는 안됨 10 9 8 ...  10포함-->
						${pageScope.i} : ${st.begin} 
				</c:forEach>		
			</div> --%>
			<c:if test="${empty sessionScope.member}">
				<a href = "./noticeWrite" >Write</a>
			</c:if>
		
	</div>
	
</body>
</html>
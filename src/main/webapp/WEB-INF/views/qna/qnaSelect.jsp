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
<%-- <h1>${data}</h1> --%>
<div class="container">
  <h2>QnA Select Page</h2>
  <ul class="list-group">
    <li class="list-group-item">Title : ${qnaVO.title} </li>
    <li class="list-group-item">Writer : ${qnaVO.writer} </li>
    <li class="list-group-item">DATE : ${qnaVO.reg_date}</li>
    <li class="list-group-item">HIT : ${qnaVO.hit} </li>
  </ul>
   <p>CONTENTS: ${qnaVO.contents} </p>
	<div id="box">
		<a class = "btn btn-primary" href="./qnaList">QnAList</a>
		<a class = "btn btn-primary" href="./qnaUpdate?num=${qnaVO.num}">Update</a>
 		<a class = "btn btn-danger" href="./qnaDelete?num=${qnaVO.num}">Delete</a>
 		<a class = "btn btn-primary" href="./qnaReply?num=${qnaVO.num}">Reply</a>
 		
		
	
	<%-- <%if(memberDTO !=null && memberDTO.getId().equals(noticeDTO.getWriter())) {%>
 	<% }%> --%>
 	
	</div>
</div>


</body>
</html>
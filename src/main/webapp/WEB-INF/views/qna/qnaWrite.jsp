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
	<h1>QnA Write Form</h1>
	
	<div class="container">
  <h2>QnA Write</h2>
  <form action="./qnaWrite" method="post">
    <div class="form-group">
      <label for="title">TITLE:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title"> <!-- name은 parameter DBcloumn과 동일하게 -->
    </div>
    
    <div class="form-group">
      <label for="writer">WRITER:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" >
    </div>
      <label for="contents">CONTENTS:</label>
    <div class="form-group">    
      <textarea rows="10" cols="160" name = "contents"></textarea>
    </div>     
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
	
	
	<form action="./qnaWrite" method="post">
			
		<button>Write</button>
	</form>
</body>
</html>
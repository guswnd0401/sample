<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!--bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!--font-awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Insert title here</title>
<style>
h1 {
	text-align : center;
}
table {
	margin : auto;
	top : 30px;
}
td {
	text-align : center;
}
#link:hover {
	cursor: pointer;
	color :red;
}
img {
	width : 100px;
	height : 100px;
}
</style>
</head>

<body>
<h1>가게 목록</h1>
<hr/>

<table width="1200" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>번호</td>
		<td>가게명</td>
		<td>최저가격</td>
		<td>배달팁</td>
		<td>이미지</td>
	<tr>
	
	<c:forEach items="${storelist}" var="dto">
	<tr>
		<td>${dto.sNo}</td>
		<td id="link">${dto.sName}</td>
		<td>${dto.mPrice}</td>
		<td>${dto.sTip}</td>
		<td><img class="img-thumbnail" src="https://localhost:8443/HK/Store/${dto.sImg}"></td>
	<tr>
	
	</c:forEach>
	
</table>


<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!--bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!--font-awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table {
	margin : auto;
}
td {
	text-align : center;
}
</style>

</head>
<body> 

<table width="1200" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>성별</td>
		<td>이메일</td>
		<td>전화번호</td>
		<td>자기소개</td>
		<td>필수동의여부</td>
		<td>선택동의여부</td>
		<td>코드</td>
		<td>가입일</td>
	<tr>
	
	<c:forEach items="${List}" var="dto">
	<tr>
		<td>${dto.user_id}</td>
		<td>${dto.user_name}</td>
		<td>${dto.user_sex}</td>
		<td>${dto.user_email}</td>
		<td>${dto.user_phone}</td>
		<td>${dto.user_profile}</td>
		<td>${dto.user_ag1}</td>
		<td>${dto.user_ag2}</td>
		<td>${dto.user_code}</td>
		<td>${dto.user_date}</td>
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
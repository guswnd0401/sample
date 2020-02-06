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
</head>
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
	color :red;
}
</style>
<body>

<h1>전체 입점문의 목록</h1>
<hr/>
<div id="ApList">
	<table width="1200" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>입점문의번호</td>
			<td>가게명</td>
			<td>카테고리</td>
			<td>등록일</td>
			<td>회원아이디</td>
		<tr>
		
		<c:forEach items="${applylist}" var="dto">
		<tr>
			<td id="asno" name="asNo">${dto.asNo}</td>
			<td><a id="link" href="ApplyContent?asNo=${dto.asNo}">${dto.asName}</a></td>
			<td>${dto.asCategory}</td>
			<td>${dto.asDate}</td>
			<td>${dto.user_id}</td>
		<tr>
		
		</c:forEach>
		
	</table>
</div>


<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
/*
$(document).ready(function() {
	//var no = $("#no").val();
	
	$("#link").click(function() {
		
		console.log("번호	 : 	" + $("#asno").val());
		
		$.ajax({
			type : "post", 
			url : "ApplyContent",
			data : {
				asNo : $("#asno").val()
			}, //주소비교하기위해 보내기
			//여기까지가 위도,경도값 컨트롤러에 보내주기
			/////////////////////////////////////////////////////////////////////////////////////////////

			success : function(data) {
				console.log("성공");
				$("#ApList").html(data);
				
			},
			error : function(data) {
				alert("데이터 전송 실패");
			}
		});
		
		
		
		
	});
	
});*/
</script>
</body>
</html>
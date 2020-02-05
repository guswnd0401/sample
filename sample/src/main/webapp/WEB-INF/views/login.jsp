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
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>

<!--bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!--font-awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form {
	width : 500px;
	height : 500px;
	margin : auto;
	display : table;
}
#id1 {
	display : table-cell;
    vertical-align : middle;
    text-align : center;
}
#id,#pw {
	width : 350px;
	height : 50px;
}
#login {
	width : 350px;
	height : 50px;
	background-color : #FF4848;
	color : white;
	font-size : 25px;
	font-weight : bolder;
}
hr {
	border : 0.5px solid gray;
}
#logo {
	font-size : 50px;
	color : #FF4848;
	font-weight : bolder; 
    cursor:pointer; /*커서포인트 마우스 대면 커서모양 변함*/
}
a:hover,a:link,a:visited {
	 text-decoration: none; /*마우스 클릭, 갖다대기, 방문 등 효과 없애기 */
}
</style>
</head>
<body>

<div class="container">
	<form id="loginForm" action="login" method="POST">
	<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" /><br/>
		<div id="id1">
			<a id="logo" href="home">HK라이더스</a><br/><br/><br/>
			<div>
				<input id="id" type="text" name="user_id" placeholder="  아이디">
			</div>
			<br/>
			<div>
				<input id="pw" type="password" name="user_pw" placeholder="  비밀번호">
			</div>
			
			<br/>
			
			<div>
				<input id="login" type="submit" value="로그인">
			</div>
			
			<br><hr/><br/>
			<input id="remember_me" name ="_spring_security_remember_me" type="checkbox"/>Remember me
			<div>
				<a href="#">아이디 찾기</a>&nbsp;&nbsp;<a href="#">비밀번호 찾기</a>&nbsp;&nbsp;<a href="join_view">회원가입</a>
			</div>
			
		</div>
	</form>
</div>

<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
/*
$(document).ready(function(){	
	$("#loginForm").submit(function(){
		event.preventDefault();
		$.ajax({
			url : $("#loginForm").attr("action"),
			type : $("#loginForm").attr("method"),
			data : $("#loginForm").serialize(), //서버로 보내는 데이터
			dataType : "text", //응답데이터형 
			beforeSend : function(xhr, settings) { //xhr은 XmlHttpRequest객체
				xhr.setRequestHeader("X-CSRF-TOKEN", $("meta[name='_csrf']").attr('content'));
			},
			success : function() {				
				location.href = "main_view";
			},
			error : function() { //서버 에러
				$("#div1").text("server error");
			}
		});
		
	});
});*/
</script>
</body>
</html>
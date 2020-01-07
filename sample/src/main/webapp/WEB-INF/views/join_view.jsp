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
<body>
<h1>회원가입 페이지 입니다.</h1>
<hr/>

<form id="joinForm" name="Form" action="join" method="post">

	<input id="userid" type="text" name="tId" placeholder="아이디를 입력하시오."> &nbsp;&nbsp;
	<input id="idbtn" type="button" value="중복확인"><br/>
	<b><span id="userid1"></span></b>
	
	<br/>
	<!--
	<input id="userpw" type="password" name="tPw" placeholder="비밀번호를 입력하시오."><br/>
	
	<br/> -->
	
	<!-- 체크박스값 보내기 -->
	<input id="cbox" type="checkbox" name="tPw" value="1"> 필수 
	
	<br/>
	
	<input id="joinbtn" type="button" value="가입"> &nbsp;&nbsp;
	<input id="resetbtn" type="reset" value="다시입력">
	
</form>



<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script>
var join = false;//가입버튼누를떄 바로 submit하는거 막음

$(document).ready(function() {
	
	
	$("#joinbtn").click(function(event) {
		
		if(join) {
			if($("input:checkbox[name=tPw]").is(":checked") == false) { //체크박스 체크여부 (name만 바꿔주면된다.)
				alert("필수항목은 반드시 체크해야 합니다.");
				return false;
			}
			else {
				$("#joinForm").submit();
			}
			//$("#joinForm").submit();
		}
		
		if(!join) {
			alert("아이디 중복체크를 해주세요."); //아이디중복체크를 하지 않는이상 가입이 되지 않는다.
			return false;
		}
		
		
	});
	
	//아이디 중복체크
	$("#idbtn").click(function() {
		
		if(!document.Form.tId.value) { //아이디 중복체크시 아이디 값이 없으면 중복체크 불가능하게 함
			$("#userid1").css("color","red");
			$("#userid1").html("아이디를 입력하지 않았습니다.");
			$("#userid1").focus();
			return false;
		}
		
		$.ajax({
			url:"checkId",
			type:"post",
			data:{
				tId:$("#userid").val()
			},
			
			success:function(data) {
				if(data=="ok") {
					$("#userid1").css("color","green");
					$("#userid1").html("사용가능한 아이디입니다.");//모달로 띄어도 상관없음
					$("#userid").attr("readonly",true); //아이디 중복확인시 아이디 재입력 되지 않게하기
					join = true;//join을 true로 해서 submit가 가능하게함
				}
				if(data=="no") {
					$("#userid1").css("color","red");
					$("#userid1").html("이미 사용중인 아이디입니다.");
					join = false;
					$("#userid").val("");
					$("#userid").focus();
				}
				
			}
			
		});
		
	}); //아이디 중복체크 ajax
	
	$("#resetbtn").click(function() {
		location.reload();
	})
	
	
});

</script>

</body>
</html>
<!-- ======================= 현재위치만 있는거 ======================================= -->



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 로그인,로그아웃 버튼에 사용하는 시큐리티 태그라이브러리 추가 -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!--bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!--font-awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<title>Insert title here</title>
<style>
/* 로그인 버튼 */
#logbtn1, #logbtn2 {
	background-color: #FF4848;
}

/*헤더1(로그인,회원가입,로고)*/
#logo {
	color : white;
	margin-left : auto;
	margin-top : 15px;
}
.navbar-nav {
	margin-top : 15px;
}
nav {
	height : 100px;
	background-color : #FF4848;
}

/*배너관련 스타일 css*/
.d-block {
	width : 100%;
	height : 100%; 
	cursor: pointer;
}
.d-block:hover {
	opacity: 0.6;
}

/*모달 css*/
/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
}
/* Modal Content (image) */
.modal-content {
  margin: auto;
  display: block;
  width: 80%;
  max-width: 700px;
}

/* Add Animation */
.modal-content {  
  -webkit-animation-name: zoom;
  -webkit-animation-duration: 0.6s;
  animation-name: zoom;
  animation-duration: 0.6s;
}

/* 모달창 띄울때 점점크게 듸우는 효과 */
@-webkit-keyframes zoom {
  from {-webkit-transform:scale(0)} 
  to {-webkit-transform:scale(1)}
}

@keyframes zoom {
  from {transform:scale(0)} 
  to {transform:scale(1)}
}

/* The Close Button */
.close {
  position: absolute;
  top: 0px;
  right: 20px;
  color: #f1f1f1;
  font-size: 60px;
  font-weight: bold;
  transition: 0.3s;
}

.close:hover,.close:focus {
  color: #bbb;
  text-decoration: none;
  cursor: pointer;
}

/* 100% Image Width on Smaller Screens  모달창 이미지*/
@media only screen and (max-width: 700px){
  .modal-content {
    width: 100%;
  }
}


/*주소 검색 section*/
#sec {
	/*background-color : #FFFFFF; /* 이미지 또는 배경색 바꾸기*/
	border-bottom : 1px solid #FF4848;
}
#ad1 {
	display : table;
	margin : auto;
	height : 100px;
}
#ad2 {	
	display : table-cell;
    vertical-align : middle; /* id=ad1 div를 테이블로 하고 밑에서 id=ad2의 내용을 가운데 정렬*/
    text-align : center;
    color : gray; /* 글자색 변경하기*/
}
#btn,#icon {
	border-radius: 10px;
	border : 1px solid red;
	cursor:pointer; 
}

#address  {
	width : 450px;
}
#google-map {
	width : 700px;
	height : 400px;
	margin : auto;
}
/*기본 홈 contents*/
#cul {
	text-align : center;
    list-style:none;
    -webkit-padding-start:0px; /*ul왼쪽 여백 없애기*/
}
#img1 {
	width : 250px;
	height : 250px;
	border : 1px solid #BDBDBD;
	background-color : white;
	cursor:pointer;
}
/*footer 바닥글*/
#ft1 {
	border : 1px solid gray;
}
#ft1_1 {
	display : table;
	height : 60px;
}
#ft1_2 {
    list-style:none;
    -webkit-padding-start:0px; /*ul왼쪽 여백 없애기*/
    display : table-cell;
    vertical-align : middle;
}	
#ft1_3 {
    float: left; /* 리스트 가로정렬 */
}
a:hover,a:link,a:visited {
	 text-decoration: none; /*마우스 클릭, 갖다대기, 방문 등 효과 없애기 */
}
</style>
</head>
<body>
<!--============================== 헤더 navbar사용 로그인,회원가입,로고 ==============================-->
<header>
	<!-- header1 : 로그인 | 회원가입 | 로고(홈링크) -->
	<nav class="navbar navbar-expand-sm navbar-dark">
		<div class="container">
	 		<ul class="navbar-nav">
		   		<li class="nav-item active">
		   			<!-- 로그인한 뒤에 로그아웃으로 바뀌는 부분 -->
		   			<sec:authorize access="isAnonymous()">
   						<button type="button" class="btn btn-lg" style="color:#FFFFFF;"
   								onclick="location.href='login?log=start'">로그인</button>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">   							
						<form action="logout" method="POST">
        					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        					<button type="submit" class="btn btn-lg" style="color:#FFFFFF;">로그아웃</button>
    					</form>
   					</sec:authorize>
		   		</li>
		   		
			    <li class="nav-item">
			    	<a class="nav-link" href="join_view"><h3>회원가입</h3></a>
			    </li>
	 		</ul>
	 		<a id="logo" href="home"><h3>HK라이더스</h3></a>
	 	</div>
	</nav>
</header>
<br/>
<!--============================== 헤더 navbar사용 로그인,회원가입,로고 끝 ==============================-->

<!--============================== 이벤트 내용 배너 시작 ==============================-->
<section class="container">

	<div id="event" class="carousel slide" data-ride="carousel">
		
		  <!-- Indicators -->
		  <ul id="indicator" class="carousel-indicators">
		    <li data-target="#event" data-slide-to="0" class="active bg-danger"></li>
		    <li data-target="#event" data-slide-to="1" class=" bg-danger"></li>
		    <li data-target="#event" data-slide-to="2" class=" bg-danger"></li>
		  </ul>
		  
		  <!-- The slideshow -->
		  <div class="carousel-inner">
		  
		  	<div class="carousel-item active">
		      <img id="im1" src="resources/MainImg/event1_2.png" alt="이벤트1" class="d-block mx-auto">
		    </div>
		    
		    <div class="carousel-item">
		      <img id="im2" src="resources/MainImg/event2_2.png" alt="이벤트2" class="d-block mx-auto ">
		    </div>
		    
		    <div class="carousel-item">
		      <img id="im3" src="resources/MainImg/event3_2.png" alt="이벤트3" class="d-block mx-auto ">
		    </div>

		  </div>
	</div>		
</section>

<!--============================== 이벤트 내용 배너 모달 시작 ==============================-->
<div id="myModal" class="modal">
	<span class="close">&times;</span>
  	<img class="modal-content" id="img01">
</div><br/>
<!--============================== 이벤트 내용 배너 모달 끝 ==============================-->

<!--============================== 이벤트 내용 배너 끝 ==============================-->


<!--============================== 주소 API 시작 ==============================-->
<
<section id="sec">
	<div id="ad1">
		<!-- header2 : 주소 검색 -->
		<form id="ad2" class="container" action="search1" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="text" id="lat" name="sLat" placeholder="위도"> 
			<input type="text" id="lng" name="sLng" placeholder="경도">
			<br/> 
			<div id="btn" class="btn-group btn-group-lg">
				<i id="icon" class="material-icons" style="font-size:48px;color:red">my_location</i> 
				<input type="search" id="address" class="btn" placeholder="주소를 설정해주세요." readonly>
				<!-- readonly는 읽는거만 가능 입력 불가 대신 form안에서 사용시 전송은 가능 -->
				<input type="submit" id="search" class="btn bg-danger" value="검색">
			</div>
			<br/><br/>
			
			<div id="google-map"></div>
			
			<br/>		
			
		</form>
		
	</div>
</section>
<br/>
<!--============================== 주소 API 끝 ==============================-->

<!--============================== main 메뉴버튼  시작 ==============================-->
<!-- 내용 기본으로 홈화면 내용 설정한후 ajax통해서 이부분만 교체 -->
<div id="contents" class="container">

	<ul id="cul" class="row">
    	<li class="col-4"><img id="img1" src="resources/MainImg/all.png" class="rounded-square" title="전체보기"></li>
        <li class="col-4"><img id="img1" src="resources/MainImg/치킨.png" class="rounded-square" title="치킨"></li>
        <li class="col-4"><img id="img1" src="resources/MainImg/피자.png" class="rounded-square" title="피자"></li>
    </ul>
	
	<br><br>
	
	<ul id="cul" class="row">
    	<li class="col-4"><img id="img1" src="resources/MainImg/중식.png" class="rounded-square" title="중식"></li>
        <li class="col-4"><img id="img1" src="resources/MainImg/한식.png" class="rounded-square" title="한식"></li>
        <li class="col-4"><img id="img1" src="resources/MainImg/카페.png" class="rounded-square" title="카페"></li>
    </ul>
	
	<br><br>
	
	<ul id="cul" class="row">
    	<li class="col-4"><img id="img1" src="resources/MainImg/프렌차이즈.png" class="rounded-square" title="편의점"></li>
        <li class="col-4"><img id="img1" src="resources/MainImg/프렌차이즈.png" class="rounded-square" title="공지사항"></li>
    </ul>
</div>
<br/>
<!--============================== main 메뉴버튼  끝 ==============================-->

<!--============================== footer 시작 ==============================-->
<footer>
	<div id="ft1">
		<div id="ft1_1" class="container">
			<ul id="ft1_2">
				<li id="ft1_3">
					<a class="text-secondary" href="#">이용약관</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				</li>
				<li id="ft1_3">
					<a class="text-secondary" href="#">개인정보방침</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				</li>
				<li id="ft1_3">
					<a class="text-secondary" href="#">회원등급 정책</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				</li>
				<li id="ft1_3">
					<a class="text-secondary" href="#">회사소개</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				</li>
				<li id="ft1_3">
					<a class="text-secondary" href="#">요기요 사장님</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				</li>
				<li id="ft1_3">
					<a class="fab fa-facebook text-secondary" href="#"> 페이스북</a>
				</li>		
			</ul>
		</div>
	</div>
	
	<br/>
	
	<div id="ft2" class="container">
	<h6><b>(주)HK라이더스</b></h6>
	<p style="font-size:15px;" class="text-secondary">
		서울 영등포구 양산로 53 월드메르디앙비즈센터 | 대표자 : 김상우 김현중 정성민 | 
       	사업자 등록번호 : 000-00-00000 | 전화번호 : 02-000-0000
	</p>
	<p style="font-size:15px;" class="text-secondary">
		주식회사 HK라이더스는 통신 판매중개자이며 통신판매의 당사자가 아닙니다.<br/>
      	따라서 상품/ 거래정보 및 거래와 관련하여 요기요에 등록된 판매자의 고의 또는 과실로 소비자에게 발생하는 손해에 대해 당사는 책임을 지지 않습니다.<br/>
       	상품 및 거래에 관하여 보다 정확한 정보는 해당 판매자에게 직접 확인하여 주시기 바랍니다.
	</p>
	</div>
</footer>
<!--============================== footer 끝 ==============================-->
<br/><br/>



<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- 구글 맵 API -->
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBHgDQIauLTIeS1P9UWW9ba_HmNUY7fvO0&libraries=places&callback=initMap"></script>

<script>
//============================= 이벤트 배너 모달 자바스크립트 코드 시작 =============================
//Get the modal
var modal = document.getElementById("myModal");
var modalImg = document.getElementById("img01");

$("#im1").click(function(){
	modal.style.display = "block";
  	modalImg.src = 'resources/MainImg/event1_1.png';
  	$("#indicator").hide();
});
$("#im2").click(function(){
	modal.style.display = "block";
  	modalImg.src = 'resources/MainImg/event2_1.png';
  	$("#indicator").hide();
});
$("#im3").click(function(){
	modal.style.display = "block";
  	modalImg.src = 'resources/MainImg/event3_1.png';
  	$("#indicator").hide();
});

//모달창 닫기
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() { 
  modal.style.display = "none"; //x클릭시 모달 닫기
  $("#indicator").show(); //모달 띄울때 숨긴거 다시 표시
}
//============================= 이벤트 배너 모달 자바스크립트 코드 끝 =============================

//============================= 구글 API 시작 =============================

function initMap() {
	
    console.log('Map is initialized.');

    //처음 페이지 실행시 보여지는 맵 주소 설정
    var map = new google.maps.Map(document.getElementById('google-map'), {
        zoom: 17,//맵확대정도
        center: {
            lat: 37.5536067, //위도
            lng: 126.9696195 //경도
        } 
    }); 
    
    //현위치 찾기
    var geocoder = new google.maps.Geocoder;
    var infowindow = new google.maps.InfoWindow;
    
    document.getElementById('icon').addEventListener('click', function() {
    	//getLocation(); 
    	geocodeLatLng(geocoder, map, infowindow); 	 
    });
    //현위치 끝
}

//현위치 찾기

getLocation(); //화면에 뿌려줌

function getLocation() { //현위치 위도경도함수를 조건에 따라 뿌려줌
	
	if (navigator.geolocation) { 
		navigator.geolocation.watchPosition(showPosition);
	}
	else { 
		x.innerHTML = "Geolocation is not supported by this browser.";
	}	
	
}
	
function showPosition(position) { //현위치 위도 경도 얻기	
	document.getElementById('lat').value = position.coords.latitude;
	document.getElementById('lng').value = position.coords.longitude;
}

function geocodeLatLng(geocoder, map, infowindow) { 
	
	var lat = document.getElementById('lat').value;
	var lng = document.getElementById('lng').value; 
	var latlngStr = lat + "," + lng;
   
	console.log(latlngStr);
   
	var latlng = {lat: parseFloat(lat), lng: parseFloat(lng)};
   
   	console.log(latlng);
	   
   	geocoder.geocode({'location': latlng}, function(results, status) {
    	if (status === 'OK') {
       		if (results[0]) {
       			
       			map.setZoom(17); 
         		
         		var marker = new google.maps.Marker({
           			
         			position:latlng, 
           			map: map
           			 
           		});
           		 
         		infowindow.setContent(results[0].formatted_address);
         		document.getElementById("address").value = results[0].formatted_address;
         		infowindow.open(map, marker);
         	
       		} 
       		else {
         		window.alert('No results found');
       		}
       	
    	} 
    		else {
       			window.alert('Geocoder failed due to: ' + status);
     		}
    });
}
//============================= 구글 API 끝 =============================
	
//============================= 가게테이블 위도,경도와 메인에서 검색한 주소에 위도,경도 비교 =============================

$(document).ready(function(){
	$("#ad2").submit(function(event){ //form엘리먼트의 submit이벤트 처리 메서드
		
		var ad = $("#address").val();
		var lat = $("#lat").val();
		var lng = $("#lng").val();
		
		if(ad == ""){
			alert("주소를 먼저 설정해주세요.");
			$("#address").focus();
			return false;
		}
		
		//원래의 submitt기능 비활성화
		event.preventDefault();	
		console.log("lat : " + lat);
		console.log("lng : " + lng);
		$.ajax({
			type : $("#ad2").attr("method"), 
			url : $("#ad2").attr("action"),
			data : $("#ad2").serialize(), //주소비교하기위해 보내기
			//여기까지가 위도,경도값 컨트롤러에 보내주기
			/////////////////////////////////////////////////////////////////////////////////////////////

			success : function(data) {
				console.log("성공");
				$("#contents").html(data);
				
			},
			error : function(data) {
				alert("데이터 전송 실패");
			}
		});	
		
	});	
});

</script>
</body>
</html>
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
h1 { 
	text-align : center;
}
.container {
	border : 2px solid blue;/* 없애야 할 것*/
}
form {
	margin-top : 50px;
	margin-bottom : 50px; 
}
#content {
	margin : auto;
	width : 350px;
}
input {
	width : 350px;
	height : 50px;
	text-align : center;
}
#google-map {
	width : 350px;
	height : 250px;
	margin : auto;
}
select { 
	width : 250px;
	height : 50px;
}


</style>
</head>
<body>

<h1>입점문의 등록 test</h1>
<br/>
<div class="container">
	<form action="ApplyModify" method="post">
	<c:forEach items="${modify}" var="dto">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		<div id="content">
		
			입점문의 번호<b>${dto.asNo}</b><br/>
			
			<input type="text" name="asName" value="${dto.asName}">
			<br/><br/>
			
			<input type="tel" name="abNo" pattern="[0-9]{3}-[0-9]{2}-[0-9]{5}" required value="${dto.abNo}">
			<br/><br/>
			
			<!-- 위도 경도는 페이지에서는 숨겨서 받고 db에는 전송 -->
			<input type="text" id="lat" name="asLat" style="display:none" value="${dto.asLat}">
			<input type="text" id="lng" name="asLng" style="display:none" value="${dto.asLng}">
			
			<!-- 한글주소가 자동으로 입력됨 -->
			<input type="search" id="address" name="asAd" readonly value="${dto.asAd}">
			<br/>
			<button id="search" type="button">검색</button>
			
			<br/><br/>
			<div id="google-map"></div>
			<br/>
			
			<b>가게전화번호</b><br/>
			<input type="tel" name="asPhone" value="${dto.asPhone}">
			<br/><br/>
			
			<div id="catagory">
				<select name="asCategory" value="${dto.asCategory}">
				    <option value="">카테고리를 선택하세요.</option>
				    <option value="치킨">치킨</option>
				    <option value="피자">피자</option>
				    <option value="중식">중식</option>
				    <option value="한식">한식</option>
				    <option value="분식">분식</option>
				    <option value="카페">카페</option>
				    <option value="편의점">편의점</option>
				</select>
			</div>
			
			<br/><br/>			
			
			<input type="submit" value="수정">
			
		</div>
		</c:forEach>
	</form>
</div>


<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- 구글 맵 API -->
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBHgDQIauLTIeS1P9UWW9ba_HmNUY7fvO0&libraries=places&callback=initMap"></script>
<script>

//============================= 구글 API 시작 =============================
var x = document.getElementById("google-map");

getLocation(); //화면에 뿌려줌
	
function initMap() { //페이지 실행시 처음 화면
    
	var map = new google.maps.Map(document.getElementById('google-map'), {
    	zoom: 17,
    	center: {lat: 37.497665, lng: 126.7805416} 
	});
    
    var geocoder = new google.maps.Geocoder;
    var infowindow = new google.maps.InfoWindow;
    
    document.getElementById('search').addEventListener('click', function() {
    	geocodeLatLng(geocoder, map, infowindow); 
    });
}
	
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
	//document.getElementById('latlng').value =  position.coords.latitude + "," + position.coords.longitude; 
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
           			position: latlng, 
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
</script>
</body>
</html>
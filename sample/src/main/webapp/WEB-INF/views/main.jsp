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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

<title>Insert title here</title>
<style>
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
  top: 80px;
  right: 620px;
  color: #f1f1f1;
  font-size: 40px;
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
#btn {
	border-radius: 10px;
	border : 1px solid red;
}
#sample4_extraAddress {
	width : 450px;
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
<header>
	<!-- header1 : 로그인 | 회원가입 | 로고(홈링크) -->
	<nav class="navbar navbar-expand-sm navbar-dark">
		<div class="container">
	 		<ul class="navbar-nav">
		   		<li class="nav-item active">
		    			<a class="nav-link" href="login_view"><h3>로그인</h3></a>
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
<!-- 배너 시작 -->
<!-- ================ Start Popular Course Area ================= -->
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
		      <img id="im1" src="resources/F.C/event1_2.png" alt="이벤트1" class="d-block mx-auto">
		    </div>
		    
		    <div class="carousel-item">
		      <img id="im2" src="resources/F.C/event2_2.png" alt="이벤트2" class="d-block mx-auto ">
		    </div>
		    
		    <div class="carousel-item">
		      <img id="im3" src="resources/F.C/event3_2.png" alt="이벤트3" class="d-block mx-auto ">
		    </div>

		  </div>
	</div>		
</section>
<!-- 모달 -->
<div id="myModal" class="modal">
	<span class="close">&times;</span>
  	<img class="modal-content" id="img01">
</div>
<!-- 모달 끝 -->
<!-- 배너 끝 -->

<section id="sec">
	<div id="ad1">
		<!-- header2 : 주소 검색 -->
		<div id="ad2" class="container">
			<span id="guide" style="color:#999;display:none"></span>
			<input type="text" id="sample4_jibunAddress" placeholder="지번주소" style="display:none">
			<div id="btn" class="btn-group btn-group-lg">
				<input type="search" id="sample4_extraAddress" class="btn" placeholder="검색을 클릭하여 주소를 설정해주세요." readonly>
				<!-- readonly는 읽는거만 가능 입력 불가 대신 form안에서 사용시 전송은 가능 -->
				<button id="btn1" type="button" class="btn bg-danger" onclick="sample4_execDaumPostcode()">검색</button>
			</div>
			
		</div>
	</div>
</section>
<br/>
<!-- 내용 기본으로 홈화면 내용 설정한후 ajax통해서 이부분만 교체 -->
<div id="contents" class="container">

	<ul id="cul" class="row">
    	<li class="col-4"><img id="img1" src="resources/F.C/all.png" class="rounded-square" title="전체보기"></li>
        <li class="col-4"><img id="img1" src="resources/F.C/치킨.png" class="rounded-square" title="치킨"></li>
        <li class="col-4"><img id="img1" src="resources/F.C/피자.png" class="rounded-square" title="피자"></li>
    </ul>
	
	<br><br>
	
	<ul id="cul" class="row">
    	<li class="col-4"><img id="img1" src="resources/F.C/중식.png" class="rounded-square" title="중식"></li>
        <li class="col-4"><img id="img1" src="resources/F.C/한식.png" class="rounded-square" title="한식"></li>
        <li class="col-4"><img id="img1" src="resources/F.C/카페.png" class="rounded-square" title="카페"></li>
    </ul>
	
	<br><br>
	
	<ul id="cul" class="row">
    	<li class="col-4"><img id="img1" src="resources/F.C/프렌차이즈.png" class="rounded-square" title="프렌차이즈"></li>
        <li class="col-4"><img id="img1" src="resources/F.C/프렌차이즈.png" class="rounded-square" title="회원정보"></li>
        <li class="col-4"><img id="img1" src="resources/F.C/프렌차이즈.png" class="rounded-square" title="이벤트"></li>
    </ul>
</div>
<br/>
<!-- 바닥글 -->
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
<br/><br/>



<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- 주소 API -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>
//모달 자바스크립트 코드
//Get the modal
var modal = document.getElementById("myModal");
var modalImg = document.getElementById("img01");

$("#im1").click(function(){
	modal.style.display = "block";
  	modalImg.src = 'resources/F.C/event1_1.png';
  	$("#indicator").hide();
});
$("#im2").click(function(){
	modal.style.display = "block";
  	modalImg.src = 'resources/F.C/event2_1.png';
  	$("#indicator").hide();
});
$("#im3").click(function(){
	modal.style.display = "block";
  	modalImg.src = 'resources/F.C/event3_1.png';
  	$("#indicator").hide();
});

//모달차 닫기
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() { 
  modal.style.display = "none"; //x클릭시 모달 닫기
  $("#indicator").show(); //모달 띄울때 숨긴거 다시 표시
}


//다음 주소 API
//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            //document.getElementById('sample4_postcode').value = data.zonecode;
            //나중에 data.zonecode값과 DB에 저장된 우편번호 값을 비교해서 가게를 찾아도 되고 roadAddr 즉 도로명주소값을 통해 찾아도 된다.
            //document.getElementById("sample4_roadAddress").value = roadAddr;
            //document.getElementById("sample4_jibunAddress").value = data.jibunAddress; data.sigungu + data.bname
            
            //ex) 부천시중동값만 받아와 store테이블에서 배달가능한 지역 저장해둔 값과 비교하여 부천시중동이 배달지역에 포함된 가게정보 불러옴
            document.getElementById("sample4_jibunAddress").value = data.sigungu + data.bname;
            
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = roadAddr + " " + extraRoadAddr;
                //도로명 + 상세주소를 한곳에 연결해서 받음
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}
</script>
</body>
</html>
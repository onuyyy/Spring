<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="wrapper row1">
  <header id="header" class="clear"> 
    <div id="logo" class="fl_left">
      <h1><a href="index.html">Tiles & Session</a></h1>
    </div>
    <div class="fl_right">
      <ul class="inline">
        <li></i>ID:<input type=text name="id" size="10"></li>
        <li></i>PWD:<input type="text" name="pwd" size="10" ></li>
        <li></i><input type="button" value="로그인" size="10" ></li>
      </ul>
    </div>

  </header>
</div>

<div class="wrapper row2">
  <nav id="mainav" class="clear"> 

    <ul class="clear">
      <li class="active"><a href="../main/main.do">Home</a></li>
      <li><a class="drop" href="#">회원</a>
        <ul>
          <li><a href="../member/join.do">회원가입</a></li>
          <li><a href="pages/full-width.html">아이디 찾기</a></li>
          <li><a href="pages/sidebar-left.html">비밀번호 찾기</a></li>
        </ul>
      </li>
            <li><a class="drop" href="#">맛집</a>
        <ul>
          <li><a href="../member/join.do">맛집 추천</a></li>
          <li><a href="pages/full-width.html">맛집 찾기</a></li>
        </ul>
      </li>      <li><a class="drop" href="#">서울</a>
        <ul>
          <li><a href="pages/gallery.html">명소</a></li>
          <li><a href="pages/full-width.html">자연</a></li>
          <li><a href="pages/sidebar-left.html">쇼핑</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">스토어</a>
        <ul>
          <li><a href="pages/gallery.html">상품 목록</a></li>
          <li><a href="pages/full-width.html">장바구니</a></li>
        </ul>
      </li>
      <li><a href="#">커뮤니티</a></li>
      <li><a href="#">마이페이지</a></li>
    </ul>
  </nav>
</div>

</body>
</html>
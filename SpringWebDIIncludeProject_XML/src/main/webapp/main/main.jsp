<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.row {
	margin:0px auto;
	width:960px;
}

</style>
</head>
<body>

<!-- header.jsp를 포함한다 -->
<jsp:include page="header.jsp"></jsp:include>
<div style="height:30px"></div>
<div class="container">
	<jsp:include page="${main_jsp }"></jsp:include>
</div>

<!-- footer -->
<div class="container">
	<div class="col-sm-4">
		
	</div>
	<div class="col-sm-4">
		
	</div>
	<div class="col-sm-4">
		
	</div>
</div>
</body>
</html>
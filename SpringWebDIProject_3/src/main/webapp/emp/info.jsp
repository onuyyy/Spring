<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
  margin: 0px auto;
  width:400;
}
</style>
</head>
<body>
<!-- 
	private int empno,sal,comm,deptno;
	private String ename,job,dbday;
	private Date hiredate;
 -->
<div class="container">
	<div class="row">
		<h1 class="text-center">사원 정보</h1>
		<table class="table">
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>직위</th>			
				<th>입사일</th>			
				<th>급여</th>		
			</tr>
			<c:forEach var="n" items="${list }">
				<tr>
					<td>${n.empno}</td>
					<td>${n.ename}</td>
					<td>${n.job }</td>		
					<td>${n.dbday }</td>		
					<td>${n.sal }</td>		
				</tr>		
			</c:forEach>
		</table>
	</div>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Spring에선 RestController에서 수행한다 -->
<c:if test="${bCheck==true }">
	<script>
		location.href="list.do"
	</script>
</c:if>
<c:if test="${bCheck==false }">
	<script>
		alert("비밀번호가 틀렸습니다");
		history.back();
	</script>
</c:if>
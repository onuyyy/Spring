<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    text-align: center;
    width: 600px;
}	
</style>
</head>
<body>
	<div class="row">
		<form method="post" action="../member/login.do">
			<table class="table">
				<tr>
					<th colspan="2" class="text-center">Login</th>
				</tr>
				<tr>
					<th>id</th>
					<td>
						<input type="text" name="id">
					</td>
				</tr>
				<tr>
					<th>pwd</th>
					<td>
						<input type="password" name="pwd">
					</td>
				</tr>
	            <tr>
	                <td colspan="2">
	                    <input type="submit" value="login">
	                </td>
	            </tr>
			</table>
		</form>
	</div>
</body>
</html>
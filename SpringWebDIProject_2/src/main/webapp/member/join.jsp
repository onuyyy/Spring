<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);

}	
</style>
<script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

$(function(){
	$('#postBtn').click(function(){
		new daum.Postcode({
			oncomplete:function(data) {
				$('#post').val(data.zonedoe)
				$('#addr1').val(data.address)
			}
		}).open()
	})
})

</script>
</head>
<body>

<div class="container">
	<form method=post action="../member/join_ok.do">
		<table class="table">
			<div class="text-center">
				<h3>회원가입</h3>
			</div>
			<tr>
				<th>id</th>
				<td><input type=text name=id></td>
			</tr>
			<tr>
				<th>pwd</th>
				<td><input type=text name=pwd></td>
			</tr>
			<tr>
				<th>email</th>
				<td><input type=text name=email></td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type=text name=name></td>
			</tr>
			<tr>
				<th>nickname</th>
				<td><input type=text name=nickname></td>
			</tr>
			<tr>
				<th>sex</th>
				<td>
				남자<input type=radio name=sex value="남자" checked>
				여자<input type=radio name=sex value="여자">
				</td>
			</tr>
			<tr>
				<th>birth</th>
				<td><input type=text name=birth></td>
			</tr>
			<tr>
				<th>phone</th>
				<td><input type=text name=phone></td>
			</tr>
			<tr>
				<th>post</th>
				<td>
				<input type=text name=post id=post class="input-sm">
				<input type=button id="postBtn" value="우편번호 검색" class="btn btn-sm btn-default">
				</td>
			</tr>
			<tr>
				<th>addr1</th>
				<td>
				<input type=text name=addr1 id=addr1 size=50>
				</td>
			</tr>
			<tr>
				<th>addr2</th>
				<td>
				<input type=text name=addr2 id=addr2 size=50>
				</td>
			</tr>
			<tr>
				<td>
					<input type=submit name="joinBtn" value="회원가입">
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>